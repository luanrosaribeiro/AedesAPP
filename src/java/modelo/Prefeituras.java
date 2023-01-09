/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luan
 */
@Entity
@Table(name = "prefeituras")
@NamedQueries({
    @NamedQuery(name = "Prefeituras.findAll", query = "SELECT p FROM Prefeituras p")})
public class Prefeituras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeituraId")
    private transient List<Denuncias> denunciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeituraId")
    private transient List<Admins> adminsList;

    public Prefeituras() {
    }

    public Prefeituras(Integer id) {
        this.id = id;
    }

    public Prefeituras(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Denuncias> getDenunciasList() {
        return denunciasList;
    }

    public void setDenunciasList(List<Denuncias> denunciasList) {
        this.denunciasList = denunciasList;
    }

    public List<Admins> getAdminsList() {
        return adminsList;
    }

    public void setAdminsList(List<Admins> adminsList) {
        this.adminsList = adminsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prefeituras)) {
            return false;
        }
        Prefeituras other = (Prefeituras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Prefeituras[ id=" + id + " ]";
    }
    
}
