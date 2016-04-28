package exercicio2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginSessionOkPost", urlPatterns = "/LoginSessionOkPost")
public class LoginSessionOkPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("user");
        String senha = request.getParameter("senha");

        HttpSession sessao = request.getSession();

        sessao.setAttribute("usuario", nome);
        sessao.setAttribute("senha", senha);

        if (sessao.getAttribute("usuario") == null || sessao.getAttribute("senha") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginSessionPost");
            rd.include(request, response);
        } else {
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title> Login OK POST Servlet </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login OK POST </h1>");
            out.println("<form method='post' action='LogoutSessionPost'>");
            out.println("<h2> Usuario:" + nome + "</h2>");
            out.println("<h2> Senha:" + senha + "</h2>");
            out.println("<input type='submit' value='Sair'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
