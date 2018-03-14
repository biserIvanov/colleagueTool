package collegueRecognition.entities;


import java.util.Date;

public class Vote {

    public String userName;         // the username of the person for whom we are voting
    public String comment;

    private Date createdDate = new Date();

    public Vote(String userName, String comment, Date createdDate) {
        this.userName = userName;
        this.comment = comment;
        this.createdDate = createdDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
