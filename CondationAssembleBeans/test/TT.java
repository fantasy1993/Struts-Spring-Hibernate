import com.condation.bean.Interf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhuxinquan on 17-4-9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.condation.bean.SayConfig.class})
@ActiveProfiles("prod")
public class TT {

    @Autowired
    private Interf interf;

    @Test
    public void say(){
        interf.say();
    }
}
