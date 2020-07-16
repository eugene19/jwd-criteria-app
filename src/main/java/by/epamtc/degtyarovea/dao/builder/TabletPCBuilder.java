package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.TabletPC;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;

import java.util.Map;

public class TabletPCBuilder extends AbstractBuilder {

    private TabletPC appliance = new TabletPC();

    @Override
    public Appliance build(Map<String, String> params) {
        double batteryCapacity = Double.parseDouble(params.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()));
        double displayInches = Double.parseDouble(params.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()));
        int memoryROM = Integer.parseInt(params.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()));
        int flashMemoryCapacity = Integer.parseInt(params.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()));
        String color = params.get(SearchCriteria.TabletPC.COLOR.toString());

        appliance.setBatteryCapacity(batteryCapacity);
        appliance.setDisplayInches(displayInches);
        appliance.setMemoryROM(memoryROM);
        appliance.setFlashMemoryCapacity(flashMemoryCapacity);
        appliance.setColor(color);

        return appliance;
    }
}
