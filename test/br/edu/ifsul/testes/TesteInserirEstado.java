package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteInserirEstado {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirEstado() {
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
            Estado es = new Estado();
            es.setNome("SANTA CATARINA");
            es.setUf("SC");
            em.getTransaction().begin();
            em.persist(es);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
