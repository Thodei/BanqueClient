# TP Application Banque (BanqueClient)
Projet Java dans le cadre de la LP - GL (Mai 2019)
## Équipe
- François Recchia
- Thibaut Genrault
- Florian Pexoto
- Thomas Deiss
## Construction et lancement de l'application
Importer le projet dans Eclipse (.settings, .classpath et .project envoyés en PJ par mail si nécessaires)

Importer la BDD grâce au script fourni (bdd_bank.sql)

Lancer l'application. 

Il y a 2 utilisateurs :

|                  |Login |Password  |
|------------------|------|----------|
|Bienaimé Joseph   |`1`	|`password`|
|Compte de l'agence|`2`   |`password`|

## Technologies utilisées
- **BDD** : MariaDB 10.1.38
- **Frontend** : JavaFX (FXML)
- **IDE** : Eclipse 2018-12 (4.10.0)
- Apache Maven 3.6.0
## Tâches effectuées
#### Login
- [x] Connexion/Déconnexion à son compte
#### Compte
- [x] Sélection de son compte
#### Détails compte
- [x] Affichage du solde en €
- [x] Conversion du solde en $ et £ 
- [x] Affichage du découvert autorisé
- [x] Virement vers un autre compte
## Notes



# Gestion de projet

## Indications du client
### Côté projet : 
- Comptes en €
- Virement entre comptes de la banque
- Pas de limite de montants
- On ne peut pas supprimer de compte (on peut geler)
- Pas d’historique
### Côté agile :
- Scrum master : Thomas
- Backlog des sprints
## Sprint 0
### Vision du produit

**Pour** les utilisateurs / clients d’une banque

**Qui** ont besoin une application où l’on peut gérer ses comptes, consulter son solde mais aussi convertir son argent dans une autre devise pour faciliter ses déplacements.

**Notre** solution, BanqueClient est une application de gestion de compte en banque

**Qui** permet d’avoir accès à ses comptes et de pouvoir y faire des actions, en ligne et facilement, et rapidement, à l’instar de virements entre comptes.

**À l’inverse** des autres banques qui ne permettent pas certaines actions en ligne et privilégient les rendez-vous en agence, et qui nécessitent des délais de traitement.

**Notre produit** est une solution intéressante pour les clients qui ne peuvent pas ou ne veulent pas se rendre en agence pour leurs démarches.

### Backlog initial

#### Clarification fonctionnelle

L’application met à disposition un seul type d’utilisateur (*simplement nommé “utilisateur”*).

Il peut se connecter à l’aide de son numéro client ainsi que son mot de passe pour pouvoir créer un compte bancaire ou consulter ceux existants. Un utilisateur peut également effectuer différentes opérations sur ses comptes, comme consulter son solde, faire un virement vers un autre compte ou convertir un montant dans une autre devise.

#### User Stories

**En tant qu**’utilisateur

**Je veux**:

-	pouvoir créer rapidement un compte. 
-	pouvoir consulter mes comptes.
-	pouvoir faire un virement.
-	pouvoir geler un compte.
-	pouvoir convertir mon argent dans une autre devise.

**Pour** gagner du temps et faciliter mes démarches.

### Rôles attribués :
**Développeur** : François, Florian, Thibaut, Thomas
**Scrum master** : Thomas
**Client** : M. Joyeux


## Organisation de l’équipe pour réaliser le travail

**François** : Front-end

**Florian** : Base de données + Back-end (DAO)

**Thibaut** : Tests métier & tests techniques

**Thomas** : Back-end

## Points de vélocités
**Front-end :** `13`

-	Réalisation des fenêtres JavaFX : `13`

**Back-end :** `102`

-	DAO : `34`
-	Tests : `13`
-	Développement des méthodes : `55`

**Base de données :** `13`

-	Création de la base de données & scripts : `13`



## Sprints
### Sprint backlog n°1

**François** : Vues en FXML (`vélocité : 21`)

**Florian** : Diagramme base de données, création de la base de données (`vélocité : 13`)

**Thibaut** : Finalisation sprint 0, 1ers tests (`vélocité : 34`)

**Thomas** : Finalisation sprint 0, classe conversion devises (`vélocité : 34`)


### Sprint backlog n°2

**François** : Vues en FXML (`vélocité : 21`)

**Florian** : Implémentation de la base de données (`vélocité : 13`)

**Thibaut** : Tests sur la base de données (`vélocité : 13`)

**Thomas** : Développement des méthodes (`vélocité : 55`)


### Sprint backlog n°3

**François** : Documentation du projet (`vélocité : 34`)

**Florian** : Préparation des requêtes (`vélocité : 21`)

**Thibaut** : Documentation du projet (`vélocité : 34`)

**Thomas** : Requêtes utiles aux méthodes (`vélocité : 55`)
