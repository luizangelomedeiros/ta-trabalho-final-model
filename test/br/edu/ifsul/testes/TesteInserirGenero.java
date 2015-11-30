package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Genero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteInserirGenero {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirGenero() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-FINAL-PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste(){
        boolean excecao = false;
        try {
            Genero e = new Genero();
            e.setNome("AÇÃO");
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
