package org.example.Exo15;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        etapeBoucle();
    }

    private static void etapeBoucle(){
        CyclicBarrier barrier = new CyclicBarrier(3);


        Runnable task = () -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " atteint l'étape "+(i+1));
                    barrier.await();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task,("Thread"+(i+1))).start();
        }
    }
}
