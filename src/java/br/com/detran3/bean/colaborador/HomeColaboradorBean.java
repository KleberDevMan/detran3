package br.com.detran3.bean.colaborador;

import br.com.detran3.bean.AbstractBean;
import br.com.detran3.dao.DAO;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Proprietario;
import br.com.detran3.model.Usuario;
import br.com.detran3.model.Veiculo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kleber Junio
 */
@ManagedBean
@ViewScoped
public class HomeColaboradorBean extends AbstractBean {

    private static final String LOGIN = "/colaborador/login?faces-redirect=true";
    
    private static final String NEW_PROPRIETARIO = "cadastrar-proprietario?faces-redirect=true";
    private static final String NEW_VEICULO = "cadastrar-veiculo?faces-redirect=true";
    
    private Usuario colaboradorSession;

    @PostConstruct
    public void init() {
        if (colaboradorSession == null) {
            colaboradorSession = (Usuario) pegaDaSessao(VariaveisSessao.USER_COLABORADOR);
        }
    }

    public void verificaSeLogou() {
        if (colaboradorSession == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/detran3/colaborador/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(HomeColaboradorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String sair() {
        getSession().invalidate();
        return LOGIN;
    }
    public Usuario getColaboradorSession() {
        return colaboradorSession;
    }
    
    //---------------------------------------->>> PROPRIETARIO
    public void removerProprietario(Integer id) {
        Proprietario proprietario = new DAO<>(Proprietario.class).buscaPorId(id);
        new DAO<>(Proprietario.class).remove(proprietario);
    }

    public List<Proprietario> getProprietarios() {
        List<Proprietario> list = new DAO<>(Proprietario.class).listaTodos();
        return list;
    }

    public String novoProprietario() {
        return NEW_PROPRIETARIO;
    }
    
    public String editarProprietario(Integer id) {
        Proprietario p = new DAO<>(Proprietario.class).buscaPorId(id);
        adicionaNaSessao(VariaveisSessao.PROPRIETARIO_PARA_EDICAO, p);
        return NEW_PROPRIETARIO;
    }
    
    //---------------------------------------->>> VEICULO
    public void removerVeiculo(Integer id) {
        Veiculo veiculo = new DAO<>(Veiculo.class).buscaPorId(id);
        new DAO<>(Veiculo.class).remove(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        List<Veiculo> list = new DAO<>(Veiculo.class).listaTodos();
        return list;
    }

    public String novoVeiculo() {
        return NEW_VEICULO;
    }
    
    public String nomeProprietario(Integer id) {
        Proprietario proprietario = new DAO<>(Proprietario.class).buscaPorId(id);
        return proprietario.getNome();
    }
    
    public String editarVeiculo(Integer id) {
        Veiculo v = new DAO<>(Veiculo.class).buscaPorId(id);
        adicionaNaSessao(VariaveisSessao.VEICULO_PARA_EDICAO, v);
        return NEW_VEICULO;
    }
}
