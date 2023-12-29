package com.mycompany.project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String name;
    private double price;
    private String author;

    public Book() {
    }

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    static ArrayList<Book> booksList = new ArrayList();

    public static void displayAllBook(){
        ArrayList<Book> listBook=  Book.booksList;
        if(listBook.isEmpty()){
            System.out.println("Sorry! There is no data...");
        }else{
            System.out.println("BookName          "+"BookAuthor          "+"BookPrice");
            for(Book book:listBook){
                System.out.println(book.getName()+"          "
                        +book.getAuthor()+"          "
                        +book.getPrice());
            }}
    }

    public static void addBook(Scanner scanner){
        System.out.println("How many books do you want to enter? ");
        int countBook=scanner.nextInt();
        if(countBook<0){
            System.out.println("Not valid! Number of Books must be > 0");
        }else{
            for(int i=0;i<countBook;i++){
                System.out.println("Enter Book #"+(i+1)+" Name: ");
                String bookName=scanner.next();
                System.out.println("Enter Book #"+(i+1)+" Author: ");
                String bookAuthor=scanner.next();
                System.out.println("Enter Book #"+(i+1)+" Price: ");
                double bookPrice=scanner.nextDouble();
                Book book = new Book();
                book.setName(bookName);
                book.setAuthor(bookAuthor);
                book.setPrice(bookPrice);
                Book.booksList.add(book);
                System.out.println("The Book #"+(i+1)+" has been added successfully!");
                System.out.println();
            }
        }
    }

    public static Book getBookByName(String name){
        for(Book book:booksList){
            if(book.name.equalsIgnoreCase(name)){
                return book;
            }
        }
        return null;
    }

    public static boolean updateBook(Book newBook,Book oldBook){
        if(booksList.size()>0){
            int index=-1;
            for (int i=0;i<booksList.size();i++){
                if(booksList.get(i).getName().equalsIgnoreCase(oldBook.getName())){
                    index=i;
                    break;
                }
            }
            if(index !=-1){
                booksList.get(index).setName(newBook.getName());
                booksList.get(index).setAuthor(newBook.getAuthor());
                booksList.get(index).setPrice(newBook.getPrice());
                return true;
            }
        }
        return false;
    }

    public static void updateBook(Scanner scanner){
        boolean condition=true;
        while(condition){
            System.out.println("----Update Menu----");
            System.out.println("1.Update Book Name");
            System.out.println("2.Update Book Author");
            System.out.println("3.Update Book Price");
            System.out.println("4.Back to Main Menu");
            System.out.println("5.Exit Program");
            System.out.println();
            System.out.println("Enter Your Choice: ");
            int choiceNumberUpdate=scanner.nextInt();
            switch (choiceNumberUpdate){
                case 1:
                    System.out.println("Enter the Book Name: ");
                    String bookName=scanner.next();
                    Book oldBook=Book.getBookByName(bookName);
                    Book newBook=Book.getBookByName(bookName);
                    if(oldBook == null){
                        System.out.println("Your Book name not found!");
                    }else{
                        System.out.println("Enter new name: ");
                        String bookNameUp=scanner.next();
                        newBook.setName(bookNameUp);
                        if (Book.updateBook(newBook,oldBook)) {
                            System.out.println("Updated successfully!");
                        }else{
                            System.out.println("Update failed!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the Book Name: ");
                    String bookAuthor=scanner.next();
                    Book oldAuthor=Book.getBookByName(bookAuthor);
                    Book newAuthor=Book.getBookByName(bookAuthor);
                    if(oldAuthor == null){
                        System.out.println("Your Book Name not found!");
                    }else{
                        System.out.println("Enter new Author: ");
                        String bookAuthorUp=scanner.next();
                        newAuthor.setAuthor(bookAuthorUp);
                        if (Book.updateBook(newAuthor,oldAuthor)) {
                            System.out.println("Updated successfully!");
                        }else{
                            System.out.println("Update failed!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the Book Name: ");
                    String bookPrice=scanner.next();
                    Book oldPrice=Book.getBookByName(bookPrice);
                    Book newPrice=Book.getBookByName(bookPrice);
                    if(oldPrice == null){
                        System.out.println("Your Book Name not found!");
                    }else{
                        System.out.println("Enter new Price: ");
                        int bookPriceUp=scanner.nextInt();
                        newPrice.setPrice(bookPriceUp);
                        if (Book.updateBook(newPrice,oldPrice)) {
                            System.out.println("Updated successfully!");
                        }else{
                            System.out.println("Update failed!");
                        }
                    }
                    break;
                case 4:
                    condition=false;
                    break;
                case 5:
                    System.exit(0);
                    break;
            }}
    }

    public static boolean deleteBook(Book book){
        if(!booksList.isEmpty()){
            booksList.remove(book);
            return true;
        }
        return false;
    }

    public static void deleteBook(Scanner scanner){
        System.out.println("Enter the Book Name: ");
        String bookName=scanner.next();
        Book book=Book.getBookByName(bookName);
        if(book == null){
            System.out.println("Your Book not found!");
        }else{
            if (Book.deleteBook(book)) {
                System.out.println("Deleted successfully!");
            }else{
                System.out.println("Deletion failed!");
            }
        }
    }


}
