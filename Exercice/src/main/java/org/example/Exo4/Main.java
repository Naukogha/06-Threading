package org.example.Exo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            service.submit(() -> System.out.println("Tâche " + taskId + " exécutée par " + Thread.currentThread().getName()));
        }
        service.shutdown();
    }
}
