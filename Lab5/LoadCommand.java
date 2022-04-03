package command;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import filehandler.InvalidCatalogException;
import model.Catalog;
import model.Item;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LoadCommand implements Command{
    private String myPath;

    @Override
    public Catalog command(Catalog myCatalog) throws InvalidCatalogException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(myPath), model.Catalog.class);
        } catch (IOException myException) {
            throw new InvalidCatalogException(myException);
        }

    }

    public Catalog ceva() throws InvalidCatalogException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(myPath), model.Catalog.class);
        } catch (IOException myException) {
            throw new InvalidCatalogException(myException);
        }
    }


    public Catalog command(Catalog loadedCatalog, String myPath) throws InvalidCatalogException {
        this.myPath = myPath;
        return command(loadedCatalog);
    }
}
