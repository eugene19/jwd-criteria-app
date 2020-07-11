package by.epamtc.degtyarovea.dao.impl;

import by.epamtc.degtyarovea.dao.ApplianceDAO;
import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileApplianceDAO implements ApplianceDAO {

    private static final String DEVICE_FILENAME = "appliances_db.txt";

    private File devicesFile;

    public FileApplianceDAO() {
        ClassLoader loader = getClass().getClassLoader();
        devicesFile = new File(loader.getResource(DEVICE_FILENAME).getFile());
    }

    @Override
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> appliances = new ArrayList<>();
        DeviceFileReader reader = new DeviceFileReader(devicesFile);
        DeviceParser parser = new DeviceParser();

        try {
            List<String> applianceLines = reader.readLinesForAppliance(criteria.getApplianceName());

            for (String line : applianceLines) {
                if (applianceMatchCriteria(criteria, line)) {
                    // todo make parser
                    appliances.add(parser.parse(criteria.getApplianceName(), line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appliances;
    }

    private boolean applianceMatchCriteria(Criteria criteria, String applianceLine) {
        boolean isMatch = true;
        Map<String, Object> criteria1 = criteria.getCriteria();

        for (Map.Entry<String, Object> stringObjectEntry : criteria1.entrySet()) {
            String key = stringObjectEntry.getKey();
            String value = stringObjectEntry.getValue().toString();

            String patternToMatch = ".+" + key + "=" + value + ".*";

            if (!applianceLine.matches(patternToMatch)) {
                isMatch = false;
            }
        }

        return isMatch;
    }
}
