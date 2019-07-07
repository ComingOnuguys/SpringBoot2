mybatis批量插入与自己拼装Sql批量插入性能结果

----------

## 测试文件SpringbootDemoApplicationTests.java ##
注：插入数据量为2万，再大到2万5则会报com.mysql.jdbc.PacketTooBigException: Packet for query is too large异常.

## 测试结果 ##
```
ms     %     Task name
02790  020%  batchInsertUser批量插入时长
10791  077%  batchInsertUser2批量插入时长
00478  003%  batchInsertJDBC3批量插入时长
```