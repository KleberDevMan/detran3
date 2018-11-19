package br.com.detran3.bean.colaborador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Proprietario;
import br.com.detran3.model.Veiculo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@RequestScoped
public class CadastrarVeiculoBean extends AbstractBean {

    private static final String HOME_COLABORADOR = "page-veiculo?faces-redirect=true";
    private Veiculo veiculo = new Veiculo();
    private String labelBtn;
    private static final String CADASTRAR = "Cadastrar";
    private static final String EDITAR = "Editar";

    @PostConstruct
    public void init() {
        veiculo = (Veiculo) pegaDaSessao(VariaveisSessao.VEICULO_PARA_EDICAO);
        if (veiculo == null) {
            //CRIA
            veiculo = new Veiculo();
            labelBtn = CADASTRAR;
        } else {
            //EDITA
            labelBtn = EDITAR;
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public String btnOk() {

        if (labelBtn.equals(CADASTRAR)) {
            //CRIA
            new DAO<>(Veiculo.class).adiciona(veiculo);
            veiculo = new Veiculo();
        } else {
            //EDITA
            new DAO<>(Veiculo.class).atualiza(veiculo);
            removeDaSessao(VariaveisSessao.VEICULO_PARA_EDICAO);
            exibirMensagemFlash("Alterações salvas.");
        }
        return HOME_COLABORADOR;
    }

    public String btnCancelar() {
        return HOME_COLABORADOR;
    }

    public List<Proprietario> getProprietarios() {
        return new DAO<Proprietario>(Proprietario.class).listaTodos();
    }

    public String getLabelBtn() {
        return labelBtn;
    }
    
    
}
