package com.mo.test.config;

import com.mo.test.sharding.PreciseDatabaseShardingAlgorithm;
import com.mo.test.sharding.PreciseTableShardingAlgorithm;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.constant.ShardingPropertiesConstant;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @author MoXingwang on 2018-04-28.
 * 分库分表
 */
//@Configuration
//@EnableTransactionManagement//开启事务
//@MapperScan("com.chinaredstar.ordercenter.mapper")
@MapperScan("com.mo.test.mapper")
public class DataSourceShardingConfig {
    @Bean(name = "tx_order_master_0")
    public DataSource dataSourceMaster0() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl("jdbc:mysql://192.168.226.237:3306/tx_order_master_0");
        result.setUsername("root");
        result.setPassword("password");
        return result;
    }


    @Bean(name = "tx_order_master_1")
    public DataSource dataSourceMaster1() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl("jdbc:mysql://192.168.226.237:3306/tx_order_master_1");
        result.setUsername("root");
        result.setPassword("password");
        return result;
    }


    public Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>(2, 1);
        result.put("tx_order_master_0", dataSourceMaster0());
        result.put("tx_order_master_1", dataSourceMaster1());
        return result;
    }

    @Bean
    public DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().addAll(getTableRuleConfigurations());
        shardingRuleConfig.setDefaultDataSourceName("tx_order_master_0");
        shardingRuleConfig.getBindingTableGroups().add(SHARDING_TABELS + "," + INDEP_TABELS);
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("sharding_key", PreciseDatabaseShardingAlgorithm.class.getName()));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("sharding_key", PreciseTableShardingAlgorithm.class.getName()));
        Properties props = new Properties();
        props.setProperty(ShardingPropertiesConstant.SQL_SHOW.getKey(), "true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new HashMap<String, Object>(), props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getShardingDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:sqlmapper/**/*.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(getShardingDataSource());
    }

    private List<TableRuleConfiguration> getTableRuleConfigurations() {
        List<TableRuleConfiguration> tableRuleConfigurations = new ArrayList<>();

        for (String s : SHARDING_TABELS.split(",")) {
            TableRuleConfiguration table = new TableRuleConfiguration();
            table.setLogicTable(s);
            table.setActualDataNodes("tx_order_master_${0..1}." + s + "_${[0, 1]}");

            if (!"tx_order".equals(s)) {
                table.setKeyGeneratorColumnName("id");
            }
            tableRuleConfigurations.add(table);
        }
        for (String s : INDEP_TABELS.split(",")) {
            TableRuleConfiguration table = new TableRuleConfiguration();
            table.setLogicTable(s);
            table.setActualDataNodes("tx_order_master_${0}." + s + "_${[0]}");
            table.setKeyGeneratorColumnName("id");
            tableRuleConfigurations.add(table);
        }


        return tableRuleConfigurations;
    }

    private static final String SHARDING_TABELS = "tx_customer_service,tx_item_payment,tx_item_promotion,tx_operation_history,tx_order,tx_order_addition,tx_order_extend,tx_order_item,tx_order_reviewed,tx_order_status_version,tx_order_worker,tx_payment_line,tx_payment_line_detail,tx_promotion,tx_promotion_job,tx_refund_bill,tx_attachment";
    private static final String INDEP_TABELS = "tx_cancel_payment_log,tx_config,tx_return_detail,tx_return_info,tx_item_attributes,tx_customer_service_status_version";

}
