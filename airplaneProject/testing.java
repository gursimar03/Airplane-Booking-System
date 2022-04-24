package airplaneProject;

import java.util.ArrayList;

public class testing {

    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        //ArrayList to store customers

       customers.add(new Customer("Gursimar Singh", "29 03 2003", "D123213", "Male", "0123324", "A1"));
       customers.add(new Customer("Robert", "09 01 2003", "D213213", "Male", "123214214", "A5"));
       customers.add(new Customer("Rick Astley", "01 03 1800", "D123214", "Male", "2131251", "B3"));

       ArrayList<String> seats = new ArrayList<>();

       seats.add("A1");
       seats.add("A2");
       seats.add("A3");
       seats.add("A4");
       seats.add("A5");
       seats.add("B1");
       seats.add("B2");
       seats.add("B3");
       seats.add("B4");
       seats.add("B5");

       Flight flight = new Flight("Air France", "Dublin", "06:05", "PARIS", "08:45", seats, customers);
    

       customers.get(1).displayDetails();
       //Displays details for the customer
     
       
        //Duplicate and CompareBy functions
       
        if (customers.get(0).equals(customers.get(2))) {
           System.out.println(customers.get(2).getCostumerName()+" is duplicate of "+customers.get(0).getCostumerName());
       } 
       else {
        System.out.println(customers.get(2)+" is not duplicate of "+customers.get(0));
       }

       System.out.println(customers.get(0).compareTo(customers.get(2)));
    
       flight.flightStatus(); //Gives flight Details 
       System.out.println();

       // shows output based on situation 
       flight.showFlightDetails("single"); 
       flight.showFlightDetails("data");
    }
    
}
