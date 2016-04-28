package exercicio2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutSessionPost", urlPatterns = "/LogoutSessionPost")
public class LogoutSessionPost extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        sessao.invalidate();

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> Logout POST Servlet </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Usuário deslogado com sucesso!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
