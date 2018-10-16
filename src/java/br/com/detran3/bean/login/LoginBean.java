package br.com.detran3.bean.login;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Colaborador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class LoginBean extends AbstractBean{
    
    private static final String HOME_COLABORADOR = "home-colaborador?faces-redirect=true";
    private static final String LOGIN_ADMINISTRADOR = "loginAdm?faces-redirect=true";
    
    Colaborador colaborador = new Colaborador();
    
    //busco o veiculo e salvo em sessao
    public String btnBuscarClick() {
        if (colaborador.getUsuarioidUsuario().getUsuario().equals("adm")
                &&colaborador.getUsuarioidUsuario().getSenha().equals("adm")) {
            return LOGIN_ADMINISTRADOR;
        }
        return autenticarColaborador();
    }

    private String autenticarColaborador() {
        Colaborador cRetornado = new DAO<>(Colaborador.class)
                .autenticarColaborador(colaborador.getUsuarioidUsuario().getUsuario(), colaborador.getUsuarioidUsuario().getSenha());
        if (cRetornado != null) {
            adicionaNaSessao(VariaveisSessao.USER_COLABORADOR, cRetornado);
            colaborador = new Colaborador();
            return HOME_COLABORADOR;
        } else {
            exibirMensagem("colaborador nao encontrado");
            colaborador = new Colaborador();
            return "";
        }
    }

    public Colaborador getColaborador() {
        return colaborador;
    }
    
    
    
    
}    

    
