package br.com.detran3.security;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.enuns.VariaveisSessao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kleber
 */
@ManagedBean
@RequestScoped
public class Administrador extends AbstractBean{
 
    private boolean admAutenticado;

    public boolean isAdmAutenticado() {
        return admAutenticado;
    }

    public void setAdmAutenticado(boolean admAutenticado) {
        this.admAutenticado = admAutenticado;
    }
    
    @PostConstruct
    public void init() {
        admAutenticado = pegaDaSessao(VariaveisSessao.USER_ADMINISTRADOR) !=  null;
    }
    
}
