package br.com.detran3.bean.login;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Administrador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class LoginAdmBean extends AbstractBean{
    
    private static final String HOME_ADMINISTRADOR = "home-administrador?faces-redirect=true";
    private Administrador administrador = new Administrador();

    public String autenticarAdministrador() {
        Administrador cRetornado = new DAO<>(Administrador.class)
                .autenticarAdministrador(administrador.getUsuarioidUsuario().getUsuario(), administrador.getUsuarioidUsuario().getSenha());
        if (cRetornado != null) {
            adicionaNaSessao(VariaveisSessao.USER_ADMINISTRADOR, cRetornado);
            administrador = new Administrador();
            return HOME_ADMINISTRADOR;
        } else {
            exibirMensagem("administrador nao encontrado");
            administrador = new Administrador();
            return "";
        }
    }

    public Administrador getAdministrador() {
        return administrador;
    }

}    

    
