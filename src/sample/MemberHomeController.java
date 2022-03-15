package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MemberHomeController {
    private Main main;

    @FXML
    private Label userName;

    @FXML
    private Button bookIssueButton;

    @FXML
    private Button bookReturnButton;

    @FXML
    private Button forgotIdbutton;

    @FXML
    private Button logoutButton;

    public void init(String user) {
        userName.setText(user);
    }

    public void logoutAction(ActionEvent e) {
        try {
            main.showStartingPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void bookIssueAction(ActionEvent e) {
        try {
            main.showIssueBookPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void bookReturnAction(ActionEvent e) {
        try {
            main.showReturnBookPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void forgotIdAction(ActionEvent e) {
        try {
            main.showForgotIdPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
