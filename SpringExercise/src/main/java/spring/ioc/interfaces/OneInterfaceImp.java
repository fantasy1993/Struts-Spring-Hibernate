package spring.ioc.interfaces;

/**
 * Created by zhuxinquan on 16-10-13.
 */
public class OneInterfaceImp implements OneInterface{
    public String hello(String word) {
        return "hello" + word;
    }
}
