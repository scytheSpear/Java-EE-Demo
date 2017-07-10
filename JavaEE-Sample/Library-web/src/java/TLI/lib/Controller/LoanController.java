package TLI.lib.Controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import TLI.Lib.server.ejb.*;
import TLI.Lib.server.models.*;
import java.util.Date;
import javax.faces.context.FacesContext;
/**
 *
 * @author user
 */
@Named(value = "loanController")
@SessionScoped
public class LoanController implements Serializable {

    @EJB
    LoanService loanService;

    @EJB
    BookService bookService;
    
    @EJB
    UserService userService;
    
    
    private Loan loan;
    private Users user;
    private Book book;
    private Long bid;
    private Long uid;
    private Date date;
   
    public LoanController() {
    }
        
    public Loan getLoan(){
        return loan;
    }


     public String readLoan(Loan loan){
        this.loan = loan;
        return "loan";
    }
     
     public String userreadLoan(Loan loan){
        this.loan = loan;
        return "userloan";
    }
    
     public String setupLoan(){
         loan = new Loan();
         return "loan";
     }
     
     public String usersetLoan(){
         loan = new Loan();
         return "userloan";
     }

     public String creatLoan(){
         book = bookService.getBookById(bid);
         user = userService.getUserById(uid);
         loan.setBook(book);
         loan.setUser(user);
         date = new Date();
         loan.setLoandate(date);
         loanService.createLoan(loan);
         bookService.setBookLoan(book);
         return  "adminloanmanage";
        
     }
     
      public String userCreatLoan(){
          String url = "uloanfail";
         book = bookService.getBookById(bid);
          String U = String.valueOf(FacesContext.getCurrentInstance()
                 .getExternalContext().getUserPrincipal().getName());
         user = userService.getUserByName(U);
        
         if (book.getLoanStat().equals(""))
         {
         loan.setBook(book);
         loan.setUser(user);
         date = new Date();
         loan.setLoandate(date);
         loanService.createLoan(loan);
         bookService.setBookLoan(loan.getBook());
         url = "userprofile";
         }
         return url;
                  
     }
     
     public String updateLoan(){
         book = bookService.getBookById(bid);
         loan.setBook(book);
         user = userService.getUserById(uid);
         loan.setUser(user);
       
         loanService.updateLoan(loan);
         return "adminloanmanage";
     }

     
     public String deleteLoan(Loan loan){
         loanService.deleteLoan(loan);
         bookService.deleteBookLoan(loan.getBook());
         return "adminloanmanage";
     }

     public List<Loan> getLoans(){
         return loanService.getAllLoans();
     }
     
          

    public LoanService getLoanService() {
        return loanService;
    }

    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
     
     
}
