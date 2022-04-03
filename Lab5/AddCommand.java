package command;

import model.Book;
import model.Catalog;
import model.Item;

public class AddCommand implements Command{
    private Item myItem;

    @Override
    public Catalog command(Catalog myCatalog) {
        myCatalog.getItemList().add(myItem);
        return null;
    }

    public Catalog command(Catalog myCatalog, Item myItem) {
        this.myItem = myItem;
        command(myCatalog);
        return null;
    }
}
