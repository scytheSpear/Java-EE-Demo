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
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    @EJB
    UserService userService;
    
    @EJB
    LoanService loanService;
    
    @EJB
    MarkService markService;
    
    @EJB
    GroupService groupService;
    
    private Users user;
    private Users cuser;
    private Groups group;
    
    
    public UserController() {
        
    }

    
    public Users getUser(){
        return user;
    }
   
    public Users getCurrentUser(){
        String U = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
        cuser = userService.getUserByName(U);
        return cuser;
    }
   
    public String readUser(Users user){
        this.user = user;
        return "user";
    }
        
    public String readUserProfile(Users user){
        this.user = user;
        return "regis";
    }
    

 
     public String setupUser(){
         user = new Users();
         return "user";
     }
     
     public String regUser(){
         user = new Users();
         return "regis";
     }
     
  
     public String creatUser(){
         user.setPassword(userService.hashPW(user.getPassword()));
         userService.createUser(user);
         group = new Groups();
         group.setUsername(user.getUsername());
         group.setGroupname("user");
         groupService.createGroup(group);
         return "adminuser";
     }
     
     public String signupUser(){
         user.setPassword(userService.hashPW(user.getPassword()));
         userService.createUser(user);
         group = new Groups();
         group.setUsername(user.getUsername());
         group.setGroupname("user");
         groupService.createGroup(group);
         return "index";
     }
     
    
     public String updateUser(){
         user.setPassword(userService.hashPW(user.getPassword()));
         userService.updateUser(user);
         return "adminuser";
     }
     
     public String editUser(){
         user.setPassword(userService.hashPW(user.getPassword()));
         userService.updateUser(user);
         return "userprofile";
     }
    
     
     public String deleteUser(Users user){
         userService.deleteUser(user);
         return"adminuser";
     }

     public List<Users> getUsers(){
         return userService.getAllUsers();
     }
   
     public String addComment(Comment c){
         user.getComments().add(c);
         return "userbook";
      }
       
     public String addLoan(Book b){
         Date date = new Date();
         Loan l = new Loan();
         l.setBook(b);
         l.setUser(getCurrentUser());
         l.setLoandate(date);
         loanService.createLoan(l);
         return "userbook";
      }
     
       
     public String addMark(Book b){
         Mark m = new Mark();
         m.setBook(b);
         m.setUser(getCurrentUser());
         markService.createMark(m);
         return "userbook";
      }
     
}
