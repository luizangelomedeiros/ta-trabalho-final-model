
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Filme;
import br.edu.ifsul.modelo.Genero;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInserirGenero {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TA-FINAL-PU");
            em = emf.createEntityManager();
            Filme obj = em.find(Filme.class, 3);
            Genero p = em.find(Genero.class,1);
            obj.getFilme_genero().add(p);
            em.getTransaction().begin();            
            em.persist(obj); // insert
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
