## 官方文档
* [Sharding jdbc](http://shardingjdbc.io/docs_cn/01-start/code-demo/)

## restful
* http://localhost:8081/test/insert
* http://localhost:8081/test/select/order?id=196685549572980736


## 推荐spring-boot java方式实现
 DataSourceShardingAndSlaveConfig分库分表主从，支撑同一个datasource事务（@Transactional）,支持强制路由到主库（@ShardingHint）

## 常见问题
#### io.shardingjdbc.core.exception.ShardingJdbcException: Parameter `null` should extends Comparable for sharding value.
> 字段为空了


## 源码分析
#### ShardingPreparedStatement route

## 参考
* [Sharding-JDBC 源码分析](https://www.iocoder.cn/categories/Sharding-JDBC/)