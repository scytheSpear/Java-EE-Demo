package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

@Stateless
@LocalBean
public class BookService {

    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createBook(Book b) {
        em.persist(b);
    }

    public void updateBook(Book b) {
        em.merge(b);
    }

    public void deleteBook(Book b) {
        em.remove(em.merge(b));
    }

    public Book getBookById(Long Id) {

        return em.find(Book.class, Id);

    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b", Book.class);
        return q.getResultList();
    }

    public void setBookLoan(Book b) {
        b.setLoanStat("Loan Out");
        em.merge(b);
    }

    public void deleteBookLoan(Book b) {
        b.setLoanStat("");
        em.merge(b);
    }

    public List<Book> getUnloanBooks() {
        List<Book> books = getAllBooks();
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.getLoanStat() != null) {
                if (b.getLoanStat().equals("")) {
                    bookList.add(b);
                }
            }
        }
        return bookList;
    }

    public List<Book> searchByTitle(String STitle) {
        List<Book> books = getAllBooks();
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().trim().contains(STitle)) {
                bookList.add(b);
            }
        }
        return bookList;
    }

    public List<Book> searchByISBN(String SISBN) {
        List<Book> books = getAllBooks();
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.getISBN().toLowerCase().trim().contains(SISBN)) {
                bookList.add(b);
            }
        }
        return bookList;
    }

    public List<Book> searchByAuthor(String SAuthor) {
        List<Book> books = getAllBooks();
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().trim().contains(SAuthor)) {
                bookList.add(b);
            }
        }
        return bookList;
    }

//     public List<Book> SearchBookByTitle(String Title){
//        String query = "SELECT b FROM Book b WHERE b.Title = :Title";
//        return em.createQuery(query, Book.class).setParameter("Title", Title)
//            .getResultList();
//    }
//     
//     public List<Book> SearchBookByISBN(String ISBN){
//        String query = "SELECT b FROM Book b WHERE b.ISBN = :ISBN";
//        return em.createQuery(query, Book.class).setParameter("ISBN", ISBN)
//            .getResultList();
//    }
//    
//     public List<Book> SearchBookByAuthor(String Author){
//        String query = "SELECT b FROM Book b WHERE b.Author = :Author";
//        return em.createQuery(query, Book.class).setParameter("Author", Author)
//            .getResultList();
//    }
}
