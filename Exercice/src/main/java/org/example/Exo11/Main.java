package org.example.Exo11;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread thread1 = new Thread(()->account.deposit(10));
        Thread thread2 = new Thread(()->account.withdraw(10));
        Thread thread3 = new Thread(()->account.deposit(10));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }


}
