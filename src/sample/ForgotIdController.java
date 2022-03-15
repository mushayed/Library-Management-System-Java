package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ForgotIdController {
    private Main main;
    private LoginController loginController;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField userPasswordField;

    @FXML
    private Button findButton;

    @FXML
    private Button backButton;

    public void findAction(ActionEvent e) {
        int flag = 0;
        if (userNameField.getText().equals("")
        || userPasswordField.getText().equals("")) {
            main.showError();
        } else {
            for (int i = 0; i < main.privateData.size(); i++) {
                if(userPasswordField.getText().equals(main.privateData.get(i).getPassword())) {
                    main.showIdInformation(main.privateData.get(i).getId());
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                main.showAlert();
            }
        }
    }

    public void backAction(ActionEvent e) {
        String name = null;
        for (int i = 0; i < main.memberData.size(); i++) {
            if (userPasswordField.getText().equals(main.privateData.get(i).getPassword())) {
                name = main.memberData.get(i).getName();
                break;
            }
        }

        try {
            main.showMemberHomePage(name);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
