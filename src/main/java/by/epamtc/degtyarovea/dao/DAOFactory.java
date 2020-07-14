package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.dao.impl.FileApplianceDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final ApplianceDAO applianceDAO = new FileApplianceDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }
}
