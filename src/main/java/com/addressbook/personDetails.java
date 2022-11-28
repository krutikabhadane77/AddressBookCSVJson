package com.addressbook;

import java.util.Comparator;

public class personDetails {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phoneNumber ;

    public personDetails(String firstName, String lastName, String address, String city, String state, String zip,String email, String phoneNumber) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "personDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static Comparator<personDetails> citySorting = (p1,p2)-> {
        String city1 = p1.getCity();
        String city2 = p2.getCity();

        return city1.compareToIgnoreCase(city2);
    };

    public static Comparator<personDetails> stateSorting = (p1,p2)-> {
        String state1 = p1.getState();
        String state2 = p2.getState();

        return state1.compareToIgnoreCase(state2);
    };

    public static Comparator<personDetails> firstNameSorting = (p1,p2)-> {
        String fname1 = p1.getFirstName();
        String fname2 = p2.getFirstName();

        return fname1.compareToIgnoreCase(fname2);
    };

    public static Comparator<personDetails> zipSorting = (p1,p2)-> {
        String zip1 = p1.getZip();
        String zip2 = p2.getZip();

        return zip1.compareToIgnoreCase(zip2);
    };
}
