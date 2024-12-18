package org.example.Exo13;

public class Printer{
    @Override
    public String toString(){

        return Thread.currentThread().getName()+" a acquis le verrou et utilise l'imprimante";
    }

}
