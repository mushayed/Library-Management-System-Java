package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IssueBookController {
    private Main main;

    @FXML
    private TableView bookTable;

    @FXML
    private TextField bookIdField;

    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField userPasswordField;

    @FXML
    private Button issueButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button backButton;

    @FXML
    private DatePicker myDatePicker;

    private boolean init = true;

    private void ViewBook() {
        TableColumn<BookTable, String> name = new TableColumn<>("Name");
        name.setMinWidth(80);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<BookTable, String> type = new TableColumn<>("Type");
        type.setMinWidth(80);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<BookTable, String> id = new TableColumn<>("ID");
        id.setMinWidth(80);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<BookTable, String> writer = new TableColumn<>("Writer");
        writer.setMinWidth(80);
        writer.setCellValueFactory(new PropertyValueFactory<>("writer"));

        bookTable.getColumns().addAll(name, type, id, writer);
    }

    public void load() {
        if (init) {
            ViewBook();
            init = false;
        }

        bookTable.setEditable(true);
        bookTable.setItems(main.bookData);
    }

    public void viewAction(ActionEvent e) {
        load();
    }

    String formattedDate = "";

    public void getDateAction(ActionEvent e) {
        LocalDate issueDate = myDatePicker.getValue();
        formattedDate = issueDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getDateAction() {
        return formattedDate;
    }

    public void issueAction(ActionEvent e) {
        if (bookIdField.getText().equals("") || userIdField.getText().equals("")
                || getDateAction().equals("") || userPasswordField.getText().equals("")) {
            main.showError();
        } else {
            int userId = Integer.parseInt(userIdField.getText());
            int flagOne = 0;
            int flagTwo = 0;
            int flagThree = 0;

            String userName;
            int id = -1;
            String mail;
            String bookName;
            String type;
            String bookId;
            String writer;
            String issueDate;
            String returnDate;

            int userIdx = -1;
            int bookIdx = -1;

            for (int i = 0; i < main.bookData.size(); i++) {
                if (bookIdField.getText().equals(main.bookData.get(i).getId())) {
                    bookIdx = i;
                    flagOne = 1;
                    for (int j = 0; j < main.privateData.size(); j++) {
                        if (userId == main.privateData.get(j).getId()
                                && userPasswordField.getText().equals(main.privateData.get(j).getPassword())) {
                            flagTwo = 1;
                            userName = main.memberData.get(j).getName();
                            id = main.memberData.get(j).getId();
                            mail = main.memberData.get(j).getMail();
                            bookName = main.bookData.get(i).getName();
                            type = main.bookData.get(i).getType();
                            bookId = main.bookData.get(i).getId();
                            writer = main.bookData.get(i).getWriter();
                            issueDate = getDateAction();
                            returnDate = "Not returned yet";

                            userIdx = j;

                            if (main.activityData.size() == 0) {
                                main.activityData.add(new ActivityTable(userName, id, mail, bookName, type, bookId, writer, issueDate, returnDate, main));
                                main.bookData.remove(i);
                                bookTable.refresh();
                                main.showIssueConfirmation();
                            } else {
                                for (int k = 0; k < main.activityData.size(); k++) {
                                    if (userId == main.activityData.get(k).getUserId()) {
                                        if (main.activityData.get(k).getReturnDate().equals("Not returned yet")) {
                                            main.showRestrictionError();
                                            flagThree = 1;
                                        }
                                    }
                                }
                                if (flagThree != 1) {
                                    userName = main.memberData.get(userIdx).getName();
                                    id = main.memberData.get(userIdx).getId();
                                    mail = main.memberData.get(userIdx).getMail();
                                    bookName = main.bookData.get(bookIdx).getName();
                                    type = main.bookData.get(bookIdx).getType();
                                    bookId = main.bookData.get(bookIdx).getId();
                                    writer = main.bookData.get(bookIdx).getWriter();
                                    issueDate = getDateAction();
                                    returnDate = "Not returned yet";

                                    main.activityData.add(new ActivityTable(userName, id, mail, bookName, type, bookId, writer, issueDate, returnDate, main));
                                    main.bookData.remove(bookIdx);
                                    bookTable.refresh();
                                    main.showIssueConfirmation();
                                }
                            }
                        }
                    }
                }
            }

            if (flagOne != 1) {
                main.showBookIdError();
            } else if (flagTwo != 1) {
                main.showIssueAlert();
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
