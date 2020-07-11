package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {

    List<Appliance> find(Criteria criteria);

}
