/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran3.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KLEBER
 */
@Entity
@Table(name = "imagemproprietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagemproprietario.findAll", query = "SELECT i FROM Imagemproprietario i")
    , @NamedQuery(name = "Imagemproprietario.findByIdImagemProprietario", query = "SELECT i FROM Imagemproprietario i WHERE i.idImagemProprietario = :idImagemProprietario")
    , @NamedQuery(name = "Imagemproprietario.findByDiretorio", query = "SELECT i FROM Imagemproprietario i WHERE i.diretorio = :diretorio")
    , @NamedQuery(name = "Imagemproprietario.findByDataRegistro", query = "SELECT i FROM Imagemproprietario i WHERE i.dataRegistro = :dataRegistro")})
public class Imagemproprietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImagemProprietario")
    private Integer idImagemProprietario;
    @Column(name = "diretorio")
    private String diretorio;
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.DATE)
    private Date dataRegistro;
    @JoinColumn(name = "Proprietario_idProprietario", referencedColumnName = "idProprietario")
    @ManyToOne
    private Proprietario proprietarioidProprietario;

    public Imagemproprietario() {
    }

    public Imagemproprietario(Integer idImagemProprietario) {
        this.idImagemProprietario = idImagemProprietario;
    }

    public Integer getIdImagemProprietario() {
        return idImagemProprietario;
    }

    public void setIdImagemProprietario(Integer idImagemProprietario) {
        this.idImagemProprietario = idImagemProprietario;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Proprietario getProprietarioidProprietario() {
        return proprietarioidProprietario;
    }

    public void setProprietarioidProprietario(Proprietario proprietarioidProprietario) {
        this.proprietarioidProprietario = proprietarioidProprietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagemProprietario != null ? idImagemProprietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagemproprietario)) {
            return false;
        }
        Imagemproprietario other = (Imagemproprietario) object;
        if ((this.idImagemProprietario == null && other.idImagemProprietario != null) || (this.idImagemProprietario != null && !this.idImagemProprietario.equals(other.idImagemProprietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.detran3.model.Imagemproprietario[ idImagemProprietario=" + idImagemProprietario + " ]";
    }
    
}
