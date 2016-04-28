import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pinghua.wph on 2016/4/28.
 */
public class CommentFilter1 implements Filter {
    public CommentFilter1() {
        System.out.println("Filter1 construct");
    }

    /**

     * 容器在启动时，会创建过滤器实例，接下来，会立即调用init方法完成初始化操作，该方法只会执行一次
     * 容器会事先创建好一个符合FilterConfig接口要求的对象。可以通过FilterConfig.getInitPrameter方法来访问过滤器的初始化参数。
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter1 is init...");
    }

    /**
     * 容器调用此方法来处理请求，类似于容器调用servlet的service方法一样。
     * 如果调用了FilterChain的doFilter方法，容器会继续调用后续的过滤器或者servlet
     * 如果没有调用，则容器不再向后调用
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        String content = req.getParameter("content");
        if(content.contains("dog")){
            // 有敏感字
            out.println("<h1>has dog word</h1>");
            out.close();
        }else{
            //继续调用后续的过滤器或者servlet
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("Filter1 doFilter end.");
    }

    /**
     * 容器在销毁过滤器之前，会调用此方法，该方法只会执行一次
     */
    @Override
    public void destroy() {
        System.out.println("Filter1 is destroy...");
    }
}
