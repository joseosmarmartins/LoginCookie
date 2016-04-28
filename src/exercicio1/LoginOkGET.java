package exercicio1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginOkGET", urlPatterns = "/LoginOkGET")
public class LoginOkGET extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("user");
        String senha = req.getParameter("pass");

        if (nome == null || senha == null) {
            RequestDispatcher rd = req.getRequestDispatcher("LoginCookieGet");
            rd.include(req, resp);
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Ok GET</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br><h1>Login Ok GET</h1></br>");
        out.println("<br><h2>Usuario:" + nome + "</h2></br>");
        out.println("<br><h2>Senha:" + senha + "</h2></br>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
