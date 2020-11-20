package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Classes
        com.company.UserAccount ua = new com.company.UserAccount();
        Scanner kbInput = new Scanner(System.in);

        //Variables
        String userInput;
        String username;
        String password;
        boolean isDone = false;

        while(!isDone){
            System.out.println("Select 1 to create a new account, 2 for returning users, 3 to exit");
            userInput = kbInput.nextLine();
            if(userInput.equalsIgnoreCase("1")){
                System.out.println("Thank you for choosing us today" + "\n");
                System.out.println("Please enter an username that is not taken");
                username = kbInput.nextLine();
                System.out.println("\n" + "Please enter a password that is not taken");
                password = kbInput.nextLine();
                ua.getUsers(username, password);
                ua.setUserAccount();
                if(ua.checkDuplicateUserAccount()){
                    ua.deleteDuplicates();
                    System.out.println("Sorry that username or password was taken. Try again.");
                }else{
                    System.out.println("Select 1 to deposit, 2 to withdraw, 3 to check balance, 4 to exit");
                    userInput = kbInput.nextLine();
                    if(userInput.equalsIgnoreCase("1")){

                        //System.out.println("deposit method goes here");
                        ua.depositMethod();

                    }else if(userInput.equalsIgnoreCase("2")){

                        //System.out.println("withdraw method goes here");
                        ua.withdrawMethod();

                    }else if(userInput.equalsIgnoreCase("3")){
                        //ua.eee();
                        ua.checkBalance();
                    }
                }
            }else if(userInput.equalsIgnoreCase("2")){
                System.out.println("Please enter your username");
                username = kbInput.nextLine();
                System.out.println("\n" + "Please enter your password");
                password = kbInput.nextLine();
                ua.getUsers(username, password);
                if(ua.checkUserAccount()){
                    System.out.println("\n" + "Welcome " + username.substring(0,1).toUpperCase() + username.substring(1));
                    //Structure this block of code similar above in the new account block of code
                    while (!isDone){
                        System.out.println("Select 1 to deposit, 2 to withdraw, 3 to check balance, 4 to exit");
                        userInput = kbInput.nextLine();
                        if(userInput.equalsIgnoreCase("1")){

                            //System.out.println("deposit method goes here");
                            ua.depositMethod();

                        }else if(userInput.equalsIgnoreCase("2")){

                            //System.out.println("withdraw method goes here");
                            ua.withdrawMethod();

                        }else if(userInput.equalsIgnoreCase("3")){
                            //ua.eee();
                            ua.checkBalance();
                        }else {
                            System.out.println("Thank you for banking with us today.");
                            isDone = true;
                        }
                    }

                }else{
                    System.out.println("One of the information above was entered incorrectly. Please try again");
                }
            }else {
                System.out.println("Thank you for banking with us today.");
                isDone = true;
            }
        }
    }
}

