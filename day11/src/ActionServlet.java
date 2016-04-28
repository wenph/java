import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        }else if("/count".equals(action)){
            HttpSession session = request.getSession(true);
            if(session.isNew()){
                int count = 0;
                session.setAttribute("count", count);
            }else{
                int count = (Integer)session.getAttribute("count");
                count += 1;
                session.setAttribute("count", count);
            }
            Cookie[] cookie = request.getCookies();

            String jSessionId = null;
            for (int i = 0; i < cookie.length; i++) {
                if (cookie[i].getName().equals("JSESSIONID")){
                    jSessionId = cookie[i].getValue();
                    cookie[i].setMaxAge(60*60);
                    response.addCookie(cookie[i]);
                }
            }

            System.out.println("浏览器的cookie：" + jSessionId);
            System.out.println("服务器的cookie：" + session.getId());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("count.jsp");
            requestDispatcher.forward(request, response);
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<html>"+ session.getId() + "," + session.getAttribute("count") +"</html>");
//            out.close();
        }
    }
}
