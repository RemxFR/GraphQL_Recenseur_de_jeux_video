# README Recenseur de Jeux Vidéos

## Installation
Pour lancer l'application, il vous suffit de lancer dans le terminal la commande suivante :

--> docker compose -f docker-compose.dev.yml up --build

Puis dans votre navigateur web aller sur l'url suivante : 

--> http://localhost:8081/graphiql?path=/graphql

## Utilisation

### POST :
Pour enregistrer un jeu de données, un endpoint ReST est créé à cet effet à l'url :

--> http://localhost:8081/game/add

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

#### games :

#### editors et studios :

#### game, studio et editor :
