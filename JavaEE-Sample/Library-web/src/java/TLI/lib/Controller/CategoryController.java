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
@Named(value = "categoryController")
@SessionScoped
public class CategoryController implements Serializable {

    @EJB
    CategoryService categoryService;
  
    private Category category;

    
   
    public CategoryController() { }
        
    public Category getCategory(){
        return category;
    }


     public String readCategory(Category category){
        this.category = category;
        return "category";
    }
    

     
     public String setupCategory(){
         category = new Category();
         return "category";
     }
     

     public String creatCategory(){
         categoryService.createCategory(category);
         return "viewcategories";
     }
     
     
     public String updateCategory(){
         categoryService.updateCategory(category);
         return "viewcategories";
     }

     
     public String deleteCategory(Category category){
         categoryService.deleteCategory(category);
         return "viewcategories";
     }

     public List<Category> getCategories(){
         return categoryService.getAllCategories();
     }
    
}
