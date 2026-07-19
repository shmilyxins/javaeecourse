import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        
        // 将用户名存储在session中
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        
        // 重定向到主页
        response.sendRedirect("index.html");
    }
}