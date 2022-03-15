package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartPageController {
    public Main main;

    @FXML
    private Button librarianButton;

    @FXML
    private Button memberButton;

    @FXML
    private Button createAccountButton;

    public void setMain(Main main) {
        this.main = main;
    }

    public void librarianAction(ActionEvent e) {
        try {
            main.showLoginPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void memberAction(ActionEvent e) {
        try {
            main.showLoginPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void createAccountAction(ActionEvent e) {
        try {
            main.showAccountPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
