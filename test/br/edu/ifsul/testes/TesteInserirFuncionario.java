package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TesteInserirFuncionario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteInserirFuncionario() {
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
        boolean ativo = true;
        try {
            Funcionario f = new Funcionario();
            f.setNome("Luiz Ângelo");
            f.setCpf("000-000-000-00");
            f.setData_nascimento(Calendar.getInstance());
            f.setEstado_civil("Solteiro");
            f.setEndereco("Eduardo de Brito 321");
            f.setUsuario("luizmedeiros");
            f.setSenha("12345");
            f.setAtivo(ativo);
            f.setSalario(3000.00);
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
