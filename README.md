# TPNewSQL
## TP - Adoption d’une BD NewSQL

Travail réalisé par Malo DUMONT et Alexandre SANIGOU.

Le projet comprend deux exemples d'utilisation de deux bases de données `NewSql` différentes.

Chacun des exemples possède un jeu de données qui lui est propre.

#### Exemple 1 : CockRoachDB

Le premier exemple utilise la base de données `CockRoachDB`.

Le projet est une API permettant de gérer une bibliothèque simplifiée.

Elle est composée de deux tables, les livres (`books`) et les auteurs (`authors`).

Un livre n'est associé qu'à un seul auteur, mais un auteur peut être associé à plusieurs livres différents.

Un auteur est composé des champs suivants :

 - `id` : L'identifiant de l'auteur
 - `firstname`  : Le prénom de l'auteur
 - `lastname`  : Le nom de l'auteur
 
Un livre est composé des champs suivants :

 - `id` : L'identifiant du livre
 - `title`  : Le titre du livre
 - `author_id`  : L'identifiant de l'auteur du livre
 
Toutes les informations permettant l'exécution et l'utilisation du projet sont disponibles dans le fichier `README.txt` disponible dans le dossier `CockRoachDB`.