# François Recchia
# Thibaut Genrault
# Florian Pexoto
# Thomas Deiss
# TP SUJET N°1 : Annuaire d'entreprise
Projet JavaEE dans le cadre de la LP - GL (Mai 2019)
## Construction et lancement de l'application
Importer le projet dans Eclipse (.settings, .classpath et .project envoyés en PJ par mail si nécessaire)

Importer la BDD grâce au script fourni (SCRIPT_BDD.sql)

Lancer l'application. Le lien de connexion est : http://localhost:8080/annuaire/connexion

Il y a 2 utilisateurs, le plus simple est :
- login : admin
- password : admin

## Technologies utilisées
- Serveur d'application : Apache Tomcat 9.0.19 (+ Webby)
- BDD : MariaDB 10.1.38
- Frontend : JSP, Boostrap
- IDE : Eclipse 2018-12 (4.10.0)
- Apache Maven 3.6.0
## Tâches 
#### Tâches effectuées
- [x] Connexion/Déconnexion (+ redirection vers la page de connexion)
- [x] Recherche dans l'annuaire
- [x] Ajouter une personne dans l'annuaire
- [x] Supprimer une personne de l'annuaire
#### Tâches non effectuées
- [ ] Modifier une personne
- [ ] Une personne par poste
- [ ] Notification
- [ ] Résponsable hiérarchique
## Notes
- Les mots de passe ne sont pas cryptés dans la BDD pour éviter de perdre du temps sur le developpement et la saisie de données

- La plupart des tests ont été faits sur Firefox 66.0.4 donc certaines choses risquent de mal fonctionner sur les autres navigateurs (notamment les formulaires)

- Projet créé en partie grâce au [cours d'openclassroom sur Java EE]( https://openclassrooms.com/fr/courses/626954-creez-votre-application-web-avec-java-ee )

- [Fonction "chercher()" de la barre de recherche](https://www.w3schools.com/howto/howto_js_filter_table.asp) (modifiée)

- [Documentation Bootstrap](https://getbootstrap.com/docs/4.3/getting-started/introduction/)
