package basics;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String rollno = request.getParameter("rollno");
            String name = request.getParameter("name");

            int s1 = Integer.parseInt(request.getParameter("sub1"));
            int s2 = Integer.parseInt(request.getParameter("sub2"));
            int s3 = Integer.parseInt(request.getParameter("sub3"));
            int s4 = Integer.parseInt(request.getParameter("sub4"));
            int s5 = Integer.parseInt(request.getParameter("sub5"));

            // Server-side validation
            if (rollno == null || name == null || rollno.isEmpty() || name.isEmpty()) {
                request.setAttribute("error", "All fields are required");
                request.getRequestDispatcher("Result1.jsp").forward(request, response);
                return;
            }

            int[] marks = {s1, s2, s3, s4, s5};
            for (int m : marks) {
                if (m < 0 || m > 100) {
                    request.setAttribute("error", "Marks must be between 0 and 100");
                    request.getRequestDispatcher("Result1.jsp").forward(request, response);
                    return;
                }
            }

            // Calculate result
            int total = s1 + s2 + s3 + s4 + s5;
            double avg = total / 5.0;

            boolean pass = true;
            for (int m : marks) {
                if (m < 40) {
                    pass = false;
                    break;
                }
            }

            String result = pass ? "PASS" : "FAIL";

            // Set attributes
            request.setAttribute("rollno", rollno);
            request.setAttribute("name", name);
            request.setAttribute("s1", s1);
            request.setAttribute("s2", s2);
            request.setAttribute("s3", s3);
            request.setAttribute("s4", s4);
            request.setAttribute("s5", s5);
            request.setAttribute("average", avg);
            request.setAttribute("result", result);

        } catch (Exception e) {
            request.setAttribute("error", "Invalid input");
        }

        request.getRequestDispatcher("Result1.jsp").forward(request, response);
    }
}