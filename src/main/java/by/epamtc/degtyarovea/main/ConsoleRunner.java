package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.controller.Controller;

public class ConsoleRunner {

    public static void main(String[] args) {
        Controller controller = new Controller();

        // request in format "<ApplianceName> <param1=value1> <param2=value2> ..."
        String request = "Oven CAPACITY=33 DEPTH=60";
        String response = controller.execute(request);

        System.out.println(response);
    }
}
