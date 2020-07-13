package by.epamtc.degtyarovea.controller;

import by.epamtc.degtyarovea.entity.Appliance;

import java.util.List;

public class ApplianceInfoParser {

    public static String parseToString(List<Appliance> appliances) {
        StringBuilder builder = new StringBuilder();

        for (Appliance appliance : appliances) {
            builder.append(appliance.toString())
                    .append("\n");
        }

        return builder.toString();
    }
}
