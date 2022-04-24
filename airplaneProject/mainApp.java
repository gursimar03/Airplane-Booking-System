//Name - Gursimar Singh Ply
//SD1c
//D00251816


package airplaneProject;

import java.io.IOException;
import java.util.*;

public class mainApp {


    //Sample objects to run methods from other class
    public static final Customer SAMPLE_CUSTOMER = new Customer("sample");
    public static final Flight SAMPLE_FLIGHT = new Flight("sample");

    public static ArrayList<ArrayList<Customer>> customersArrayList = new ArrayList<>();
    // Here I used 2D Arraylist as there could be multiple customers for the same flight. More information on this in documentation

    public static ArrayList<Flight> flights = new ArrayList<>();
    //ArrayList flight to store flight objects 

    public static boolean firstCustomer = true;
    //To make sure the system does not loop infinite to check passports for the first time

    public static int numberOfAccounts = 1;
    //To have a count of total accounts

    public static void main(String[] args) throws IOException {

        fileReader();//to call the function to read data from the file
        mainMenu();//to go to main menu

    }

    public static void mainMenu() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("________Welcome to Air Line Booking Center__________\n");
        System.out.println("1.Book flights");
        System.out.println("2.Log in as Administrator");
        System.out.println("3.View Bookings");
        System.out.println("4.Flight Status");
        System.out.print("_______________________________________________________\nInput: ");
        int key = keyboard.nextInt();

        switch (key) {
            case 1:
                bookingMenu();
                break;
            case 2:
                addFlight();
                break;
            case 3:
                seeBookedFlight();
                break;
            case 4:
                showAvailabliltiy();
                break;
            case -1:
                showAll();
                break;
            default:
                System.out.println("Wrong Input!");
                mainMenu();
                break;
        }
        mainMenu();
        keyboard.close();
    }

    public static void bookingMenu() {

        Scanner keyboard = new Scanner(System.in);
        
        //REGREX to clear Screen . REFRENCE - https://stackoverflow.com/questions/2979383/how-to-clear-the-console
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        System.out.println();
        System.out.println("_____________Avaiable Flights______________\n");
        displayMenu();
        
        System.out.println("\nPlease enter your flight number to buy the ticket");
        System.out.print("____________________________________________________\nInput: ");
        int optionKey = takeInputChoice();
        // goes to function to get non garbage value
        System.out.println();
        System.out.println("PLease enter your name");
        String name = keyboard.nextLine();
        System.out.println("Please enter your date of birth");
        String date = keyboard.nextLine();

        String passport = "  ";
        int set = 0;

        //Checks if the passport is duplicate of other object
        do {
            if (set == 1) {
                System.out.println("Error! PLease enter correct passport");
            }
            System.out.println("Please enter your passport");
            passport = keyboard.nextLine();
            if (firstCustomer) {
                firstCustomer = false;
                break;
            }
            set = 1;
        } while (SAMPLE_CUSTOMER.checkPassport(customersArrayList, passport) != false);

        System.out.println("Please enter your gender");
        String g = keyboard.nextLine();
        System.out.println("Please enter your phone number");
        String ph = keyboard.nextLine();

        ArrayList<String> seats = flights.get(optionKey).getSeats(); //gets the seats from the object

        for (int i = 0; i < seats.size(); i++) {

            if (i % 10 == 0) {
                System.out.println("");
            }

            System.out.print(seats.get(i) + " ");

        }

        String bookedSeat = "";
        boolean flag = true;
        //nested while and do while to get corect seat number
        while (flag) {

            String seatNum = "";
            Boolean innerFlag = true;

            do {

                System.out.println("\nPlease enter your seat number (Exactly as menstioned above)");
                seatNum = keyboard.nextLine();
                for (String seat : seats) {
                    if (seatNum.equals(seat)) {
                        innerFlag = false;
                    }
                }

            }while(innerFlag);

            int indexOfSeat = seats.indexOf(seatNum);

            if (seats.get(indexOfSeat) != " " && seatNum != " ") {
                bookedSeat = seats.get(indexOfSeat);
                flights.get(optionKey).setSeats(indexOfSeat, " ");
                flag = false;
            } else {
                System.out.println("Please enter correct seat number.");
            }
        }

        customersArrayList.get(optionKey).add(new Customer(name, date, passport, g, ph, bookedSeat));
        customersArrayList.get(optionKey).get(customersArrayList.get(optionKey).size() - 1).display();
        //Adds new customer object and displays the related output

        mainMenu();
        keyboard.close();
    }

    //Shows avaiabliltiy of flights 
    public static void showAvailabliltiy() {

        Scanner keyboard = new Scanner(System.in);
        displayMenu();
        int option = takeInputChoice();
        flights.get(option).flightStatus();
        mainMenu();
        keyboard.close();
    }

    //Creats and adds new flight
    public static void addFlight() {

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        System.out.println("Please enter Admin Name");
        String adminName = keyboard.nextLine();
        System.out.println("Please enter Admin password");
        String adminPassword = keyboard.nextLine();

        if (adminName.equals("LordGursimar") && adminPassword.equals("nothankyou")) {

            customersArrayList.add(new ArrayList<Customer>());

            System.out.println("Please enter flight name ");
            String airline = keyboard.nextLine();
            System.out.println("Please enter departure airport");
            String destinationName = keyboard.nextLine();
            System.out.println("Please enter departure time");
            String destinationTime = keyboard.nextLine();
            System.out.println("Please enter arrival airport");
            String arrivalName = keyboard.nextLine();
            System.out.println("Please enter arrival time");
            String arrivalTime = keyboard.nextLine();

            System.out.println("Choose your plane option ");
            System.out.println("1. Boeing 737");
            System.out.println("2. Boeing 374");
            System.out.println("3. Cirrus SR22");
            int key = keyboard.nextInt();

            int lengthOfSection = 0;
            int numberOfSections = 0;

            switch (key) {
                case 1:
                    lengthOfSection = 10;
                    numberOfSections = 4;
                    break;
                case 2:
                    lengthOfSection = 10;
                    numberOfSections = 5;
                    break;
                case 3:
                    lengthOfSection = 8;
                    numberOfSections = 2;
                    break;
                default:
                    break;
            }

            ArrayList<String> seats = new ArrayList<>();

            seats =  SAMPLE_FLIGHT.seatsCreater(numberOfSections, lengthOfSection);

            flights.add(new Flight(airline, destinationName, destinationTime, arrivalName, arrivalTime, seats,customersArrayList.get((customersArrayList.size() - 1))));

            numberOfAccounts++;
            mainMenu();

        } else {
            System.out.println("Wrong password or admin name.");
            System.out.println("enter any key to try again \n0 to go back to Main Menu");
            String checky = keyboard.nextLine();
            if (checky.equals("0")) {
                mainMenu();
            } else {
                addFlight();
            }
        }
        keyboard.close();
    }


    //Gives user info of booked flight
    public static void seeBookedFlight() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your passport:");
        String passport = keyboard.nextLine();
        System.out.println("Please enter your Name:");
        String name = keyboard.nextLine();

        for (int i = 0; i <= customersArrayList.size() - 1; i++) {

            for (int j = 0; j <= customersArrayList.get(i).size() - 1; j++) {
                Customer checkedCustomer = customersArrayList.get(i).get(j);

                if ((checkedCustomer.getCostumerPassport().equals(passport)) && (checkedCustomer.getCostumerName().equals(name))) {

                    checkedCustomer.displayDetails();
                    flights.get(i).showFlightDetails("single");

                }

            }

        }

        mainMenu();
        keyboard.close();

    }

    //takes input from the user
    public static int takeInputChoice() {

        Scanner keyboard = new Scanner(System.in);
        int optionKey = 0;
        boolean invalidInput = true;
        do {

            optionKey = keyboard.nextInt() - 1;
            if (optionKey >= 0 && optionKey <= flights.size() - 1) {
                invalidInput = false;
            }
        } while (invalidInput);

        return optionKey;

    }

    //Debug mode of admin
    public static void showAll() {

        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i).getAirline());
        }
        mainMenu();
    }

    //Displays Flight Menu to user
    public static void displayMenu() {

        int counter = 1;

        for (Flight flight : flights) {

            System.out.print(counter + ". ");
            flight.showFlightDetails("data");
            counter++;
        }
    }

    //Reads file to get object flights
    public static void fileReader() throws IOException {

        ArrayList<Flight> fligthgetter = new ArrayList<>();
        fligthgetter = SAMPLE_FLIGHT.FlightFileReader();

        for (Flight flight : fligthgetter) {

            customersArrayList.add(new ArrayList<>());
            flights.add(flight);
        }

    }

}
