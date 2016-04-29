import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pinghua.wph on 2016/4/29.
 */
public class CommentFilter2 implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        String content = req.getParameter("content");
        int size = Integer.parseInt(filterConfig.getInitParameter("size"));
        if(content.length() > size){
            out.println("<h1>your comment is too long</h1>");
            out.close();
        }else{
            //继续调用后续的过滤器或者servlet
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("Filter2 doFilter end.");
    }

    @Override
    public void destroy() {

    }
}
