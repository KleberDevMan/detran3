package br.com.detran3.bean.cadastro;

import br.com.detran3.dao.DAO;
import br.com.detran3.model.Proprietario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@ViewScoped
public class CadastrarProprietario {
    
    private Proprietario proprietario = new Proprietario();

    public String btnCadastrar() {        
        new DAO<Proprietario>(Proprietario.class).adiciona(proprietario);
        proprietario = new Proprietario();
        return "";
    }

    public Proprietario getProprietario() {
        return proprietario;
    } 
    
    public String btnCancelar() {
        return "home-colaborador?faces-redirect=true";
    }

}
