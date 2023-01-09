/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import modelo.Denuncias;

/**
 *
 * @author luan
 */
public class DenunciasDAO extends GenericDAO<Denuncias, Integer>{
    public DenunciasDAO(){
        super(Denuncias.class);
    }
        
    public List<Denuncias> buscarPorToken(String token) throws Exception{
        List<Denuncias> r = em.createNamedQuery("Denuncias.findByToken").setParameter("token",token).getResultList();
        return r;
    }
    
    public List<Denuncias> buscarPorData(Date data) throws Exception{
        List<Denuncias> r = em.createNamedQuery("Denuncias.findByData").setParameter("data",data).getResultList();
        return r;
    }
    public List<Denuncias> buscarPorDataIntervalo(Date data1, Date data2) throws Exception{
        List<Denuncias> r = em.createNamedQuery("Denuncias.findByDataIntervalo").setParameter("data1",data1).setParameter("data2", data2).getResultList();
        return r;
    }
    
    public List<Denuncias> buscarPorStatus(Integer status) throws Exception{
        List<Denuncias> r = em.createNamedQuery("Denuncias.findByStatus").setParameter("status",status).getResultList();
        return r;
    }
    
}
