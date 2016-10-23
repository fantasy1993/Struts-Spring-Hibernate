package action;

import org.apache.struts.action.ActionServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhuxinquan on 16-10-23.
 */
public class MyActionServlet extends ActionServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("已进入ActionServlet");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        super.process(request, response);
    }
}
