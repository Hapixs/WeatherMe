## WEATHER ME _1.0_


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

**Fonctionalitées**

- Gestion et synchronisation du cycle jour / nuit
    - Modification du nombre de ticks dans une journée
    - Synchronisation avec l'heure réel d'un endroit donné.

    **Modification du gameplay**<br>
    Aucune réele modification du gameplay est à noté. Le monde agit normalement en fonction de son horraire.

    **Configuration de la fonctionalité**
     - > **Par fichier local spéciale**
       >
       > _Le fichier local seraient sous la forme JSON ou YAML et contenue dans le dossier par défaut ./plugins/weatherme/time/config.json ._
       >
       > L'administrateur définie le nombre de ticks nécessaire pour un cycle jour+nuit par monde connue du serveur
       > 
       > L'administrateur peut définir une géolocalisation réele qui définira le moment de la journé du monde.

    - > **Par fichier local général**
        > _Le fichier local seraient sous la forme JSON ou YAML et contenue dans le dossier par défaut ./plugins/weatherme/global.json ._
        >
        > L'administrateur peut choisir de synchroniser tout les mondes entre eux.
        > 
        > L'administrateur peut choisir de syncrhoniser avec le serveur 'Master'

- Gestion et synchronistaion de la météo
    - Synchronisation de la météo d'un monde par rapport à une géolocalisation réele.
    - Synchronisation de la météo d'un joueur par rapport à une géolocalisation réele.
    - Synchronisation de la météo d'une région* par rapport à une géolocalisation réele.
    - Synchronisation de la météo d'un serveur par rapport à une géolocalisation réele.
    - Synchronisation de la météo d'un serveur par rapport à d'autres serveur configurés.
    - Synchronisation de la météo d'un biome par rapport à une géolocalisation réele.
     - Synchronisation de la météo d'un monde par rapport à une configuration interne.
    - Synchronisation de la météo d'un joueur par rapport à une configuration interne.
    - Synchronisation de la météo d'une région* par rapport à une configuration interne.
    - Synchronisation de la météo d'un serveur par rapport à une configuration interne.
    - Synchronisation de la météo d'un biome par rapport à une configuration interne.

     **Modification du gameplay** <br>
      La mise en place de différent climats impact de certaines manière le jeux et les joueurs. Example:
     - > **Pluie**
       > 
       > Des flaque d'eau peuvent apparaitrent à certains endroit.
       >
       > Les plantations peuvent obtenir un boost temporaire.
       > 
       > L'hydratation des terre peut ce faire plus simplement
    
    - > **Tempètes**
      > 
      > Des partie de terrains peuvent être 'inondés'
      > 
      > Les plantations peuvent obtenir un boost temporaire comme avec la pluie
      >
      > Les plantations peuvent ce voir inondées et ne rien produire.
      > 
      > Les terres peuvent ne pas accepter de nouvelle plantations avant d'avoir relativement sécher.

    - > **Neige**
      >
      > Les joueurs peuvent recevoir l'effet de géle
      > 
      > Les plantations peuvent avoir un boost négatif de pousse
      >
      > Les plantations peuvent geler et ne rien produire

    - > **Soleil**
      >
      > La plus part des fonctionnalité restent inchanger
      >
      > Si le soleil apparait dans un endroit eneiger et que la température s'y prete, le neige peut fondre à certains endroits.


- Gestion et synchronisation des saison
    - Synchronisation de la saison actuel avec la saison d'une géolocalisation réele.
    - Configuration des période de saison en fonction d'un nombre de jours in-game donner.

    **Modification du gameplay** <br>
    La mise en place de différent climats impact de certaines manière le jeux:
    > En fonction de la saison et de l'endroit les feuilles des arbres peuvent ce voir changer de couleurs / les perdre.
    >
    > La saison comme le printemps peuvent boost les loot de pommes etc des feuilles casssés.
    > 
    > La saison peut intergire sur le climat et la météo.


- Gestion et synchronisation du climat
    - Synchronisation du climat d'une région par rapport à une géolocalisation réele.
    - Synchronisation du climat de biome par rapport à une géolocalisation réele.
    - Synchronisation du climat d'une région par rapport à une configuration interne.
    - Synchronisation du climat de biome par rapport à une configuration interne.

    **Modification du gameplay** <br>
    La mise en place de différent climats impact de certaines manière le jeux et les joueurs.
    Example:
    - > **Climat froid**
      >
      > Si le climat atteint des températures basse le joueurs peut se voir souffrire de géle. Pour y remedier il devras s'approcher d'un source de chaleur ou porter une armure qui protègera plus ou moins du froid.
      > 
      > Les plantations auront plus de mal à poussée et pourrait dans certains cas geler 

    - > **Climat chaud**
      > 
      > Pas d'impact direct pour les joueurs
      >
      > Les terres aurons du mal à être hydrater.
      >
      > Les plantations peuvent brulées
      >
      > Des incendie peuvent avoir lieu
      >
      > Si l'endroit est eneiger alors la neige peut fondre à certains endroits

    - > **Climat humide**
      > 
      > Pas d'impact sur les joueurs
      > 
      > Les terre seront hydratés plus facilement et sur un plus grand périmètre
      > 
      > Les plantations pourraient avoir plus de facilitées à pousser et produire plus de récoltes

    - > **Climat sec**
      > 
      > Rien ne change, le jeux est normal.
    
    **Configuration de la fonctionalité**
     - > **Par fichier local spéciale**
       >
       > _Le fichier local seraient sous la forme JSON ou YAML et contenue dans le dossier par défaut ./plugins/weatherme/climat/config.json ._
       >
       > L'administrateur définis les climat possible pour chaque biomes du jeux.
       > L'administrateur choisis entre plusieurs style de transition:
       > - Static (Il choisis un climat et il ne bougera plus)
       > - Timer (Il choisis le temps entre chaque changement de climat)
       > - Dynamique (Le changement s'effecura en fonction de la météo/saison)
       > - Géolocalisé (L'administrateur choisis une géolocalisation réele)

    - > **Par fichier local général**
        > _Le fichier local seraient sous la forme JSON ou YAML et contenue dans le dossier par défaut ./plugins/weatherme/global.json ._
        >
        > L'administrateur peut choisir de syncrhoniser avec le serveur 'Master'

### Aspect technique:

- **Api call**
> Le plugin doit récuperer les informations d'une géolocalisation réele tel que:
    > - La météo
    > - La température / humidité
    > - L'heure de la journée

Dans ce cadre l'api 'OpenCage Geocoding' serait intégrer au plugin.

- **Machine to Machine**
> Afin de mettre en place la synchronisation entre serveur une partie Websocket sera integrer dans le plugin afin que les different serveurs mis en ligne puissent communiquer entre eux

- **Base de donnée**
> Le plugin utilisera une base de donnée afin de principalement stocker les information de configuration du serveur actuel

> Mais aussi afin de garder en mémoire la liste des serveur en ligne et leurs adresses.

> Les informations relative au joueurs / mondes y seront stocker si necessaire.

**Interactions utilisateur**

> Afin de simplifier l'interaction des utilisateurs, des menu in-game seront mis en place en fonction de la demande.

> Des commandes seront aussi disponible pour un controle plus étendue

**Protection contre les gens pas cool**

> En utilisant le système 'built-in' de la librairie Bukkit, des permissions seront mis en place, pour la modification d'état de variable et pour l'acces au fonctionalité et leur menu d'interaction.