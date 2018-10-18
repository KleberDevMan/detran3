package br.com.detran3.bean.login;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class LoginAdmBean extends AbstractBean{
    
    private static final String HOME_ADMINISTRADOR = "gerenciar-administradores?faces-redirect=true";
    private Usuario administrador = new Usuario();

    public String autenticarAdministrador() {
        Usuario cRetornado = new DAO<>(Usuario.class)
                .autenticar(administrador.getUsuario(), administrador.getSenha(), TipoUsuario.ADM);
        if (cRetornado != null) {
            adicionaNaSessao(VariaveisSessao.USER_ADMINISTRADOR, cRetornado);
            administrador = new Usuario();
            return HOME_ADMINISTRADOR;
        } else {
            exibirMensagem("administrador nao encontrado");
            administrador = new Usuario();
            return "";
        }
    }

    public Usuario getAdministrador() {
        return administrador;
    }

}    

    
