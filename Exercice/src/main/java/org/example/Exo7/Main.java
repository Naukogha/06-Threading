package org.example.Exo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            int count = counter.incrementAndGet();
            System.out.println("Message périodique " + count);

            if (count >= 5) {
                System.out.println("Toutes les tâches ont été exécutées. Arrêt du programme.");
                scheduler.shutdown();
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
