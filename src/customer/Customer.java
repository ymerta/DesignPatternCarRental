package customer;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private String licenseNumber;
    private String address;

    // Constructor to initialize customer details
    public Customer(String name, String email, String phoneNumber, String licenseNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.address = address;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    public void updatePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }

    // String representation of the customer
    @Override
    public String toString() {
        return name + " (" + email + ") - Phone: " + phoneNumber + " - License: " + licenseNumber;
    }
}