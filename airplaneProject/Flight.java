package airplaneProject;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight {

    private String airline;
    private String Departure_airport;
    private String Departure_time;
    private String Arrival_airport;
    private String Arrival_time;
    private ArrayList<String> seats = new ArrayList<>();
    private ArrayList<Customer> customers;

    public Flight(String airline, String Departure_airport, String Departure_time, String Arrival_airport,String Arrival_time, ArrayList<String> seats, ArrayList<Customer> customers) {
        
        this.airline = airline;
        this.Departure_airport = Departure_airport;
        this.Departure_time = Departure_time;
        this.Arrival_airport = Arrival_airport;
        this.Arrival_time = Arrival_time;
        this.seats = seats;
        this.customers = customers;
    
    }

    public Flight(String airline, String Departure_airport, String Departure_time,ArrayList<String> seats, ArrayList<Customer> customers) {
        
        this.airline = airline;
        this.Departure_airport = Departure_airport;
        this.Departure_time = Departure_time;
        this.seats = seats;
        this.customers = customers;
    
    }

    public Flight(String airline, String Departure_airport, String Departure_time, String Arrival_airport,String Arrival_time, ArrayList<String> seats) {
        
        this.airline = airline;
        this.Departure_airport = Departure_airport;
        this.Departure_time = Departure_time;
        this.Arrival_airport = Arrival_airport;
        this.Arrival_time = Arrival_time;
        this.seats = seats;
    
    }

    public Flight(String airline, String Departure_airport, String Departure_time) {
        
        this.airline = airline;
        this.Departure_airport = Departure_airport;
        this.Departure_time = Departure_time;
    
    }

    public Flight(String airline){
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public String get() {
        return "Arriabl " + this.Arrival_airport + " " + " coustmers details" + this.customers;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }


    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }

    public void setSeats(int indexOfSeat , String value){

        this.seats.set(indexOfSeat, value);

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


    //Displays Flight status with number of available seats 
    public void flightStatus() {

        showFlightDetails("single");

        int counter = 0;

        for (String seat : seats) {
            if (seat.equals(" ")) {
                counter++;
            }
        }

        int numberOfSeatsAvaiable = seats.size() - counter;
        System.out.println("Number Of Seats avaiable: " + numberOfSeatsAvaiable);

    }

    //Shows details depending upon the situation.. programmer can choose what format of output should be presented
    public void showFlightDetails(String menuType) {

        if (menuType.equals("single"))
            System.out.println("\nFlight Name: " + this.airline + "\nDeparture Airport: " + this.Departure_airport
                    + "\nDeparture time: " + this.Departure_time + "\nArrival Airport: " + this.Arrival_airport
                    + "\nArrival Time: " + this.Arrival_time + "\n");
        else
            System.out.println(this.airline + " " + this.Departure_airport + " " + this.Departure_time + " "
                    + this.Arrival_airport + " " + this.Arrival_time);
    }

    public ArrayList<String> seatsCreater(int numberOfSections,int lengthOfSection){
        char seatSection = 'A';
        String seatNumber = "";
        ArrayList<String> seats = new ArrayList<>();

        for (int i = 1; i <= numberOfSections; i++) {

            for (int j = 1; j <= lengthOfSection; j++) {

                seatNumber = seatSection + (Integer.toString(j));

                seats.add(seatNumber);
            }

            seatNumber = "";
            seatSection++;

        }
        return seats;
    }

    //Reads through the file with provided filepath
    public  ArrayList<Flight> fileReader(String filepath) throws IOException {

        try {
            File myfile = new File(filepath);
            Scanner fileScanner = new Scanner(myfile);
            ArrayList<Flight> flights = new ArrayList<>();
            while (fileScanner.hasNext()) {

               ArrayList<String> seats = new ArrayList<>();
              

                String airline = fileScanner.nextLine();
                String Departure_airport = fileScanner.nextLine();
                String Departure_time = fileScanner.nextLine();
                String Arrival_airport = fileScanner.nextLine();
                String Arrival_time = fileScanner.nextLine();
                int numberOfSections = fileScanner.nextInt();
                int lengthOfSection = fileScanner.nextInt();
               
                seats = seatsCreater(numberOfSections, lengthOfSection);

                flights.add( new Flight(airline, Departure_airport, Departure_time, Arrival_airport, Arrival_time, seats, customers));
            }
            fileScanner.close();
            return flights;
            
        } 
        
        catch (FileNotFoundException e) {

            System.out.println("Error");
            e.printStackTrace();
        }
        return null;

    }

    //OverLoaded function to run default when no parameter/filepath is not provided
    public  ArrayList<Flight> FlightFileReader() throws IOException {

        try {
            File myfile = new File("airplaneProject/flightData.txt");
            Scanner fileScanner = new Scanner(myfile);
            ArrayList<Flight> flights = new ArrayList<>();
            
            while (fileScanner.hasNext()) {

               ArrayList<String> seats = new ArrayList<>();

                String airline = fileScanner.next();
                String Departure_airport = fileScanner.next();
                String Departure_time = fileScanner.next();
                String Arrival_airport = fileScanner.next();
                String Arrival_time = fileScanner.next();
                int numberOfSections = fileScanner.nextInt();
                int lengthOfSection = fileScanner.nextInt();

                seats = seatsCreater(numberOfSections, lengthOfSection);

                flights.add( new Flight(airline, Departure_airport, Departure_time, Arrival_airport, Arrival_time, seats, customers));
            }
            fileScanner.close();
            return flights;
            
        } 
        catch (FileNotFoundException e) {

            System.out.println("Error");
            e.printStackTrace();
        }
        return null;
    }

}
