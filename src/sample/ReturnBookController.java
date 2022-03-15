package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReturnBookController {
    private Main main;

    @FXML
    private TableView activityTable;

    @FXML
    private TextField bookIdField;

    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField userPasswordField;

    @FXML
    private DatePicker myDatePicker;

    @FXML
    private Button viewActivityButton;

    @FXML
    private Button returnButton;

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

    public void viewActivityAction(ActionEvent e) {
        View();
    }

    String formattedDate = "";

    public void getDateAction(ActionEvent e) {
        LocalDate returnDate = myDatePicker.getValue();
        formattedDate = returnDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getDateAction() {
        return formattedDate;
    }

    public void returnAction(ActionEvent e) {
        if (bookIdField.getText().equals("") || userIdField.getText().equals("")
                || getDateAction().equals("") || userPasswordField.getText().equals("")) {
            main.showError();
        } else {
            int idx = -1;
            int userId = Integer.parseInt(userIdField.getText());
            int flagOne = 0;
            int flagTwo = 0;
            int flagThree = 0;

            String bookName;
            String bookType;
            String bookId;
            String bookWriter;
            String returnDate = "";

            for (int i = 0; i < main.activityData.size(); i++) {
                if (bookIdField.getText().equals(main.activityData.get(i).getBookId())
                && userId == main.activityData.get(i).getUserId()) {
                    idx = i;
                    flagOne = 1;
                    for (int j = 0; j < main.privateData.size(); j++) {
                        if (userId == main.privateData.get(j).getId()
                                && userPasswordField.getText().equals(main.privateData.get(j).getPassword())) {
                            flagTwo = 1;
                            if (main.activityData.get(idx).getReturnDate().equals("Not returned yet")) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                Date issuedDate = null;
                                Date returnedDate = null;
                                try {
                                    issuedDate = simpleDateFormat.parse(main.activityData.get(idx).getIssueDate());
                                } catch (ParseException parseException) {
                                    parseException.printStackTrace();
                                }
                                try {
                                    returnedDate = simpleDateFormat.parse(getDateAction());
                                } catch (ParseException parseException) {
                                    parseException.printStackTrace();
                                }
                                if (issuedDate.compareTo(returnedDate) <= 0) {
                                    bookName = main.activityData.get(idx).getBookName();
                                    bookType = main.activityData.get(idx).getType();
                                    bookId = main.activityData.get(idx).getBookId();
                                    bookWriter = main.activityData.get(idx).getWriter();

                                    returnDate = getDateAction();

                                    main.bookData.add(new BookTable(bookName, bookType, bookId, bookWriter, main));
                                    main.activityData.get(idx).setReturnDate(returnDate);
                                    main.showReturnConfirmation();

                                    flagThree = 1;
                                } else {
                                    main.showDateError();
                                    flagThree = 1;
                                }
                            }
                        }
                    }
                }
            }

            if (flagOne != 1) {
                main.showReturnAlert();
            }
            else if (flagTwo != 1) {
                main.showIssueAlert();
            }
            else if (flagThree != 1) {
                main.showBookReturnError();
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
