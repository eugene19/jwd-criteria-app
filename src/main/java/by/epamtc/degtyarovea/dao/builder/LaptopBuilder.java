package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.Laptop;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;

import java.util.Map;

public class LaptopBuilder extends AbstractBuilder {

    private Laptop appliance = new Laptop();

    @Override
    public Appliance build(Map<String, String> params) {
        double batteryCapacity = Double.parseDouble(params.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()));
        String OS = params.get(SearchCriteria.Laptop.OS.toString());
        int memoryROM = Integer.parseInt(params.get(SearchCriteria.Laptop.MEMORY_ROM.toString()));
        int systemMemory = Integer.parseInt(params.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()));
        double CPU = Double.parseDouble(params.get(SearchCriteria.Laptop.CPU.toString()));
        double displayInches = Double.parseDouble(params.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString()));

        appliance.setBatteryCapacity(batteryCapacity);
        appliance.setOS(OS);
        appliance.setMemoryROM(memoryROM);
        appliance.setSystemMemory(systemMemory);
        appliance.setCPU(CPU);
        appliance.setDisplayInches(displayInches);

        return appliance;
    }
}
