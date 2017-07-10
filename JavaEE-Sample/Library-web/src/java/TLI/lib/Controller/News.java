package TLI.lib.Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.inject.Named;
/**
 *
 * @author user
 */

@Named(value = "news")

public class News {
    private String newstitle;
    private String newsdata;

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsdata() {
        return newsdata;
    }

    public void setNewsdata(String newsdata) {
        this.newsdata = newsdata;
    }
    
    public News(String newstitle, String newsdata) {
        this.newstitle = newstitle;
        this.newsdata= newsdata;
    }
    
}
