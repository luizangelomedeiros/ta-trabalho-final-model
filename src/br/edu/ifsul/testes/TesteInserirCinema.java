package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
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


public class TesteInserirCinema {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TA-FINAL-PU");
            em = emf.createEntityManager();
            Cinema c = new Cinema();
            Cidade cc = em.find(Cidade.class, 3);
            
            c.setEndereco("Rua Morom");
            c.setHorarioFunc("10h as 22h");
            c.setQtdSalas(10);
            c.setCapacidadeTotal(400);
            c.setQtdFuncionarios(50);
            c.setCidade(cc);
            
            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Cinema>> erros = validador.validate(c);
            if (erros.size() > 0) {
                for (ConstraintViolation<Cinema> erro : erros){
                    System.out.println("Erro: "+erro.getMessage());
                }
            } else {
                em.getTransaction().begin();
                em.persist(c);
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
