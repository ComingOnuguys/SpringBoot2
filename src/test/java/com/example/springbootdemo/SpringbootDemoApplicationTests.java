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
        stopWatch.start("统计方式一批量插入时长");
        int r1 = userMapper.batchInsertUser(list);
        stopWatch.stop();

        stopWatch.start("统计方式二批量插入时长");
        int r2 = userMapper.batchInsertUser2(list);
        stopWatch.stop();

        stopWatch.start("统计方式三批量插入时长");
        int r3 = batchInsertJDBC3(list);
        stopWatch.stop();

        log.info("time={}ms",stopWatch.prettyPrint());

    }

    @Transactional("dbTransaction")
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
