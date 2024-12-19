package org.example.Exo19;


import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
        runTest(clq);
    }

    private static void runTest(ConcurrentLinkedQueue<String> list) throws InterruptedException {
        Runnable product = () -> {
            for (int i = 0; i < 10; i++) {
                list.add("Producer-Element-" + i);
                System.out.println("Producer a ajouté : Producer-Element-" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consume = () -> {
            for (int i = 0; i < 10; i++) {
                String element = list.poll();
                if (element != null) {
                    System.out.println("Consumer a retiré : " + element);
                } else {
                    System.out.println("Consumer n'a trouvé aucun élément à retirer.");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producer = new Thread(product, "Producer");
        Thread consumer = new Thread(consume, "Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(list);
    }
}

