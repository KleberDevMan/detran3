package br.com.detran3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Frederico
 */
public class JPAUtil {

    private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("detran4");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close(EntityManager em) {
        em.close();
    }
}
