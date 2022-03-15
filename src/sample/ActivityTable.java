package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ActivityTable {
    private final SimpleStringProperty userName;
    private final SimpleIntegerProperty userId;
    private final SimpleStringProperty mail;
    private final SimpleStringProperty bookName;
    private final SimpleStringProperty type;
    private final SimpleStringProperty bookId;
    private final SimpleStringProperty writer;
    private String issueDate;
    private String returnDate;

    public Main main;

    public ActivityTable(String userName, int userId, String mail, String bookName, String type,
                         String bookId, String writer, String issueDate, String returnDate, Main main) {
        this.userName = new SimpleStringProperty(userName);
        this.userId = new SimpleIntegerProperty(userId);
        this.mail = new SimpleStringProperty(mail);
        this.bookName = new SimpleStringProperty(bookName);
        this.type = new SimpleStringProperty(type);
        this.bookId = new SimpleStringProperty(bookId);
        this.writer = new SimpleStringProperty(writer);
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.main = main;
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String memberName) {
        userName.set(memberName);
    }

    public int getUserId() {
        return userId.get();
    }

    public void setId(int memberId) {
        userId.set(memberId);
    }

    public String getMail() {
        return mail.get();
    }

    public void setMail(String memberMail) {
        mail.set(memberMail);
    }

    public String getBookName() {
        return bookName.get();
    }

    public void setBookName(String booksName) {
        bookName.set(booksName);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String bookType) {
        type.set(bookType);
    }

    public String getBookId() {
        return bookId.get();
    }

    public void setLanguage(String idBook) {
        bookId.set(idBook);
    }

    public String getWriter() {
        return writer.get();
    }

    public void setWriter(String bookWriter) {
        writer.set(bookWriter);
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(String date) {
        this.issueDate = date;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(String date) {
        this.returnDate = date;
    }

}
