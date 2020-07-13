package by.epamtc.degtyarovea.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplianceFileReader {

    private File file;

    public ApplianceFileReader(File file) {
        this.file = file;
    }

    public List<String> readLinesForAppliance(String applianceName) throws IOException {
        List<String> appliances = new ArrayList<>();
        String applianceLinePattern = applianceName + ".+";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(applianceLinePattern)) {
                    appliances.add(line);
                }
            }
        }

        return appliances;
    }
}
