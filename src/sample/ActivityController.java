package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ActivityController {
    public Main main;

    @FXML
    private TableView activityTable;

    @FXML
    private Button viewButton;

    @FXML
    private Button backButton;

    private boolean init = true;

    private void initializeView() {
        TableColumn<ActivityTable, String> userName = new TableColumn<>("User Name");
        userName.setMinWidth(80);
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn<ActivityTable, String> userId = new TableColumn<>("User ID");
        userId.setMinWidth(80);
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));

        TableColumn<ActivityTable, String> mail = new TableColumn<>("Mail Address");
        mail.setMinWidth(80);
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));

        TableColumn<ActivityTable, String> bookName = new TableColumn<>("Book Name");
        bookName.setMinWidth(80);
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));

        TableColumn<ActivityTable, String> type = new TableColumn<>("Type");
        type.setMinWidth(80);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<ActivityTable, String> bookId = new TableColumn<>("Book ID");
        bookId.setMinWidth(80);
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<ActivityTable, String> writer = new TableColumn<>("Writer");
        writer.setMinWidth(80);
        writer.setCellValueFactory(new PropertyValueFactory<>("writer"));

        TableColumn<ActivityTable, String> issueDate = new TableColumn<>("Issue Date");
        issueDate.setMinWidth(80);
        issueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));

        TableColumn<ActivityTable, String> returnDate = new TableColumn<>("Return Date");
        returnDate.setMinWidth(80);
        returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        activityTable.getColumns().addAll(userName, userId, mail, bookName, type, bookId, writer, issueDate, returnDate);

    }

    public void View() {
        if(init) {
            initializeView();
            init = false;
        }

        activityTable.setEditable(true);
        activityTable.setItems(main.activityData);
        activityTable.refresh();
    }

    public void viewAction(ActionEvent e) {
        View();
    }

    public void backAction(ActionEvent e) {
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
