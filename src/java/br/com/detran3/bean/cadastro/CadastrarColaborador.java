package br.com.detran3.bean.cadastro;

import br.com.detran3.dao.DAO;
import br.com.detran3.model.Colaborador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class CadastrarColaborador {

    private static final String HOME_COLABORADOR = "home-colaborador?faces-redirect=true";
    private Colaborador colaborador = new Colaborador();

    public String btnCadastrar() {
        new DAO<>(Colaborador.class).adiciona(colaborador);
        return "";
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public String btnCancelar() {
        return HOME_COLABORADOR;
    }

}
