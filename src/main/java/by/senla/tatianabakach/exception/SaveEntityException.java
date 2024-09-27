package by.senla.tatianabakach.exception;

public class SaveEntityException extends RuntimeException{

    public SaveEntityException(final String entityType) {
        super("The " + entityType + "wasn't save in database");
    }
}
