# README Recenseur de Jeux Vidéos

## Installation
Pour lancer l'application, il vous suffit de lancer dans le terminal la commande suivante :

→ docker compose -f docker-compose.dev.yml up --build

Puis dans votre navigateur web aller sur l'url suivante : 

→ http://localhost:8081/graphiql?path=/graphql

## Utilisation

### POST :
Pour enregistrer un jeu de données, un endpoint ReST est créé à cet effet à l'url :

→ http://localhost:8081/game/add

Voici un jeu de données permettant de tester l'application, ils sont à enregistrer un au niveau de ce endpoint.
Il suffit d'inscrire chacun de ces jeux de données dans le body de la requête, dans postman par exemple.

#### Jeu de données :

#### Jeu 1 :
{
"name": "Tales of Symphonia",
"genres": ["Action-RPG"],
"dateTypePublicationDate": "2003-09-19",
"editors": [
{
"name": "Namco"
}
],
"studios": [
{
"name": "Namco Tales Studio"
}
],
"platforms": ["Gamecube"]
}
#### Jeu 2 :
{
"name": "Mario Kart: Double Dash!!",
"genres": ["Course, Combat motorisé"],
"dateTypePublicationDate": "2003-11-07",
"editors": [
{
"name": "Nintendo"
}
],
"studios": [
{
"name": "Nintendo EAD"
}
],
"platforms": ["Gamecube"]
}
#### Jeu 3 :
{
"name": "Fifa 23",
"genres": ["Sport"],
"dateTypePublicationDate": "2022-09-27",
"editors": [
{
"name": "Electronic Arts"
}
],
"studios": [
{
"name": "EA Vancouver"
}
],
"platforms": ["Playstation 4", "Playstation 5", "Xbox One", "Xbox Series", "Nintendo Switch", "Google Stadia", "Microsoft Windows"]
}

### GET :
Pour faire les requêtes GET via GraphQL, la page http://localhost:8081/graphiql?path=/graphql, permet de requêter directement
depuis le navigateur.
Toutes les données à spécifier sont indiquées en autocomplétion.
Il est à noter quelques particularités au niveau de la forme des requêtes :
Toutes les queries en graphQl sont précédées de la balise query {}.

#### games :
Pour le type games, on récupère 2 autres types : le type infos et le type results.
Les paramètres accéptés sont les suivants : 
- pages: un int qui permet de définir le nombre de pages de résultats que l'on souhaite récupérer (par défaut 10) ; 
- genre: un string qui permet de rechercher les jeux par genre ; 
- platform: un String qui permet de rechercher les jeux par plateforme ; 
- studio: un String qui permet de rechercher les jeux par studio.

Pour récupérer les résultats de la requête, on obtient deux types dans la réponse :

→ infos, qui contient les datas suivantes : 
- count : un int qui donne le nombre de résultats ;
- pages : un int qui donne le nombre de pages ;
- nextPage : un int qui donne le numéro de la prochaine page ;
- previousPage : un int qui donne le numéro de la page précédente ;

→ results qui contient les datas suivantes :

- [game] : une liste de jeux ;

Exemple 1 :

    query {
        games(genre:"Sport") {
            infos {
                count
                pages
            }
            results {
                id
                name
                // Tous les autres champs souhaités
            }
        }
    }

Exemple 2 :

    query {
        games(genre:"Combat motorisé", platform:"Gamecube") {
            results {
                id
                name
                // Tous les autres champs souhaités
            }
        }
    }

À noter qu'il n'est pas obligé de mettre dans la query le type infos par exemple, on peut juste avoir le type 
results et inversément.



#### editors et studios :
Pour ces types, on récupère également les types infos et results avec pour :
editors : 
- infos : idem games ;
- [editor] : une liste d'éditeurs.

studios :
- infos : idem games ;
- [studio] : une liste de studios.

En revanche, le seul paramètre accepté pour ces types est le nombre de pages que l'on souhaite recevoir, il sera par défaut de 10 et peut être
customisé de la manière suivante si l'on veut par exemple récupérer 5 pages de résultats :

    editors(page: 5) {

    //mettre ici les champs que l'on souhaite récupérer

    }
#### game, studio et editor :
L'id à renseigner en paramètre est en format string et donc à mettre entre "". 

On ouvre ensuite les accolades et on met les champs que nous voulons récupérer comme pour un fichier json.


    ex: game(id:"1") {
    id    
    nom
    studios {
        id
        nom
        }
    }
