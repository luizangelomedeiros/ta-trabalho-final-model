package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class TesteInserirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TA-2015-2-6N1-ModelPU");
            em = emf.createEntityManager();
            Estado e = new Estado();
            e.setNome("Rio Grande do Sul");
            e.setUf("RS");
            // criando o objeto para validar as anotações da bean validation API
            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Estado>> erros = validador.validate(e);
            if (erros.size() > 0) {
                for (ConstraintViolation<Estado> erro : erros){
                    System.out.println("Erro: "+erro.getMessage());
                }
            } else {
                em.getTransaction().begin();
                em.persist(e);
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
