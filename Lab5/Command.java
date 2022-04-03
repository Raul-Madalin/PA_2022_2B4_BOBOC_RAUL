package command;

import filehandler.InvalidCatalogException;
import model.Catalog;

public interface Command {
    Catalog command(Catalog myCatalog) throws InvalidCatalogException;
}
