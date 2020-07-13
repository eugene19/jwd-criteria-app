package by.epamtc.degtyarovea.controller.validation;

public class RequestValidator {

    private static final String REQUEST_PATTERN = "[A-Za-z]+([ ]?[A-Za-z_]+=[-\\w.]+)*";

    public static boolean validate(String request) {
        return request.matches(REQUEST_PATTERN);
    }
}
