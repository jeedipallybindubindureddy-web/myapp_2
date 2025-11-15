import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // For demonstration: hardcoded username/password
        if("admin".equals(username) && "password123".equals(password)) {
            // Login successful
            request.getSession().setAttribute("user", username);
            response.sendRedirect("welcome.jsp");
        } else {
            // Login failed
            request.setAttribute("error", "Invalid username or password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}