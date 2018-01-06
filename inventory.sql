-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 20, 2016 at 08:58 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inventory`
--
CREATE DATABASE IF NOT EXISTS `inventory` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `inventory`;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Id` int(10) DEFAULT NULL,
  `First_Name` varchar(30) DEFAULT NULL,
  `Middle_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) DEFAULT NULL,
  `Birthday` date NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Contact` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `P_Id` int(11) NOT NULL DEFAULT '0',
  `P_Name` varchar(30) NOT NULL,
  `Quantity` varchar(20) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`P_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE IF NOT EXISTS `signup` (
  `User_Id` int(11) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Status` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Confirm_Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `Supplier_Id` int(11) DEFAULT NULL,
  `First_Name` varchar(30) DEFAULT NULL,
  `Middle_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) DEFAULT NULL,
  `Address` varchar(50) NOT NULL,
  `Contact` int(10) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
