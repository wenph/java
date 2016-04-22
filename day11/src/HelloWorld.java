import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pinghua.wph on 2016/4/19.
 */
public class HelloWorld extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String age = req.getParameter("age");
        String info = name + "," + salary + "," + age;
        System.out.println(info);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>"+ info +"</html>");
        out.close();
    }
}
