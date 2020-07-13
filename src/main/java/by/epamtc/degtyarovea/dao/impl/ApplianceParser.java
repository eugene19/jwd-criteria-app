package by.epamtc.degtyarovea.dao.impl;

import by.epamtc.degtyarovea.dao.ApplianceParseException;
import by.epamtc.degtyarovea.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceParser {

    private static final String KEY_VALUE_REGEX = "[A-Z_]+=[-\\w.]+";

    public Appliance parse(String applianceName, String line) throws ApplianceParseException {
        switch (applianceName) {
            case "Oven":
                return parseOven(line);
            case "Laptop":
                return parseLaptop(line);
            case "Refrigerator":
                return parseRefrigerator(line);
            case "VacuumCleaner":
                return parseVacuumCleaner(line);
            case "TabletPC":
                return parseTabletPC(line);
            case "Speakers":
                return parseSpeakers(line);
            default:
                throw new ApplianceParseException("No such device type: " + applianceName);
        }
    }

    public Laptop parseLaptop(String device) {
        Laptop laptop = new Laptop();
        List<String> attributes = getAttributes(device);

        laptop.setBatteryCapacity(Double.parseDouble(attributes.get(0)));
        laptop.setOS(attributes.get(1));
        laptop.setMemoryROM(Integer.parseInt(attributes.get(2)));
        laptop.setSystemMemory(Integer.parseInt(attributes.get(3)));
        laptop.setCPU(Double.parseDouble(attributes.get(4)));
        laptop.setDisplayInches(Double.parseDouble(attributes.get(5)));

        return laptop;
    }

    public Oven parseOven(String device) {
        Oven oven = new Oven();
        List<String> attributes = getAttributes(device);

        oven.setPowerConsumption(Integer.parseInt(attributes.get(0)));
        oven.setWeight(Double.parseDouble(attributes.get(1)));
        oven.setCapacity(Integer.parseInt(attributes.get(2)));
        oven.setDepth(Integer.parseInt(attributes.get(3)));
        oven.setHeight(Double.parseDouble(attributes.get(4)));
        oven.setWidth(Double.parseDouble(attributes.get(5)));

        return oven;
    }

    public Refrigerator parseRefrigerator(String device) {
        Refrigerator refrigerator = new Refrigerator();
        List<String> attributes = getAttributes(device);

        refrigerator.setPowerConsumption(Integer.parseInt(attributes.get(0)));
        refrigerator.setWeight(Double.parseDouble(attributes.get(1)));
        refrigerator.setFreezerCapacity(Integer.parseInt(attributes.get(2)));
        refrigerator.setOverallCapacity(Double.parseDouble(attributes.get(3)));
        refrigerator.setHeight(Double.parseDouble(attributes.get(4)));
        refrigerator.setWidth(Double.parseDouble(attributes.get(5)));

        return refrigerator;
    }

    public Speakers parseSpeakers(String device) {
        Speakers speakers = new Speakers();
        List<String> attributes = getAttributes(device);

        speakers.setPowerConsumption(Integer.parseInt(attributes.get(0)));
        speakers.setNumberOfSpeakers(Integer.parseInt(attributes.get(1)));
        speakers.setFrequencyRange(attributes.get(2));
        speakers.setCardLength(Integer.parseInt(attributes.get(3)));

        return speakers;
    }

    public TabletPC parseTabletPC(String device) {
        TabletPC tabletPC = new TabletPC();
        List<String> attributes = getAttributes(device);

        tabletPC.setBatteryCapacity(Double.parseDouble(attributes.get(0)));
        tabletPC.setDisplayInches(Double.parseDouble(attributes.get(1)));
        tabletPC.setMemoryROM(Integer.parseInt(attributes.get(2)));
        tabletPC.setFlashMemoryCapacity(Integer.parseInt(attributes.get(3)));
        tabletPC.setColor(attributes.get(4));

        return tabletPC;
    }

    public VacuumCleaner parseVacuumCleaner(String device) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        List<String> attributes = getAttributes(device);

        vacuumCleaner.setPowerConsumption(Integer.parseInt(attributes.get(0)));
        vacuumCleaner.setFilterType(attributes.get(1));
        vacuumCleaner.setBagType(attributes.get(2));
        vacuumCleaner.setWandType(attributes.get(3));
        vacuumCleaner.setMotorSpeed(Integer.parseInt(attributes.get(4)));
        vacuumCleaner.setCleaningWidth(Integer.parseInt(attributes.get(5)));

        return vacuumCleaner;
    }

    private List<String> getAttributes(String device) {
        List<String> attributes = new ArrayList<>();
        Matcher matcher = Pattern.compile(KEY_VALUE_REGEX).matcher(device);

        while (matcher.find()) {
            String[] pair = matcher.group().split("=");
            attributes.add(pair[1]);
        }

        return attributes;
    }
}
