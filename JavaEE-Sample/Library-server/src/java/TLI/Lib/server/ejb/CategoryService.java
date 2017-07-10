/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class CategoryService {
    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createCategory(Category Ca) {
        em.persist(Ca);
    }
    
    public void updateCategory(Category Ca) {
        em.merge(Ca);
    }
    
    public void deleteCategory(Category Ca) {
        em.remove(em.merge(Ca));
    }
    
    public Category getCategoryById(Long Id){
         
         return em.find(Category.class, Id);

    }
    
    
    public List<Category> getAllCategories() {
        TypedQuery<Category> q = em.createQuery("SELECT Ca FROM Category Ca", Category.class);
        return q.getResultList();
    }

    
}
