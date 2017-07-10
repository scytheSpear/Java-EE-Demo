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

@Named(value = "bookController")
@SessionScoped
public class BookController implements Serializable {
    @EJB
    BookService bookService;
    
    @EJB
    CategoryService categoryService;
  
    private String temp;
    private Book book;
   // private Mark mark;
    private Category cate;
    private Long cid;
   
    
    
    public BookController() {
 
    }

    public Book getBook(){
        return book;
    }

     public String readBook(Book book){
        this.book = book;
        return "book";
    }
    
     public String bookDetail(Book book){
         this.book = book;
         return "bookdetail";
     }

     
     public String setupBook(){
         book = new Book();
         return "book";
     }
     

     public String creatBook(){
         cate = categoryService.getCategoryById(cid);
         book.setCategory(cate);
         book.setLoanStat("");
         bookService.createBook(book);
         return "showbooks";
     }
     
     
     public String updateBook(){
         cate = categoryService.getCategoryById(cid);
         book.setCategory(cate);
         bookService.updateBook(book);
         return "showbooks";
     }

     
     public String deleteBook(Book book){
         bookService.deleteBook(book);
         return "showbooks";
     }

     public List<Book> getBooks(){
         return bookService.getAllBooks();
     }
     
     public List<Book> getUnloanedBooks(){
         return bookService.getUnloanBooks();
     }

     
  
//     public List<Book> SearchBookByTitle(String Title){
//         List<Book> books = bookService.getAllBooks();
//         for(Book b : books){
//             if (b.getTitle().equals(Title))
//             {
//                result.add(b);
//             }
//         }
//        return result;
//     }
//     
//     public List<Book> SearchBookByISBN(String ISBN){
//          List<Book> books = bookService.getAllBooks();
//         for(Book b : books){
//             if (b.getISBN().equals(ISBN))
//             {
//                result.add(b);
//             }
//         }
//        return result;
//     }
//     
//     public List<Book> SearchBookByAuthor(String Author){
//        List<Book> books = bookService.getAllBooks();
//         for(Book b : books){
//             if (b.getAuthor().equals(Author))
//             {
//                result.add(b);
//             }
//         }
//        return result;
//     }
//     
//   
     
     public String addComment(Comment c){
         book.getComments().add(c);
         return "userbook";
      }
     
     
     

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category Cate) {
        this.cate = Cate;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
     
}
