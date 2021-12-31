-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 31, 2021 at 02:44 PM
-- Server version: 5.7.24
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE `director` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `director`
--

INSERT INTO `director` (`id`, `name`, `user_id`) VALUES
(1, 'Aidar Sharshenkulov', 1);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` int(11) NOT NULL,
  `time_of_work` varchar(255) DEFAULT NULL,
  `weekend` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`id`, `name`, `salary`, `time_of_work`, `weekend`, `user_id`) VALUES
(1, 'Ersultan Ismailov', 20002, '14:30-18:30', 'Monday', 2),
(2, 'Alaken Kubatbekov', 30000, '12:30-20:30', 'Voskresenje', 12),
(3, 'Sam ', 2000, '14:30-15:30', 'Montag', 16);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `role_prefix` varchar(255) DEFAULT 'ROLE_',
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `role_prefix`, `password`, `username`) VALUES
(1, 'ROLE_', 'aidar2002', 'Aidar'),
(2, 'ROLE_', 'ersultan2002', 'Ersultan'),
(8, 'ROLE_', 'adis2002', 'Adis'),
(9, 'ROLE_', 'ismail2021', 'Ismail'),
(12, 'ROLE_', 'alaken2002', 'Alaken'),
(15, 'ROLE_', 'aibike2002', 'Aibike'),
(16, 'ROLE_', 'wjdfsf', 'kkdkd');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'DIRECTOR'),
(2, 'MANAGER'),
(8, 'WORKER'),
(9, 'WORKER'),
(12, 'MANAGER'),
(15, 'WORKER'),
(16, 'MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prize` int(11) NOT NULL,
  `salary` int(11) NOT NULL,
  `time_of_work` varchar(255) DEFAULT NULL,
  `weekend` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`id`, `name`, `prize`, `salary`, `time_of_work`, `weekend`, `user_id`) VALUES
(6, 'Adis Kerimov', 0, 2000, '15:30-15:25', 'Sunday', 8),
(7, 'Ismail Akhmetov', 200, 2002, '20:30-20:32', 'All days', 9),
(15, 'Maksutova Aibike', 0, 430, '14:30-20:30', 'Donnerstag', 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK77iek92hi44rrcf60u15uv98f` (`user_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe4b084ktygfqnia0gc5u396h0` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`);

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc8gmqke88cu4hspkgxrto85wt` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `director`
--
ALTER TABLE `director`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `director`
--
ALTER TABLE `director`
  ADD CONSTRAINT `FK77iek92hi44rrcf60u15uv98f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `FKe4b084ktygfqnia0gc5u396h0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `worker`
--
ALTER TABLE `worker`
  ADD CONSTRAINT `FKc8gmqke88cu4hspkgxrto85wt` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
