## 官方文档
* [Sharding jdbc](http://shardingjdbc.io/docs_cn/01-start/code-demo/)

## restful
* http://localhost:8081/test/insert
* http://localhost:8081/test/select/order?id=196685549572980736


## 推荐spring-boot java方式实现
 DataSourceShardingAndSlaveConfig分库分表主从，支撑同一个datasource事务（@Transactional）,支持强制路由到主库（@ShardingHint）
 
 
## @ShardingHint要结合@Transactional使用才能保证方法内部的所有sql落到主库，使用同一个collection

  HintManager hintManager = HintManager.getInstance();只能够保证在这个线程内部，调用的过程中，如果collection（SpringManagedTransaction）关闭掉会清理掉theradlocal中的hintManager对象，所以不使用@Transactional只是保证了第一个sql走了主库，后续的sql只会走到从库去。

## 常见问题
#### io.shardingjdbc.core.exception.ShardingJdbcException: Parameter `null` should extends Comparable for sharding value.
> 字段为空了


## 源码分析
#### ShardingPreparedStatement route


## 主从配置
* 主库
````$xslt
log-bin="D:\data\mysql"
# 使binlog在每N次binlog写入后与硬盘 同步
sync-binlog=1
# 1天时间自动清理二进制日志
expire_logs_days=1
# 需要同步的数据库 
binlog-do-db=tx_order_master_0
binlog-do-db=tx_order_master_1
# 不需要同步的数据库
binlog-ignore-db=mysql   
binlog-ignore-db=information_schema 
binlog-ignore-db=performance_schema
````
* 从库
````$xslt
replicate_wild_do_table=tx_order_0.%
replicate_wild_do_table=tx_order_1.%

replicate_wild_ignore_table=mysql.%
replicate_wild_ignore_table=information_schema.%
replicate_wild_ignore_table=performance_schema.%
replicate_wild_ignore_table=database5.%
replicate_wild_ignore_table=database6.%
expire_logs_days=1
# Server Id.
server-id=5
````
* 启动从库
````$xslt
stop slave ;
change master to master_host='192.168.226.237',master_user='root',master_password='password', master_log_file='mysql.000002',master_log_pos=121437;
start slave ;
````







## 参考
* [Sharding-JDBC 源码分析](https://www.iocoder.cn/categories/Sharding-JDBC/)