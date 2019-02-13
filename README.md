# travel-agency

The Travel Agency est un logiciel de gestion de réservation de voyage.
Dans le cadre de ce projet, vous allez contribuer au développement de ce logiciel.


# Organisation

Ce travail sera réalisé par groupe de 2 étudiants.

Quelques règles de mise en œuvre et gestion du projet:

1. Avant toutes choses, créez un **"Fork"** du projet sur le serveur.
Pour ce faire, cliquez sur l'icône "Fork" (ou "Créer une divergence" en français) de la page du projet our accéder au lien suivant: [https://gitlab.univ-nantes.fr/naomod/software-construction-course/alma-gtd/forks/new](https://gitlab.univ-nantes.fr/naomod/software-construction-course/alma-gtd/forks/new)

2. Clonez **votre fork du projet** (et non pas celui d'origine). Toutes vos modifications devront être poussées sur votre fork et toutes les issues (ou "tickets" en français) ouvertes le seront sur votre version du projet.

3. Ajouter tous les autres membres du groupe à votre fork.

4. **Il ne doit y avoir qu'un seul "fork" par groupe d'étudiants.** Il sera utilisé comme espace de rendu des fichiers lié au projet.

# Travail à réaliser

Le travail à réaliser est réparti en différentes "issues" (ou tickets), répertoriées dans le fichier [`ISSUES.md`](https://gitlab.univ-nantes.fr/naomod/software-construction-course/travel-agency/blob/master/ISSUES.md). **Le but du projet est de résoudre tous ces tickets.** Pour ce faire, **vous devrez suivre le protocole de travail suivant**, suivant la méthodologie Test-Driven Development (TDD).

Pour chaque ticket du fichier [`ISSUES.md`](https://gitlab.univ-nantes.fr/naomod/software-construction-course/travel-agency/blob/master/ISSUES.md):

1. Ouvrez un ticket dans votre projet Gitlab (sur l'interface en ligne de Gitlab, section *Tickets*). Vous y détaillerez les points suivants:
  * Un bref résumé du problème lié au ticket.
  * Quels sont les tests à mettre en oeuvre pour vérifier que le ticket a bien été résolu ?
  * Comment la solution au ticket doit être mise en oeuvre ?
 
2. **Associer un membre du groupe** à la résolution du ticket, via l'interface de Gitlab. Cette personne, et uniquement celle ci, sera chargée de résoudre le ticket.

3. Créer la/les classes de tests et les tests unitaires qui permetteront de valider la résolution du ticket. Pour le nommage de vos tests, vous pouvez vous référer à la ressource suivante: [https://dzone.com/articles/7-popular-unit-test-naming](https://dzone.com/articles/7-popular-unit-test-naming).

4. Implémenter de quoi résoudre le ticket. Les tests écrits précédemment devront valider votre implémentation. *Faites attention à la regression!*: toute modification ne doit pas "casser" du code fonctionnel.

5. Si jamais vous devez changer d'approche au niveau des tests, de l'implémentation, etc, **ajouter un commentaire sur le ticket Gitlab**  pour commenter tout changement. **N'éditez pas le texte du ticket original**, afin de garder un historique de votre travail.

6. Effectuer un commit de vos modifications, en référençant le numéro du ticket et en indiquant votre progression dans sa résolution. Nous vous invitons à lire le billet suivant à ce sujet: [https://chris.beams.io/posts/git-commit/](https://chris.beams.io/posts/git-commit/).

7. Enfin, quand le ticket est résolu, marquer le comme "résolu" dans l'interface de Gitlab.

Le code du projet est là pour vous fournir une base de code. Vous êtes libre de *modifier l'implémentation comme vous l'entendez*, voir même de modifier le modèle UML en lui même !  **Mais attention, vous devrez motiver tous vos changements dans vos différents tickets/commits !!!**

## Evaluation

* Le travail à rendre se composera de votre **fork en ligne Gitalb**, sur lequel vous aurez pousser toutes vos modifications. Cela inclut également tous les messages de commits et tickets ouverts.

* Pour être évalué, **tout étudiant doit participer activement du projet**, en réalisant des "commits", en ajoutant des lignes de code, en ouvrant des tickets sur le serveur GitLab, etc.

* L'évaluation portera sur les citères suivants :
  * Respect du protocole de développement donné dans l'énoncé.
  * Qualité des tickets ouverts sur votre projet Gitlab en ligne.
  * Qualité du code produit.
  * Qualité et pertinence des tests unitaires mis en place.
  * Qualité des messages de commits.
  * Approche choisie pour résoudre chaque ticket.
  * Nombre de tickets résolus.

## Dépendances Maven

Le projet de démarrage est configuré comme un projet Maven standard. Vous êtes libres d'ajouter de nouvelles extensions lors du développement du projet. Par défaut, les dépendances suivantes sont configurées:
* JUnit ([https://junit.org/junit5/](https://junit.org/junit5/)) pour gérer les tests.

* Joda Time ([https://www.joda.org/joda-time/](https://www.joda.org/joda-time/)) pour manipuler des dates.

* Apache Commons Lang ([https://commons.apache.org/proper/commons-lang/](https://commons.apache.org/proper/commons-lang/)) qui fournit une extension de la librairie Java standard.
