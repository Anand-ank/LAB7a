package basics;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    int count = 0;

    // Handle GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                    break;
                }
            }
        }

        // HTML response
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");

        if (existingUser != null) {
            count++;
            out.println("<font color='blue'><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color='magenta'><h2>You have visited this page " + count + " times!</h2></font>");
            out.println("<br><a href='logout'>Logout</a>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please login</h2>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Handle POST request (Login)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {

            // Create cookie
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 60 seconds

            response.addCookie(userCookie);
        }

        // Redirect to GET
        response.sendRedirect("CookieServlet");
    }
}