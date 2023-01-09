package api;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import dao.DenunciasDAO;
import dao.PrefeiturasDAO;
import dao.UsuariosDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Denuncias;
import modelo.Prefeituras;
import modelo.Usuarios;

@WebServlet(name="DenunciaAPI", urlPatterns={"/api/denuncia"})
public class Denuncia extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Denuncias denuncia;
        DenunciasDAO dao = new DenunciasDAO();
        denuncia = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id")));
        Usuarios usuario;
        usuario = denuncia.getUsuarioId();
        if (!usuario.getToken().equals(request.getParameter("token"))) {
            denuncia = null;
        }
        String json = new Gson().toJson(denuncia);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);    
        
            
        
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //receber latitude, longitude, obs, prefeitura_id, token
        modelo.Denuncias d = new modelo.Denuncias();
        UsuariosDAO udao = new UsuariosDAO();
        Usuarios u = null;
        try {
            u = udao.buscarPorToken(request.getParameter("token"));
        } catch (Exception ex) {
            Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (u == null) {
            u = new modelo.Usuarios();
            u.setToken(request.getParameter("token"));
            udao.incluir(u);
        }
        d.setLatitude(Float.parseFloat(request.getParameter("latitude")));
        d.setLongitude(Float.parseFloat(request.getParameter("longitude")));
        d.setObservacoes(request.getParameter("observacoes"));
        PrefeiturasDAO pdao = new PrefeiturasDAO();
        Prefeituras p = pdao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("prefeitura_id")));
        d.setPrefeituraId(p);
        d.setUsuarioId(u);
        d.setData(new Date());
        d.setStatus(1);
        DenunciasDAO dao = new DenunciasDAO();
        dao.incluir(d);
        d.setProtocolo(d.getPrefeituraId().getCodigo() + d.getId());
        
        String filePath = getServletContext().getRealPath("//arquivos/" + d.getId()+".jpg");
        File arquivo = new File(filePath);
	FileOutputStream imagem = new FileOutputStream(arquivo);
        String base = request.getParameter("imagem");
        try{
            byte[] foto = Base64.decode(base);
            imagem.write(foto);
        }catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        imagem.close();
        String path = ""+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/aedesapp-web/arquivos/"+d.getId()+".jpg";
        d.setImagem(path);
        dao = new DenunciasDAO();  
        dao.alterar(d);
        String json = new Gson().toJson(d);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
