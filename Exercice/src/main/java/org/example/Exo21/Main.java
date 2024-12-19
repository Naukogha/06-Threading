package org.example.Exo21;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int threadCount = 1000;

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < threadCount; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(200);
                        System.out.println("Connexion Accepté");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } // Fermeture de l'executeur


    }
}
