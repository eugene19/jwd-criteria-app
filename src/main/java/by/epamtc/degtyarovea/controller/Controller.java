package by.epamtc.degtyarovea.controller;

import by.epamtc.degtyarovea.controller.validation.RequestValidator;
import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.criteria.Criteria;
import by.epamtc.degtyarovea.service.ApplianceService;
import by.epamtc.degtyarovea.service.ApplianceServiceException;
import by.epamtc.degtyarovea.service.ServiceFactory;

import java.util.List;

public final class Controller {

    private ApplianceService service;
    private RequestParser parser;

    public Controller() {
        ServiceFactory factory = ServiceFactory.getInstance();
        this.service = factory.getApplianceService();
        this.parser = new RequestParser();
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
        Criteria criteria = parser.parse(request);

        try {
            List<Appliance> appliances = service.find(criteria);
            response = ApplianceInfoParser.parseToString(appliances);
        } catch (ApplianceServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}
