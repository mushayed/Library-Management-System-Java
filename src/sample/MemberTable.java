package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class MemberTable {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty mail;
    private final Button button;
    public Main main;

    public MemberTable(String name, int id, String mail, Main main) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(id);
        this.mail = new SimpleStringProperty(mail);
        this.button = new Button("Remove");

        button.setOnAction(e -> {
            this.main.memberData.remove(this);
            main.showMemberRemoveConfirmation();
        });

        this.main = main;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String memberName) {
        name.set(memberName);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int memberId) {
        id.set(memberId);
    }

    public String getMail() {
        return mail.get();
    }

    public void setMail(String memberMail) {
        mail.set(memberMail);
    }

    public Button getButton() {
        return this.button;
    }

}
