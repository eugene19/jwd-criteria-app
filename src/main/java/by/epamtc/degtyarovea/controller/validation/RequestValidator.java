package by.epamtc.degtyarovea.controller.validation;

public class RequestValidator {

    private static final String REQUEST_PATTERN = "[\\w]+([ ]?[\\w_]+=[\\w\\d.]+)*";

    public static boolean validate(String request) {
        return request.matches(REQUEST_PATTERN);
    }
}
