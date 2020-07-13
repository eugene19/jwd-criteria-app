package by.epamtc.degtyarovea.controller;

import by.epamtc.degtyarovea.controller.validation.RequestValidator;
import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;
import by.epamtc.degtyarovea.service.ApplianceService;
import by.epamtc.degtyarovea.service.ApplianceServiceException;
import by.epamtc.degtyarovea.service.ServiceFactory;

import java.util.List;

public final class Controller {

    private static final String PARAM_DELIMITER_PATTERN = "\\s+";

    private ApplianceService service;

    public Controller() {
        ServiceFactory factory = ServiceFactory.getInstance();
        this.service = factory.getApplianceService();
    }

    /**
     * @param request - Line in format "<applianceName> <key1=value1> <key2=value2> ..."
     * @return Line with matching appliances or error message
     */
    public String execute(String request) {
        if (!RequestValidator.validate(request)) {
            return "Request is not valid.";
        }

        String response;
        Criteria criteria = prepareCriteria(request);

        try {
            List<Appliance> appliances = service.find(criteria);
            response = ApplianceInfoParser.parseToString(appliances);
        } catch (ApplianceServiceException e) {
            response = e.getMessage();
        }

        return response;
    }

    /**
     * Prepare Criteria object from String request
     */
    private Criteria prepareCriteria(String request) {
        String[] params = request.split(PARAM_DELIMITER_PATTERN);

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
