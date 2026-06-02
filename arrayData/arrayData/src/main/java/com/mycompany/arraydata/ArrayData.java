
package com.mycompany.arraydata;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayData {

    public static void mainMenu(){ 
        System.out.println("::: MENU :::\n"
                + "[1]. Register users \n"
                + "[2]. List users \n"
                + "[3]. Search user \n"
                + "[4]. Update user \n"
                + "[5]. Delete user \n"
                + "[6]. Exit \n"
                + ".::: Press an option: ");
    }
    
    public static void main(String[] args) {
        Scanner data=new Scanner(System.in);
   
        ArrayList<String> identNumbers = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        String firstname, lastname, email, key, ident_number;
        int age, opt;
        boolean menu_status = true;
        
        int i=1;
        while(menu_status){
            mainMenu();
            opt=data.nextInt();
            data.nextLine();
            
            switch (opt){
                case 1:
                    System.out.println("::: REGISTER NEW USER :::");
                    System.out.println("\nUser Nro.: " + (firstNames.size()+1));   
            
                    System.out.println("Identification number: ");   
                    ident_number=data.nextLine();
                    System.out.println("First name: ");   
                    firstname=data.nextLine();
                    System.out.println("Last name: ");   
                    lastname=data.nextLine();
                    System.out.println("Email: ");   
                    email=data.nextLine();
                    System.out.println("Age: ");   
                    age=data.nextInt();
                    data.nextLine();

                    identNumbers.add(ident_number);
                    firstNames.add(firstname);
                    lastNames.add(lastname);
                    emails.add(email);
                    ages.add(age);
                    System.out.println("\nUser has been registered successfully !!!");
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 2:
                    
                    System.out.println("Total users: " + firstNames.size());
                    if (firstNames.size() == 0){
                        System.out.println("No users !!!");
                    }else{
                        for(int  j = 0; j < firstNames.size(); j+=1){
                            System.out.println("User " + (j+1) + ": " 
                                    + identNumbers.get(j) + " | " 
                                    + firstNames.get(j) + " | " 
                                    + lastNames.get(j) + " | " 
                                    + emails.get(j) + " | " 
                                    + ages.get(j));
                        }
                    }
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 3:
                    System.out.println("::: SEARCH USER :::");
                    System.out.println("Enter identification number to search: ");
                    key = data.nextLine();

                    int found = -1;
                    for (int j = 0; j < identNumbers.size(); j++) {
                        if (identNumbers.get(j).equals(key)) {
                            found = j;
                            break;
                        }
                    }

                    if (found == -1) {
                        System.out.println("User not found.");
                    } else {
                        System.out.println("User found:");
                        System.out.println("ID: "        + identNumbers.get(found));
                        System.out.println("First name: " + firstNames.get(found));
                        System.out.println("Last name: "  + lastNames.get(found));
                        System.out.println("Email: "      + emails.get(found));
                        System.out.println("Age: "        + ages.get(found));
                    }

                    System.out.println("\nPress any key to back to main menu.");
                    key = data.nextLine();
                    break;
                case 4:
                    System.out.println("::: UPDATE USER :::");
                    System.out.println("Enter identification number to update: ");
                    key = data.nextLine();

                    found = -1;
                    for (int j = 0; j < identNumbers.size(); j++) {
                        if (identNumbers.get(j).equals(key)) {
                            found = j;
                            break;
                        }
                    }

                    if (found == -1) {
                        System.out.println("User not found.");
                    } else {
                        System.out.println("Leave field empty to keep current value.");

                        System.out.println("New identification number [" + identNumbers.get(found) + "]: ");
                        String newIdent = data.nextLine();
                        if (!newIdent.isEmpty()) identNumbers.set(found, newIdent);

                        System.out.println("New first name [" + firstNames.get(found) + "]: ");
                        String newfirstname = data.nextLine();
                        if (!newfirstname.isEmpty()) firstNames.set(found, newfirstname);

                        System.out.println("New last name [" + lastNames.get(found) + "]: ");
                        String newLastname = data.nextLine();
                        if (!newLastname.isEmpty()) lastNames.set(found, newLastname);

                        System.out.println("New email [" + emails.get(found) + "]: ");
                        String newEmail = data.nextLine();
                        if (!newEmail.isEmpty()) emails.set(found, newEmail);

                        System.out.println("New age [" + ages.get(found) + "] (0 to keep): ");
                        int newAge = data.nextInt();
                        data.nextLine();
                        if (newAge != 0) ages.set(found, newAge);

                        System.out.println("User updated successfully!");
                    }

                    System.out.println("\nPress any key to back to main menu.");
                    key = data.nextLine();
                    break;
                case 5:
                    System.out.println("::: DELETE USER :::");
                    System.out.println("Enter identification number to delete: ");
                    key = data.nextLine();

                    found = -1;
                    for (int j = 0; j < identNumbers.size(); j++) {
                        if (identNumbers.get(j).equals(key)) {
                            found = j;
                            break;
                        }
                    }

                    if (found == -1) {
                        System.out.println("User not found.");
                    } else {
                        System.out.println("Deleting user: "+ firstNames.get(found) + " "+ lastNames.get(found));
                        identNumbers.remove(found);
                        firstNames.remove(found);
                        lastNames.remove(found);
                        emails.remove(found);
                        ages.remove(found);
                        System.out.println("User deleted successfully!");
                    }

                    System.out.println("\nPress any key to back to main menu.");
                    key = data.nextLine();
                    break;
                case 6:
                    System.out.println("Bye, bye");
                    menu_status = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
