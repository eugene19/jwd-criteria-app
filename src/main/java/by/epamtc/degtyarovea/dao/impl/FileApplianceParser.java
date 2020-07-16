package by.epamtc.degtyarovea.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileApplianceParser {

    private static final String KEY_VALUE_REGEX = "[A-Z_]+=[-\\w.]+";
    private static final String KEY_VALUE_DELIMITER_REGEX = "=";

    /**
     * @param appliance - line of appliance from file
     * @return Map of appliance's params as key and value
     */
    public static Map<String, String> getAttributesMap(String appliance) {
        Map<String, String> attributes = new HashMap<>();
        Matcher matcher = Pattern.compile(KEY_VALUE_REGEX).matcher(appliance);

        while (matcher.find()) {
            String[] pair = matcher.group().split(KEY_VALUE_DELIMITER_REGEX);
            attributes.put(pair[0], pair[1]);
        }

        return attributes;
    }
}
