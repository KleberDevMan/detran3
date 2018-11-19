package br.com.detran3.bean.colaborador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Proprietario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KLEBER
 */
@ManagedBean
@ViewScoped
public class CadastrarProprietarioBean extends AbstractBean {

    private static final String HOME_COLABORADOR = "page-proprietario?faces-redirect=true";

    private Proprietario proprietario;
    private String labelBtn;
    private static final String CADASTRAR = "Cadastrar";
    private static final String EDITAR = "Editar";

    @PostConstruct
    public void init() {
        proprietario = (Proprietario) pegaDaSessao(VariaveisSessao.PROPRIETARIO_PARA_EDICAO);
        if (proprietario == null) {
            //CRIA
            proprietario = new Proprietario();
            labelBtn = CADASTRAR;
        } else {
            //EDITA
            labelBtn = EDITAR;
        }
    }

    public String btnOk() {

        if (labelBtn.equals(CADASTRAR)) {
            //CRIA
            new DAO<Proprietario>(Proprietario.class).adiciona(proprietario);
            proprietario = new Proprietario();
        } else {
            //EDITA
            new DAO<>(Proprietario.class).atualiza(proprietario);
            removeDaSessao(VariaveisSessao.PROPRIETARIO_PARA_EDICAO);
            exibirMensagemFlash("Alterações salvas.");
        }
        return HOME_COLABORADOR;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public String btnCancelar() {
        return HOME_COLABORADOR;
    }

    public String getLabelBtn() {
        return labelBtn;
    }

}
