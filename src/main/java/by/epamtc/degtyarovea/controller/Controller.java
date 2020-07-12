package by.epamtc.degtyarovea.controller;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;
import by.epamtc.degtyarovea.service.ApplianceService;
import by.epamtc.degtyarovea.service.ServiceFactory;
import by.epamtc.degtyarovea.service.impl.ApplianceServiceException;

import java.util.List;

public class Controller {

    private ApplianceService service;

    public Controller() {
        ServiceFactory factory = ServiceFactory.getInstance();
        this.service = factory.getApplianceService();
    }

    /**
     * @param request - Line in format "<applianceName> <key=value> <key=value> ..."
     * @return Line with matching appliances or error message
     */
    public String execute(String request) {
        String response;

        Criteria criteria = prepareCriteria(request);

        try {
            List<Appliance> appliances = service.find(criteria);
            response = PrintApplianceInfo.print(appliances);
        } catch (ApplianceServiceException e) {
            response = e.getMessage();
        }

        return response;
    }

    /**
     * Prepare Criteria object from String request
     */
    private Criteria prepareCriteria(String request) {
        String[] params = request.split("\\s+");

        String applianceName = params[0];
        Criteria criteria = new Criteria(applianceName);

        for (int i = 1; i < params.length; i++) {
            String keyValuePair = params[i]; // key=value
            String[] keyValueArray = keyValuePair.split("=");

            criteria.add(keyValueArray[0], keyValueArray[1]);
        }
        return criteria;
    }
}
