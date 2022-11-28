package com.addressbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public ArrayList<personDetails> contactList = new ArrayList<personDetails>();
    private static final String ADDRESSBOOK_CSV_FILE ="C:\\Terminalcommand\\linux-content\\AddressBookProblemCSVJson\\src\\addressbook.csv";
    private static final String ADDRESSBOOK_JSON_FILE ="C:\\Terminalcommand\\linux-content\\AddressBookProblemCSVJson\\src\\addressbook.json";
    public void writeData() {
        StringBuffer empBuffer = new StringBuffer();
        contactList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get("addressBook-file.txt"), empBuffer.toString().getBytes());

        } catch (IOException e) {

        }
    }

    public void readData() {
        try {
            Files.lines(new File("addressBook-file.txt").toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));

        } catch (IOException e) {

        }
    }

    public void writeDataToCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (Writer writer = Files.newBufferedWriter(Paths.get(ADDRESSBOOK_CSV_FILE));) {
            StatefulBeanToCsvBuilder<personDetails> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<personDetails> beanWriter = builder.build();
            beanWriter.write(contactList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataUsingCSV() throws IOException, CsvValidationException {
        try (Reader reader = Files.newBufferedReader(Paths.get(ADDRESSBOOK_CSV_FILE));
             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("First Name - " + nextRecord[3]);
                System.out.println("Last Name - " + nextRecord[4]);
                System.out.println("Address - " + nextRecord[0]);
                System.out.println("City - " + nextRecord[1]);
                System.out.println("State - " + nextRecord[6]);
                System.out.println("Email - " + nextRecord[2]);
                System.out.println("Phone - " + nextRecord[5]);
                System.out.println("Zip - " + nextRecord[7]);
            }
        }
    }

    public void writeDataInJSon() throws IOException {
        {
            Path filePath = Paths.get(ADDRESSBOOK_JSON_FILE);
            Gson gson = new Gson();
            String json = gson.toJson(contactList);
            FileWriter writer = new FileWriter(String.valueOf(filePath));
            writer.write(json);
            writer.close();
        }
    }

    public void readDataFromJson() throws IOException {
        ArrayList<personDetails> contactList = null;
        Path filePath = Paths.get(ADDRESSBOOK_JSON_FILE);
        try (Reader reader = Files.newBufferedReader(filePath);) {
            Gson gson = new Gson();
            contactList = new ArrayList<personDetails>(Arrays.asList(gson.fromJson(reader, personDetails[].class)));
            for (personDetails contact : contactList) {
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("Address : " + contact.getAddress());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip : " + contact.getZip());
                System.out.println("Phone number : " + contact.getPhoneNumber());
                System.out.println("Email : " + contact.getEmail());

            }
        }
    }

    public void addContact(){
        System.out.println("Enter the contact details.....");
        int i = 0;
        String firstName=null;
        while (i == 0){
            System.out.println("Enter the first name: ");
            firstName = sc.next();
            if (checkExists(firstName)){
                System.out.println("Name already exists..");
            }
            else {
                i = 1;
            }
        }



        System.out.println("Enter the last name: ");
        String lastName = sc.next();
        System.out.println("Enter the address: ");
        String address = sc.next();
        System.out.println("Enter the city: ");
        String city = sc.next();
        System.out.println("Enter the state: ");
        String state = sc.next();
        System.out.println("Enter the zip code: ");
        String zip = sc.next();
        System.out.println("Enter the email: ");
        String email = sc.next();
        System.out.println("Enter the phone no: ");
        String phoneNumber = sc.next();

        contactList.add(new personDetails(firstName,lastName,address,city,state,zip,email,phoneNumber));

    }

    public void displayRecord()
    {
        if (contactList.isEmpty())
        {
            System.out.println("No Records!!!");
        }
        else {
            for (personDetails contact : contactList) {
                System.out.println(contact);
            }
        }

    }

    public boolean editContact(String Name)
    {
        int flag = 0;
        for(personDetails contact: contactList)
        {
            if(contact.getFirstName().equals(Name))
            {
                System.out.println("Enter the detail which needs to be updated:");

                int ch = sc.nextInt();
                switch(ch)
                {
                    case 1:
                    {
                        System.out.println("Enter First Name: ");
                        String firstName = sc.next();
                        contact.setFirstName(firstName);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter last name: ");
                        String lastName = sc.next();
                        contact.setLastName(lastName);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter Address: ");
                        String address = sc.next();
                        contact.setAddress(address);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter City: ");
                        String city = sc.next();
                        contact.setCity(city);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter State: ");
                        String state =sc.next();
                        contact.setState(state);
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter Zip Code: ");
                        String zip = sc.next();
                        contact.setZip(zip);
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Enter Phone Number:");
                        String phoneNumber = sc.next();
                        contact.setPhoneNumber(phoneNumber);
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Enter Email: ");
                        String email = sc.next();
                        contact.setEmail(email);
                        break;
                    }

                }

                flag = 1;
                break;
            }
        }
        return flag == 1;
    }
    public boolean deleteContact(String name) {
        int flag = 0;
        for(personDetails contact: contactList)
        {
            if(contact.getFirstName().equals(name))
            {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    public boolean checkExists(String name)
    {
        int flag=0;
        for (personDetails contact: contactList)
        {
            if (contact.getFirstName().equals(name))
            {
                flag=1;
                break;
            }
        }
        if (flag==1)
        {
            return true;
        }
        return false;
    }

    public void sortPersonDetails() {
        int i = 0;
        while (i == 0) {
            System.out.println("Person details sort by :\n" + "1. City\n" + "2. State\n" + "3. Name\n" + "4. Zip");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Sort.sortPersonByCity(contactList);
                    break;
                case 2:
                    Sort.sortPersonByState(contactList);
                    break;
                case 3:
                    Sort.sortByPersonName(contactList);
                    break;
                case 4:
                    Sort.sortByZip(contactList);
                    break;
                case 5:
                    i=1;
                    break;
                default:
                    System.out.println("Enter valid option....");
            }
        }
    }
}

