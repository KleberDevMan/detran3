package br.com.detran3.bean.login;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Usuario2;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class LoginBean extends AbstractBean{
    
    private static final String HOME_COLABORADOR = "gerenciar-proprietarios?faces-redirect=true";
    private static final String LOGIN_ADMINISTRADOR = "/administrador/loginAdm?faces-redirect=true";
    
    Usuario2 colaborador = new Usuario2();
    
    public String btnBuscarClick() {
        if (colaborador.getUsuario().equals("adm")
                &&colaborador.getSenha().equals("adm")) {
            return LOGIN_ADMINISTRADOR;
        }
        return autenticarColaborador();
    }

    private String autenticarColaborador() {
        Usuario2 cRetornado = new DAO<>(Usuario2.class)
                .autenticar(colaborador.getUsuario(), colaborador.getSenha(), TipoUsuario.COLABORADOR);
        if (cRetornado != null) {
            adicionaNaSessao(VariaveisSessao.USER_COLABORADOR, cRetornado);
            colaborador = new Usuario2();
            return HOME_COLABORADOR;
        } else {
            exibirMensagem("colaborador nao encontrado");
            colaborador = new Usuario2();
            return "";
        }
    }

    public Usuario2 getColaborador() {
        return colaborador;
    }
}    

    
