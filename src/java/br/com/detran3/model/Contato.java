/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran3.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KLEBER
 */
@Entity
@Table(name = "contato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")
    , @NamedQuery(name = "Contato.findByIdContato", query = "SELECT c FROM Contato c WHERE c.idContato = :idContato")
    , @NamedQuery(name = "Contato.findByDdd", query = "SELECT c FROM Contato c WHERE c.ddd = :ddd")
    , @NamedQuery(name = "Contato.findByNumero", query = "SELECT c FROM Contato c WHERE c.numero = :numero")
    , @NamedQuery(name = "Contato.findByEmail", query = "SELECT c FROM Contato c WHERE c.email = :email")})
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContato")
    private Integer idContato;
    @Column(name = "ddd")
    private String ddd;
    @Column(name = "numero")
    private String numero;
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "Proprietario_idProprietario", referencedColumnName = "idProprietario")
    @ManyToOne
    private Proprietario proprietarioidProprietario;

    public Contato() {
    }

    public Contato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.detran3.model.Contato[ idContato=" + idContato + " ]";
    }
    
}
