package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Mark;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class MarkService {
    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createMark(Mark m) {
        em.persist(m);
    }
    
    public void updateMark(Mark m) {
        em.merge(m);
    }
    
    public void deleteMark(Mark m) {
        em.remove(em.merge(m));
    }
    
    public List<Mark> getUserMarks(Long USER_ID){
        String query = "SELECT m FROM Mark m WHERE m.USER_ID = :USER_ID";
        return em.createQuery(query, Mark.class).setParameter("USER_ID", USER_ID)
            .getResultList();
    }
    
    public List<Mark> getBookMarks(Long BOOK_ID){
        String query = "SELECT m FROM Mark m WHERE m.BOOK_ID = :BOOK_ID";
        return em.createQuery(query, Mark.class).setParameter("BOOK_ID", BOOK_ID)
            .getResultList();
    }
    
    public List<Mark> getAllMarks() {
        TypedQuery<Mark> q = em.createQuery("SELECT m FROM Mark m", Mark.class);
        return q.getResultList();
    }
}
