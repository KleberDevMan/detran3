package br.com.detran3.bean.administrador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
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
public abstract class HomeAdministradorBean extends AbstractBean {

    private static final String EDIT_USUARIO = "editar-usuario?faces-redirect=true";

    public String editar(Integer idusuario2, int itemMenu) {
        Usuario user = new DAO<>(Usuario.class).buscaPorId(idusuario2);
        adicionaNaSessao(VariaveisSessao.ITEM_MENU_EDICAO, itemMenu);
        adicionaNaSessao(VariaveisSessao.USER_TEMPORARIO, user);
        return EDIT_USUARIO;
    }

    public void remover(Integer idusuario2) {
        Usuario user = new DAO<>(Usuario.class).buscaPorId(idusuario2);
        new DAO<>(Usuario.class).remove(user);
    }
}
