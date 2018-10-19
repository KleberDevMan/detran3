package br.com.detran3.bean.consulta;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Veiculo;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kleber Junio
 */
@ManagedBean
@RequestScoped
public class HomeVeiculoBean extends AbstractBean {

    private static final String INDEX = "inicio.xhtml?faces-redirect=true";
    private Veiculo veiculo;

    @PostConstruct
    public void init() {
        if (veiculo == null) {
            veiculo = (Veiculo) pegaDaSessao(VariaveisSessao.VEICULO);
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    public String sair() {
        removeDaSessao(VariaveisSessao.USER_ADMINISTRADOR);
        return INDEX;
    }
}
