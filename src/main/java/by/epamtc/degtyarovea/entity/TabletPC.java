package by.epamtc.degtyarovea.entity;

import java.util.Objects;

public class TabletPC implements Appliance {

    private double batteryCapacity;
    private double displayInches;
    private int memoryROM;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC() {
    }

    public TabletPC(double batteryCapacity, double displayInches, int memoryROM, int flashMemoryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(int memoryROM) {
        this.memoryROM = memoryROM;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return Double.compare(tabletPC.batteryCapacity, batteryCapacity) == 0 &&
                Double.compare(tabletPC.displayInches, displayInches) == 0 &&
                memoryROM == tabletPC.memoryROM &&
                flashMemoryCapacity == tabletPC.flashMemoryCapacity &&
                Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayInches, memoryROM, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryROM=" + memoryROM +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
