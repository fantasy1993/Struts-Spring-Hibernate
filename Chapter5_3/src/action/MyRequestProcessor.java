package action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RequestProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zhuxinquan on 16-10-23.
 */
public class MyRequestProcessor extends RequestProcessor {
    @Override
    protected Action processActionCreate(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) throws IOException {
        System.out.println("进入实例化Action阶段");
        return super.processActionCreate(request, response, mapping);
    }

    @Override
    protected ActionForm processActionForm(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) {
        System.out.println("进入填充ActionForm阶段");
        return super.processActionForm(request, response, mapping);
    }

    @Override
    protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理用户请求");
        String charsetEncoding = request.getCharacterEncoding();
        System.out.println("charset：" + charsetEncoding);
        if("UTF-8".equals(charsetEncoding)){
            try {
                request.setCharacterEncoding("gb2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setCharacterEncoding("gb2312");
            return true;
        }else {
            return false;
        }
    }
}
