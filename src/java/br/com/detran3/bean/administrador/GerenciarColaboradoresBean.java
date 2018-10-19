package br.com.detran3.bean.administrador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kleber Junio
 */
@ManagedBean
@RequestScoped
public class GerenciarColaboradoresBean extends HomeAdministradorBean {

    private static final String LOGIN_ADM = "loginAdm?faces-redirect=true";
    private static final String EDIT_USUARIO = "editar-usuario?faces-redirect=true";
    private static final String NEW_USUARIO = "cadastrar-colaborador?faces-redirect=true";
    private Usuario admSession;

    private Usuario colaboradorParaCadastro;
    private Usuario admParaCadastro;

    @PostConstruct
    public void init() {
        if (admSession == null) {
            admSession = (Usuario) pegaDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        }
    }

    public void autenticar() {
        if (admSession == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/detran3/colaborador/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(GerenciarColaboradoresBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public String btnNew() {
        return EDIT_USUARIO;
    }

//    public String editar(Integer idusuario2) {
//        Usuario user = new DAO<>(Usuario.class).buscaPorId(idusuario2);
//        adicionaNaSessao(VariaveisSessao.USER_TEMPORARIO, user);
//        return EDIT_USUARIO;
//    }

//    public void remover(Integer idusuario2) {
//        Usuario user = new DAO<>(Usuario.class).buscaPorId(idusuario2);
//        new DAO<>(Usuario.class).remove(user);
//    }

    public String novo() {
        return NEW_USUARIO;
    }

    public void salvar() {
        System.out.println("salvando...");
    }

    public String sair() {
        removeDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        return LOGIN_ADM;
    }

    public Usuario getAdmSession() {
        return admSession;
    }

    public List<Usuario> getAdministradores() {
        List<Usuario> list = new DAO<>(Usuario.class).listaUsuarios(TipoUsuario.ADM);
        return list;
    }

    public List<Usuario> getColaboradores() {
        return new DAO<>(Usuario.class).listaUsuarios(TipoUsuario.COLABORADOR);
//        return list;
    }

    public Usuario getAdmParaCadastro() {
        return admParaCadastro;
    }

    public void setAdmParaCadastro(Usuario admParaCadastro) {
        this.admParaCadastro = admParaCadastro;
    }

    public Usuario getColaboradorParaCadastro() {
        return colaboradorParaCadastro;
    }

    public void setColaboradorParaCadastro(Usuario colaboradorParaCadastro) {
        this.colaboradorParaCadastro = colaboradorParaCadastro;
    }

}
