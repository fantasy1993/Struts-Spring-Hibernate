import com.spring.demo4.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhuxinquan on 17-4-27.
 * Spring声明式事物管理:基于 注解 的事物管理的方式
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringDemoTest4 {


    /*
    此时需要注入代理类：因为代理类进行增强操作
     */
    @Resource(name = "accountService")
//    @Resource(name = "accountServiceProxy")
    private AccountService accountService;

    @Test
    public void demo1(){
        accountService.transfer("aaa", "bbb", 200d);
    }
}
