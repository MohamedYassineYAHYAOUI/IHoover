# IHoover
Test entretien pour Yanport

Ennoncé disponible sur : 

##Introduction

L'application est développé en <b>Java</b> avec une interface graphique qui utilise la lib <b>Swing</b>, 
Pour mieux organiser le code, l'architecture adoptée est <b>MVC.</b>

## Continue du rendu:

La structure du rendu est la suivante :
```
    .
    └── src
    │   └── main
    │       └── java
    │           └── yanport
    │               ├── controller
    │               ├── model
    │               └── view
    ├── resources
    │    ├── config.properties
    │    └── Test technique - Développeur Full Stack.pdf
    ├── pom.xml
    ├── README.md
    └── exe
        └── IHoover-Mohamed-Yassine-YAHYAOUI.jar

```

## Documentation

On peut générer la javadoc en utilisant <b>Maven</b> avec la commande suivante :
```
    mvn javadoc:javadoc
```
Un répertoire **target** sera généré dans la racine, la javadoc est accessible au ```target/site/apidocs/index.html``` 

## Execution de l'application

Du même, on peut générer le jar pour l'application avec la commande maven : 
```
    mvn install
```
S'il n'est pas déjà le cas, un répertoire ***target*** sera généré dans la racine, dans lequel se trouve le fichier jar ```IHoover-Mohamed-Yassine-YAHYAOUI.jar```.

Dans l'appication, on fait appel au fichier properties ```resources/config.properties```, l'exécution du jar doit se faire donc au racine du projet.
```java
    java -jar target/IHoover-Mohamed-Yassine-YAHYAOUI.jar
```
Dans le cas ou il y a des erreurs de génération avec maven, un éxecutable pré-généré de la même application se trouve dans le repertoire **exe**.

On peut aussi utiliser le main de l'applicaiton ```yanport.controller.IHoover``` si on souhaite lancer l'application manuellement. 

## Utilisation 

Au lancement de l'application, une nouvelle fenêtre qui permet la saisie des informations s'affiche, Il faut donc remplir
les informations suivante :
* Les dimensions souhaitée de la grille **width** x **height**
* Le position de départ de l'aspirateur (x, y) dans la grille.
* Une série d'instructions que l’aspirateur exécutera, composée par les lettres 'A', 'D', 'G' (cf l'énoncé)
* La direction initiale **card** de l'aspirateur

Pour valider la saisie, on clique sur **Start**, une grille avec les dimensions souhaitées sera affichée.
L'aspirateur se déplace en suivant les instructions données par l'utilisateur, à la fin du parcours, une Pop-up indique la position et l'orientation finale. 

Dans la fenêtre principale, On peut changer les valeurs et lancer un autre test.

Une Pop-up s'affiche dans le cas ou il y'a eu une erreur de saisie.