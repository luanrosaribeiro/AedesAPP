package controle;

import dao.DenunciasDAO;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.StormData;

@WebServlet(name = "Denuncia", urlPatterns = {"/prefeitura/denuncias"})
public class Denuncia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DenunciasDAO dao = new DenunciasDAO();
        List<modelo.Denuncias> lista = null;
        if (request.getParameter("txtData1") == null && request.getParameter("status") == null) {
            lista = dao.listar();
            request.setAttribute("lista", lista);
        } else {
            if(request.getParameter("status") != null){
                Integer st = Integer.parseInt(request.getParameter("status"));
                try {
                    lista = dao.buscarPorStatus(st);
                    request.setAttribute("lista", lista);
                } catch (Exception ex) {
                    Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if (!"".equals(request.getParameter("txtData1")) && "".equals(request.getParameter("txtData2"))) {
                    String data = request.getParameter("txtData1");
                    Date formata = StormData.formata(data,"yyyy-MM-dd");
                    try {
                        lista = dao.buscarPorData(formata);
                        request.setAttribute("lista", lista);
                    } catch (Exception ex) {
                        Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(!"".equals(request.getParameter("txtData1")) && !"".equals(request.getParameter("txtData2"))){
                    String data1 = request.getParameter("txtData1");
                    String data2 = request.getParameter("txtData2");
                    Date formata1 = StormData.formata(request.getParameter("txtData1"),"yyyy-MM-dd");
                    Date formata2 = StormData.formata(request.getParameter("txtData2"),"yyyy-MM-dd");
                    try {
                        lista = dao.buscarPorDataIntervalo(formata1, formata2);
                        request.setAttribute("lista", lista);
                    } catch (Exception ex) {
                        Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    lista = dao.listar();
                    request.setAttribute("lista", lista);
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("denuncias.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("denuncias.jsp");
        view.forward(request, response);
    }

}
