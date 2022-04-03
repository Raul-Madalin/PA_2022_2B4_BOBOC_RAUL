package command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import filehandler.InvalidCatalogException;
import model.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command{
    private String myPath;

    @Override
    public Catalog command(Catalog myCatalog) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            objectMapper.writeValue(new File(myPath), myCatalog);
        } catch (IOException myException) {
            throw new InvalidCatalogException(myException);
        }
        return null;
    }

    public Catalog command(Catalog myCatalog, String myPath) throws InvalidCatalogException {
        this.myPath = myPath;
        command(myCatalog);
        return null;
    }
}
