package by.epamtc.degtyarovea.entity;

import java.util.Objects;

public class Laptop implements Appliance {

    private double batteryCapacity;
    private String OS;
    private int memoryROM;
    private int systemMemory;
    private double CPU;
    private double displayInches;

    public Laptop() {
    }

    public Laptop(double batteryCapacity, String OS, int memoryROM, int systemMemory, double CPU, double displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.OS = OS;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(int memoryROM) {
        this.memoryROM = memoryROM;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCPU() {
        return CPU;
    }

    public void setCPU(double CPU) {
        this.CPU = CPU;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 &&
                memoryROM == laptop.memoryROM &&
                systemMemory == laptop.systemMemory &&
                Double.compare(laptop.CPU, CPU) == 0 &&
                Double.compare(laptop.displayInches, displayInches) == 0 &&
                Objects.equals(OS, laptop.OS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, OS, memoryROM, systemMemory, CPU, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", OS='" + OS + '\'' +
                ", memoryROM=" + memoryROM +
                ", systemMemory=" + systemMemory +
                ", CPU=" + CPU +
                ", displayInches=" + displayInches +
                '}';
    }
}
