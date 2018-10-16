package br.com.detran3.bean.cadastro;

import br.com.detran3.dao.DAO;
import br.com.detran3.model.Administrador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class CadastrarAdministrador {

    private static final String HOME_COLABORADOR = "home-colaborador?faces-redirect=true";

    private Administrador adm = new Administrador();

    public String btnCadastrar() {
        new DAO<>(Administrador.class).adiciona(adm);
        return "";
    }

    public Administrador getAdm() {
        return adm;
    }

    public String btnCancelar() {
        return HOME_COLABORADOR;
    }

}
