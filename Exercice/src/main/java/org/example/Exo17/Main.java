package org.example.Exo17;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


//les threads sont : acheteur 1, acheteur 2==> il reduise les stock de 1, réapprovisionneur augmente de 10
//on a produit A, produit B, produit C ==> qui sont dans une liste
public class Main {


    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> inventaire = new ConcurrentHashMap<>();
        inventaire(inventaire);
    }

    public static void inventaire (ConcurrentHashMap<String, Integer> list) throws InterruptedException {
        list.put("ProduitA", 30);
        list.put("ProduitB", 30);
        list.put("ProduitC", 30);

        Runnable acheteur = () -> {
            for (int i = 0; i < 10; i++) {
                String produit = choisirProduit();
                list.computeIfPresent(produit, (key, stock) -> stock > 0 ? stock - 1 : 0);
                System.out.println(Thread.currentThread().getName() + " a acheté 1 unité de " + produit);
            }
        };

        Runnable reapprovisionneur = () -> {
            for (int i = 0; i < 5; i++) {
                String produit = choisirProduit();
                list.compute(produit, (key, stock) -> stock != null ? stock + 10 : 10);
                System.out.println("Réapprovisionneur a réapprovisionné 10 unités de " + produit);
            }
        };

        Thread acheteur1 = new Thread(acheteur, "acheteur-1");
        Thread acheteur2 = new Thread(acheteur, "acheteur-2");
        Thread reaprovisionneur = new Thread(reapprovisionneur, "reappro");

        acheteur1.start();
        acheteur2.start();
        reaprovisionneur.start();

        acheteur1.join();
        acheteur2.join();
        reaprovisionneur.join();

        System.out.println("Inventaire final : " + list);
    }

    private static String choisirProduit() {
        List<String> produits = List.of("ProduitA", "ProduitB", "ProduitC");
        return produits.get((int) (Math.random() * produits.size()));
    }
}
