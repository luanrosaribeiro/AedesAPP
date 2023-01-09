/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DenunciasDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import modelo.Admins;

/**
 *
 * @author luan
 */
@WebServlet(name = "Index", urlPatterns = {"/prefeitura/index"})
public class Index extends BaseServlet {

    @Override
    protected String getPagina() {
        return "principal.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DenunciasDAO dao = new DenunciasDAO();
        List<modelo.Denuncias> lista = dao.listar();
        Integer tamanho = lista.size();
        request.setAttribute("tamanho", tamanho);
        List<modelo.Denuncias> listadia = null;
        try {
            listadia = dao.buscarPorData(new Date());
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer tamanhodia;
        tamanhodia = listadia.size();
        request.setAttribute("tamanhodia", tamanhodia);
        List<modelo.Denuncias> lista1 = null;
        try {
            lista1 = dao.buscarPorStatus(1);
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer tamanho1 = lista1.size();
        request.setAttribute("tamanho1", tamanho1);
        List<modelo.Denuncias> lista2 = null;
        try {
            lista2 = dao.buscarPorStatus(2);
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer tamanho2 = lista2.size();
        request.setAttribute("tamanho2", tamanho2);
        List<modelo.Denuncias> lista3 = null;
        try {
            lista3 = dao.buscarPorStatus(3);
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer tamanho3 = lista3.size();
        request.setAttribute("tamanho3", tamanho3);
        List<modelo.Denuncias> lista4 = null;
        try {
            lista4 = dao.buscarPorStatus(4);
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer tamanho4 = lista4.size();
        request.setAttribute("tamanho4", tamanho4);
        request.setAttribute("lista", lista);
        RequestDispatcher view = request.getRequestDispatcher("principal.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
