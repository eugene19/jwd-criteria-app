package by.epamtc.degtyarovea.service;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria);

}
