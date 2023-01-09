/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
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

public abstract class BaseServlet extends HttpServlet {
    
    protected abstract String getPagina();
    
    
    protected void finish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if (request.getSession().getAttribute("administrador") == null) {
            response.sendRedirect("./login");
            return;
            
        } else {
            
            Admins adm = (Admins)request.getSession().getAttribute("administrador");
            request.setAttribute("adm", adm);
            
            RequestDispatcher view = request.getRequestDispatcher(this.getPagina());
            view.forward(request, response);
        }
        
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
