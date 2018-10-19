package br.com.detran3.bean.colaborador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.model.Proprietario;
import br.com.detran3.model.Veiculo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class CadastrarVeiculoBean extends AbstractBean {
    
    private Veiculo veiculo = new Veiculo();

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    public String btnCadastrar() {        
        new DAO<Veiculo>(Veiculo.class).adiciona(veiculo);
        return "home-colaborador?faces-redirect=true";
    }
    
    public String btnCancelar() {
        return "home-colaborador?faces-redirect=true";
    }
    
    public List<Proprietario> getProprietarios() {
        return new DAO<Proprietario>(Proprietario.class).listaTodos();
    }
}
