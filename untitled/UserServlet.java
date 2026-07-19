import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 从session获取用户名
        HttpSession session = request.getSession(false); // false表示不创建新session
        String username = null;
        
        if (session != null) {
            username = (String) session.getAttribute("username");
        }
        
        // 设置响应内容类型
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        if (username != null) {
            out.print("{\"username\":\"" + username + "\"}");
        } else {
            out.print("{\"username\":null}");
        }
        out.flush();
    }
}