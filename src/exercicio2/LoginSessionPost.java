package exercicio2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginSessionPost")
public class LoginSessionPost extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendLogin(response, true);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        if ((user != null && !user.isEmpty()) && (senha != null && !senha.isEmpty())) {
            Cookie usuario = new Cookie("user", user);
            Cookie password = new Cookie("senha", senha);

            response.addCookie(usuario);
            response.addCookie(password);

            RequestDispatcher rd = request.getRequestDispatcher("/LoginSessionOkPost");
            rd.include(request, response);
        } else {
            sendLogin(response, false);
        }
    }

    protected void sendLogin(HttpServletResponse response, Boolean sucesso) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Post Servlet </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Login Post </h1>");

        if (!sucesso) {
            out.println("<h2 style='color: red'>Login Failed. Please try again. <br></h2>");
        }

        out.println("<form method='post' action='LoginSessionPost'>");
        out.println("<label>Nome:</label>");
        out.println("<input type='text' value='' name='user'>");
        out.println("<label>Senha:</label>");
        out.println("<input type='password' value='' name='senha'>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
