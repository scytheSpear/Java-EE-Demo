/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLI.lib.Controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import TLI.Lib.server.ejb.*;
import TLI.Lib.server.models.*;

/**
 *
 * @author user
 */
@Named(value = "loginController")
@SessionScoped

public class LoginController implements Serializable {
    private Users user;
    private String login;
    private String password;
    private List<Users> users;
    
    @EJB
    UserService userService;
    
    public LoginController() {
        
    }

    public String validate() {
        this.user = new Users();
        users = userService.getAllUsers();
        String newpassword = this.password;
        String hashed = userService.hashPW(newpassword);
        for(Users u : users)
        {
            if ( this.login.equals(u.getPassword()) && hashed.equals(u.getPassword()))
                return "user/userindex";
        }
       
        return "userloginerror";
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
    
    
    
}
