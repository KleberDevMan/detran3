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
@Table(name = "multa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multa.findAll", query = "SELECT m FROM Multa m")
    , @NamedQuery(name = "Multa.findByIdMulta", query = "SELECT m FROM Multa m WHERE m.idMulta = :idMulta")
    , @NamedQuery(name = "Multa.findByDescricao", query = "SELECT m FROM Multa m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Multa.findByValor", query = "SELECT m FROM Multa m WHERE m.valor = :valor")
    , @NamedQuery(name = "Multa.findByDataVencimento", query = "SELECT m FROM Multa m WHERE m.dataVencimento = :dataVencimento")})
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMulta")
    private Integer idMulta;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @JoinColumn(name = "Veiculo_idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne
    private Veiculo veiculoidVeiculo;

    public Multa() {
    }

    public Multa(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Veiculo getVeiculoidVeiculo() {
        return veiculoidVeiculo;
    }

    public void setVeiculoidVeiculo(Veiculo veiculoidVeiculo) {
        this.veiculoidVeiculo = veiculoidVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMulta != null ? idMulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multa)) {
            return false;
        }
        Multa other = (Multa) object;
        if ((this.idMulta == null && other.idMulta != null) || (this.idMulta != null && !this.idMulta.equals(other.idMulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.detran3.model.Multa[ idMulta=" + idMulta + " ]";
    }
    
}
