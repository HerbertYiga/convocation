-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2018 at 12:51 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `convocation`
--

-- --------------------------------------------------------

--
-- Table structure for table `messagesbody`
--

CREATE TABLE IF NOT EXISTS `messagesbody` (
  `messageBodyId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `headingId` int(10) unsigned NOT NULL,
  `messageBody` varchar(600) NOT NULL,
  PRIMARY KEY (`messageBodyId`),
  KEY `headingId` (`headingId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `messagesheading`
--

CREATE TABLE IF NOT EXISTS `messagesheading` (
  `headingId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `theHeading` varchar(200) NOT NULL,
  PRIMARY KEY (`headingId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `notices`
--

CREATE TABLE IF NOT EXISTS `notices` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `noticeHeading` varchar(200) NOT NULL,
  `noticeBody` varchar(500) NOT NULL,
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `notices`
--

INSERT INTO `notices` (`noticeId`, `noticeHeading`, `noticeBody`) VALUES
(6, 'WE ONLY GIVE UP WHEN ITS DONE', 'The ugandan Gonverment truly loves its people'),
(7, 'Students meeting on 24th ', 'Please make sure that  you attend the meeting of 29th');

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

CREATE TABLE IF NOT EXISTS `studentdetails` (
  `courseStudied` varchar(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `imageLink` varchar(20) NOT NULL,
  `phoneNumber` int(15) NOT NULL,
  `regNo` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password1` varchar(20) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `studentdetails`
--

INSERT INTO `studentdetails` (`courseStudied`, `id`, `email`, `imageLink`, `phoneNumber`, `regNo`, `username`, `password1`, `fullName`) VALUES
('BITC', 1, 'herbertyiga@gmail.com', 'bobi.jpg', 701228625, '12/u/8673/393', 'null', 'null', 'jef'),
('bitc', 2, 'herbertyiga@gmail.com', 'cos1.jpg', 701228625, '12/u/8673/3932', 'joice', '12', 'herbert Yiga'),
('BITC', 3, 'herbertyiga@gmail.com', 'two.jpg', 12, '12/u/8673/39311', 'tom', '12', 'herbert Yiga'),
('BITC', 4, 'herbertyiga@gmail.com', 'three.jpg', 81112, '12/u/8673/39389', 'jonah', 'ww', 'herbert Yiga');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phoneNumber` int(50) NOT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `username`, `password`, `phoneNumber`, `enable`) VALUES
(3, 'aki', 't5', 701228625, 1),
(5, 'john', '11', 701228625, 1),
(8, 'jesi', 'TUNU', 701228625, 1),
(9, 'job', 'MGQ3', 701228625, 1),
(10, 'jonah', 'G3M6', 701228625, 1),
(11, 'ew', 'XK91', 701228625, 0),
(13, 'jovia', 'EFJY', 701228625, 1),
(14, 'jonhken', '25B7', 702346637, 1),
(15, 'herbert', 'VDRO', 701228625, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `userRoleId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(10) unsigned NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`userRoleId`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`userRoleId`, `userId`, `authority`) VALUES
(3, 3, 'ROLE_ADMIN'),
(5, 5, 'ROLE_USER'),
(8, 8, 'ROLE_USER'),
(9, 9, 'ROLE_USER'),
(10, 10, 'ROLE_ADMIN'),
(11, 11, 'ROLE_USER'),
(13, 13, 'ROLE_USER'),
(14, 14, 'ROLE_USER'),
(15, 15, 'ROLE_USER');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `messagesbody`
--
ALTER TABLE `messagesbody`
  ADD CONSTRAINT `messagesbody_ibfk_1` FOREIGN KEY (`headingId`) REFERENCES `messagesheading` (`headingId`) ON DELETE CASCADE;

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
