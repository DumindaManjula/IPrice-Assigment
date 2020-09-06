package com.iprice;

import com.iprice.service.DataExport;
import com.iprice.service.DataGenerate;
import com.iprice.service.impl.DataExportImpl;
import com.iprice.service.impl.DataGenerateImpl;


import java.util.Scanner;

public class IPriceApplication {

    public static void main(String[] args) {

        char choice;
        //This do while perform action as long as user select exit option
        do {
            System.out.println("Please entered value text value \n ");
            Scanner firstIn = new Scanner(System.in);
            String s1 = firstIn.nextLine();
            System.out.println("You entered value :" + s1);

            while (!iterator(s1)) {
                iterator(s1);
            }
            System.out.println("Enter Y for continue or any character to exit \n  ");

            Scanner thirdIn = new Scanner(System.in);
            choice = thirdIn.next().charAt(0);

        } while ((choice == 'y') || (choice == 'Y'));

        System.out.println("Thank you for choosing iPrice app.....!!!!");
    }

    /**
     * Method to show available activities to users and call the chosen method
     *
     * @param s1- This is user input text
     */
    public static boolean iterator(String s1) {

        char choice;
        System.out.println("You have three options.Please select one from below \n");
        System.out.println("A. Convert to uppercase");
        System.out.println("B. Convert to alternate upper and lower case");
        System.out.println("C. Generate CSV created file \n");

        try{
            Scanner secondIn = new Scanner(System.in);
            choice = secondIn.next().charAt(0);

            // Redirect to specific method chosen by user among available options.
            if ((choice == 'A') || (choice == 'a')) {
                DataGenerate dataGenerate = new DataGenerateImpl();
                System.out.println("Your output: " + dataGenerate.convertToUpperCase(s1));
            } else if ((choice == 'b') || (choice == 'B')) {
                DataGenerate dataGenerate = new DataGenerateImpl();
                System.out.println("Your output: " + dataGenerate.convertToAlternateCase(s1));
            } else if ((choice == 'C') || (choice == 'c')) {
                DataExport dataExport = new DataExportImpl();
                dataExport.generateCsvFile(s1);
            } else {
                System.out.println("You have selected incorrect choice");
                return false;
            }
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
