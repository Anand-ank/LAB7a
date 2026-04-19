package basics;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        // Create name cookie
        Cookie nameCookie = new Cookie("username", username);
        nameCookie.setMaxAge(30); // expires in 30 seconds
        response.addCookie(nameCookie);

        // Check visit count cookie
        int count = 1;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create/update visit count cookie
        Cookie countCookie = new Cookie("visitCount", String.valueOf(count));
        countCookie.setMaxAge(30); // expires in 30 seconds
        response.addCookie(countCookie);

        // HTML response
        out.println("<html><body>");
        out.println("<h2 style='color:blue;'>Welcome back " + username + "!</h2>");
        out.println("<h3 style='color:magenta;'>You have visited this page " + count + " times</h3>");

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Cookie Name: " + c.getName() + 
                            " | Value: " + c.getValue() + "<br>");
            }
        }

        out.println("<br><b>Note:</b> Cookies will expire in 30 seconds.<br>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}