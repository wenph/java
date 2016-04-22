import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pinghua.wph on 2016/4/22.
 */
public class ActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        if ("/list".equals(action)) {
            LinkedList<String> nameList = new LinkedList<String>();
            nameList.add("wenph");
            nameList.add("zhangsan");
            nameList.add("lisi");
            request.setAttribute("nameList", nameList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            PrintWriter out = response.getWriter();
            /**
             * 转发之前，会将out清空
             * 转发之前，不能调用out.close()
             */
            requestDispatcher.forward(request, response);
        }
    }
}
