package filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {
    private CatalogUtil() {}
    public static void save (Catalog myCatalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), myCatalog);
    }

    public static Catalog load (String path)
            throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog myCatalog;
        try {
            myCatalog = objectMapper.readValue(new File(path), Catalog.class);
        }
        catch (IOException myException){
            throw new InvalidCatalogException(myException);
        }
        return myCatalog;
    }
}

