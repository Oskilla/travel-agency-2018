# Issues

Tous les tickets à résoudre durant le projet sont listés içi. Ils ne sont triés ni par niveau de difficulté, ni par priorité, à vous de définir tout cela :muscle: !

1. Remplacer les utilisations de la classe `Vector` par les collections appropriées. A vous de choisir !

2. Dans la classe `Correspondence`, utiliser un véritable type "date" à la place d'entiers. **Astuce:** la librarie [JodaTime](https://www.joda.org/joda-time/) fournit des outils très puissants pour la gestion des dates.

3. Vérifier les contraintes sur l'association (bidirectionnelle) `Calendar <-> Travel`.

4. Vérifier les contraintes sur l'association (bidirectionnelle) `Travel <-> Correspondence`.

5. Vérifier les contraintes sur les associations `Correspondence -> City`.

6. Vérifier les contraintes sur les attributs de `Correspondence`.

7. Vérifier qu'un voyage (`Travel`) est composé d'un ensemble de correspondences cohérent (à vous de définir "cohérente" :wink:).

8. Refactorer la classe `Person`, pour faire la distinction entre les agents et les administrateurs.
Un agent possède un calendrier de voyages et peut réserver des voyages, tandis qu'un administrateur ne voyage pas mais peut réserver des voyages pour les agents.

9. **Une fois le ticket 5 résolu**, vérifier les contraintes sur l'association (bidirectionnelle) `Calendar <-> Agent`.

10. Refactorer la classe `UserManager`, pour séparer les logiques de gestion d'utilisateurs (ajout/suppression) et la gestion des mots de passe.

11. Renforcer le système d'encryption des mots de passe. Quelques pistes :
  * La classe [Cipher](https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html) disponible nativement.
  * La librarie [ Apache Commons Crypto](https://commons.apache.org/proper/commons-crypto/), installable via Maven.
  * La librarie [Bouncy Castle](http://www.bouncycastle.org/java.html), installable via Maven.

12. Ajouter le support pour une interface graphique, en utilisant JavaFX (La classe [`GUI`](https://gitlab.univ-nantes.fr/naomod/software-construction-course/travel-agency/blob/master/src/main/java/fr/unantes/software/construction/ui/GUI.java) contient un code de démarrage avec JavaFX).
**Ce ticket est résolu une fois les tickets 13 à 17 résolus.**

13. Ajouter un support graphique qu'un utilisateur se connecte au logiciel.

14. Ajouter un support graphique pour gérer les utilisateurs (ajout, modification et suppression d'utilisateurs)

15. Ajouter un support graphique pour qu'un agent puisse réserver un nouveau voyage.

16. Ajouter un support graphique pour qu'un administrateur puisse réserver un nouveau voyage pour le compte d'un autre agent.

17. Ajouter un support graphique pour modifier ou supprimer un voyage existant.

18. Améliorer la documentation générale du projet, i.e., améliorer la javadoc de chaque classe.
