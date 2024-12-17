package org.example.Exo10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    private static AtomicLong atomicLong = new AtomicLong(0);
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread[] atomicThreads = createAtomicThreads();
        for (Thread thread : atomicThreads) thread.start();
        for (Thread thread : atomicThreads) thread.join(); // Attendre la fin de tous les threads
        System.out.println("Valeur finale atomique : "+ atomicLong.get());
    }


    private static Thread[] createAtomicThreads(){
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                atomicLong.incrementAndGet();
                System.out.println(threads[finalI].getName()+" a incrémenté le compteur à " + atomicLong);

            });
        }
        return threads;
    }
}
