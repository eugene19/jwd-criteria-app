package by.epamtc.degtyarovea.dao.builder;

public class ApplianceBuilderFactory {

    private ApplianceBuilderFactory() {
    }

    public static AbstractBuilder createBuilder(String applianceType) {
        ApplianceType type = ApplianceType.valueOf(applianceType.toUpperCase());

        switch (type) {
            case OVEN:
                return new OvenBuilder();
            case LAPTOP:
                return new LaptopBuilder();
            case REFRIGERATOR:
                return new RefrigeratorBuilder();
            case SPEAKERS:
                return new SpeakersBuilder();
            case TABLETPC:
                return new TabletPCBuilder();
            case VACUUMCLEANER:
                return new VacuumCleanerBuilder();
            default:
                throw new IllegalArgumentException("Wrong type of appliance: " + applianceType);
        }
    }

    private enum ApplianceType {
        OVEN, LAPTOP, REFRIGERATOR, SPEAKERS, TABLETPC, VACUUMCLEANER
    }
}
