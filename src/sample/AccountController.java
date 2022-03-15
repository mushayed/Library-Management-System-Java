package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AccountController {
    public Main main;

    @FXML
    private TextField memberName;

    @FXML
    private PasswordField memberPassword;

    @FXML
    private TextField memberMail;

    @FXML
    private Button buttonBackTwo;

    @FXML
    private Button applyButton;


    @FXML
    public void applyAction(ActionEvent e) {
        int flag = 0;
        if (memberName.getText().equals("") || memberPassword.getText().equals("")
                || memberMail.getText().equals("")) {
            main.showError();
        } else if (memberPassword.getText().equals("admin")) {
            main.showAccountError();
        } else {
            if (memberPassword.getLength() >= 4) {
                if (memberMail.getText().contains("@gmail.com")) {
                    for (int i = 0; i < main.memberData.size(); i++) {
                        if (memberPassword.getText().equals(main.privateData.get(i).getPassword())) {
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 1) {
                        main.showAccountError();
                    } else {
                        String name = memberName.getText();
                        int id = main.id.get(0);
                        String password = memberPassword.getText();
                        String mail = memberMail.getText();

                        main.memberData.add(new MemberTable(name, id, mail, main));
                        main.showConfirmation();
                        main.showIdAllocation();

                        main.privateData.add(new PrivateInformationTable(name, id, password, main));
                    }
                } else {
                    main.showMailAlert();
                }
            } else {
                main.showPasswordAlert();
            }
        }
    }

    @FXML
    public void buttonTwoAction(ActionEvent e) {
        try {
            main.showStartingPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
