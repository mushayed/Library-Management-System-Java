package sample;

import javafx.beans.property.SimpleStringProperty;

public class BookTable {
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty id;
    private final SimpleStringProperty writer;

    public Main main;

    public BookTable(String name, String type, String id, String writer, Main main) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.id = new SimpleStringProperty(id);
        this.writer = new SimpleStringProperty(writer);
        this.main = main;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String bookName) {
        name.set(bookName);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String bookType) {
        type.set(bookType);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String bookId) {
        id.set(bookId);
    }

    public String getWriter() {
        return writer.get();
    }

    public void setWriter(String bookWriter) {
        writer.set(bookWriter);
    }

}
