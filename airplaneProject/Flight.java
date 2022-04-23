package airplaneProject;

import java.util.ArrayList;

public class Flight {

    private String airline;// "aer lingus","dublin", "12pm", "Da paris", "1am" ,"737"
    private String Departure_airport;
    private String Departure_time;
    private String Arrival_airport;
    private String Arrival_time;

    private ArrayList<String> seats = new ArrayList<>();
    private ArrayList<Customer> customers;

    // private String[] FlightData = new String[5];

    public Flight(String airline, String Departure_airport, String Departure_time, String Arrival_airport,
            String Arrival_time, ArrayList<String> seats, ArrayList<Customer> customers) {
        this.airline = airline;
        this.Departure_airport = Departure_airport;
        this.Departure_time = Departure_time;
        this.Arrival_airport = Arrival_airport;
        this.Arrival_time = Arrival_time;

        this.seats = seats;
        this.customers = customers;
    }
    // public Flight(ArrayList<String> seats, String[] fStrings) {

    // this.seats = seats;
    // this.FlightData = fStrings;

    // }

    // public String[] getFlightData() {
    // return FlightData;
    // }

    public String getAirline() {
        return airline;
    }

    public String get() {
        return "Arriabl " + this.Arrival_airport + " " + " coustmers details" + this.customers;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }

    // public void setFlightData(String[] flightData) {
    // FlightData = flightData;
    // }

    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }

    public String getArrival_airport() {
        return Arrival_airport;
    }

    public String getArrival_time() {
        return Arrival_time;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getDeparture_airport() {
        return Departure_airport;
    }

    public String getDeparture_time() {
        return Departure_time;
    }

    @Override
    public String toString() {

        return Departure_airport + "   " + Departure_time;
    }



    public void showFlightDetails(String menuType){

        if(menuType.equals("single"))
            System.out.println("\nFlight Name: " + this.airline +"\nDeparture Airport: "+this.Departure_airport+"\nDeparture time: "+this.Departure_time+"\nArrival Airport: "+ this.Arrival_airport+ "\nArrival Time: "+this.Arrival_time+"\n" );
        else 
            System.out.println(this.airline+" "+this.Departure_airport+" "+this.Departure_time+" "+this.Arrival_airport+" "+this.Arrival_time);
    }
}
