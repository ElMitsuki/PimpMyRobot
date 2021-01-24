# Présentation

## L'équipe

- Meya Georges
- Ramos Tommy
- Hitchon Thomas
- Chafiol Antonin

## Le projet

### Histoire

Dans ce projet vous incarnez un concepteur de robot, et plus spécifiquement,
vous devez vous occupez de programmer l'algorithme qui va resteindre le robot dans ses actes.

Après initialiser votre robot, il sera temps de le tester ! Il sera soumis à une batterie de situations, qui utiliseront
vos régles définits plus tôt, à vous de résoudre un maximum de situations sans provoquer de paradoxe.

Bonne chance !


### Déroulement du jeu
#### L'initialisation du robot
Pour pouvoir jouer vous devez configurer tout les éléments nécéssaire pour le jeu à votre guise :

- Dès l'application lancée, vous allez devoir choisir le nom de votre robot. <br>
![Image Nom](/ressources/Images/Tuto_Nom.png)

- Dès que le nom est validé, vous devez ensuite choisir toutes les règles à appliquer au robot parmi les différentes règles qui lui sont proposées.
Afin de faciliter les choix du robot, les règles « Obéir aux ordres des humains » et « Ne pas faire de mal physiques aux humains » sont automatiquement attribuées au robot car, <br> si le joueur ne choisit pas ces règles, il est fort probable que le robot n’ai pas de moyens de faire un choix.
![Image Regles](/ressources/Images/Tuto_Regles.png)

- Après avoir choisi les règles à appliquer au robot, vous allez devoir décider de la priorité de celles-ci.
Pour ce faire, vous allez les classer de la plus importante à la moins importante (du haut vers le bas). <br>
Par exemple, La règle en deuxième position, sera plus importante que toutes les autres en dessous mais moins importante que la première. Le joueur à ici une totale liberté dans ses choix. <br>
Vous allez devoir également choisir le nombre de situations auxquelles votre robot va devoir être confrontée. <br>
Le nombre de situations utilisées pour tester votre robot est __limité à 15 situations__.
![Image Hierarchisation](/ressources/Images/TUTO_Hierarchisation.png)

### L'évaluation du robot
Après les éléments essentiels créée, le robot va devoir passer les test:

- Des situations vont apparaitre une par une, la situation courante va avoir une description et une image pour expliquer le cas actuel, elle va aussi avoir plusieurs réponses (issues).
- Maintenant, vous allez devoir choisir la réponse dont vous pensez que le robot va choisir
- Une infobulle apparaitra montrant qu'elle issue à été choisie par le robot
- Cliquez sur le bouton `Suivant` pour faire apparaitre la prochaine situation
![Image Situation](/ressources/Images/Tuto_situation.png)

### Bilan
Une fois toutes les situations résolues, un récapitulatif des situations s'affiche avec le score du joueur ainsi que la liste des issues choisient par le joueur et par le robot pour chaques situations.
![Image Bilan](/ressources/Images/TUTO_Bilan.png)

# Documentation

Pour accéder à la documentation, ouvrez le fichier `menu.html` lorsque vous avez téléchargé le projet, ce fichier est situé dans le **répertoire pimpMyRobot_Finale/javadoc/menu.html** du projet.

# Execution
Après avoir installé le jeu, assurez-vous d'avoir bien téléchargé la dernière version du logiciel JDeveloper. <br>
- Allez dans pimpMyRobot_Finale puis double-cliquez sur pimpMyRobot_Finale.jpr. <br>
  (cela devrait lancer l'application par l'intermediaire de JDeveloper, sinon faites clique-droit, ouvrir avec JDeveloper).
- Une fois que l'IDE JDeveloper est lancé, déployez l'arborescence du projet (icone (+) à gauche du nom de projet) <br>
  et rendez vous sur le package view et enfin faites clique-droit, Run sur la classe FenetreAppelante.java.
### Prérequis
Vous devez posséder une version récente du JDK sur votre machine et avoir ajouté le dossier bin/ du JDK <br>
dans votre variable d'environnement PATH afin de pouvoir utiliser convenablement les commandes cités dans la section suivante.
### Execution
Ouvrez un invité de commande et déplacez-vous vers le dossier **pimpMyRobot_Finale/classes** puis entrez la commande suivante :
- Si vous êtes sur Windows :
  `java -cp ".;../../ressources/JSON/json-simple-1.1.1.jar" view/FenetreAppelante`
- Si vous êtes sur Linux :
  `java -cp ".:../../ressources/JSON/json-simple-1.1.1.jar" view/FenetreAppelante`
