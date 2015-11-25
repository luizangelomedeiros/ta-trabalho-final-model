
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Genero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInserirGenero {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TA-FINAL-PU");
        EntityManager em = emf.createEntityManager();
        Genero obj = new Genero();
        obj.setNome("Ação");
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
