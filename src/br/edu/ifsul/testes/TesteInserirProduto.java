
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class TesteInserirProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("TA-2015-2-6N1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Produto obj = new Produto();
        obj.setNome("Mouse sem Fio Laser");
        obj.setDescricao("Mouse sem Fio Laser Garantia 2 Anos");
        obj.setEstoque(100.00);
        obj.setPreco(150.00);
        obj.setMarca(em.find(Marca.class, 1));
        obj.setGrupo(em.find(Grupo.class, 1));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
