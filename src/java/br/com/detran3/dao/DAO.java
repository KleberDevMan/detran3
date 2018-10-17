package br.com.detran3.dao;

import br.com.detran3.enuns.TipoUsuario;
import br.com.detran3.enuns.VariaveisSessao;
import br.com.detran3.model.Usuario2;
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
            result = (T) em.createNamedQuery("Veiculo.findByPlacaRenavam", Veiculo.class)
                    .setParameter("placa", placa).setParameter("renavam", renavam)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("erro: veiculo nao encontrado");
        }

        em.close();

        return result;

    }
//    public Colaborador autenticarColaborador(String usuario, String senha) {
//
//        EntityManager em = new JPAUtil().getEntityManager();
//
//        Colaborador c = null;
//        Usuario user = null;
//        
//        try {
//            user = (Usuario) em.createNamedQuery("Usuario.findByUsuarioSenha", Usuario.class)
//                    .setParameter("usuario", usuario).setParameter("senha", senha)
//                    .getSingleResult();
//        } catch (Exception e) {
//            System.out.println("erro: colaborador nao encontrado");
//        }
//
//        em.close();
//        
//        if (user != null) {
//            c = new Colaborador();
//            c.setUsuarioidUsuario(user);
//        }
//
//        return c;
//    }
//    
//    public Administrador autenticarAdministrador(String usuario, String senha) {
//
//        EntityManager em = new JPAUtil().getEntityManager();
//
//        Administrador adm = null;
//        Usuario user = null;
//        
//        try {
//            user = (Usuario) em.createNamedQuery("Usuario.findByUsuarioSenha", Usuario.class)
//                    .setParameter("usuario", usuario).setParameter("senha", senha)
//                    .getSingleResult();
//        } catch (Exception e) {
//            System.out.println("erro: administrador nao encontrado");
//        }
//
//        em.close();
//        
//        if (user != null) {
//            adm = new Administrador();
//            adm.setUsuarioidUsuario(user);
//        }
//
//        return adm;
//    }

//    public T autenticarAdminstrador(String usuario, String senha) {
//
//        EntityManager em = new JPAUtil().getEntityManager();
//
//        T result = null;
//        try {
//            result = (T) em.createNamedQuery("Administrador.findByUsuarioSenha", Administrador.class)
//                    .setParameter("usuario", usuario).setParameter("senha", senha)
//                    .getSingleResult();
//        } catch (Exception e) {
//            System.out.println("erro: administrador nao encontrado");
//        }
//
//        em.close();
//
//        return result;
//
//    }
//    public UsuarioServidor autenticar(UsuarioServidor usr){
//        EntityManager em = new JPAUtil().getEntityManager();
//        
//        Query query = em.createNamedQuery("Usuarioservidor.findByUsuarioSenha");
//        query.setParameter("usurio", usr.getUsuario());
//        query.setParameter("senha", usr.getSenha());
//        
//        List<UsuarioServidor> servidores = query.getResultList();
//        
//        em.close();
//        
//        return servidores.get(0);
//    }
//    

//    public Usuario2 autenticarUsuarioAdm(String usuario, String senha) {
//        EntityManager em = new JPAUtil().getEntityManager();
//      
//        Usuario2 user = null;
//        
//        try {
//            user = (Usuario2) em.createNamedQuery("Usuario2.autentica", Usuario2.class)
//                    .setParameter("usuario", usuario)
//                    .setParameter("senha", senha)
//                    .setParameter("tipo", TipoUsuario.ADM)
//                    .getSingleResult();
//        } catch (Exception e) {
//            System.out.println("erro: "+e);
//        }
//
//        em.close();
//        
//        return user;
//    }

    public Usuario2 autenticar(String usuario, String senha, TipoUsuario tipo) {
        EntityManager em = new JPAUtil().getEntityManager();
      
        Usuario2 user = null;
        
        try {
            user = (Usuario2) em.createNamedQuery("Usuario2.autentica", Usuario2.class)
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
    
    public List<Usuario2> listaUsuarios(TipoUsuario tipo) {
        EntityManager em = new JPAUtil().getEntityManager();
      
        List<Usuario2> users = null;
        
        try {
            users = em.createNamedQuery("Usuario2.listar", Usuario2.class)
                    .setParameter("tipo", tipo).getResultList();
        } catch (Exception e) {
            System.out.println("erro: "+e);
        }

        em.close();
        
        return users;
    }
    
}
