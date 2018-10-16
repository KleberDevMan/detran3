package br.com.detran3.bean;

import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Veiculo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kleber Junio
 */
@ManagedBean
@RequestScoped
public class IndexBean extends AbstractBean {

    private static final String HOME_VEICULO = "/consulta/home-veiculo?faces-redirect=true";
    
    Veiculo veiculo = new Veiculo();

    //busco o veiculo e salvo em sessao
    public String btnBuscarClick() {
        Veiculo vRetornado = new DAO<>(Veiculo.class).autenticarVeiculo(veiculo.getPlaca(), veiculo.getRenavam());
        if (vRetornado != null) {
            adicionaNaSessao(VariaveisSessao.VEICULO, vRetornado);
            veiculo = new Veiculo();
            return HOME_VEICULO;
        } else {
            exibirMensagem("veiculo nao encontrado");
            veiculo = new Veiculo();
            return "";
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

}
