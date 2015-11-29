
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cinema;
import br.edu.ifsul.modelo.Filme;
import br.edu.ifsul.modelo.Sessao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInserirSessao {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TA-FINAL-PU");
        EntityManager em = emf.createEntityManager();
        
        Filme f = new Filme();
        Filme ff = em.find(Filme.class, 42);
        
        Cinema c = new Cinema();
        Cinema cc = em.find(Cinema.class, 2);
        
        Sessao obj = new Sessao();
        obj.setData(Calendar.getInstance());
        obj.setHora("16h as 18h");
        obj.setValorInteiro(28.00);
        obj.setValorMeia(14.00);
        obj.setNumSala("25b");
       
        obj.setCinema(cc);
        obj.setFilme(ff);
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
