package org.example.Exo6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            scheduler.schedule(() -> System.out.println("Task executee aprés " +(finalI +1)+ " secondes"),(finalI +1), TimeUnit.SECONDS);
                               //  schedule(Runnable task, long delay, TimeUnit unit)
        }
        scheduler.schedule(() -> {
            System.out.println("Toutes les tâches ont été exécutées. Arrêt du programme.");
            scheduler.shutdown();
        }, 4, TimeUnit.SECONDS); // Prévoir une marge après la dernière tâche pour arrêter

    }
}
