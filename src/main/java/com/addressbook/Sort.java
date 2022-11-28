package com.addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sort {
    public static void sortPersonByCity(List<personDetails> person) {
        Collections.sort(person, personDetails.citySorting);
        List<personDetails> matches = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter city to search: ");
        String search = sc.next();
        int flag = 0;
        for (personDetails p : person) {
            if (p.getCity().equalsIgnoreCase(search)) {
                flag = 1;
                matches.add(p);
            }
        }
        if (flag == 1) {
            for (personDetails p : person)
                System.out.println(p);
        } else {
            System.out.println("Match not found");
        }
    }

    public static void sortPersonByState(List<personDetails> person) {
        Collections.sort(person, personDetails.stateSorting);
        List<personDetails> matches = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter state to search: ");
        String search = sc.next();
        int flag = 0;
        for (personDetails p : person) {
            if (p.getState().equalsIgnoreCase(search)) {
                flag = 1;
                matches.add(p);
            }
        }
        if (flag == 1) {
            for (personDetails p : person)
                System.out.println(p);
        } else {
            System.out.println("Match not found");
        }
    }

    public static void sortByPersonName(List<personDetails> person)
    {
        Collections.sort(person, personDetails.firstNameSorting);
        for(personDetails p: person)
        {
            System.out.println(p);
        }
    }

    public static void sortByZip(List<personDetails> person)
    {
        Collections.sort(person, personDetails.zipSorting);
        for(personDetails p: person)
        {
            System.out.println(p);
        }
    }
}
