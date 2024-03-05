## PROJET PERSONNEL


Le projet _WeatherMe_ <br>

**Général**

Cela consiste en un plugin Minecraft (version 1.20.4)
permettant de synchroniser la météo et le cycle jour / nuit du monde réel dans le jeux directemement.

Plusieurs mode de synchronisation seront disponiblent: 6
 - Par joueur (Un peut useless et étrange)
 - Par monde 
 - Par serveur
 - Par régions

Le mode par joueur laisse le choix à l'utilisateur de définir une localisation dans le monde réel et d'avoir le rendu in-game de la météo. En revanche ce mode peut rendre le jeux étrange. Il consiste à faussé les informatique que le serveur envoie en evitant les vrais paquet du serveur et en envoyant d'autre. Cela peut entendre que le monde actuel du joueur ne prendra pas en compte la météo que le joueur recois et n'agira pas comme voulu dans le jeux de base.

Le mode par monde permet à un administrateur de définir la météo d'un monde syncrhonisé avec une ville dans le monde.

Le mode par serveur est similaire au mode 'Par monde' mais syncrhonise plusieurs serveur entre eux. Qu'il soient connecter par le même 'proxy' ou non.

Le mode par régions permetterais à un administrateur de créer des région dans le monde ou la météo serait synchronisé avec une ville du monde. Cela permetterais de créer des map du monde réele et de lié les ville avec leurs équivalence in-game

**Permisions**

Le plugin contiendra des permissions. 3

Premièrement pour la partie configuration et administration du plugin afin que n'importe qui ne puisse modifier n'importe quoi.

Pour le choix de la localisation (par example dans le mode Par joueur.)

**Interface utilisateur**

Les interfaces utilisateur seront gérer avec des inventaire du jeux et des items actionable. 3

Dans le meilleur des monde un fichier (json / yml) sera disponible pour la customisation de ses items.

Pour la partie administration des commandes seront mise en place pour modifier / ajouter des paramètre au plugins ex:
- De nouvelle géolocalisations
- Le temps entre les requette
- Si le serveur doit ce synchro en fonction d'un autre
...



> - Une communication entre deux logiciels de votre création (deux fois le même
ou deux différents, en local ou en réseau) : machine to machine : 6
>
> Etant limité par l'API de météo un nombre de requette max dans un certains doivent être respecter.
Pour cela une solution ce présente.
Une foie un serveur en ligne il ira s'inscrire dans la base de donnée comme 'node' il ira ensuite grace à sans doute une web socket ou juste un paquet réseau simple, demander au autre serveur inscrit si il y en a qui est le master et proposer de prendre le relais si besoin.
>
> Le principe du master est tout simplement qu'il sera le seul et unique à parler avec l'api. Une foie les informations récuperées il les mettra dans la base de donnée disponible pour les autres serveur et envera l'information au autre que de nouvelles informations sont disponiblent.


> - Un lien avec une base de données de votre création, comprenant au moins 3 tables : 3
>
> Le plugin viendra stocker les informatique utilisateur, la configuration de celui-ci et les informations récuperer de l'API afin d'eviter le spam de requettes et d'atteindre trop vite la limite

> - Au moins un algorithme avancé (ex : génération, IA, analyse, ...) : 3
>
> Le projet devrait porter sur une map préfaite et viendra donc en fonction de la localisation des joueurs (XYZ) chercher la géolocalisation dans le monde réel avec une précisions définie.

> - De l’interaction avec l’utilisateur (ex : bouton, champ texte, événement : 2
>
> L'interaction avec l'utilisateur ce fera à l'aide de 'menu' mis en place dans le jeux grace à des inventaire replis d'item actionable
>
> Et aussi à l'aide de commandes utilisable par les joueurs / uniquement les administrateurs

> - Un CRUD sur au moins une donnée utile au logiciel : 4
>
> Toutes les donnée stocker dans la base de donée auront leurs gestion interne dans le plugin à l'aide de librairie permettant de créer des requettes sql objet.
Elles pouront donc être créées, modifiées, supprimées et lues.