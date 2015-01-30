/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BO.Taxrate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Temp
 */
public class TaxrateService {

    private static EntityManager em;

    public TaxrateService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerbDerpPU");
        em = emf.createEntityManager();
    }

    public List<Taxrate> getAllTaxrates() {
        Query q = em.createNamedQuery("Taxrate.findAll", Taxrate.class);
        List<Taxrate> trs = q.getResultList();
        return trs;
    }

    public boolean Save(Taxrate tr) {

        if (tr.getId() == null) {
            try {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(tr);
                transaction.commit();
                return true;
            } catch (Exception e) {
                System.out.println("Error: " + e);
                return false;
            }
        } else {
            try {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(tr);
                transaction.commit();
                return true;
            } catch (Exception e) {
                System.out.println("Error: " + e);
                return false;
            }
        }
    }
    
    public boolean Delete(Taxrate delTax) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query q = em.createQuery("DELETE FROM Taxrate t WHERE t.id = :id");
            q.setParameter("id", delTax.getId());
            q.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
