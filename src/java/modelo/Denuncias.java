/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import util.StormData;

/**
 *
 * @author luan
 */
@Entity
@Table(name = "denuncias")
@NamedQueries({
    @NamedQuery(name = "Denuncias.findAll", query = "SELECT d FROM Denuncias d ORDER BY d.dataCriacao"),
    @NamedQuery(name = "Denuncias.findByToken", query = "SELECT d FROM Denuncias d WHERE d.usuarioId.token = :token ORDER BY d.dataCriacao"),
    @NamedQuery(name = "Denuncias.findByDataIntervalo", query = "SELECT d FROM Denuncias d WHERE d.dataCriacao BETWEEN :data1 and :data2 ORDER BY d.dataCriacao"),
    @NamedQuery(name = "Denuncias.findByData", query = "SELECT d FROM Denuncias d WHERE d.dataCriacao = :data ORDER BY d.dataCriacao"),
    @NamedQuery(name = "Denuncias.findByStatus", query = "SELECT d FROM Denuncias d WHERE d.status = :status ORDER BY d.dataCriacao")
})
public class Denuncias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private float latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private float longitude;
    @Size(max = 255)
    @Column(name = "imagem")
    private String imagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Size(max = 2147483647)
    @Column(name = "observacoes")
    private String observacoes;
    @Size(max = 255)
    @Column(name = "protocolo")
    private String protocolo;
    @JoinColumn(name = "prefeitura_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Prefeituras prefeituraId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Denuncias() {
    }

    public Denuncias(Integer id) {
        this.id = id;
    }

    public Denuncias(int id, int status, float latitude, float longitude, Date dataCriacao) {
        this.id = id;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusNome(){
        switch(this.status){
            case 1:
                return "Pendente";
            case 2:
                return "Concluído";
            case 3:
                return "Não Procede";
            case 4:
                return "Não foi possível verificar";
                
        }
        return "Desconhecido";
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getData() {
        return dataCriacao;
    }

    public void setData(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public String getDataFormatada()
    {
        return StormData.formata(this.dataCriacao);
    }
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Prefeituras getPrefeituraId() {
        return prefeituraId;
    }

    public void setPrefeituraId(Prefeituras prefeituraId) {
        this.prefeituraId = prefeituraId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "modelo.Denuncias[ id=" + id + " ]";
    }
    
}
