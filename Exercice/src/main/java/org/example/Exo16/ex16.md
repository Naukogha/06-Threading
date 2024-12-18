# Calcul parallèle avec une action de barrière

Implémente un programme où quatre threads calculent des parties d'un tableau de nombres (somme partielle).
Une fois tous les threads synchronisés à la barrière, calcule la somme totale dans une action de barrière.


Résultat possible  :

```bash
Thread-2 a calculé une somme partielle de (indice : 2 à indice : 3) : 7
Thread-4 a calculé une somme partielle de (indice : 6 à indice : 7) : 15
Thread-1 a calculé une somme partielle de (indice : 0 à indice : 1) : 3
Thread-3 a calculé une somme partielle de (indice : 4 à indice : 5) : 11
Somme totale : 36
```