package airplaneProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class mainApp {

    public static ArrayList<ArrayList<String>> data = new ArrayList<>();
    public static ArrayList<ArrayList<Customer>> customersArrayList = new ArrayList<>();
    public static ArrayList<Flight> flighData = new ArrayList<>();
    public static ArrayList<ArrayList<String>> seatNumbers = new ArrayList<>();
    public static boolean firstCustomer = true;
    public static int numberOfAccounts = 1;

    public static void main(String[] args) throws IOException {

        fileReader();
        adminView();
        mainMenu();
       

    }

    public static void bookingMenu() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("FLIGHT OPTIONS ");
        displayMenu();

        System.out.println("Please enter your flight number to buy the ticket");
        int optionKey = keyboard.nextInt() - 1;

        keyboard.nextLine();

        System.out.println("PLease enter your name");
        String name = keyboard.nextLine();
        System.out.println("Please enter your date of birth");
        String date = keyboard.nextLine();

        String passport = "  ";
        int set = 0;

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
        } while (customerCheck(passport) != false);

        System.out.println("Please enter your gender");
        String g = keyboard.nextLine();
        System.out.println("Please enter your phone number");
        String ph = keyboard.nextLine();

        for (int i = 0; i < seatNumbers.get(optionKey).size() - 1; i++) {

            if (i % 10 == 0) {
                System.out.println("");
            }

            System.out.print(seatNumbers.get(optionKey).get(i) + " ");

        }

        System.out.println("\nPlease enter your seat number (Exactly as menstioned above)");
        String seatNum = keyboard.nextLine();

        int indexOfSeat = seatNumbers.get(optionKey).indexOf(seatNum);
        String bookedSeat = "";

        if (seatNumbers.get(optionKey).get(indexOfSeat) != " ") {
            bookedSeat = seatNumbers.get(optionKey).get(indexOfSeat);
            seatNumbers.get(optionKey).set(indexOfSeat, " ");
        }

        customersArrayList.get(optionKey).add(new Customer(name, date, passport, g, ph, bookedSeat));

        customersArrayList.get(optionKey).get(customersArrayList.get(optionKey).size() - 1).display();

        mainMenu();
       

    }

    public static void adminView() {

        String fligString = "";
        String dString = "";
        String dtime = "";
        String aaString = "";
        String atime = "";

        int index = 0;

        int s = data.size();

        if (data.size() == 1) {
            s = 0;
        }  

        int c =0;
        if(flighData.size() == 0){
            c = 0;
        }else{
            c = flighData.size()-1;
        }


        for (int a = c ; a < s; a++) {

            index = 0;
            fligString = data.get(a).get(index);
            index++;
            dString = data.get(a).get(index);
            index++;
            dtime = data.get(a).get(index);
            index++;
            aaString = data.get(a).get(index);
            index++;
            atime = data.get(a).get(index);
            index++;

            index = 0;

            flighData.add(
                    new Flight(fligString, dString, dtime, aaString, atime, seatNumbers.get(a),
                            customersArrayList.get(a)));

        }

        mainMenu();

    }

    public static void mainMenu() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("________Welcome to Air Line Booking Center__________");
        System.out.println("1.Book flights");
        System.out.println("2.Log in as Administrator");
        System.out.println("3.View Bookings");
        int key = keyboard.nextInt();

        switch (key) {
            case 1:
                bookingMenu();
                break;
            case 2:
                login();
                break;
            case 3:
                view();
                break;
            case 4:
                showall();
                break;
            default:
                System.out.println("Wrong Input!");
                mainMenu();
                break;
        }

    }

    public static void showall() {

        for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i).toString());
        }

        for (int i = 0; i < flighData.size(); i++) {
            System.out.println(flighData.get(i).getAirline());
    }

        mainMenu();
    }


    public static void login() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter Admin Name");
        String adminName = keyboard.nextLine();
        System.out.println("Please enter Admin password");
        String adminPassword = keyboard.nextLine();
        System.out.println(numberOfAccounts);
        if (adminName.equals("LordGursimar") && adminPassword.equals("nothankyou")) {

            data.add(new ArrayList<String>());
            seatNumbers.add(new ArrayList<String>());
            customersArrayList.add(new ArrayList<Customer>());
            

            System.out.println("Please enter flight name ");
            String name = keyboard.nextLine();
            data.get(data.size()-1).add(name);

            System.out.println("Please enter departure airport");
            String dString = keyboard.nextLine();
            data.get(data.size()-1).add(dString);

            System.out.println("Please enter departure time");
            String dtime = keyboard.nextLine();
            data.get(data.size()-1).add(dtime);

            System.out.println("Please enter arrival airport");
            String aname = keyboard.nextLine();
            data.get(data.size()-1).add(aname);

            System.out.println("Please enter arrival time");
            String atime = keyboard.nextLine();
            data.get(data.size()-1).add(atime);

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

                    lengthOfSection = 3;
                    numberOfSections = 2;
                    break;

                default:
                    break;
            }

            seatManager(numberOfSections, lengthOfSection);

            numberOfAccounts++;
            // mainMenu();
            adminView();
        } else {
            System.out.println("Wrong password or admin name.");
            System.out.println("enter any key to try again \n0 to go back to Main Menu");
            String checky = keyboard.nextLine();
            if (checky.equals("0")) {
                mainMenu();
            } else {
                login();
            }
        }
    }

    public static void seatManager(int numberOfSections, int lengthOfSection) {

        char seatSection = 'A';
        String seatNumber = "";

        for (int i = 1; i <= numberOfSections; i++) {

            for (int j = 1; j <= lengthOfSection; j++) {

                seatNumber = seatSection + (Integer.toString(j));
                seatNumbers.get(data.size()-1).add(seatNumber);

            }

            seatNumber = "";
            seatSection++;

        }

    }

    public static boolean customerCheck(String passport) {

        for (int i = 0; i <= customersArrayList.size() - 1; i++) {

            for (int j = 0; j <= customersArrayList.get(i).size() - 1; j++) {
                Customer a = customersArrayList.get(i).get(j);

                if (a.getCostumerPassport().equals(passport)) {

                    return true;
                }

            }

        }

        return false;

    }

    public static void displayMenu() {
        
        int counter = 1;
        for (Flight flight : flighData) {

            System.out.print(counter + ". ");
            flight.showFlightDetails("data");
            counter++;
        }
    }

    public static void view(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your passport:");
        String passport = keyboard.nextLine();
        System.out.println("Please enter your Name:");
        String name = keyboard.nextLine();

        for (int i = 0; i <= customersArrayList.size() - 1; i++) {

            for (int j = 0; j <= customersArrayList.get(i).size() - 1; j++) {
                Customer checkedCustomer = customersArrayList.get(i).get(j);

                if ( (checkedCustomer.getCostumerPassport().equals(passport)) && (checkedCustomer.getCostumerName().equals(name)) ) {

                    checkedCustomer.displayDetails();
                    flighData.get(i).showFlightDetails("single");
                    
                }

            }

        }


    }


    public static void viewBookings() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please Choose your flight");
        System.out.println("FLIGHT OPTIONS ");
        displayMenu();

        System.out.print("Option: ");
        int optionKey = keyboard.nextInt() - 1;

        for (int i = 0; i < customersArrayList.get(optionKey).size(); i++) {

            System.out.println("--------------------");
            System.out.println(
                    flighData.get(optionKey).toString() + "" + customersArrayList.get(optionKey).get(i).toString());

        }

        mainMenu();

    }

    public static void fileReader() throws IOException {

        try {
            File myfile = new File("airplaneProject/flightData.txt");
            Scanner fileScanner = new Scanner(myfile);

            while (fileScanner.hasNext()) {

                String[] dataExtracter = new String[6];

                for (int i = 0; i <= 4; i++) {
                    dataExtracter[i] = fileScanner.next();
                }

                int numberOfSections = fileScanner.nextInt();
                int lengthOfSection = fileScanner.nextInt();

                char seatSection = 'A';
                String seatNumber = "";

                seatNumbers.add(new ArrayList<>());
                data.add(new ArrayList<>());
                customersArrayList.add(new ArrayList<>());

                int s = seatNumbers.size();

                if (s == 1) {
                    s = 0;
                } else {
                    s -= 1;
                }

                for (int i = 1; i <= numberOfSections; i++) {

                    for (int j = 1; j <= lengthOfSection; j++) {

                        seatNumber = seatSection + (Integer.toString(j));

                        seatNumbers.get(s).add(seatNumber);
                    }

                    seatNumber = "";
                    seatSection++;

                }

                s = data.size();

                if (s == 1) {
                    s = 0;
                } else {
                    s -= 1;
                }

                for (String dataGet : dataExtracter) {
                    data.get(s).add(dataGet);
                }
                numberOfAccounts++;

            }

            fileScanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("Error");
            e.printStackTrace();
        }

    }

}
