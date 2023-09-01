import java.util.Scanner;

public class Atm {

    Atm() {
        System.out.println("Enter Pin");
    }

    Scanner sc = new Scanner(System.in);

    int balance = 00;

    int pin = 1234;

    void checkPin() {

        int userPin = sc.nextInt();
        if (userPin == pin) {
            menu();
            // go to menu

        } else {
            System.out.println("Invalid Pin.");
        }

    }

    public void menu() {

        System.out.println("Enter choice.");
        System.out.println("Enter 1. for Account Balance");
        System.out.println("Enter 2. to Withdraw Money");
        System.out.println("Enter 3. to Deposit Money");
        System.out.println("Enter 4. to Exit");

        int key = sc.nextInt();

        switch (key) {
            case 1:
                accBalance();

                break;
            case 2:
                withdrawMoney();

                break;
            case 3:
                depositMoney();

                break;
            case 4:
                System.out.println("Exit");

                break;

            default:
                System.out.println("Enter valid number.");
                System.exit(0);

                break;
        }
    }

    public void accBalance() {
        System.out.println("Balance : " + balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter the amount to withdraw");
        int withdrawMoney = sc.nextInt();
        if (balance < withdrawMoney) {
            System.out.println("Enter valid amount.");
        } else {
            balance = balance - withdrawMoney;
            System.out.println("Amount left : " + balance);

        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the amount to deposit");
        int DepMoney = sc.nextInt();
        balance = balance + DepMoney;
        System.out.println("Amount : " + balance);
        menu();
    }

    public static void main(String[] args) {
        Atm user1 = new Atm();
        user1.checkPin();

    }
}