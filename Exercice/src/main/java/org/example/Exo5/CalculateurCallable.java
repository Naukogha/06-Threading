package org.example.Exo5;

import java.util.concurrent.*;

public class CalculateurCallable implements Callable<Integer> {
    private final int nombre;

    public CalculateurCallable(int nombre){
        this.nombre = nombre;
    }

    @Override
    public Integer call() throws Exception {
        return nombre * nombre;
    }


    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer>[] futures = new Future[10];

        for (int i = 1; i <= 10;  i++) {
            futures[i-1] = service.submit(new CalculateurCallable(i));
        }

        for (int i = 0; i < futures.length; i++) {
            try {
                System.out.println("Résultat de la tache "+(i+1)+ " : "+futures[i].get());
            }catch (InterruptedException | ExecutionException e){
                System.out.println("Erreur lors de la récuperation pour "+i);
            }

        }

        service.shutdown();
    }
}
