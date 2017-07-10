/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLI.lib.Controller;

/**
 *
 * @author user
 */
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author user
 */
@Named(value = "indexController")
@ManagedBean(eager=true)
@RequestScoped

public class IndexController {

    private String pageTitle;
    private String pageHeader;
    private String adminTitle;
    private String regTitle;
    private String userTitle;
    private String searchTitle;
    private String bookTitle;
    private String LoginTitle;
    private String errorTitle;
    
    public IndexController() {
        pageTitle = "Monash Book";
        adminTitle ="Admin manage page";
        regTitle = "User Registration Page";
        userTitle = "User Profile Page";
        searchTitle = "Search Books";
        bookTitle = "Book Information";
        LoginTitle = "User Login";
        errorTitle = "Login Fail";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader;
    }

    public String getAdminTitle() {
        return adminTitle;
    }

    public void setAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle;
    }

    public String getRegTitle() {
        return regTitle;
    }

    public void setRegTitle(String regTitle) {
        this.regTitle = regTitle;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getLoginTitle() {
        return LoginTitle;
    }

    public void setLoginTitle(String LoginTitle) {
        this.LoginTitle = LoginTitle;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }
    
    
    
}