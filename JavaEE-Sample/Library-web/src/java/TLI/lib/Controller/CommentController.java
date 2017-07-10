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
@Named(value = "commentController")
@SessionScoped
public class CommentController implements Serializable {
    @EJB
    CommentService commentService;
    
    @EJB
    BookService bookService;
    
    @EJB
    UserService userService;
    
    private Comment comment;
    private Users user;
    private Book book;
    private Long bid;
    private Long uid;
    private String data;
    private Date date;
    
    
    public CommentController() { }


    public Comment getComment(){
        return comment;
    }
    
    
   
    public String readComment(Comment comment){
        this.comment = comment;
        return "userprofile";
    }

     public String setupComment(){
         comment = new Comment();
         return "addcomment";
     }
     
  
     public String creatComment(){
         comment = new Comment();
         comment.setCommentdata(data);
         book = bookService.getBookById(bid);
         comment.setBook(book);
         user = userService.getUserById(uid);
         comment.setUser(user);
         date = new Date();
         comment.setCommentdate(date);
                 
         commentService.createComment(comment);
         return "userprofile";
     }
     
     public String usercreatComment(){
         comment = new Comment();
         comment.setCommentdata(data);
         book = bookService.getBookById(bid);
         comment.setBook(book);
         String U = String.valueOf(FacesContext.getCurrentInstance()
                 .getExternalContext().getUserPrincipal().getName());
         user = userService.getUserByName(U);
         comment.setUser(user);
         date = new Date();
         comment.setCommentdate(date);
                 
         commentService.createComment(comment);
         return "userprofile";
     }
             
    
     public String updateComment(){
         comment.setCommentdata(data);
         book = bookService.getBookById(bid);
         comment.setBook(book);
         
         commentService.updateComment(comment);
         return "userprofile";
     }
     
    
     
     public String deleteComment(Comment comment){
         commentService.deleteComment(comment);
         return"userprofile";
     }

     public List<Comment> getComments(){
         return commentService.getAllComments();
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     
     
}
