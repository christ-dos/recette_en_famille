package fr.dawan.planification_repas.exception;

public class JourAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JourAlreadyExistException(String message) {
        super(message);
    }

}
