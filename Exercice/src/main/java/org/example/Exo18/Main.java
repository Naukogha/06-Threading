package org.example.Exo18;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        runTest(copyOnWriteList);

    }

    private static void runTest(List<String> list) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 9; i++) {
                list.add(Thread.currentThread().getName()+"-Produit-"+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list);


    }
}
