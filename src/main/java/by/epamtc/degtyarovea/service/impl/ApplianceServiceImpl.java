package by.epamtc.degtyarovea.service.impl;

import by.epamtc.degtyarovea.dao.ApplianceDAO;
import by.epamtc.degtyarovea.dao.DAOFactory;
import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;
import by.epamtc.degtyarovea.service.ApplianceService;
import by.epamtc.degtyarovea.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) {
        if (!Validator.validateCriteria(criteria)) {
            // todo realize throw Exception
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        return applianceDAO.find(criteria);
    }
}
