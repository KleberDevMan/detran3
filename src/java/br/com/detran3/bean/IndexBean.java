package br.com.detran3.bean;

import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Veiculo;
import java.util.concurrent.ThreadLocalRandom;
import javax.faces.application.FacesMessage;
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
    
    private boolean check;
    private String[] frases =  {"O importante não é vencer todos os dias, mas lutar sempre."
            , "Enquanto houver vontade de lutar haverá esperança de vencer."
            ,"Arriscamo-nos a perder quando queremos ganhar demais." 
            , "Se você pretende ser rico, pense em economizar tanto quanto em ganhar."};

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    

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

    
    public void exibirFraseDoDia() {
        if (check) {
            getContext().addMessage(":form:msg", new FacesMessage(frases[ThreadLocalRandom.current().nextInt(0, 3)]));
            
        }
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

}
