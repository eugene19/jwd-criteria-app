package by.epamtc.degtyarovea.service.validation;

import by.epamtc.degtyarovea.entity.criteria.Criteria;

public class CriteriaValidator {

    public static boolean validate(Criteria criteria) {
        return criteria.getApplianceName() != null;
    }
}
