package model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("article")

public class Article extends Item{

    public Article() {}

    public Article(String id, String title, String location, int year, String author) {
        super(id, title, location, year, author);
    }

    @Override
    public String toString() {
        return "Article{" +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                '}';
    }
}
