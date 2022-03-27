package filehandler;

import java.io.IOException;

public class InvalidCatalogException extends IOException {
    public InvalidCatalogException(Exception myException) {
        super("Invalid catalog.", myException);
    }
}
