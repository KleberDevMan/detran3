package br.com.detran3.bean.cadastro;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.model.Usuario2;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class CadastrarUsuarioBean extends AbstractBean{

    private static final String HOME_ADM = "gerenciar-administradores?faces-redirect=true";

    private Usuario2 usuario = new Usuario2();
    
    public String btnCadastrar() {
        new DAO<>(Usuario2.class).adiciona(usuario);
        exibirMensagemFlash("Usuario cadastrado");
        return HOME_ADM;
    }

    public Usuario2 getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario2 usuario) {
        this.usuario = usuario;
    }

    public String btnCancelar() {
        return HOME_ADM;
    }

    public List<TipoUsuario> getTiposUser() {
        return Arrays.asList(TipoUsuario.values());
    }

}
