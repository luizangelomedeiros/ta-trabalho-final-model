package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class TesteInserirPessoaFisica {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setBairro("Boqueirão");
            pf.setCep("99834-987");
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setComplemento("Ap 999");
            pf.setCpf("774.784.645-21");
            pf.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
            pf.setEndereco("rua tal");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Jorge");
            pf.setRg("8747563474");
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
