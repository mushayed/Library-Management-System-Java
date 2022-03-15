package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private Main main;

    @FXML
    private Label loginLabel;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    public void setMain(Main main){
        this.main = main;
    }

    public void loginButtonAction(ActionEvent e) {
        int flag = 0;
        if (nameField.getText().equals("")
        || passwordField.getText().equals("")) {
            main.showError();
        }
        else if(nameField.getText().equals("Librarian")
        && passwordField.getText().equals("admin")){
            try {
                main.showHomePage(nameField.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else {
            for (int i = 0; i < main.memberData.size(); i++) {
                if(nameField.getText().equals(main.privateData.get(i).getName())
                && passwordField.getText().equals(main.privateData.get(i).getPassword())) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) {
                try {
                    main.showMemberHomePage(nameField.getText());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                main.showAlert();
            }
        }
    }

    public void backAction(ActionEvent e) {
        try {
            main.showStartingPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
