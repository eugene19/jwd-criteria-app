package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.Speakers;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;

import java.util.Map;

public class SpeakersBuilder extends AbstractBuilder {

    private Speakers appliance = new Speakers();

    @Override
    public Appliance build(Map<String, String> params) {
        int powerConsumption = Integer.parseInt(params.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()));
        int numberOfSpeakers = Integer.parseInt(params.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()));
        String frequencyRange = params.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        int cardLength = Integer.parseInt(params.get(SearchCriteria.Speakers.CORD_LENGTH.toString()));

        appliance.setPowerConsumption(powerConsumption);
        appliance.setNumberOfSpeakers(numberOfSpeakers);
        appliance.setFrequencyRange(frequencyRange);
        appliance.setCardLength(cardLength);

        return appliance;
    }
}
