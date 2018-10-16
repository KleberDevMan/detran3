package br.com.detran3.bean.home;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Administrador;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kleber Junio
 */
@ManagedBean
@RequestScoped
public class HomeAdmBean extends AbstractBean {

    private static final String LOGIN_ADM = "loginAdm?faces-redirect=true";
    private Administrador administrador;

    @PostConstruct
    public void init() {
        if (administrador == null) {
            administrador = (Administrador) pegaDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        }
    }

    public String sair() {
        removeDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        return LOGIN_ADM;
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
