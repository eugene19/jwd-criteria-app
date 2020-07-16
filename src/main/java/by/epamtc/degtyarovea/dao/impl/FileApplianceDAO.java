package by.epamtc.degtyarovea.dao.impl;

import by.epamtc.degtyarovea.dao.ApplianceDAO;
import by.epamtc.degtyarovea.dao.ApplianceDAOException;
import by.epamtc.degtyarovea.dao.builder.AbstractBuilder;
import by.epamtc.degtyarovea.dao.builder.ApplianceBuilderFactory;
import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileApplianceDAO implements ApplianceDAO {

    private static final String DEVICE_FILENAME = "appliances_db.txt";

    private ApplianceFileReader reader;

    public FileApplianceDAO() {
        ClassLoader loader = getClass().getClassLoader();
        File devicesFile = new File(loader.getResource(DEVICE_FILENAME).getFile());
        reader = new ApplianceFileReader(devicesFile);
    }

    @Override
    public List<Appliance> find(Criteria criteria) throws ApplianceDAOException {
        List<Appliance> appliances = new ArrayList<>();
        String applianceName = criteria.getApplianceName();
        AbstractBuilder builderFactory = ApplianceBuilderFactory.createBuilder(applianceName);

        try {
            List<String> applianceLines = reader.readLinesForAppliance(applianceName);

            for (String line : applianceLines) {
                if (isApplianceMatchCriteria(criteria, line)) {
                    Map<String, String> attributes = FileApplianceParser.getAttributesMap(line);
                    Appliance appliance = builderFactory.build(attributes);
                    appliances.add(appliance);
                }
            }
        } catch (IOException e) {
            throw new ApplianceDAOException(e);
        }

        return appliances;
    }

    /**
     * @param criteria      - search criteria.
     * @param applianceLine - appliance line from file.
     * @return if appliance line contains all criteria's params
     */
    private boolean isApplianceMatchCriteria(Criteria criteria, String applianceLine) {
        boolean isMatch = true;
        Map<String, Object> criteriaMap = criteria.getCriteriaMap();

        for (Map.Entry<String, Object> entry : criteriaMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();

            String matchLinePattern = ".+" + key + "=" + value + ".*";

            if (!applianceLine.matches(matchLinePattern)) {
                isMatch = false;
            }
        }

        return isMatch;
    }
}
