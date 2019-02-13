# Issues

1. Vérifier les contraintes sur l'association Calendar-Agent.

2. Vérifier les contraintes sur l'association Calendar-Travel.

3. Vérifier les contraintes sur l'association Travel-Correspondence.

4. Vérifier les contraintes sur les associations Correspondence-City.

5. Vérifier les contraintes sur les attributs de Correspondence.

6. Refactorer la classe `Person`, pour faire la distinction entre les agents et les administrateurs.

7. Remplacer les utilisations de Vector par les collections appropriées

8. Refactorer la classe `UserManager`, pour séparer les logique de gestion d'utilisateurs (ajout/suppression) et la gestion des mots de passe.

9. Renforcer le système d'encryption des mots de passe. Quelques pistes :
  * La classe [`Cipher`](https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html) disponible nativement.
  * La librarie [ `Apache Commons Crypto`](https://commons.apache.org/proper/commons-crypto/), installable via Maven.
  * La librarie [`Bouncy Castle`](http://www.bouncycastle.org/java.html), installable via Maven.

10. Ajouter le support pour une interface graphique, en utilisant JavaFX (La classe [`GUI`](https://gitlab.univ-nantes.fr/naomod/software-construction-course/travel-agency/blob/master/src/main/java/fr/unantes/software/construction/ui/GUI.java) contient un code de démarrage avec JavaFX).
