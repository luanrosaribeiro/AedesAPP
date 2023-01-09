package controle;

import dao.DenunciasDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="detalhes", urlPatterns={"/prefeitura/detalhes"})
public class detalhes extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DenunciasDAO dao = new DenunciasDAO();
        modelo.Denuncias d;
        d = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("denuncia", d);
        
        RequestDispatcher view = request.getRequestDispatcher("detalhes.jsp");
        view.forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}
