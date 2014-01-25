resttuto
========

Il y a deux projets.

###restservice & restconsume

* restservice 
founit les services REST. Il repose sur spring-boot (et donc un serveur tomcat 7 embarqué) et spring-rest.
Il est possible de configurer restservice en modifiant les valeurs du host et du port de connexion dans le fichier application.properties

Par défaut le nom du serveur est localhost et le numéro de port est 8181.

Pour faire un package et l'éxécuter il suffit de taper 

			mvn package && java -jar restservice/target/restservice-1.0-SNAPSHOT.jar



* restconsumer 
propose une interface cliente qui accède au fournisseur de service.
Outre une page de login/password (un clic sur le bouton 'Valider' suffit à passer à l'écran suivant), restconsumer permet de visualiser, créer modifier, supprimer des utilisateurs.
Il y a aussi un fichier application.properties qui indique quelle est l'adresse et le port d'écoute de restservice auquel se connecter.
Par défaut le nom du serveur distant est localhost et le port d'écoute 8181.

Contrairement à restservice, restconsumer ne repose pas sur un serveur embarqué. Il faut donc le déployer sur un serveur à part entière.
Dans un but pédagogique spring n'est pas utilisé dans les Controleurs. Néanmoins, dans les autres couches, il est fait usage de RestTemplate pour générer les URIs ainsi que de org.springframework.web.filter.HiddenHttpMethodFilter afin de générer des requêtes PUT et DELETE qu'il manque à l'HTML.


