## MySql主从配置
* 参考
 [mysql 5.7 主从同步配置](https://blog.csdn.net/natahew/article/details/71122569)

* 主库
````$xslt
log-bin="D:\data\mysql"
# 使binlog在每N次binlog写入后与硬盘 同步
sync-binlog=1
# 1天时间自动清理二进制日志
expire_logs_days=1
# 需要同步的数据库 
binlog-do-db=db_order_0
binlog-do-db=db_order_1
# 不需要同步的数据库
binlog-ignore-db=mysql   
binlog-ignore-db=information_schema 
binlog-ignore-db=performance_schema
````

* 从库
````$xslt
replicate_wild_do_table=db_order_0.%
replicate_wild_do_table=db_order_1.%

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