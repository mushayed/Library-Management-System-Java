package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MemberListController {
    public Main main;

    @FXML
    private TableView memberTable;

    @FXML
    private Button viewButton;

    @FXML
    private Button buttonBackFour;

    private boolean init = true;

    private void initializeMember() {
        TableColumn<MemberTable, String> name = new TableColumn<>("Name");
        name.setMinWidth(80);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MemberTable, String> id = new TableColumn<>("ID");
        id.setMinWidth(80);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<MemberTable, String> mail = new TableColumn<>("Mail Address");
        mail.setMinWidth(80);
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));

        TableColumn<MemberTable, Button> button = new TableColumn<>("Remove");
        button.setMinWidth(80);
        button.setCellValueFactory(new PropertyValueFactory<>("button"));

        memberTable.getColumns().addAll(name, id, mail, button);
    }

    public void view() {
        if(init) {
            initializeMember();
            init = false;
        }

        memberTable.setEditable(true);
        memberTable.setItems(main.memberData);
        memberTable.refresh();
    }

    public void viewAction(ActionEvent e) {
        view();
    }

    public void backFourAction(ActionEvent e) {
        try {
            main.showHomePage("Librarian");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
