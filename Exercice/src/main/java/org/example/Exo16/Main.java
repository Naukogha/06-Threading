package org.example.Exo16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;

public class Main {
    List<Integer> array = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7));
    static AtomicInteger couter = new AtomicInteger(0);
    static int sum;

    public static void main(String[] args) {

    }

    public static void sumList() {
        CyclicBarrier barrier = new CyclicBarrier(4);


        Runnable task = () -> {
            try {

                System.out.println(Thread.currentThread().getName() + " a calculé une somme partielle de (indice : " + couter.get() + " à indice 3");
                barrier.await();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task,("Thread"+(i+1))).start();
        }
    }


}
