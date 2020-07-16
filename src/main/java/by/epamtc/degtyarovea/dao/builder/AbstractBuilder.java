package by.epamtc.degtyarovea.dao.builder;

import by.epamtc.degtyarovea.entity.Appliance;

import java.util.Map;

public abstract class AbstractBuilder {

    public abstract Appliance build(Map<String, String> params);

}
