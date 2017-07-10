package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Comment;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class CommentService {
    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createComment(Comment c) {
        em.persist(c);
    }
    
    public void updateComment(Comment c) {
        em.merge(c);
    }
    
    public void deleteComment(Comment c) {
        em.remove(em.merge(c));
    }
    
    public List<Comment> getUserComments(Long USER_ID){
        String query = "SELECT c FROM Comment c WHERE c.USER_ID = :USER_ID";
        return em.createQuery(query, Comment.class).setParameter("USER_ID", USER_ID)
            .getResultList();
    }
    
    public List<Comment> getBookComments(Long BOOK_ID){
        String query = "SELECT c FROM Comment c WHERE c.BOOK_ID = :BOOK_ID";
        return em.createQuery(query, Comment.class).setParameter("BOOK_ID", BOOK_ID)
            .getResultList();
    }
    
    public List<Comment> getAllComments() {
        TypedQuery<Comment> q = em.createQuery("SELECT c FROM Comment c", Comment.class);
        return q.getResultList();
    }
}
