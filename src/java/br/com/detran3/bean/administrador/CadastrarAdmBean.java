package br.com.detran3.bean.administrador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.model.Usuario;
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
public class CadastrarAdmBean extends AbstractBean{

    private static final String HOME_ADM = "gerenciar-administradores?faces-redirect=true";

    private Usuario usuario = new Usuario();
    
    public String btnCadastrar() {
        usuario.setTipoUsuario(TipoUsuario.ADM);
        new DAO<>(Usuario.class).adiciona(usuario);
        exibirMensagemFlash("Administrador cadastrado");
        return HOME_ADM;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String btnCancelar() {
        return HOME_ADM;
    }

//    public List<TipoUsuario> getTiposUser() {
//        return Arrays.asList(TipoUsuario.values());
//    }

}
