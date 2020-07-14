package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.controller.Controller;

public class ConsoleRunner {

    public static void main(String[] args) {
        Controller controller = new Controller();

        // request in format "<ApplianceName> <param1=value1> <param2=value2> ..."
        String request = "VacuumCleaner POWER_CONSUMPTION=100 WAND_TYPE=all-in-one";
        String response = controller.execute(request);

        System.out.println(response);
    }
}
