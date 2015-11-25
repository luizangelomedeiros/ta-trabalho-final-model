package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TesteInserirCidade {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirCidade() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2015-2-6N1-ModelPU");
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
            Estado e = em.find(Estado.class, 5);
            Cidade c = new Cidade();
            c.setNome("Passo Fundo");
            c.setEstado(e);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
