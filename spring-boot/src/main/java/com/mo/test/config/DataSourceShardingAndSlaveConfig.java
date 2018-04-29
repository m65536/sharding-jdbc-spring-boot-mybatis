package com.mo.test.config;

import com.mo.test.sharding.PreciseDatabaseShardingAlgorithm;
import com.mo.test.sharding.PreciseTableShardingAlgorithm;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.constant.ShardingPropertiesConstant;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @author MoXingwang on 2018-04-28.
 * https://blog.csdn.net/yanyan19880509/article/details/78170233
 * 分库分表，主从
 */
@Configuration
@EnableTransactionManagement//开启事务
//@MapperScan("com.chinaredstar.ordercenter.mapper")
@MapperScan("com.mo.test.mapper")
public class DataSourceShardingAndSlaveConfig {
    public DataSource dataSourceMaster0() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl("jdbc:mysql://192.168.226.237:3306/tx_order_master_0");
        result.setUsername("root");
        result.setPassword("password");
        return result;
    }


    public DataSource dataSourceMaster1() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl("jdbc:mysql://192.168.226.237:3306/tx_order_master_1");
        result.setUsername("root");
        result.setPassword("password");
        return result;
    }


    public DataSource dataSourceSlave0() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl("jdbc:mysql://192.168.226.237:3306/tx_order_slave_0");
        result.setUsername("root");
        result.setPassword("password");
        return result;
    }


    public DataSource dataSourceSlave1() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl("jdbc:mysql://192.168.226.237:3306/tx_order_slave_1");
        result.setUsername("root");
        result.setPassword("password");
        return result;
    }

    public Map<String, DataSource> getDataSourceMap() {
        Map<String, DataSource> dataSourceMap = new HashMap<>(2, 1);

        dataSourceMap.put("tx_order_master_0", dataSourceMaster0());
        dataSourceMap.put("tx_order_master_1", dataSourceMaster1());
        dataSourceMap.put("tx_order_slave_0", dataSourceSlave0());
        dataSourceMap.put("tx_order_slave_1", dataSourceSlave1());
        return dataSourceMap;
    }

    @Bean(name = "sahrdingDataSource")
    public DataSource getShardingDataSource() throws SQLException, IOException {


        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.setDefaultDataSourceName("tx_order_master_0");
        shardingRuleConfig.getTableRuleConfigs().addAll(getTableRuleConfigurations());


        // 构建读写分离配置
        MasterSlaveRuleConfiguration masterSlaveRuleConfig0 = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig0.setName("ds_0");
        masterSlaveRuleConfig0.setMasterDataSourceName("tx_order_master_0");
        masterSlaveRuleConfig0.getSlaveDataSourceNames().add("tx_order_slave_0");

        MasterSlaveRuleConfiguration masterSlaveRuleConfig1 = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig1.setName("ds_1");
        masterSlaveRuleConfig1.setMasterDataSourceName("tx_order_master_1");
        masterSlaveRuleConfig1.getSlaveDataSourceNames().add("tx_order_slave_1");

        shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveRuleConfig0);
        shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveRuleConfig1);


        shardingRuleConfig.getBindingTableGroups().add(SHARDING_TABELS + "," + INDEP_TABELS);
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", PreciseDatabaseShardingAlgorithm.class.getName()));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", PreciseTableShardingAlgorithm.class.getName()));


        Properties props = new Properties();
        props.setProperty(ShardingPropertiesConstant.SQL_SHOW.getKey(), "true");

        return ShardingDataSourceFactory.createDataSource(getDataSourceMap(), shardingRuleConfig, new HashMap<String, Object>(), props);
    }


    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("sahrdingDataSource") DataSource sahrdingDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(sahrdingDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:sqlmapper/**/*.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("sahrdingDataSource") DataSource sahrdingDataSource) throws SQLException, IOException {
        return new DataSourceTransactionManager(sahrdingDataSource);
    }

    private List<TableRuleConfiguration> getTableRuleConfigurations() {
        List<TableRuleConfiguration> tableRuleConfigurations = new ArrayList<>();

        for (String s : SHARDING_TABELS.split(",")) {
            TableRuleConfiguration table = new TableRuleConfiguration();
            table.setLogicTable(s);
            table.setActualDataNodes("ds_${0..1}." + s + "_${[0, 1]}");
            if (!"tx_order".equals(s)) {
                table.setKeyGeneratorColumnName("id");
            }
            tableRuleConfigurations.add(table);
        }
        for (String s : INDEP_TABELS.split(",")) {
            TableRuleConfiguration table = new TableRuleConfiguration();
            table.setLogicTable(s);
            table.setActualDataNodes("ds_${0}." + s + "_${[0]}");
            table.setKeyGeneratorColumnName("id");
            tableRuleConfigurations.add(table);
        }


        return tableRuleConfigurations;
    }

    private static final String SHARDING_TABELS = "tx_customer_service,tx_item_payment,tx_item_promotion,tx_operation_history,tx_order,tx_order_addition,tx_order_extend,tx_order_item,tx_order_reviewed,tx_order_status_version,tx_order_worker,tx_payment_line,tx_payment_line_detail,tx_promotion,tx_promotion_job,tx_refund_bill,tx_attachment";
    private static final String INDEP_TABELS = "tx_cancel_payment_log,tx_config,tx_return_detail,tx_return_info,tx_item_attributes,tx_customer_service_status_version";

}
