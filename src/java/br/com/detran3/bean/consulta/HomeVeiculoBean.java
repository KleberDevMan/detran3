package br.com.detran3.bean.consulta;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.bean.colaborador.HomeColaboradorBean;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Veiculo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kleber Junio
 */
@ManagedBean
@RequestScoped
public class HomeVeiculoBean extends AbstractBean {

    private Veiculo veiculoSession;

    public void verificaSeLogou() {
        if (veiculoSession == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/detran3/inicio.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(HomeColaboradorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @PostConstruct
    public void init() {
        if (veiculoSession == null) {
            veiculoSession = (Veiculo) pegaDaSessao(VariaveisSessao.VEICULO);
        }
    }

    public Veiculo getVeiculoSession() {
        return veiculoSession;
    }
    
    public void sair() {
        removeDaSessao(VariaveisSessao.VEICULO);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/detran3/inicio.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(HomeVeiculoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
