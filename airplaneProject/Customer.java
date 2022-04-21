package airplaneProject;

public class Customer {

    private String costumerName;
    private String costumerDateOfBirth;
    private String costumerPassport;
    private String gender;
    private String phoneNumber;
    private String BookedSeatNumber;

    public Customer(String costumerName, String costumerDateOfBirth, String costumerPassport, String gender,
            String phoneNumber, String bookedSeat) {

        this.costumerName = costumerName;
        this.costumerDateOfBirth = costumerDateOfBirth;
        this.gender = gender;
        this.costumerPassport = costumerPassport;
        this.phoneNumber = phoneNumber;
        this.BookedSeatNumber = bookedSeat;
    }

    public Customer(String costumerName, String costumerDateOfBirth, String costumerPassport, String gender) {

        this.costumerName = costumerName;
        this.costumerDateOfBirth = costumerDateOfBirth;
        this.gender = gender;
        this.costumerPassport = costumerPassport;
        this.phoneNumber = null;

    }

    public Customer(String costumerName, String costumerDateOfBirth, String costumerPassport) {

        this.costumerName = costumerName;
        this.costumerDateOfBirth = costumerDateOfBirth;
        this.gender = null;
        this.costumerPassport = costumerPassport;
        this.phoneNumber = null;

    }

    public Customer(String costumerName, String costumerPassport) {

        this.costumerName = costumerName;
        this.costumerDateOfBirth = null;
        this.gender = null;
        this.costumerPassport = costumerPassport;
        this.phoneNumber = null;

    }

    public Customer(String costumerName) {

        this.costumerName = costumerName;
        this.costumerDateOfBirth = null;
        this.gender = null;
        this.costumerPassport = null;
        this.phoneNumber = null;

    }

    public void setBookedSeatNumber(String bookedSeatNumber) {
        BookedSeatNumber = bookedSeatNumber;
    }

    public void setCostumerDateOfBirth(String costumerDateOfBirth) {
        this.costumerDateOfBirth = costumerDateOfBirth;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public void setCostumerPassport(String costumerPassport) {
        this.costumerPassport = costumerPassport;
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
        return costumerDateOfBirth;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public String getCostumerPassport() {
        return costumerPassport;
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
        // TODO Auto-generated method stub
        return " " + costumerName + ", your flight is booked with the passport number " + costumerPassport
                + " with the seat  Number " + BookedSeatNumber;
    }

    public void display() {

        System.out.println("Thank you so much " + this.costumerName + " for booking. \n This is your seat number"
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
            return (costumerName.equals(otherCustomer.costumerName)
                    &&costumerDateOfBirth.equals(otherCustomer.costumerDateOfBirth)
                    &&costumerPassport.equals(otherCustomer.costumerPassport)
                    &&BookedSeatNumber.equals(otherCustomer.BookedSeatNumber)
                    &&gender.equals(otherCustomer.gender));
        }
        
    }

}
