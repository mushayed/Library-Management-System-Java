package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class Main extends Application {
    private Stage stage;

    private Stage getStage(){
        return this.stage;
    }

    public ObservableList<MemberTable> memberData = FXCollections.observableArrayList();

    public ObservableList<BookTable> bookData = FXCollections.observableArrayList(
        new BookTable("Book One", "Fiction", "101", "Writer One", this),
        new BookTable("Book Two", "Adventure", "102", "Writer Two", this),
        new BookTable("Book Three", "Horror", "103", "Writer Three", this),
        new BookTable("Book Four", "Literary Fiction", "104", "Writer Four", this)
    );

    public ObservableList<ActivityTable> activityData = FXCollections.observableArrayList();

    public ObservableList<Integer> id = FXCollections.observableArrayList();

    public ObservableList<PrivateInformationTable> privateData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        showStartingPage();

        for (int i = 1001; i < 2001; i++) {
            id.add(new Integer(i));
        }
    }

    public void showStartingPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("startPage.fxml"));
        Parent root = loader.load();

        StartPageController startPageController = loader.getController();
        startPageController.setMain(this);

        stage.setTitle("Home Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();
        loginController.setMain(this);

        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credential");
        alert.setHeaderText("Incorrect password or name");
        alert.setContentText("The password or name that you have given is not correct. \nTry again");
        alert.showAndWait();
    }

    public void showIssueAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credential");
        alert.setHeaderText("Incorrect password or User ID");
        alert.setContentText("The password or user ID you have given is not correct. \nTry again");
        alert.showAndWait();
    }

    public void showMailAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credential");
        alert.setHeaderText("This is not a valid email-address");
        alert.setContentText("Please input the valid mail-address");
        alert.showAndWait();
    }

    public void showPasswordAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Unacceptable Password");
        alert.setHeaderText("The size of the user password must be at least in four characters");
        alert.setContentText("Please give the password of four character at least");
        alert.showAndWait();
    }

    public void showReturnAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credential");
        alert.setHeaderText("No books have been issued through this User ID");
        alert.setContentText("Please Try Again");
        alert.showAndWait();
    }

    public void showBookReturnError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Book Returning Error");
        alert.setHeaderText("You have already returned this book");
        alert.setContentText("Try with another book");
        alert.showAndWait();
    }

    public void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lack of information");
        alert.setHeaderText("Informations are missing");
        alert.setContentText("You have to fill up every box that is given");
        alert.showAndWait();
    }

    public void showIndexError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Index Error");
        alert.setHeaderText("Index out of bounds");
        alert.setContentText("There is no such index. Try again.");
        alert.showAndWait();
    }

    public void showDateError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Date Error");
        alert.setHeaderText("Illogical Date");
        alert.setContentText("Please input the correct date");
        alert.showAndWait();
    }

    public void showBookIdError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Book ID Error");
        alert.setHeaderText("No books found for that ID!");
        alert.setContentText("You have given the wrong ID! Please try with existing valid ID");
        alert.showAndWait();
    }

    public void showConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialogue");
        alert.setHeaderText("Congratulation!");
        alert.setContentText("You have successfully created an account");
        alert.showAndWait();
    }

    public void showIdAllocation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialogue");
        alert.setHeaderText("You have been given an ID for your account");
        alert.setContentText("Your ID is " +id.get(0));
        id.remove(0);
        alert.showAndWait();
    }

    public void showIssueConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialogue");
        alert.setHeaderText("Congratulation!");
        alert.setContentText("You have successfully issued the book from the library");
        alert.showAndWait();
    }

    public void showReturnConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialogue");
        alert.setHeaderText("Work Done!");
        alert.setContentText("You have successfully returned the issued book");
        alert.showAndWait();
    }

    public void showMemberRemoveConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialogue");
        alert.setHeaderText("Successfully Removed!");
        alert.setContentText("The member has been successfully removed from the Member List");
        alert.showAndWait();
    }

    public void showBookAddConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialogue");
        alert.setHeaderText("Successfully Added!");
        alert.setContentText("The book has been successfully added to the Book List");
        alert.showAndWait();
    }

    public void showBookRemoveConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialogue");
        alert.setHeaderText("Successfully Removed!");
        alert.setContentText("The book has been successfully removed from the Book List");
        alert.showAndWait();
    }

    public void showAccountError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Matching Error");
        alert.setHeaderText("Someone is already exist with this user password");
        alert.setContentText("Please put different USER Password");
        alert.showAndWait();
    }

    public void showIdInformation(int id) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User ID Information");
        alert.setHeaderText("Your ID is " +id);
        alert.showAndWait();
    }

    public void showRestrictionError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Book Issue Restriction Error");
        alert.setHeaderText("You can't issue more than one book");
        alert.setContentText("First return the book that you have already issued from the library");
        alert.showAndWait();
    }

    public void showHomePage(String username) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        HomeController homeController = loader.getController();
        homeController.init(username);
        homeController.setMain(this);

        stage.setTitle("Home Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showAccountPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("account.fxml"));
        Parent root = loader.load();

        AccountController accountController = loader.getController();
        accountController.setMain(this);

        stage.setTitle("Account Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showBookPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("book.fxml"));
        Parent root = loader.load();

        BookController bookController = loader.getController();
        bookController.setMain(this);

        stage.setTitle("Book Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showMemberPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("memberList.fxml"));
        Parent root = loader.load();

        MemberListController memberListController = loader.getController();
        memberListController.setMain(this);

        stage.setTitle("Member List Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showMemberHomePage(String userName) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("memberHome.fxml"));
        Parent root = loader.load();

        MemberHomeController memberHomeController = loader.getController();
        memberHomeController.init(userName);
        memberHomeController.setMain(this);

        stage.setTitle("Home Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showIssueBookPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("issuebook.fxml"));
        Parent root = loader.load();

        IssueBookController issueBookController = loader.getController();
        issueBookController.setMain(this);

        stage.setTitle("Issue Book Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showReturnBookPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("returnBook.fxml"));
        Parent root = loader.load();

        ReturnBookController returnBookController = loader.getController();
        returnBookController.setMain(this);

        stage.setTitle("Return Book Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showForgotIdPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("forgotId.fxml"));
        Parent root = loader.load();

        ForgotIdController forgotIdController = loader.getController();
        forgotIdController.setMain(this);

        stage.setTitle("ID Recovering Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showActivityPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("activity.fxml"));
        Parent root = loader.load();

        ActivityController activityController = loader.getController();
        activityController.setMain(this);

        stage.setTitle("Activity Observation Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
