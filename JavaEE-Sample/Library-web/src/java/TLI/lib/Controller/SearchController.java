/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLI.lib.Controller;

import TLI.Lib.server.ejb.*;
import TLI.Lib.server.models.*;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "searchController")
@ManagedBean
@RequestScoped

public class SearchController {
    @EJB
    BookService bookService;
    
    private String temp = "plz";

    
    public SearchController() {
        temp = String.valueOf(FacesContext.getCurrentInstance()
                         .getExternalContext()
                         .getRequestParameterMap()
                         .get("temp"));
        
        if(temp == "null"){
            temp = "Please enter content for search";
        }
       
   
    }
    
    
     public List<Book> getSearchTitle(){
      
        return bookService.searchByTitle(temp);
     }
     
     public List<Book> getSearchISBN(){
         return bookService.searchByISBN(temp);
     }
     
      public List<Book> getSearchAuthor(){
      
        return bookService.searchByAuthor(temp);
     }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

 
    
}
