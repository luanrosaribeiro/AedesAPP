package controle;

import dao.AdminsDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Admins;

@WebServlet(name="Logout", urlPatterns={"/logout"})
public class Logout extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {  
        request.getSession().setAttribute("admin", null);
        request.getSession().setAttribute("erro", "Você não está mais logado!");
        response.sendRedirect("./prefeitura/login");
        
    } 

}
