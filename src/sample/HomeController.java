package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {
    private Main main;

    @FXML
    private Label authorName;

    @FXML
    private Button buttonMemberList;

    @FXML
    private Button buttonBookList;

    @FXML
    private Button activityButton;

    @FXML
    private Button buttonLogout;

    public void init(String userName) {
        authorName.setText(userName);
    }

    public void logoutAction(ActionEvent e) {
        try {
            main.showStartingPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void memberAction(ActionEvent e) {
        try {
            main.showMemberPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void bookAction(ActionEvent e) {
        try {
            main.showBookPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void activityAction(ActionEvent e) {
        try {
            main.showActivityPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
