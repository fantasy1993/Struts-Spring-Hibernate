import com.bean.assemble.EncoreableImp;
import com.bean.assemble.EncoreableInterface;
import com.bean.assemble.PerformanceImp;
import com.bean.assemble.PerfromanceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhuxinquan on 17-4-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.bean.assemble.ConcertConfig.class)
//@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TT {

//    @Autowired
//    public PerfromanceInterface performance;

    @Autowired
    public PerformanceImp performanceImp;

    @Test
    public void test(){
//        performance.perform();
        ((EncoreableInterface)performanceImp).performEncore();
//        performance.performEncore();
    }
}
