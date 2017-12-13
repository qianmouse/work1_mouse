package cn.connext.user.service;

import cn.connext.user.controller.UserController;
import cn.connext.user.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserServiceTest {
    @Resource
    private UserService userService;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Test
    public void alterUser() throws Exception {
        userService.alterUser("12345678900","manager","super");
    }

    @Test
    public void findAllRole() throws Exception {
        List<Role> list = userService.findAllRole();
        logger.info(list.toString());
    }

    @Test
    public void newRole() throws Exception {
        userService.newRole("qianhao","编辑删除");
    }

}