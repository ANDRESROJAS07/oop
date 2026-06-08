package org.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;
import java.time.LocalDate;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void mainMenu(){
        System.out.println("""
                               \n::: MAIN MENU :::
                               [1]. USERS
                               [2]. CITIES
                               [3]. BRANDS 
                               [4]. VEHICLES 
                               [5]. EXIT 
                           ::: Press an option: """);
    }

    public static void usersMainMenu(){
        System.out.println("""
                               \n::: USERS MENU :::
                               [1]. Register users 
                               [2]. List users 
                               [3]. Search user 
                               [4]. Update user 
                               [5]. Delete user 
                               [6]. Back to main menu
                               .::: Press an option: """);
    }

    public static void citiesMainMenu(){
        System.out.println("""
                               \n::: CITIES MENU :::
                               [1]. Register cities 
                               [2]. List cities 
                               [3]. Search cities 
                               [4]. Update cities 
                               [5]. Delete cities 
                               [6]. Back to main menu
                               .::: Press an option: """);
    }

    public static void brandsMainMenu(){
        System.out.println("""
                               \n::: BRANDS MENU :::
                               [1]. Register brands 
                               [2]. List brands 
                               [3]. Search brands 
                               [4]. Update brands 
                               [5]. Delete brands 
                               [6]. Back to main menu
                               .::: Press an option: """);
    }

    public static void vehiclesMainMenu(){
        System.out.println("""
                               \n::: VEHICLES MENU :::
                               [1]. Register vehicles 
                               [2]. List vehicles 
                               [3]. Search vehicles 
                               [4]. Update vehicles 
                               [5]. Delete vehicles 
                               [6]. Back to main menu
                               .::: Press an option: """);
    }
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        ArrayList<Brands> brands = new ArrayList<>();

        int opt;
        //int brand_city_id, brandId;
        //String brand_name, brand_code, brand_abbrev, brand_descripstion;
        //LocalDate brand_create_at, brand_update_at;
        boolean menu_status = true, user_menu_status = true, brands_menu_status = true, brand_status = true;

        while(menu_status){
            mainMenu();
            opt=data.nextInt();
            data.nextLine();

            switch (opt){
                case 1:
                    while (user_menu_status){
                        usersMainMenu();
                        opt=data.nextInt();
                        data.nextLine();
                        switch (opt){
                            case 1:
                                System.out.println("::: REGISTER NEW USER :::");

                                break;

                            case 2:
                                break;

                            case 3:
                                break;

                            case 4:
                                break;

                            case 5:
                                break;

                            case 6:
                                user_menu_status = false;
                                break;

                            default:  System.out.println("Invalid option. Try again.");

                        user_menu_status = true;
                        }
                    }
                    break;

                case 2:
                    citiesMainMenu();
                    break;

                case 3:
                    brands_menu_status= true;
                    while (brands_menu_status){
                        brandsMainMenu();
                        opt=data.nextInt();
                        data.nextLine();
                        switch (opt){
                            case 1:
                                Brands.registerBrand(data);
                                break;
                            case 2:
                                Brands.listBrands();
                                break;

                            case 3:
                                Brands.searchBrand(data);
                                break;

                            case 4:
                                Brands.updateBrand(data);
                                break;

                            case 5:
                                Brands.deleteBrand(data);
                                break;

                            case 6:
                                brands_menu_status = false;
                                break;

                            default:  System.out.println("Invalid option. Try again.");
                        }

                    }
                    break;

                case 4:
                    vehiclesMainMenu();
                    break;

                case 6:
                    System.out.println("\nHAVE A GREAT DAY!");
                    menu_status = false;

                default: System.out.println("Invalid option. Try again.");

            }
        }
    }
}