/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Admins;
/**
 *
 * @author Claudio
 */
@WebFilter(filterName = "verificar", urlPatterns = {"/prefeitura/*"})
public class verificar implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpSession session = ((HttpServletRequest)request).getSession();
        Admins admin = (Admins) session.getAttribute("admin");
        if (admin == null) {
            admin = new Admins();
        }
        String path = ((HttpServletRequest)request).getRequestURI();
        if ((path.startsWith("/aedesapp-web/prefeitura/login") || path.startsWith("/aedesapp-web/prefeitura/assets")) || (admin.getId()!= null)) {
            chain.doFilter(request, response);
            
        }
        else{
            //chain.doFilter(request, response);
            session.setAttribute("erro", "Você não está logado no Sistema. Por Favor faça login para prosseguir");
            ((HttpServletResponse)response).sendRedirect("../prefeitura/login");
        }
            
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    