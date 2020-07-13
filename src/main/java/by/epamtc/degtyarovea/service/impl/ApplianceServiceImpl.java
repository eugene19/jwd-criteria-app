package by.epamtc.degtyarovea.service.impl;

import by.epamtc.degtyarovea.dao.ApplianceDAO;
import by.epamtc.degtyarovea.dao.ApplianceDAOException;
import by.epamtc.degtyarovea.dao.DAOFactory;
import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;
import by.epamtc.degtyarovea.service.ApplianceService;
import by.epamtc.degtyarovea.service.validation.CriteriaValidator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) throws ApplianceServiceException {
        if (!CriteriaValidator.validate(criteria)) {
            throw new ApplianceServiceException("Criteria is not valid.");
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        List<Appliance> appliances;

        try {
            appliances = applianceDAO.find(criteria);
        } catch (ApplianceDAOException e) {
            throw new ApplianceServiceException(e.getMessage());
        }

        return appliances;
    }
}
