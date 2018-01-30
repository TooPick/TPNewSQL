-----------------------------
 DEMARRER LA BASE DE DONNEES
-----------------------------

Dans un terminal entrez :
:> cockroach start --insecure --store=books-db --host=localhost

Laisser ce service touner en tâche de fond pour que la base de données reste connectée.

###############################################################################################

---------------------
 CREATION D'UNE BASE
---------------------

Dans un nouveau terminal entrez :
:> cockroach sql --insecure

Puis dans l'interface SQL de Cockroach entrez :
:> CREATE DATABASE books;

Votre base est créée, vous pouvez quitter l'interface SQL avec Ctrl+C.

###############################################################################################

------------------
 LANCER LE PROJET
------------------

Pour build le projet, dans un terminal entrez :
:> gradle build -x test

Pour exécuter le projet entrez :
:> java -jar build/libs/demoCockroachBD-0.0.1-SNAPSHOT.jar

Le projet est maintenant lancé et accéssible via l'URL : http://localhost:8090
Vous pouvez tester les URLs suivante avec un logiciel tel que Postman par exemple.

# AUTEURS
GET     http://localhost:8090/authors         : Permet de récupérer la liste de tous les auteurs disponibles dans la base de données.
GET     http://localhost:8090/authors/{id}    : Permet de récupérer les informations de l'auteur dont l'ID est en paramètre.
DELETE  http://localhost:8090/authors/{id}    : Supprime l'auteur dont l'ID est en paramètre.
POST    http://localhost:8090/authors         : Permet d'ajouter un nouvel auteur dans la base de données.
    Paramètres:
        id (int)            : Identifiant de l'auteur à ajouter.
        firstname (string)  : Prénom de l'auteur à ajouter.
        lastname (string)   : Nom de l'auteur à ajouter.

# LIVRES
GET     http://localhost:8090/books         : Permet de récupérer la liste de tous les livres disponibles dans la base de données.
GET     http://localhost:8090/books/{id}    : Permet de récupérer les informations du livre dont l'ID est en paramètre.
DELETE  http://localhost:8090/books/{id}    : Supprime le livre dont l'ID est en paramètre.
POST    http://localhost:8090/books         : Permet d'ajouter un nouveau livre dans la base de données.
    Paramètres:
        id (int)        : Identifiant du livre à ajouter.
        title (string)  : Titre du livre à ajouter.
        author_id (int) : Identifiant de l'autre du livre (doit déjà être présent dans la base de données).