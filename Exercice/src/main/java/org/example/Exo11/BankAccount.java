package org.example.Exo11;



public class BankAccount {
    int compte = 0;

    public synchronized void deposit(int montant){
        for(int i = 0; i < 3; i++){
            compte += montant;
            System.out.println(Thread.currentThread().getName()+" a déposé"+ montant+", solde actuel : "+compte);
        }

    }

    public synchronized void withdraw(int montant) {
        for(int i = 0; i < 3; i++){
            if(compte < montant){
                System.out.println(Thread.currentThread().getName()+"  n'a pas pu retirer "+montant+" (solde insuffisant). Solde actuel : "+ compte);
            }else {
                compte -= montant;
                System.out.println(Thread.currentThread().getName()+" a retiré "+montant+", solde actuel : "+ compte);
            }
        }

       }



}
