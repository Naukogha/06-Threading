package org.example.Exo12;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    static List<Integer> liste = new ArrayList<>();

    public static synchronized void addList(){
        for(int i = 0; i < 3; i++){
            liste.add(i);
            System.out.println(Thread.currentThread().getName()+" a ajouté "+i);
        }
    }

    public static synchronized void removeList() {
        for(int i = 0; i < 3; i++){
            if(liste.isEmpty()){
                System.out.println(Thread.currentThread().getName()+" n'a rien à supprimer");
            }else {
                liste.remove(i);
                System.out.println(Thread.currentThread().getName()+" a supprimé : "+i);
            }
        }
    }
}
