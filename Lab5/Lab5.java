package source;

import command.*;
import filehandler.CatalogUtil;
import filehandler.InvalidCatalogException;
import model.Article;
import model.Book;
import model.Catalog;

import java.io.IOException;

public class Lab5 {

    private void testCreateSave() {
        Catalog myCatalog = new Catalog("myCatalog");
        var myBook = new Book("knuth67",
                "The Art of Computer Programming",
                "/home/raul/Raul/UNI/PA/Lab5/Book.ps",
                1967,
                "Donald E. Knuth");

        var myArticle = new Article("java17",
                "The Java Language Specification",
                "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                2021,
                "James Gosling & others");

        myCatalog.add(myBook);
        myCatalog.add(myArticle);
        try {
            CatalogUtil.save(myCatalog, "/home/raul/Raul/UNI/PA/Lab5/Catalog.json");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
    }

    private void testLoadView() {
        Catalog myCatalog;
        try {
            myCatalog = CatalogUtil.load("/home/raul/Raul/UNI/PA/Lab5/Catalog.json");
            System.out.println(myCatalog);
        }
        catch (InvalidCatalogException myException){
            myException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Lab5 app = new Lab5();
        Catalog myCatalog = new Catalog("myCatalog");
        Catalog loadedCatalog = new Catalog();
        var myBook = new Book("knuth67",
                "The Art of Computer Programming",
                "/home/raul/Raul/UNI/PA/Lab5/keynote_proficient_students_book_answer_keys.pdf",
                1967,
                "Donald E. Knuth");

        var myArticle = new Article("java17",
                "The Java Language Specification",
                "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                2021,
                "James Gosling & others");

        AddCommand addCommand = new AddCommand();
        addCommand.command(myCatalog, myBook);
        addCommand.command(myCatalog, myArticle);

        SaveCommand saveCommand = new SaveCommand();
        try {
            saveCommand.command(myCatalog, "/home/raul/Raul/UNI/PA/Lab5/Catalog.json");
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }
/*  NOT WORKING
        LoadCommand loadCommand = new LoadCommand();
        try {
            loadCommand.command(loadedCatalog, "/home/raul/Raul/UNI/PA/Lab5/Catalog.json");
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }
*/
        ListCommand listCommand = new ListCommand();
        listCommand.command(myCatalog);

        ViewCommand viewCommand = new ViewCommand();
        try {
            viewCommand.command(myCatalog, 0);
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }

        // JAR
    }
}
