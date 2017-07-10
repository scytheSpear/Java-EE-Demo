/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLI.Lib.server.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author user
 */
@Entity
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COMMENT_ID")
    private Long id;
    private String Commentdata;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date commentdate;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName ="USER_ID")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName ="BOOK_ID")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentdata() {
        return Commentdata;
    }

    public void setCommentdata(String Commentdata) {
        this.Commentdata = Commentdata;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TLI.FIT5042.Assignment2.models.Comment[ id=" + id + " ]";
    }
    
}
