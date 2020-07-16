package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.Oven;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;

import java.util.Map;

public class OvenBuilder extends AbstractBuilder {

    private Oven appliance = new Oven();

    @Override
    public Appliance build(Map<String, String> params) {
        int powerConsumption = Integer.parseInt(params.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()));
        double weight = Double.parseDouble(params.get(SearchCriteria.Oven.WEIGHT.toString()));
        int capacity = Integer.parseInt(params.get(SearchCriteria.Oven.CAPACITY.toString()));
        int depth = Integer.parseInt(params.get(SearchCriteria.Oven.DEPTH.toString()));
        double height = Double.parseDouble(params.get(SearchCriteria.Oven.HEIGHT.toString()));
        double width = Double.parseDouble(params.get(SearchCriteria.Oven.WIDTH.toString()));

        appliance.setPowerConsumption(powerConsumption);
        appliance.setWeight(weight);
        appliance.setCapacity(capacity);
        appliance.setDepth(depth);
        appliance.setHeight(height);
        appliance.setWidth(width);

        return appliance;
    }
}
