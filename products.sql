-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 20 déc. 2020 à 23:07
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `products`
--

-- --------------------------------------------------------

--
-- Structure de la table `assiettecarree`
--

CREATE TABLE `assiettecarree` (
  `id` int(11) NOT NULL,
  `dateDeFabriquation` int(11) NOT NULL,
  `prix` double NOT NULL,
  `cote` double NOT NULL,
  `surface` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `assiettecarree`
--

INSERT INTO `assiettecarree` (`id`, `dateDeFabriquation`, `prix`, `cote`, `surface`) VALUES
(2, 1900, 355, 12, 144);

-- --------------------------------------------------------

--
-- Structure de la table `assietteronde`
--

CREATE TABLE `assietteronde` (
  `id` int(11) NOT NULL,
  `dateDeFabriquation` int(11) NOT NULL,
  `prix` double NOT NULL,
  `rayon` double NOT NULL,
  `surface` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `assietteronde`
--

INSERT INTO `assietteronde` (`id`, `dateDeFabriquation`, `prix`, `rayon`, `surface`) VALUES
(5, 1990, 20, 10, 314),
(6, 1990, 10, 20, 30),
(7, 1950, 40, 10, 314),
(8, 1990, 12, 12, 452.16),
(9, 1900, 75, 12, 452.16);

-- --------------------------------------------------------

--
-- Structure de la table `cuillere`
--

CREATE TABLE `cuillere` (
  `id` int(11) NOT NULL,
  `dateDeFabriquation` int(11) NOT NULL,
  `prix` double NOT NULL,
  `longueur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cuillere`
--

INSERT INTO `cuillere` (`id`, `dateDeFabriquation`, `prix`, `longueur`) VALUES
(1, 0, 0, 0),
(2, 0, 0, 0),
(3, 1990, 10.22, 13),
(4, 1990, 10.22, 13),
(5, 1990, 10.22, 13),
(6, 1990, 10.22, 13),
(7, 1990, 10, 12),
(9, 2002, 20.22, 35.5),
(10, 1990, 10, 10),
(11, 0, 20.22, 20),
(12, 0, 12.12, 12),
(13, 1999, 12, 12),
(14, 1111, 12, 112);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `assiettecarree`
--
ALTER TABLE `assiettecarree`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `assietteronde`
--
ALTER TABLE `assietteronde`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cuillere`
--
ALTER TABLE `cuillere`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `assiettecarree`
--
ALTER TABLE `assiettecarree`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `assietteronde`
--
ALTER TABLE `assietteronde`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `cuillere`
--
ALTER TABLE `cuillere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
