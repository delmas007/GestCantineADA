# Documentation du Projet

## Installation

1. **Clonez le dépôt :**
   ```bash
   git clone https://github.com/delmas007/GestCantineADA.git
    ```
   charger maven pour l'installation des dépendances.


2. **Exécutez le projet :**
   ```bash
   mvn spring-boot:run
   ```
   Ouvrez votre navigateur et allez à l adresse suivante : http://localhost:8080
   Vous arriverez sur la page d accueil de l application.
    

3. **Fonctionnalités Principales :**

    `Gestion des Menus` : Ajoutez et gérez les menus. Pour ajouter un menu, assurez-vous que des plats sont créés et qu'ils ne figurent pas déjà dans un autre menu.

    `Gestion des Plats` : Ajoutez, modifiez et supprimez des plats. Lors de la suppression d'un plat, assurez-vous que le plat n'est pas utilisé dans un menu existant.

    `Templates HTML` : Les pages HTML sont gérées par des contrôleurs qui interceptent les requêtes HTTP et les dirigent vers les bonnes vues.