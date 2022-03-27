package command;

import filehandler.InvalidCatalogException;
import model.Catalog;

public interface Command {
    void command(Catalog myCatalog) throws InvalidCatalogException;
}
