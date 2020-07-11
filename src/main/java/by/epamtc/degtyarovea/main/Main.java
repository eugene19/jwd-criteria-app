package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.entity.Appliance;
import by.epamtc.degtyarovea.entity.TabletPC;
import by.epamtc.degtyarovea.entity.criteria.Criteria;
import by.epamtc.degtyarovea.entity.criteria.SearchCriteria;
import by.epamtc.degtyarovea.service.ApplianceService;
import by.epamtc.degtyarovea.service.ServiceFactory;

import java.util.List;

import static by.epamtc.degtyarovea.entity.criteria.SearchCriteria.Oven;

public class Main {

    public static void main(String[] args) {
        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(Oven.CAPACITY.toString(), 33);
        criteriaOven.add(Oven.HEIGHT.toString(), 45);

        appliances = service.find(criteriaOven);

        System.out.println(appliances);

//        PrintApplianceInfo.print(appliances);
//
//        //////////////////////////////////////////////////////////////////
//
//        criteriaOven = new Criteria(Oven.class.getSimpleName());
//        criteriaOven.add(Oven.HEIGHT.toString(), 200);
//        criteriaOven.add(Oven.DEPTH.toString(), 300);
//
//        appliances = service.find(criteriaOven);
//
//        PrintApplianceInfo.print(appliances);
//
//        //////////////////////////////////////////////////////////////////
//
        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        //criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "blue");
        //criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);

        appliances = service.find(criteriaTabletPC);// find(Object...obj)

        System.out.println(appliances);
//
//        PrintApplianceInfo.print(appliances);

    }

}
