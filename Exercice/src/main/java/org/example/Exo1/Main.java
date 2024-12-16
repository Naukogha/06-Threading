package org.example.Exo1;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        //Creation de plusieurs threads
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MonPremierThread("Thread-"+i+1));
            thread.start();
        }
        System.out.println("Tous les threads sont démarées");
    }
}
