/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuarios;

/**
 *
 * @author luan
 */
public class UsuariosDAO extends GenericDAO<Usuarios, Integer>{
    public UsuariosDAO(){
        super(Usuarios.class);
    }
    public Usuarios buscarPorToken(String token) throws Exception{
        Usuarios r = (Usuarios) em.createNamedQuery("Usuarios.findByToken").setParameter("token",token).getSingleResult();
        this.fecharConexao();
        return r;
    }
    
}
