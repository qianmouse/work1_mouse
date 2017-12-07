import cn.connext.user.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;


public class UserTest {
    @Resource
    private UserService userService;

    @Test
    public void test1(){

        userService.findPhone("178521220726");
        userService.register("13675109838","951202");
    }
}
