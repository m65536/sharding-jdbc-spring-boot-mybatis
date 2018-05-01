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

## 参考
* [Sharding-JDBC 源码分析](https://www.iocoder.cn/categories/Sharding-JDBC/)