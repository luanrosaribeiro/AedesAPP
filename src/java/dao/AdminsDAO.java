/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.Query;
import modelo.Admins;

/**
 *
 * @author luan
 */
public class AdminsDAO extends GenericDAO<Admins, Integer>{
    public AdminsDAO()
    {
        super(Admins.class);
    }
    public Admins logar(String email, String senha)
    {
        Admins retorno;
        Query q = em.createNamedQuery("Admins.login").setParameter("email", email).setParameter("senha", senha);
        try {
            retorno = (Admins) q.getSingleResult();
            
        } catch (Exception e) {
            retorno = null;
        }
        return retorno;
    }
}
