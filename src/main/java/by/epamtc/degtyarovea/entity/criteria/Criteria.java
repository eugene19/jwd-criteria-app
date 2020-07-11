package by.epamtc.degtyarovea.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private String applianceName;
    private Map<String, Object> criteria = new HashMap<>();

    public Criteria(String applianceName) {
        this.applianceName = applianceName;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }
}
