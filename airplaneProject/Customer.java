package airplaneProject;


import java.util.*;

public class Customer {

    private String customerName;
    private String customerDateOfBirth;
    private String customerPassport;
    private String gender;
    private String phoneNumber;
    private String BookedSeatNumber;

    public Customer(String customerName, String customerDateOfBirth, String customerPassport, String gender,
            String phoneNumber, String bookedSeat) {

        this.customerName = customerName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.gender = gender;
        this.customerPassport = customerPassport;
        this.phoneNumber = phoneNumber;
        this.BookedSeatNumber = bookedSeat;
    }

    public Customer(String customerName, String customerDateOfBirth, String customerPassport, String gender) {

        this.customerName = customerName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.gender = gender;
        this.customerPassport = customerPassport;
        this.phoneNumber = null;

    }

    public Customer(String customerName, String customerDateOfBirth, String customerPassport) {

        this.customerName = customerName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.gender = null;
        this.customerPassport = customerPassport;
        this.phoneNumber = null;

    }

    public Customer(String customerName, String customerPassport) {

        this.customerName = customerName;
        this.customerDateOfBirth = null;
        this.gender = null;
        this.customerPassport = customerPassport;
        this.phoneNumber = null;

    }

    public Customer(String customerName) {

        this.customerName = customerName;
        this.customerDateOfBirth = null;
        this.gender = null;
        this.customerPassport = null;
        this.phoneNumber = null;

    }

    public void setBookedSeatNumber(String bookedSeatNumber) {
        this.BookedSeatNumber = bookedSeatNumber;
    }

    public void setCostumerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public void setCostumerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCostumerPassport(String customerPassport) {
        this.customerPassport = customerPassport;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBookedSeatNumber() {
        return BookedSeatNumber;
    }

    public String getCostumerDateOfBirth() {
        return customerDateOfBirth;
    }

    public String getCostumerName() {
        return customerName;
    }

    public String getCostumerPassport() {
        return customerPassport;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int compareTo(Customer other) {
        if (!(this.BookedSeatNumber.equals(other.BookedSeatNumber))) {
            return -1;
        } else if (this.BookedSeatNumber.equals(other.BookedSeatNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.customerName;
    }

    public void display() {

        System.out.println("Thank you so much " + this.customerName + " for booking. \n This is your seat number "
                + this.BookedSeatNumber);

    }

    public boolean equals(Object otherObject)
    {
        if(otherObject == null)
        {
            return false;
        }else if(getClass() != otherObject.getClass())
        {
            return false;
        }
        else 
        {
            Customer otherCustomer = (Customer) otherObject;
            return (customerName.equals(otherCustomer.customerName)
                    &&customerDateOfBirth.equals(otherCustomer.customerDateOfBirth)
                    &&customerPassport.equals(otherCustomer.customerPassport)
                    &&BookedSeatNumber.equals(otherCustomer.BookedSeatNumber)
                    &&gender.equals(otherCustomer.gender));
        }
        
    }

    public void displayDetails(){

        System.out.println("\nName: "+this.customerName+"\nDate Of Birth: "+this.customerDateOfBirth+"\nPassport Number: "+this.customerPassport+"\nBooked Seat Number:"+this.BookedSeatNumber);

    }

    public boolean checkPassport(ArrayList<ArrayList<Customer>> customers, String passport){

        for (int i = 0; i <= customers.size() - 1; i++) {

            for (int j = 0; j <= customers.get(i).size() - 1; j++) {
                Customer customer = customers.get(i).get(j);

                if (customer.getCostumerPassport().equals(passport)) {

                    return true;
                }

            }

        }

        return false;


    }

    
}
