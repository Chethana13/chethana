package chethu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NQueensServlet")
public class NQueensServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.jsp").include(request,response);        // Get the value of N from the request parameter
        int n = 4;
        
        // Solve the N-Queens problem
        NQueensSolver solver = new NQueensSolver(n);
        List<int[]> solutions = solver.solveNQueens();
        
        // Display the solutions
        out.println("<html><body>");
        out.println("<h1>Solutions for N-Queens Problem (N = " + n + ")</h1>");
        
        for (int[] solution : solutions) {
            out.println("<p>Queen Positions:</p>");
            out.println("<table border='1'>");
            
            for (int row = 0; row < n; row++) {
                out.println("<tr>");
                for (int col = 0; col < n; col++) {
                    if (solution[row] == col) {
                        out.println("<td style='background-color:#0000FF; color:#FFFFFF;'>Q</td>");
                    } else {
                        out.println("<td></td>");
                    }
                }
                out.println("</tr>");
            }
            out.println("</table>");
        }
        
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

