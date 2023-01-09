package controle;

import dao.DenunciasDAO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import util.Notificacao;


@WebServlet(name="Status", urlPatterns={"/prefeitura/status"})
public class Status extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DenunciasDAO dao = new DenunciasDAO();
        modelo.Denuncias d;
        d = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id")));
        d.setStatus(Integer.parseInt(request.getParameter("status")));
        dao.alterar(d);
        
        try {
            Notificacao.pushFCMNotification(d.getUsuarioId().getToken(), d.getId());
        } catch (Exception ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("denuncia", d);
        RequestDispatcher view = request.getRequestDispatcher("./denuncias");
        view.forward(request, response);
        
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}
