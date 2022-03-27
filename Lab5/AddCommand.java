package command;

import model.Book;
import model.Catalog;
import model.Item;

public class AddCommand implements Command{
    private Item myItem;

    @Override
    public void command(Catalog myCatalog) {
        myCatalog.getItemList().add(myItem);
    }

    public void command(Catalog myCatalog, Item myItem) {
        this.myItem = myItem;
        command(myCatalog);
    }
}
