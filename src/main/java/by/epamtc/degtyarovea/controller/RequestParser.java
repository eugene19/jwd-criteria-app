package by.epamtc.degtyarovea.controller;

import by.epamtc.degtyarovea.entity.criteria.Criteria;

public class RequestParser {

    private static final String PARAM_DELIMITER_PATTERN = "\\s+";
    private static final String KEY_VALUE_DELIMITER_PATTERN = "=";

    /**
     * Prepare Criteria object from String request
     */
    public Criteria parse(String request) {
        String[] params = request.split(PARAM_DELIMITER_PATTERN);

        String applianceName = params[0];
        Criteria criteria = new Criteria(applianceName);

        for (int i = 1; i < params.length; i++) {
            String keyValuePair = params[i]; // key=value
            String[] keyValueArray = keyValuePair.split(KEY_VALUE_DELIMITER_PATTERN);

            criteria.add(keyValueArray[0], keyValueArray[1]);
        }

        return criteria;
    }
}
