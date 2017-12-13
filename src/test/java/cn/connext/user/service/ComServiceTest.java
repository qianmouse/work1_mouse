package cn.connext.user.service;

import cn.connext.user.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class ComServiceTest {
    @Resource
    private ComService comService;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Test
    public void putCom() throws Exception {
        comService.putCom("一定遵守！",30,"13675109838");
    }

}