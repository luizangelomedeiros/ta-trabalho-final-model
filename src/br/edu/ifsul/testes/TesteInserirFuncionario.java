package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cinema;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Funcionario;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


public class TesteInserirFuncionario {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TA-FINAL-PU");
            em = emf.createEntityManager();
            Funcionario f = new Funcionario();
            Cinema ci = em.find(Cinema.class, 1);
            f.setNome("Luiz Ângelo");
            f.setCpf("000-000-000-00");
            f.setData_nascimento(Calendar.getInstance());
            f.setEstado_civil("Solteiro");
            f.setEndereco("Eduardo de Brito 321");
            f.setUsuario("luizmedeiros");
            f.setSenha("12345");
            f.setAtivo(true);
            f.setSalario(3000.00);
            f.setIdcinema(ci);
            
            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Funcionario>> erros = validador.validate(f);
            if (erros.size() > 0) {
                for (ConstraintViolation<Funcionario> erro : erros){
                    System.out.println("Erro: "+erro.getMessage());
                }
            } else {
                em.getTransaction().begin();
                em.persist(f);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
