/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran3.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KLEBER
 */
@Entity
@Table(name = "proprietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietario.findAll", query = "SELECT p FROM Proprietario p")
    , @NamedQuery(name = "Proprietario.findByIdProprietario", query = "SELECT p FROM Proprietario p WHERE p.idProprietario = :idProprietario")
    , @NamedQuery(name = "Proprietario.findByNome", query = "SELECT p FROM Proprietario p WHERE p.nome = :nome")
    , @NamedQuery(name = "Proprietario.findByCnh", query = "SELECT p FROM Proprietario p WHERE p.cnh = :cnh")
    , @NamedQuery(name = "Proprietario.findByCpf", query = "SELECT p FROM Proprietario p WHERE p.cpf = :cpf")})
public class Proprietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProprietario")
    private Integer idProprietario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnh")
    private String cnh;
    @Column(name = "cpf")
    private String cpf;
    @OneToMany(mappedBy = "proprietarioidProprietario")
    private List<Veiculo> veiculoList;
    @OneToMany(mappedBy = "proprietarioidProprietario")
    private List<Imagemproprietario> imagemproprietarioList;
    @JoinColumn(name = "Endereco_idEndereco", referencedColumnName = "idEndereco")
    @ManyToOne
    private Endereco enderecoidEndereco;
    @OneToMany(mappedBy = "proprietarioidProprietario")
    private List<Contato> contatoList;

    public Proprietario() {
    }

    public Proprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public Integer getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }

    @XmlTransient
    public List<Imagemproprietario> getImagemproprietarioList() {
        return imagemproprietarioList;
    }

    public void setImagemproprietarioList(List<Imagemproprietario> imagemproprietarioList) {
        this.imagemproprietarioList = imagemproprietarioList;
    }

    public Endereco getEnderecoidEndereco() {
        return enderecoidEndereco;
    }

    public void setEnderecoidEndereco(Endereco enderecoidEndereco) {
        this.enderecoidEndereco = enderecoidEndereco;
    }

    @XmlTransient
    public List<Contato> getContatoList() {
        return contatoList;
    }

    public void setContatoList(List<Contato> contatoList) {
        this.contatoList = contatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProprietario != null ? idProprietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proprietario)) {
            return false;
        }
        Proprietario other = (Proprietario) object;
        if ((this.idProprietario == null && other.idProprietario != null) || (this.idProprietario != null && !this.idProprietario.equals(other.idProprietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.detran3.model.Proprietario[ idProprietario=" + idProprietario + " ]";
    }
    
}
