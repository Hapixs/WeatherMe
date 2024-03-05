## WEATHER ME _1.0_


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


_Projet à faire sous grosse redbull_