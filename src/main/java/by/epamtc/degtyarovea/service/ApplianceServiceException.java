package by.epamtc.degtyarovea.service;

public class ApplianceServiceException extends Exception {

    public ApplianceServiceException() {
    }

    public ApplianceServiceException(String message) {
        super(message);
    }

    public ApplianceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplianceServiceException(Throwable cause) {
        super(cause);
    }
}
