package org.example.Exo14;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        fusionFile();
    }

    private static void fusionFile(){
        CyclicBarrier barrier = new CyclicBarrier(3,() -> {
            System.out.println("Fusion des données terminée. Tous les threads peuvent continuer.");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " commence à charger les données.");
                Thread.sleep((long) (Math.random() * 1000)); // Simule le temps de chargement
                System.out.println(Thread.currentThread().getName() + " a terminé le chargement des données.");
                barrier.await(); // Attendre que tous les threads atteignent ce point
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task,("Thread"+(i+1))).start();
        }
    }
}
