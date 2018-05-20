package com.walker.accountsapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountsAppApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试数据库连接
     */
    @Test
    public void connectionTest() throws SQLException {
        logger.info("数据库连接信息：{}", dataSource.getConnection());
    }

}
