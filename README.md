# TP Android Studio – Projet Progressif

## 🎯 Objectif
Ce projet regroupe l’ensemble des TPs Android réalisés durant le semestre.  
Chaque TP introduit un nouveau concept Android (layouts, activités, cycle de vie, interactions, etc.) et contribue à la progression du projet global.


---

## 🧩 Structure du projet
- `app/src/main/res/layout/` → Contient les fichiers XML (interfaces utilisateur)
- `app/src/main/java/com/example/tp_android/` → Contient le code Java (logique)
- `.gitignore` → Exclut les fichiers inutiles (build, caches, etc.)
---

###  TP1 – Préparation Environnement de développement(23 septembre)
- Installation et configuration de l'environnement de développement Android(JDK,Android Studio,SDK,API).
- Se familiariser avec l'interface de base d'Android Studio.
- Creation et éxecution d'un premier projet "Hello World" sur un AVD ou un appareil physique.


###  TP2 – Interfaces d’authentification(30 septembre)
- Dans ce TP, nous avons créé deux activités principales :
  - **LoginActivity : permet à l’utilisateur de saisir son email et mot de passe pour se connecter.**
  - **RegisterActivity : permet l’inscription d’un nouvel utilisateur avec les champs Nom & Prénom, Email, Mot de passe et Confirmation du mot de passe.**
- Les interfaces ont été réalisées avec des layouts simples (LinearLayout) et des éléments de base comme TextView, EditText, Button et ImageView.

###  TP3 – Jeu du Nombre Secret et Types de Layout (07 & 14 octobre 2025)
- Découverte et utilisation des principaux types de Layout :
    - **LinearLayout**
    - **RelativeLayout**
    - **ConstraintLayout**
- Création d’un mini-jeu **"Nombre Secret"**, où l’utilisateur doit deviner un nombre entre 100 et 999.
- Mise en place de l’interface et du layout de base.
- Génération d’un nombre aléatoire entre 100 et 999.
- Vérification de la saisie de l’utilisateur.
- Affichage des messages directement à l’écran (`Txt_info`) pour indiquer les erreurs ou succès.
- Limitation du nombre de tentatives à 10.
- Mise à jour du compteur de tentatives (`Txt_nbr_essai`).

  *Le jeu a été amélioré par rapport à la version initiale du layout.*

###  TP4 – Cycle de Vie d’une Activité (14 octobre 2025)
- Création de `LiveCycleActivity`.
- Ajout de logs (`Log.e`) dans chaque méthode du cycle de vie :
    - `onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`.
- Permet d’observer et comprendre le comportement d’une activité Android.

### TP4 – Suite : Cycle de Vie d'une Activité (21 octobre 2025)

#### **Activité 1 : Comprendre le Cycle de Vie**
- Implémentation complète des méthodes du cycle de vie
- Création d'un compteur incrémentable avec interface
- Utilisation de logs pour observer les transitions d'état

#### **Activité 2 : Sauvegarde d'État lors de la Rotation**
- Résolution du problème de perte de données lors des rotations
- Implémentation de onSaveInstanceState() et restauration dans onCreate()
- Sauvegarde du compteur avec système de Bundle

#### **Activité 3 : Création de Layout Paysage**
- Création du qualifier layout-land pour l'orientation paysage
- Adaptation de l'interface en mode horizontal
- Utilisation de layout_weight pour une répartition optimale

#### **Activité 4 : Application au Jeu du Nombre Secret**
- Application des principes de sauvegarde d'état au jeu existant
- Préservation du nombre d'essais et du nombre mystère
- Création d'un layout paysage spécifique pour le jeu
---
### TP5 – Widgets et Alertes - Partie 1 (21 octobre)
- Création de RegistrationActivity avec formulaire de parcours étudiant
- Utilisation de RadioGroup (GL, IA, IOT, DS), CheckBox (clubs) et ScrollView
- Interface complète avec validation des données

## 👨‍💻 Auteur
- **Nom :** Meriem Sakhri
- **Filière :** 4 CS - Ecole Polytechnique de Sousse

---

## 🗂️ Version
Dernière mise à jour le *21 octobre 2025*

---

> Le projet sera progressivement mis à jour à chaque TP pour intégrer de nouvelles fonctionnalités et concepts Android.