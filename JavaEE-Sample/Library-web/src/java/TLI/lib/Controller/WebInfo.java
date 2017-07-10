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
@Named(value = "webInfo")
@ManagedBean(eager=true)
@RequestScoped

public class WebInfo {

    private String pageHeaders;
    private String pageFooter;
    private String adminHeader;
    private String userHeader;
    private String searchHeader;
    private String SearchRHeader;
    private String bookHeader;
    private String loginHeader;
    private String errorHeader;
    
    public WebInfo() {
        pageHeaders = "Monash Book Library";
        pageFooter ="This website Copyright by TLI";
        
        adminHeader ="Admin Homepage";
        userHeader = "Welcome";
        
        searchHeader = "Search Books";
        SearchRHeader = "Search Result";
        
        bookHeader = "Books Detail ";
        
        loginHeader = "User Login";
        errorHeader = "Login Fails";
    }
      
    public String getPageHeaders() {
        return pageHeaders;
    }

    public void setPageHeaders(String pageHeaders) {
        this.pageHeaders = pageHeaders;
    }

    public String getPageFooter() {
        return pageFooter;
    }

    public void setPageFooter(String pageFooter) {
        this.pageFooter = pageFooter;
    }

    public String getAdminHeader() {
        return adminHeader;
    }

    public void setAdminHeader(String adminHeader) {
        this.adminHeader = adminHeader;
    }

    public String getUserHeader() {
        return userHeader;
    }

    public void setUserHeader(String userHeader) {
        this.userHeader = userHeader;
    }

    public String getSearchHeader() {
        return searchHeader;
    }

    public void setSearchHeader(String searchHeader) {
        this.searchHeader = searchHeader;
    }

    public String getSearchRHeader() {
        return SearchRHeader;
    }

    public void setSearchRHeader(String SearchRHeader) {
        this.SearchRHeader = SearchRHeader;
    }

    public String getBookHeader() {
        return bookHeader;
    }

    public void setBookHeader(String bookHeader) {
        this.bookHeader = bookHeader;
    }

    public String getLoginHeader() {
        return loginHeader;
    }

    public void setLoginHeader(String loginHeader) {
        this.loginHeader = loginHeader;
    }

    public String getErrorHeader() {
        return errorHeader;
    }

    public void setErrorHeader(String errorHeader) {
        this.errorHeader = errorHeader;
    }
    

    
}