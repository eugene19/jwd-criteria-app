package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.Refrigerator;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;

import java.util.Map;

public class RefrigeratorBuilder extends AbstractBuilder {

    private Refrigerator appliance = new Refrigerator();

    @Override
    public Appliance build(Map<String, String> params) {
        int powerConsumption = Integer.parseInt(params.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()));
        double weight = Double.parseDouble(params.get(SearchCriteria.Refrigerator.WEIGHT.toString()));
        int freezerCapacity = Integer.parseInt(params.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()));
        double overallCapacity = Double.parseDouble(params.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()));
        double height = Double.parseDouble(params.get(SearchCriteria.Refrigerator.HEIGHT.toString()));
        double width = Double.parseDouble(params.get(SearchCriteria.Refrigerator.WIDTH.toString()));

        appliance.setPowerConsumption(powerConsumption);
        appliance.setWeight(weight);
        appliance.setFreezerCapacity(freezerCapacity);
        appliance.setOverallCapacity(overallCapacity);
        appliance.setHeight(height);
        appliance.setWidth(width);

        return appliance;
    }
}
