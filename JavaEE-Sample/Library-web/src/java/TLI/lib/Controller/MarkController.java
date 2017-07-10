package TLI.lib.Controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import TLI.Lib.server.ejb.*;
import TLI.Lib.server.models.*;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "markController")
@SessionScoped
public class MarkController implements Serializable {
    @EJB
    MarkService markService;
    
    @EJB
    BookService bookService;
    
    @EJB
    UserService userService;
    
    private Mark mark;
    private Users user;
    private Book book;
    private Long bid;
    private Long uid;
    
    
    public MarkController() { }


    public Mark getMark(){
        return mark;
    }
    
    
   
    public String readMark(Mark mark){
        this.mark = mark;
        return "userprofile";
    }

     public String setupMark(){
         mark = new Mark();
         return "addcomment";
     }
     
  
     public String creatMark(){
         mark = new Mark();
         book = bookService.getBookById(bid);
         mark.setBook(book);
         String U = String.valueOf(FacesContext.getCurrentInstance()
                 .getExternalContext().getUserPrincipal().getName());
         user = userService.getUserByName(U);
                 
         markService.createMark(mark);
         return "userprofile";
     }
     
             
    
     public String updateMark(){
         mark = new Mark();
         book = bookService.getBookById(bid);
         mark.setBook(book);
         
         markService.updateMark(mark);
         return "userprofile";
     }
     
    
     
     public String deleteMark(Mark mark){
         markService.deleteMark(mark);
         return"userprofile";
     }

     public List<Mark> getMarks(){
         return markService.getAllMarks();
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

     
     
}
