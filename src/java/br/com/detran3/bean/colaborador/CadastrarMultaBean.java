package br.com.detran3.bean.colaborador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.model.Multa;
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
public class CadastrarMultaBean extends AbstractBean {

    private Multa multa = new Multa();
    private int idVeiculo;

    public String btnCadastrar() {

        System.out.println(multa);

//        Veiculo v = new Veiculo(new Long(1));
//        multa.setVeiculo(v);
//        
//        if (multa.getVeiculo() == null) {
//            addMensagem("é preciso escolher um veiculo");
//        }
        new DAO<>(Multa.class).adiciona(multa);
        return "";
    }

    public Multa getMulta() {
        return multa;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void gravarVeiculo() {
        Veiculo veiculo = new DAO<Veiculo>(Veiculo.class).buscaPorId(idVeiculo);
        System.out.println(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return new DAO<Veiculo>(Veiculo.class).listaTodos();
    }

    public String btnCancelar() {
        return "home-colaborador?faces-redirect=true";
    }
}
