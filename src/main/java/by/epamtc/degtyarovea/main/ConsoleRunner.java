package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.controller.Controller;

public class ConsoleRunner {

    public static void main(String[] args) {
        Controller controller = new Controller();

        // request in format "<ApplianceName> <param=value> <param=value> ..."
        String request = "Speakers FREQUENCY_RANGE=2-3.5";
        String response = controller.execute(request);

        System.out.println(response);
    }
}
