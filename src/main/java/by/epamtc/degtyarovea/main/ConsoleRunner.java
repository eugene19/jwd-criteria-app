package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.controller.Controller;

public class ConsoleRunner {

    public static void main(String[] args) {
        Controller controller = new Controller();

        // request in format "<ApplianceName> <param=value> <param=value> ..."
        String request = "Oven POWER_CONSUMPTION=2000 HEIGHT=40";
        String response = controller.execute(request);

        System.out.println(response);
    }
}
