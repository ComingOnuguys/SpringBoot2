mybatis批量插入与自己拼装Sql批量插入性能结果

----------

## 测试文件SpringbootDemoApplicationTests.java ##
注：插入数据量为2万，再大到2万5则会报com.mysql.jdbc.PacketTooBigException: Packet for query is too large异常.

````
package com.example.springbootdemo;

import com.example.mapper.ProductMapper;
import com.example.mapper.UserMapper;
import com.example.service.user.UserService;
import com.example.vo.user.Product;
import com.example.vo.user.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

	@Autowired(required = false)
	private UserMapper userMapper;
	@Autowired(required = false)
	private ProductMapper productMapper;
	@Autowired(required = false)
	private UserService userService;

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Test
	public void testBatchInsert() {
        StopWatch stopWatch = new StopWatch();

        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 20000; i++) {
            User user = new User();
            user.setName("张无忌" + i);
            user.setAddress("光明顶" + i);
            user.setAge(new BigDecimal("23"));
            user.setBalance(new BigDecimal("88888"));
            user.setGender(0);
            list.add(user);
        }
        stopWatch.start("batchInsertUser批量插入时长");
        int r1 = userMapper.batchInsertUser(list);
        stopWatch.stop();

        stopWatch.start("batchInsertUser2批量插入时长");
        int r2 = userMapper.batchInsertUser2(list);
        stopWatch.stop();

        stopWatch.start("batchInsertJDBC3批量插入时长");
        int r3 = batchInsertJDBC3(list);
        stopWatch.stop();

        log.info(stopWatch.prettyPrint());

    }

    @Transactional
    public int batchInsertJDBC3(List<User> users) throws DataAccessException {
        StringBuffer sqlBuffer = new StringBuffer()
                .append("insert into t_user(name, gender,age, balance, address) values ");
        MessageFormat form = new MessageFormat("(''{0}'', ''{1}'', ''{2}'', ''{3}'', ''{4}''),");
        for (User user : users) {
            Object[] args = {user.getName(), user.getGender(), user.getAge(), user.getBalance().toString(), user.getAddress()};
            sqlBuffer.append(form.format(args));
        }
        String sql = sqlBuffer.toString();
        sql = sql.substring(0, sql.length()-1);
        return jdbcTemplate.update(sql);
    }


}
````

## 测试结果 ##
```
ms     %     Task name
02790  020%  batchInsertUser批量插入时长
10791  077%  batchInsertUser2批量插入时长
00478  003%  batchInsertJDBC3批量插入时长
```
从结果看出，使用自己拼装的SQL的批量插入的性能最高，但代码较繁琐，可以考虑写成一个工具类。