-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  sam. 11 mai 2019 à 17:53
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bdd_bank`
--
CREATE DATABASE IF NOT EXISTS bdd_bank;
USE bdd_bank;

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `idBanque` int(11) NOT NULL,
  `nomBanque` varchar(45) NOT NULL,
  `adresseBanque` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `banque`
--

INSERT INTO `banque` (`idBanque`, `nomBanque`, `adresseBanque`) VALUES
(1, 'Banque principale', '187 Rue du bac plus 3');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nomClient` varchar(45) NOT NULL,
  `prenomClient` varchar(45) NOT NULL,
  `numClient` int(11) NOT NULL,
  `mdpClient` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `prenomClient`, `numClient`, `mdpClient`) VALUES
(1, 'COMPTE', 'AGENCE', 1, 'password'),
(2, 'BIENAIMÉ', 'Joseph', 2, 'password');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `idCompte` int(11) NOT NULL,
  `numCompte` int(11) NOT NULL,
  `gelCompte` tinyint(1) NOT NULL,
  `balanceCompte` float NOT NULL,
  `decouvertCompte` float NOT NULL,
  `Utilisateur_idUtilisateur` int(11) NOT NULL,
  `Banque_idBanque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`idCompte`, `numCompte`, `gelCompte`, `balanceCompte`, `decouvertCompte`, `Utilisateur_idUtilisateur`, `Banque_idBanque`) VALUES
(1, 1, 0, 39995, 0, 1, 1),
(2, 2, 0, 65005, 0, 2, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`idBanque`),
  ADD UNIQUE KEY `idBanque_UNIQUE` (`idBanque`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD UNIQUE KEY `numClient_UNIQUE` (`numClient`),
  ADD UNIQUE KEY `idClient_UNIQUE` (`idClient`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`idCompte`),
  ADD UNIQUE KEY `idCompte_UNIQUE` (`idCompte`),
  ADD UNIQUE KEY `numCompte_UNIQUE` (`numCompte`),
  ADD UNIQUE KEY `Utilisateur_idUtilisateur_UNIQUE` (`Utilisateur_idUtilisateur`),
  ADD KEY `fk_Compte_Utilisateur_idx` (`Utilisateur_idUtilisateur`),
  ADD KEY `fk_Compte_Banque1_idx` (`Banque_idBanque`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `banque`
--
ALTER TABLE `banque`
  MODIFY `idBanque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `idCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk_Compte_Banque1` FOREIGN KEY (`Banque_idBanque`) REFERENCES `banque` (`idBanque`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Compte_Utilisateur` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
