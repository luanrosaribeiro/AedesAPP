package api;

import com.google.gson.Gson;
import dao.DenunciasDAO;
import dao.UsuariosDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Denuncias", urlPatterns={"/api/denuncias"})
public class Denuncias extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        DenunciasDAO dao = new DenunciasDAO();      
        List<modelo.Denuncias> lista = null;
        try {
            lista = dao.buscarPorToken(request.getParameter("token"));
        } catch (Exception ex) {
            Logger.getLogger(Denuncias.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        String json = gson.toJson(lista);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

        }
        

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}
