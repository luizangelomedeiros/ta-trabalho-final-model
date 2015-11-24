package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Telefone;
import java.util.Calendar;
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
public class TesteInserirTelefonePessoa {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirTelefonePessoa() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Telefone t = new Telefone();
            t.setNumero("(54)9888-9848");
            t.setDescricao("celular");
            pf.adicionarTelefone(t);
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
