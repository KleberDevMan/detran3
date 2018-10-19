package br.com.detran3.dao;

import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Usuario;
import br.com.detran3.model.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Frederico
 */
public class DAO<T> {

    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adiciona(T t) {

        // consegue a entity manager
        EntityManager em = new JPAUtil().getEntityManager();

        // abre transacao
        em.getTransaction().begin();

        // persiste o objeto
        em.persist(t);

        // commita a transacao
        em.getTransaction().commit();

        // fecha a entity manager
        em.close();
    }

    public void remove(T t) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(t));

        em.getTransaction().commit();
        em.close();
    }

    public void atualiza(T t) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    public List<T> listaTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = em.createQuery(query).getResultList();

        em.close();
        return lista;
    }

    public T buscaPorId(Integer id) {
        EntityManager em = new JPAUtil().getEntityManager();
        T instancia = em.find(classe, id);
        em.close();
        return instancia;
    }

    public int contaTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
        long result = (Long) em.createQuery("select count(n) from livro n")
                .getSingleResult();
        em.close();

        return (int) result;
    }

    public List<T> listaTodosPaginada(int firstResult, int maxResults) {
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = em.createQuery(query).setFirstResult(firstResult)
                .setMaxResults(maxResults).getResultList();

        em.close();
        return lista;
    }

    public T autenticarVeiculo(String placa, String renavam) {

        EntityManager em = new JPAUtil().getEntityManager();

        T result = null;
        try {
            result = (T) em.createNamedQuery("Veiculo.findVeiculo", Veiculo.class)
                    .setParameter("placa", placa).setParameter("renavam", renavam)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("erro: veiculo nao encontrado");
        }

        em.close();

        return result;

    }

    public Usuario autenticar(String usuario, String senha, TipoUsuario tipo) {

        EntityManager em = new JPAUtil().getEntityManager();
      
        Usuario user = null;
        
        try {
            user = (Usuario) em.createNamedQuery("Usuario.autentica", Usuario.class)
                    .setParameter("usuario", usuario)
                    .setParameter("senha", senha)
                    .setParameter("tipo", tipo)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("erro: "+e);
        }

        em.close();
        
        return user;
    }
    
    public List<Usuario> listaUsuarios(TipoUsuario tipo) {
        EntityManager em = new JPAUtil().getEntityManager();
      
        List<Usuario> users = null;
        
        try {
            users = em.createNamedQuery("Usuario.listar", Usuario.class)
                    .setParameter("tipo", tipo).getResultList();
        } catch (Exception e) {
            System.out.println("erro: "+e);
        }

        em.close();
        
        return users;
    }
    
}
