resttuto
========

Il y a deux projets.

restservice et restconsume

restservice fournit des founit les services REST.

repose sur spring-boot ainsi qu'un serveur tomcat embarqué.
Il est possible de configurer ce dernier en modifiant les valeurs du fichier application.properties

Par défaut le nom du serveur est localhost et le numéro de port est 8181.

Pour l'éxécuter il suffit de taper 

			mvn package && java -jar restservice/target/restservice-1.0-SNAPSHOT.jar



restconsume propose une interface cliente qui accède au fournisseur de service.
Outre une page de login/password (un clic sur le bouton 'Valider' suffit à passer à l'écran suivant), restconsume permet de visualiser, créer modifier, supprimer des utilisateurs.

Contrairement à restservice, restconsumer ne repose pas sur un serveur embarqué.
