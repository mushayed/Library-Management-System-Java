package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PrivateInformationTable {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty password;

    public Main main;

    public PrivateInformationTable(String name, int id, String password, Main main) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(id);
        this.password = new SimpleStringProperty(password);

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

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String memberPassword) {
        password.set(memberPassword);
    }

}
