package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Groups;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class GroupService {
    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createGroup(Groups g) {
        em.persist(g);
    }
    
    public void updateGroup(Groups g) {
        em.merge(g);
    }
    
    public void deleteGroup(Groups g) {
        em.remove(em.merge(g));
    }
    
            
    
    public List<Groups> getAllGroups() {
        TypedQuery<Groups> q = em.createQuery("SELECT g FROM Groups g", Groups.class);
        return q.getResultList();
    }
}
