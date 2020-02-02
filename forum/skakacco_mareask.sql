-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2020 at 05:48 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skakacco_mareask`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `AnswerID` int(15) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Text` mediumtext NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `Date` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`AnswerID`, `UserID`, `Text`, `QuestionID`, `Date`) VALUES
(28, 1, 'No.', 36, 1518009561),
(29, 1, 'Test', 37, 1518991398),
(30, 1, 'asdasd', 37, 1518991404);

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

CREATE TABLE `countries` (
  `CountryID` int(15) NOT NULL,
  `CountryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `countries`
--

INSERT INTO `countries` (`CountryID`, `CountryName`) VALUES
(1, 'Serbia'),
(2, 'Romania'),
(3, 'Bulgaria'),
(4, 'Greece');

-- --------------------------------------------------------

--
-- Table structure for table `poll_votes`
--

CREATE TABLE `poll_votes` (
  `UserID` int(10) NOT NULL,
  `Answer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poll_votes`
--

INSERT INTO `poll_votes` (`UserID`, `Answer`) VALUES
(1, 'Yes'),
(26, 'No'),
(28, 'No'),
(34, 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `QuestionID` int(20) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Date` int(15) NOT NULL,
  `AuthorID` int(15) NOT NULL,
  `Description` mediumtext NOT NULL,
  `Views` int(10) NOT NULL DEFAULT '0',
  `Locked` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`QuestionID`, `Title`, `Date`, `AuthorID`, `Description`, `Views`, `Locked`) VALUES
(32, 'How can I store interpolations into objects', 1518561471, 26, 'I m writing a webapp that allows users to choose a fellow teammate theyve worked with from a dropdown menu and then answer questions with that person in mind to provide their coworkers with some feedback. ', 7, 1),
(33, 'Firebase storage image by username', 1518561471, 1, 'I have saved my users profileimages in Firebase storage by username.\r\n\r\nHow do I retrieve the image by a user', 1, 0),
(34, 'How to I set up nodeJS to pull data from a spreadsheet', 1518561471, 1, 'I trying to develop a node JS script that pulls data from a spreadsheet to use in the script.\r\n\r\nMy script starts like this', 1, 1),
(35, 'Net Core Versions questions', 1518561471, 1, 'I followed official documentation on how to work with net core in Visual Studio 2015, and get it working, but still I cannot understand versions.', 1, 0),
(37, 'Python imported module dependency', 1518561471, 1, 'mymodule.py gives an error that math is not defined, even though its parent module has it imported.', 1, 0),
(40, 'proba unosa novog', 20200202, 1, 'hbvfgn', 0, 0),
(44, 'Razvoj softvera upotrebom .NET tehnologija54', 20200202, 26, 'KOJKOKOK', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `RoleID` int(15) NOT NULL,
  `RoleName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`RoleID`, `RoleName`) VALUES
(1, 'User'),
(2, 'Moderator'),
(3, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `Pass` varchar(50) NOT NULL,
  `Nick` varchar(30) NOT NULL,
  `Mail` varchar(255) NOT NULL,
  `Avatar` varchar(255) NOT NULL DEFAULT 'img/avatars/default-avatar.jpg',
  `RoleID` int(10) NOT NULL DEFAULT '1',
  `Active` int(1) NOT NULL DEFAULT '0',
  `CountryID` int(5) NOT NULL,
  `JoinDate` int(11) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `Pass`, `Nick`, `Mail`, `Avatar`, `RoleID`, `Active`, `CountryID`, `JoinDate`, `Gender`, `Code`) VALUES
(1, 'ec5e29f773a92ee4599b234db848ef8f', 'Mare', 'lsfmare@gmail.com', '/img/avatars/c.png', 3, 1, 1, 1518561471, 'Male', ''),
(24, '83dc3c89e1abf7a58d35c87599f1b3bc', 'Test', 'uncut.wz@gmail.com', '/img/avatars/default-avatar.jpg', 1, 0, 1, 1518561471, 'Male', 'b557e2b03b'),
(25, '21fca2998f32c840309a3df6b5f3af0a', 'Test1', 'n228432@mvrht.com', '/img/avatars/c.png', 2, 1, 3, 1518561471, 'Male', '729bcab100'),
(26, 'ec5e29f773a92ee4599b234db848ef8f', 'User123', 'n234940@mvrht.com', '/img/avatars/default-avatar.jpg', 1, 1, 4, 1518561471, 'Male', ''),
(27, 'ec5e29f773a92ee4599b234db848ef8f', 'John', 'n253260@mvrht.com', '/img/avatars/default-avatar.jpg', 1, 0, 3, 1518561471, 'Male', 'fea7f83b12'),
(28, 'ec5e29f773a92ee4599b234db848ef8f', 'Micheal', 'ees38171@diwaq.com', '/img/avatars/default-avatar.jpg', 2, 1, 3, 1518561471, 'Female', '710c761932'),
(32, '68eacb97d86f0c4621fa2b0e17cabd8c', 'Test123', 'test123@test.com', '/img/avatars/default-avatar.jpg', 1, 0, 1, 1518561471, 'Male', 'bd172e1472'),
(33, 'ec5e29f773a92ee4599b234db848ef8f', 'Test2', 'z112372@mvrht.net', '/img/avatars/default-avatar.jpg', 1, 1, 4, 1518561471, 'Male', '9b3dc74f09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`AnswerID`);

--
-- Indexes for table `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`CountryID`);

--
-- Indexes for table `poll_votes`
--
ALTER TABLE `poll_votes`
  ADD UNIQUE KEY `UserID` (`UserID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`QuestionID`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`RoleID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `Nick` (`Nick`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `AnswerID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `countries`
--
ALTER TABLE `countries`
  MODIFY `CountryID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `QuestionID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `RoleID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
