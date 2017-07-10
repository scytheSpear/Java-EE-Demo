/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLI.lib.Controller;

import javax.inject.Named;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

@Named(value = "newsApplication")
@ManagedBean(eager=true)
@ApplicationScoped
public class NewsApplication {

    public static final String APP_TITLE = "News Detail";
    private ArrayList<News> news;

    public NewsApplication() {
         // Add song data to our app
        news = new ArrayList<News>();
        news.add(new News("Pitfalls of publishing","Pitfalls of publishing - Advice for early career researchers"));
        news.add(new News("Access all databases through our new databases guide","This new database discovery service has been developed to provide continuing access to databases once the current Library databases pages are discontinued on 28th August 2013. For more information."));
        news.add(new News("Quick study guides - tips for exams, essays", "New study patterns (doc, 86 KB)\n" +
                        "Study strategies (doc, 128 KB)\n" +
                        "Making the most of your Unit Guide (doc, 92 KB)\n" +
                        "Listening and note-taking in lectures (doc, 89 KB)\n" +
                        "Participating in tutorials (doc, 91 KB)\n" +
                        "Learning in labs (doc, 138 KB)\n" +
                        "A guide to group work (doc, 91 KB)\n" +
                        "Efficient reading strategies (doc, 88 KB)\n" +
                        "Evaluating web page (doc, 102 KB)\n" +
                        "Examination strategies (doc, 95 KB)\n" +
                        "International post-graduate students coursework (doc, 85 KB)\n" +
                        "International post-graduate students research (doc, 90 KB"));
        news.add(new News("Changes to Caulfield Library access over exam study period","In an effort to provide Monash students with the greatest possible access to available study space at this critical time of the academic year, Caulfield Library will be accessible to only Monash staff and students from 14 October to 15 November 2013.\n" +
"\n" +
"This temporary policy is being introduced to alleviate the shortage of study space experienced at Caulfield during the exam study period, when use is at its peak. \n" +
"\n" +
"To assist with enforcing this policy, students from all campuses who plan to use Caulfield Library over this period are encouraged to carry their Monash ID. This will minimise inconvenience and ensure you are not delayed at the library entrance.\n" +
"\n" +
"CAVAL and ULANZ registered borrowers will be able to retrieve and borrow specific items, but will not be able to study in the library. Alumni and external fee-paying members of the Library will continue to have access by presenting their Library card. The exclusion also does not apply to Sir John Monash Science School and Nossal High School students.\n" +
"\n" +
"The exclusion is not being applied at any other Monash campus libraries."));
        news.add(new News("What's new: Library Management System","The Library’s new management system is now in place. Holds, renewals and reading lists are all back to normal, and we do not expect any more disruptions. Thank you for your patience during implementation.\n" +
"\n" +
"Some of the changes resulting from the new system include :\n" +
"\n" +
"Automatic renewals\n" +
"Automatic renewals of your items will occur up to a maximum of 6 times, providing no holds are placed by another user during this time. You will receive an email alert of the due date at the end of this period or earlier if the item is placed on hold by another user. Please note that the SMS reminder service has been discontinued, so all reminder alerts will be via email.\n" +
"Loans receipts via email\n" +
"Loans receipts will no longer be printed at the Information Point. Instead, your receipt will be emailed to you. Should you require a printout, please use Self Loans.\n" +
"Fines balance available for viewing\n" +
"Your fines balance will be available for viewing at My Loans in Search or in your my.monash profile at any time.\n" +
"New Databases Service\n" +
"The new guide to finding databases by subject and faculty can be accessed from the Quick Links on the Search home page." ));
        
    }
    
    public ArrayList<News> getNews() {
        return news;
    }
}
