package model;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("book")

public class Book extends Item{
    private String myType;

    public Book() {
        this.myType = "book";
    }

    public Book(String id, String title, String location, int year, String author) {
        super(id, title, location, year, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                '}';
    }
}
