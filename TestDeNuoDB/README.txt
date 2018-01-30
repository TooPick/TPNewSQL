-----------------------------
 INSTALLER LA BASE DE DONNEES
-----------------------------

Dans un terminal lancer le script :
:> installDB.sh

Votre base de données est installé.

###############################################################################################

-----------------------------
 DEMARRER LA BASE DE DONNEES
-----------------------------

Dans un terminal lancer le script :
:> createdb.sh

Votre base de données est crée.

###############################################################################################

---------------------
 REMPLIR LA BASE
---------------------

Dans un terminal lancer le script :
:> ./script/fillDB.sh

Votre base est remplie.

###############################################################################################

-----------------------------
 AJOUTER UN NOEUD AU CLUSTER
-----------------------------

Afin d'ajouter un autre noeud au cluster (hostaname2 étant l'adresse de la machine et si besoin ai le numéro du port), il faut exécuter la commande suivante :
:> nuodbmgr --broker <hostname2> --password pass

Le manager de nuodb s'ouvre et il suffit d'exécuter les deux commande suivante :
:> start process sm database foot host <hostname2> archive foot
:> start process te database foot host <hostname2>

Puis de quitter le manager 
:> quit

------------------
 LANCER LE PROJET
------------------

Pour build le projet, dans un terminal entrez :
:> mvn package

Pour exécuter le projet entrez :
:> java -jar build/libs/TestDeNuoDB-0.0.1-SNAPSHOT.jar

Le projet est maintenant lancé et accéssible via l'URL : http://localhost:8090
Vous pouvez tester les URLs suivante avec un logiciel tel que Postman par exemple.

# EQUIPES
GET     http://localhost:8090/team?action=lookup              : Permet de récupérer la liste de tous les équipes disponibles dans la base de données.
GET     http://localhost:8090/team?action=loockOne&id={id}    : Permet de récupérer les informations de l'équipe dont l'ID est en paramètre.
            Paramètres:
                id (int)            : Identifiant de l'équipe.
GET     http://localhost:8090/team?action=remove&id={id}      : Supprime l'équipe dont l'ID est en paramètre.
            Paramètres:
                id (int)            : Identifiant de l'équipe.
GET     http://localhost:8090/team?action=add&name={name}     : Permet d'ajouter une nouvelle équipe dans la base de données.
            Paramètres:
                name (string)       : Nom de l'équipe.

# JOUEUR
GET     http://localhost:8090/player?action=lookup              : Permet de récupérer la liste de tous les joueurs disponibles dans la base de données.
GET     http://localhost:8090/player?action=loockOne&id={id}    : Permet de récupérer les informations du joueur dont l'ID est en paramètre.
            Paramètres:
                id (int)            : Identifiant du joueur.
GET     http://localhost:8090/player?action=remove&id={id}      : Supprime le joueur dont l'ID est en paramètre.
            Paramètres:
                id (int)            : Identifiant du joueur.
GET     http://localhost:8090/player?action=add
                    &FirstName={FirstName}
                    &LastName={LastName}&id={TeamId}            : Permet d'ajouter une nouvelle équipe dans la base de données.
            Paramètres:
                FirstName (string)       : Prénom du joueur.
                LastName (string)        : Nom du joueur.
                TeamId (int)             : Id de l'équipe à laquelle appartient le joueur.
