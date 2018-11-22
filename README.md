## 官方文档
* [Sharding jdbc](http://shardingjdbc.io/docs_cn/01-start/code-demo/)

## 建库建表脚本
> auto_db.sql

## MyBatis生成
* mybatis自动生成方法入口MyBatisCodeGenerator.java
* 配置文件MBG_configuration.xml，修改“D:\Workspace\mine\sharding-jdbc-test\”为自己的项目路径

## 强制主库
 @ShardingHint要结合@Transactional使用才能保证方法内部的所有sql落到主库，使用同一个collection

  HintManager hintManager = HintManager.getInstance();只能够保证在这个线程内部，调用的过程中，如果collection（SpringManagedTransaction）关闭掉会清理掉theradlocal中的hintManager对象，所以不使用@Transactional只是保证了第一个sql走了主库，后续的sql只会走到从库去。
  


## 常见问题
#### io.shardingjdbc.core.exception.ShardingJdbcException: Parameter `null` should extends Comparable for sharding value.
> 字段为空了



## 源码分析
#### ShardingPreparedStatement route


## RESTful测试接口
* http://localhost:8081/test/insert
* http://localhost:8081/test/select/order?id=196685549572980736

## 参考
* [Sharding-JDBC 源码分析](https://www.iocoder.cn/categories/Sharding-JDBC/)