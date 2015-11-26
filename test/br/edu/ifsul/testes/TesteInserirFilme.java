package br.edu.ifsul.testes;
import br.edu.ifsul.modelo.Filme;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TesteInserirFilme {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirFilme() {
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
            Filme pf = new Filme();            
            pf.setNome("Foi entao");            
            pf.setIdioma("Ingles");
            pf.setDuracao("10 min");
            pf.setNum_discos("4");
            pf.setData_lancamento(Calendar.getInstance());
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
