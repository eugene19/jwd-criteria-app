package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.entity.*;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        for (Appliance appliance : appliances) {
            String applianceName = appliance.getClass().getSimpleName();

            switch (applianceName) {
                case "Oven":
                    print((Oven) appliance);
                    break;
                case "Laptop":
                    print((Laptop) appliance);
                    break;
                case "Refrigerator":
                    print((Refrigerator) appliance);
                    break;
                case "VacuumCleaner":
                    print((VacuumCleaner) appliance);
                    break;
                case "TabletPC":
                    print((TabletPC) appliance);
                    break;
                case "Speakers":
                    print((Speakers) appliance);
                    break;
            }
        }
    }

    private static void print(VacuumCleaner appliance) {
        System.out.printf("Vacuum cleaner: " +
                        "power consumption - %d, " +
                        "filter type - %s, " +
                        "bag type - %s, " +
                        "wand type - %s, " +
                        "motor speed - %d, " +
                        "cleaning width - %d.%n",
                appliance.getPowerConsumption(),
                appliance.getFilterType(),
                appliance.getBagType(),
                appliance.getWandType(),
                appliance.getMotorSpeed(),
                appliance.getCleaningWidth());
    }

    private static void print(TabletPC appliance) {
        System.out.printf("TabletPC: " +
                        "battery capacity - %.2f, " +
                        "display inches - %.2f, " +
                        "memory ROM - %d, " +
                        "flash memory capacity - %d, " +
                        "color - %s.%n",
                appliance.getBatteryCapacity(),
                appliance.getDisplayInches(),
                appliance.getMemoryROM(),
                appliance.getFlashMemoryCapacity(),
                appliance.getColor());
    }

    private static void print(Speakers appliance) {
        System.out.printf("Speakers: " +
                        "power consumption - %d, " +
                        "number of speakers - %d, " +
                        "frequency range - %s, " +
                        "card length - %d.%n",
                appliance.getPowerConsumption(),
                appliance.getNumberOfSpeakers(),
                appliance.getFrequencyRange(),
                appliance.getCardLength());
    }

    private static void print(Refrigerator appliance) {
        System.out.printf("Refrigerator: " +
                        "power consumption - %d, " +
                        "weight - %.2f, " +
                        "freezer capacity - %d, " +
                        "overall capacity - %.2f, " +
                        "height - %.2f, " +
                        "width - %.2f.%n",
                appliance.getPowerConsumption(),
                appliance.getWeight(),
                appliance.getFreezerCapacity(),
                appliance.getOverallCapacity(),
                appliance.getHeight(),
                appliance.getWidth());
    }

    private static void print(Laptop appliance) {
        System.out.printf("Laptop: " +
                        "battery capacity - %.2f, " +
                        "OS - %s, " +
                        "memory ROM - %d, " +
                        "system memory - %d, " +
                        "CPU - %.2f, " +
                        "display inches - %.2f.%n",
                appliance.getBatteryCapacity(),
                appliance.getOS(),
                appliance.getMemoryROM(),
                appliance.getSystemMemory(),
                appliance.getCPU(),
                appliance.getDisplayInches());
    }

    private static void print(Oven appliance) {
        System.out.printf("Oven: " +
                        "power consumption - %d, " +
                        "weight - %.2f, " +
                        "capacity - %d, " +
                        "depth - %d, " +
                        "height - %.2f, " +
                        "width - %.2f.%n",
                appliance.getPowerConsumption(),
                appliance.getWeight(),
                appliance.getCapacity(),
                appliance.getDepth(),
                appliance.getHeight(),
                appliance.getWidth());
    }
}
