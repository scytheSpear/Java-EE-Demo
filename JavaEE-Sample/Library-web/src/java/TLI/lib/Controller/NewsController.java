package TLI.lib.Controller;

import javax.inject.Named;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@Named(value = "newsController")
@ManagedBean
@RequestScoped
public final class NewsController {

    private String pageTitle;
    private int newsId;
    private News news;

    public NewsController() {
        // Assign song identifier via GET param
        newsId = Integer.valueOf(FacesContext.getCurrentInstance()
                         .getExternalContext()
                         .getRequestParameterMap()
                         .get("newsID"));
        
        // Assign song based on the id provided
        news = getNews();
        
        pageTitle = news.getNewstitle() + " | " + NewsApplication.APP_TITLE;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
    public News getNews() {
        if(news == null) {
                    // Get application context bean songApplication
            ELContext context = FacesContext.getCurrentInstance().getELContext();
            NewsApplication app = (NewsApplication) FacesContext.getCurrentInstance()
                    .getApplication()
                    .getELResolver()
                    .getValue(context, null, "newsApplication");
            
            return app.getNews().get(--newsId);
        }

        return news;
    }
}