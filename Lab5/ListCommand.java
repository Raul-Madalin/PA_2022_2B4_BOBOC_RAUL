package command;

import model.Catalog;
import model.Item;

public class ListCommand implements Command{
    @Override
    public Catalog command(Catalog myCatalog) {
        for (Item myItem : myCatalog.getItemList()
             ) {
            System.out.println(myItem);
        }
        return null;
    }
}
