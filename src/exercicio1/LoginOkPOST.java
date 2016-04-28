package exercicio1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginOkPost",
        urlPatterns = "/LoginOkPost")
public class LoginOkPOST extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("user");
        String senha = request.getParameter("senha");

        if (nome == null || senha == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginCookiePost");
            rd.include(request, response);
        } else {

            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title> Login OK POST Servlet </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login OK POST </h1>");
            out.println("<h2> Usuario:" + nome + "</h2>");
            out.println("<h2> senha:" + senha + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
