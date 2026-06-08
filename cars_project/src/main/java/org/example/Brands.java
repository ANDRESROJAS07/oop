package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Brands {

    private int BrandId;
    private String BrandCode;
    private String BrandName;
    private String BrandAbbrev;
    private int BrandCityId;
    private String BrandDescription;
    private boolean BrandStatus;
    private LocalDate BrandCreateAt;
    private LocalDate BrandUpdateAt;



    private static ArrayList<Brands> brandsList = new ArrayList<>();
    private static int nextId = 1;

    public Brands(){};

    public Brands(int brandId, String brandName, String brandCode, String brandAbbrev, int brandCityId, String brandDescription, boolean brandStatus ,
                  LocalDate brandCreateAt, LocalDate brandUpdateAt) {
        this.BrandId = brandId;
        this.BrandCode = brandCode;
        this.BrandName = brandName;
        this.BrandAbbrev = brandAbbrev;
        this.BrandCityId = brandCityId;
        this.BrandDescription = brandDescription;
        this.BrandStatus = brandStatus;
        this.BrandCreateAt = brandCreateAt;
        this.BrandUpdateAt = brandUpdateAt;
    }

    //Getters and Setters

    public int getBrandId() {
        return BrandId;
    }
    public void setBrandId(int brandId){
        this.BrandId = brandId;
    }
    public String getBrandCode() {
        return BrandCode;
    }
    public void setBrandCode(String brandCode){
        this.BrandCode = brandCode;
    }
    public String getBrandName() {
        return BrandName;
    }
    public void setBrandName(String brandName){
        this.BrandName = brandName;
    }
    public String getBrandAbbrev() {
        return BrandAbbrev;
    }
    public void setBrandAbbrev(String brandAbbrev){
        this.BrandAbbrev = brandAbbrev;
    }
    public int getBrandCityId() {
        return BrandCityId;
    }
    public void setBrandCityId(int brandCityId){
        this.BrandCityId = brandCityId;
    }
    public String getBrandDescription() {
        return BrandDescription;
    }
    public void setBrandDescription(String brandDescription){
        this.BrandDescription = brandDescription;
    }
    public boolean getBrandStatus() {
        return BrandStatus;
    }
    public void setBrandStatus(boolean brandStatus){
        this.BrandStatus = brandStatus;
    }
    public LocalDate getBrandCreateAt() {
        return BrandCreateAt;
    }
    public void setBrandCreateAt(LocalDate brandCreateAt){
        this.BrandCreateAt = brandCreateAt;
    }
    public LocalDate getBrandUpdateAt() {
        return BrandUpdateAt;
    }
    public void setBrandUpdateAt(LocalDate brandUpdateAt){
        this.BrandUpdateAt = brandUpdateAt;
    }
    public static void registerBrand(Scanner data) {
        System.out.println("\n::: REGISTER NEW BRAND :::");
        System.out.print("  Code        : "); String brand_code   = data.nextLine().trim();

        boolean codeExists = brandsList.stream().anyMatch(brand -> brand.getBrandCode().equalsIgnoreCase(brand_code));
        String finalCode = brand_code;
        while (codeExists) {
            System.out.println("  [✗] Code already exists. Please enter a unique code.");
            System.out.print("  Code        : ");
            finalCode = data.nextLine().trim();

            String temp = finalCode;
            codeExists = brandsList.stream().anyMatch(brand -> brand.getBrandCode().equalsIgnoreCase(temp));
        }

        System.out.print("  Name        : "); String brand_name   = data.nextLine().trim();
        System.out.print("  Abbreviation: "); String brand_abbrev = data.nextLine().trim();
        System.out.print("  City ID     : "); int brand_city_id    = Integer.parseInt(data.nextLine().trim());
        System.out.print("  Description : "); String brand_description   = data.nextLine().trim();

        brandsList.add(new Brands(nextId++, brand_name, brand_code, brand_abbrev, brand_city_id, brand_description,
                true, LocalDate.now(), LocalDate.now()));
        System.out.println("  [✓] Brand registered with ID: " + (nextId - 1));
    }
    public static void listBrands() {
            System.out.println("\n::: BRANDS LIST :::");
            if (brandsList.isEmpty()) { System.out.println("  Without Registers."); return; }
            for (Brands b : brandsList) {
                System.out.printf("  [%d] Code: %s | Name: %s | Abbrev: %s | City Id: %d | Description: %s | Status: %s%n",
                        b.getBrandId(),b.getBrandCode(), b.getBrandName(), b.getBrandAbbrev(),
                        b.getBrandCityId(), b.getBrandDescription(),
                        b.getBrandStatus() ? "Active" : "Inactive");
            }

    }
    public static void searchBrand(Scanner data) {
        System.out.println("\n::: SEARCH BRAND :::");
        System.out.print(" Code: "); String q = data.nextLine().trim();
        for (Brands b : brandsList) {
            if (b.getBrandCode().equalsIgnoreCase(q)) {
                System.out.printf("  [%d] Code: %s | Name: %s | Abbrev: %s | City Id: %d | Description: %s | Status: %s%n",
                        b.getBrandId(),b.getBrandCode(), b.getBrandName(), b.getBrandAbbrev(),
                        b.getBrandCityId(), b.getBrandDescription(),
                        b.getBrandStatus() ? "Active" : "Inactive");
                return;
            }
        }
        System.out.println("  [!] Not Found: " + q);

    }
    public static boolean abbrevExists(String abbrev, int currentId) {
        for (Brands b : brandsList) {
            if (b.getBrandAbbrev().equalsIgnoreCase(abbrev)
                    && b.getBrandId() != currentId) {
                return true;
            }
        }
        return false;
    }
    public static void updateBrand(Scanner data) {
        System.out.println("\n::: UPDATE BRAND :::");

        Brands t = null;
        while (true) {
            System.out.print("  Search code: ");
            String query = data.nextLine().trim();
            for (Brands b : brandsList) {
                if (b.getBrandCode().equalsIgnoreCase(query)) {
                    t = b;
                    break;
                }
            }
            if (t != null) break;
            System.out.println("  [!] Code not found. Try again.");
        }

        System.out.println("  (Enter to keep current value)");

        System.out.print("  Name [" + t.getBrandName() + "]: ");
        String name = data.nextLine().trim();
        if (!name.isEmpty()) t.setBrandName(name);

        System.out.print("  Abbrev [" + t.getBrandAbbrev() + "]: ");
        String abbrev = data.nextLine().trim();
        if (!abbrev.isEmpty()) {
            if (abbrevExists(abbrev, t.getBrandId()))
                System.out.println("  [!] Abbrev duplicated, not uptated.");
            else
                t.setBrandAbbrev(abbrev);
        }

        System.out.print("  City ID [" + t.getBrandCityId() + "]: ");
        String city = data.nextLine().trim();
        if (!city.isEmpty()) t.setBrandCityId(Integer.parseInt(city));

        System.out.print("  Description [" + t.getBrandDescription() + "]: ");
        String desc = data.nextLine().trim();
        if (!desc.isEmpty()) t.setBrandDescription(desc);

        System.out.print("  Status true/false [" + t.getBrandStatus() + "]: ");
        String status = data.nextLine().trim();
        if (!status.isEmpty()) t.setBrandStatus(Boolean.parseBoolean(status));

        t.setBrandUpdateAt(LocalDate.now());
        System.out.println("  [✓] Brand '" + t.getBrandCode() + "' Update.");
    }
    public static void deleteBrand(Scanner data) {
        System.out.println("\n::: DELETE BRAND :::");
        Brands t = null;
        while (true) {
            System.out.print("  Code to Delete: ");
            String query = data.nextLine().trim();
            for (Brands b : brandsList) {
                if (b.getBrandCode().equalsIgnoreCase(query)) {
                    t = b;
                    break;
                }
            }
            if (t != null) break;
            System.out.println("  [!] Code not Found. Try again.");
        }

        System.out.println("  Brand to Delete: [" + t.getBrandId() + "] " + " | Code: " + t.getBrandCode()+ " | Name: " +  t.getBrandName());
        System.out.print("  Confirm Elimination:  (yes/no): ");

        if (data.nextLine().trim().equalsIgnoreCase("yes")) {
            brandsList.remove(t);
            System.out.println("  [✓] Brand '" + t.getBrandCode() + "' deleted.");
        } else {
            System.out.println(" Canceled ");
        }
    }


}