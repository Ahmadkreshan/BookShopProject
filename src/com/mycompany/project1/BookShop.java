package com.mycompany.project1;

import java.util.Scanner;

public class BookShop {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choiceNumber;

        while(true){
            System.out.println("----Main Menu----");
            System.out.println("1.Display All Book");
            System.out.println("2.Add Book");
            System.out.println("3.Update Book");
            System.out.println("4.Delete Book");
            System.out.println("5.Exit Program");
            System.out.println();
            System.out.println("Enter Your Choice: ");
            try {
                choiceNumber=scanner.nextInt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            switch (choiceNumber){
                case 1:
                    Book.displayAllBook();
                    break;
                case 2:
                    Book.addBook(scanner);
                    break;
                case 3:
                    Book.updateBook(scanner);
                    break;
                case 4:
                    Book.deleteBook(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }


    }
}
