package br.com.detran3.bean.home;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Usuario2;
import java.util.List;
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
    private Usuario2 administrador;
    
    private Usuario2 novoAdm;
    private Usuario2 novoColaborador;

    @PostConstruct
    public void init() {
        if (administrador == null) {
            administrador = (Usuario2) pegaDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        }
    }

    public void salvar() {
        System.out.println("salvando...");
    }
    
    public String sair() {
        removeDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        return LOGIN_ADM;
    }

    public Usuario2 getAdministrador() {
        return administrador;
    }
    
    public List<Usuario2> getAdministradores() {
        List<Usuario2> list =     new DAO<>(Usuario2.class).listaTodos();
        return list;
    }

    public Usuario2 getNovoAdm() {
        return novoAdm;
    }

    public void setNovoAdm(Usuario2 novoAdm) {
        this.novoAdm = novoAdm;
    }

    public Usuario2 getNovoColaborador() {
        return novoColaborador;
    }

    public void setNovoColaborador(Usuario2 novoColaborador) {
        this.novoColaborador = novoColaborador;
    }
    
    
}
