package interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import spring.ioc.injection.service.InjectionService;
import base.UnitTestBase;
import spring.ioc.interfaces.OneInterface;
import spring.ioc.interfaces.OneInterfaceImp;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {
	
	public TestInjection() {
		super("classpath:spring.ioc-injection.xml");
	}

	/**
	 * 测试使用设值注入
	 */
	@Test
	public void testSetter() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}

	/**
	 * 测试使用构造注入
	 */
	@Test
	public void testCons() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}

	/**
	 * 测试使用接口注入
	 */
	@Test
	public void testInt(){
		try {
			Object object = Class.forName("spring.ioc.interfaces.OneInterfaceImp").newInstance();
			OneInterface oneInterface = (OneInterface)object;
			System.out.println(oneInterface.hello("world"));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
