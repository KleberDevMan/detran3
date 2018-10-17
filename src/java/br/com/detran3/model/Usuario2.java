package br.com.detran3.model;

import br.com.detran3.enuns.TipoUsuario;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author KLEBER
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario2.autentica", query = "SELECT u FROM Usuario2 u WHERE u.usuario = :usuario and u.senha = :senha and u.tipoUsuario = :tipo")
        ,@NamedQuery(name = "Usuario2.listar", query = "SELECT u FROM Usuario2 u WHERE u.tipoUsuario = :tipo")})
public class Usuario2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario2")
    private Integer idusuario2;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "senha")
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario2() {
    }

    public Usuario2(Integer idusuario2) {
        this.idusuario2 = idusuario2;
    }

    public Integer getIdusuario2() {
        return idusuario2;
    }

    public void setIdusuario2(Integer idusuario2) {
        this.idusuario2 = idusuario2;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario2 != null ? idusuario2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario2)) {
            return false;
        }
        Usuario2 other = (Usuario2) object;
        if ((this.idusuario2 == null && other.idusuario2 != null) || (this.idusuario2 != null && !this.idusuario2.equals(other.idusuario2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.detran3.model.Usuario2[ idusuario2=" + idusuario2 + " ]";
    }
    
}
