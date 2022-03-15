package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class BookController {
    public Main main;

    @FXML
    private TableView bookTable;

    @FXML
    private TextField bookNameField;

    @FXML
    private TextField bookTypeField;

    @FXML
    private TextField bookIdField;

    @FXML
    private TextField bookWriterField;

    @FXML
    private TextField bookIndexField;

    @FXML
    private Button bookStockButton;

    @FXML
    private Button bookAddButton;

    @FXML
    private Button bookRemoveButton;

    @FXML
    private Button buttonBackThree;

    private boolean init = true;

    private void initializeBook() {
        TableColumn<BookTable, String> name = new TableColumn<>("Name");
        name.setMinWidth(80);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<BookTable, String> type = new TableColumn<>("Type");
        type.setMinWidth(80);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<BookTable, String> id = new TableColumn<>("Book ID");
        id.setMinWidth(80);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<BookTable, String> writer = new TableColumn<>("Writer");
        writer.setMinWidth(80);
        writer.setCellValueFactory(new PropertyValueFactory<>("writer"));

        bookTable.getColumns().addAll(name, type, id, writer);
    }

    public void load() {
        if(init) {
            initializeBook();
            init = false;
        }

        bookTable.setEditable(true);
        bookTable.setItems(main.bookData);
    }

    public void bookStockAction(ActionEvent e) {
        load();
    }

    public void bookAddAction(ActionEvent e) {
        if(bookNameField.getText().equals("") || bookTypeField.getText().equals("")
        || bookIdField.getText().equals("") || bookWriterField.getText().equals("")) {
            main.showError();
        } else {
            String name = bookNameField.getText();
            String type = bookTypeField.getText();
            String id = bookIdField.getText();
            String writer = bookWriterField.getText();

            main.bookData.add(new BookTable(name, type, id, writer, main));
            bookTable.refresh();
            main.showBookAddConfirmation();
        }
    }

    public void bookRemoveAction(ActionEvent e) {
        if (bookIndexField.getText().equals("")) {
            main.showError();
        } else {
            int idx = Integer.parseInt(bookIndexField.getText());

            if(idx >= main.bookData.size() || idx < 0) {
                main.showIndexError();
            } else {
                main.bookData.remove(idx);
                bookTable.refresh();
                main.showBookRemoveConfirmation();
            }
        }
    }

    public void backThreeAction(ActionEvent e) {
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
