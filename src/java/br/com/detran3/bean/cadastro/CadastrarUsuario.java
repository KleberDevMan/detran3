package br.com.detran3.bean.cadastro;

import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.model.Usuario2;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class CadastrarUsuario {

    private static final String HOME_COLABORADOR = "home-administrador?faces-redirect=true";

    private Usuario2 usuario = new Usuario2();

    public String btnCadastrar() {
        new DAO<>(Usuario2.class).adiciona(usuario);
        return "";
    }

    public Usuario2 getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario2 usuario) {
        this.usuario = usuario;
    }

    public String btnCancelar() {
        return HOME_COLABORADOR;
    }

    public List<TipoUsuario> getTiposUser() {
        return Arrays.asList(TipoUsuario.values());
    }

}
