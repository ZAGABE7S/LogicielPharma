-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 28 Août 2018 à 08:52
-- Version du serveur: 5.5.8
-- Version de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `pharmaciestock`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `date_ca` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`, `date_ca`) VALUES
(1, 'Sirop', '2018-08-21'),
(2, 'Categorie effervescent', '2018-08-21'),
(3, 'complime', '2018-08-15');

-- --------------------------------------------------------

--
-- Structure de la table `entree`
--

CREATE TABLE IF NOT EXISTS `entree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_produit` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `entree`
--

INSERT INTO `entree` (`id`, `nom_produit`, `date`, `quantite`, `username`) VALUES
(1, 'paragorique', '2018-08-21', 7, 'nicolas-raphael'),
(2, 'paragoriqueCP', '2018-08-22', 10, 'nicolas-raphael'),
(3, 'bien', '2018-08-27', 1000, 'nicolas-raphael');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `produit` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fournisseur`
--


-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_produit` varchar(255) NOT NULL,
  `categorie` varchar(255) NOT NULL,
  `posologie` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom_produit` (`nom_produit`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `nom_produit`, `categorie`, `posologie`, `quantite`) VALUES
(1, 'paracetamole', 'Sirop', 'posologie 4 par jour', 0),
(3, 'paragorique', 'Categorie effervescent', '', 5),
(4, 'bien', 'Categorie effervescent', '2/jour', 999),
(5, 'paragoriqueCP', 'complime', 'posologie', 6);

-- --------------------------------------------------------

--
-- Structure de la table `sortie`
--

CREATE TABLE IF NOT EXISTS `sortie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_produit` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `sortie`
--

INSERT INTO `sortie` (`id`, `nom_produit`, `date`, `quantite`, `username`) VALUES
(1, 'paragorique', '2018-08-21', 1, 'worn.succes@yahoo.fr'),
(2, 'paragorique', '2018-08-22', 1, 'oubda_p22'),
(3, 'paragoriqueCP', '2018-08-22', 4, 'oubda_p22'),
(4, 'bien', '2018-08-12', 1, 'oubda_p22');
