import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

/**
 * Created by pinghua.wph on 2016/4/29.
 */
public class A extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        // 获得servletContext
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("username", "jetty");

        out.close();
    }
}
