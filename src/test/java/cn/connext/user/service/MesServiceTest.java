package cn.connext.user.service;

import cn.connext.user.controller.UserController;
import cn.connext.user.entity.Mes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class MesServiceTest {
    @Resource
    private MesService mesService;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Test
    public void findAll() throws Exception {
        List<Mes> list = mesService.findAll();
        logger.info(list.toString());
    }

    @Test
    public void saveMes() throws Exception {
        mesService.saveMes("六点准时下班！","请大家严格遵守公司时间规定","17851220726");
    }

}