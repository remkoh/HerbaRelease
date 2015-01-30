/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BO.Product;
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
public class ProductService {

    private static EntityManager em;

    public ProductService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerbDerpPU");
        em = emf.createEntityManager();
    }

    public List<Product> GetAllProducts() {
        Query q = em.createNamedQuery("Product.findAll", Product.class);
        List<Product> prds = q.getResultList();
        return prds;
    }

    public Product getByID(int id) {
        Query q = em.createNamedQuery("Product.findById", Product.class);
        q.setParameter("id", id);
        Product foundProd = (Product) q.getSingleResult();
        return foundProd;
    }

    public void SaveProd(Product saveProd) {
        if (saveProd.getId() == null) {
            try {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(saveProd);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } 
        else {
            try {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(saveProd);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }

    }

}


