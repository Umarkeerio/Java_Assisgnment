// Simple Bank Account:
// Create a BankAccount class with attributes like account number, balance, and account holder name.
// Implement methods for depositing and withdrawing money, checking the balance, 
// and displaying account details.
// Create multiple BankAccount objects and perform banking operations.

import java.util.Scanner;

class BankAccount {
    int account_number , balance;
    String name;
    BankAccount(int account_number , int balance , String name){
        this.name = name;
        this.balance = balance;
        this.account_number = account_number;
    } 
    static Scanner sc = new Scanner(System.in);
    void depositing (){
        System.out.print("Enter the deposit amount : ");
        int amount = sc.nextInt();
        this.balance += amount;
        System.out.println("amount added");
    }
    void withdrawing(){
        System.out.print("Enter the amount to withdraw : ");
        int amount = sc.nextInt();
        if (amount > this.balance){
            System.out.println("not enough money in the account");
        }
        else if ( amount < this.balance){
            System.out.println(amount + " is comin ");
            this.balance -= amount;
        }
        else 
        return;
    }
    void balance(){
        System.out.println("balance : " + this.balance );
    }
    void details(){
        System.out.println("name : " + this.name);
        System.out.println("balance : " + this.balance );
        System.out.println("password : " + this.account_number);

    }
}
public class Bank {
    static BankAccount currentuser ;
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1, 1000, "rauf");
        BankAccount b2 = new BankAccount(2,10000, "Ahsan");
        BankAccount b3 = new BankAccount(3, 100000, "M : Umar ");
        System.out.println("\t\t Banking system  ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the num of ya bankaccount or q to quit :");
        int b =  sc.nextInt();
        if (b == 1 ){
            currentuser = b1;
        }
        else if ( b == 2){
            currentuser = b2;
        }
        else if ( b == 3){
            currentuser = b3;
        }
        else if ( b != 1 | b != 2 | b != 3 ){ 
            System.out.println("invalid input pls try again ");
        }
        while (true) {
        System.out.println("wha ya wanna do ? \n 1: add money  \n 2: withdraw  \n 3: check balance \n 4: details  \n 5: quit ");
        int ans = sc.nextInt();
        if ( ans == 1){
            currentuser.depositing();
        }
        else if ( ans == 2){
            currentuser.withdrawing();
        }
        else if ( ans == 3 ){
            currentuser.balance();
        }      
        else if (ans == 4){
            currentuser.details();
        }
        else {
            break;
        }
    }       
        
    }
}