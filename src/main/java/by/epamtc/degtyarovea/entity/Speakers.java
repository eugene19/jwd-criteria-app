package by.epamtc.degtyarovea.entity;

import java.util.Objects;

public class Speakers implements Appliance {

    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cardLength;

    public Speakers() {
    }

    public Speakers(int powerConsumption, int numberOfSpeakers, String frequencyRange, int cardLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cardLength = cardLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCardLength() {
        return cardLength;
    }

    public void setCardLength(int cardLength) {
        this.cardLength = cardLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption &&
                numberOfSpeakers == speakers.numberOfSpeakers &&
                cardLength == speakers.cardLength &&
                Objects.equals(frequencyRange, speakers.frequencyRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers, frequencyRange, cardLength);
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cardLength=" + cardLength +
                '}';
    }
}
