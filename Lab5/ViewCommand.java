package command;

import filehandler.InvalidCatalogException;
import model.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command{
    int index;

    @Override
    public Catalog command(Catalog myCatalog) throws InvalidCatalogException {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File(myCatalog.getItemList().get(index).getLocation()));
        } catch (IOException myException) {
            throw new InvalidCatalogException(myException);
        }
        return null;
    }

    public Catalog command(Catalog myCatalog, int index) throws InvalidCatalogException {
        this.index = index;
        command(myCatalog);
        return null;
    }
}
