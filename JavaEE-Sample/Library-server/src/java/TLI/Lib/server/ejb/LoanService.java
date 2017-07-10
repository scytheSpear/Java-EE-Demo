package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Loan;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class LoanService {
    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createLoan(Loan l) {
        em.persist(l);
    }
    
    public void updateLoan(Loan l) {
        em.merge(l);
    }
    
    public void deleteLoan(Loan l) {
        em.remove(em.merge(l));
    }
    
            
    
    public List<Loan> getAllLoans() {
        TypedQuery<Loan> q = em.createQuery("SELECT l FROM Loan l", Loan.class);
        return q.getResultList();
    }
}
