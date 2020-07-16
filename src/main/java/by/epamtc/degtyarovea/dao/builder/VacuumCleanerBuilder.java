package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.VacuumCleaner;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;

import java.util.Map;

public class VacuumCleanerBuilder extends AbstractBuilder {

    private VacuumCleaner appliance = new VacuumCleaner();

    @Override
    public Appliance build(Map<String, String> params) {
        int powerConsumption = Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()));
        String filterType = params.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
        String bagType = params.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        String wandType = params.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        int motorSpeed = Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()));
        int cleaningWidth = Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()));

        appliance.setPowerConsumption(powerConsumption);
        appliance.setFilterType(filterType);
        appliance.setBagType(bagType);
        appliance.setWandType(wandType);
        appliance.setMotorSpeed(motorSpeed);
        appliance.setCleaningWidth(cleaningWidth);

        return appliance;
    }
}
