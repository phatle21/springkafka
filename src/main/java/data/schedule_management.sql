-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2023 at 07:02 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schedule_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `id_schedule` int(11) NOT NULL,
  `notification` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `user`, `id_schedule`, `notification`) VALUES
(5, 'krulb01', 2, 0),
(6, 'krul', 253, 1),
(154, 'krul', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `register_seq`
--

CREATE TABLE `register_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register_seq`
--

INSERT INTO `register_seq` (`next_val`) VALUES
(251);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `owner` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id`, `name`, `owner`) VALUES
(1, 'Work at AA schedule', 'krul'),
(2, 'Work at BB schedule', 'darkie'),
(3, 'Work at CC schedule', 'krulb01'),
(52, 'Work at DD schedule', 'krul'),
(53, 'Work at RR schedule', 'krul'),
(202, 'Work at KK schedule', 'darkie'),
(203, 'Work at LL schedule', 'darkie'),
(253, 'Work at EE schedule', 'krulb01');

-- --------------------------------------------------------

--
-- Table structure for table `schedule_seq`
--

CREATE TABLE `schedule_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedule_seq`
--

INSERT INTO `schedule_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `id_schedule` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `date_created` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `id_schedule`, `name`, `description`, `date_created`) VALUES
(1, 1, 'Task 1', 'Do all mission in task one', '2023-04-11'),
(53, 2, 'Task three', 'Go to ACB bookstore', '2023-04-27'),
(54, 3, 'Task 4', 'Do missions in task 4', '2023-04-27'),
(103, 53, 'Hang out ', 'Hang out for events', '2023-04-28'),
(152, 1, 'Go to school', 'AA misssion is go to school', '2023-04-28'),
(202, 53, 'Kafka task', 'Push msg to kafka when task was created', '2023-04-30'),
(253, 4, 'Kafka send msg', 'Make kafka send msg', '2023-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `task_complete`
--

CREATE TABLE `task_complete` (
  `id` int(11) NOT NULL,
  `id_task` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `complete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task_complete`
--

INSERT INTO `task_complete` (`id`, `id_task`, `user`, `complete`) VALUES
(1, 53, 'krul', 1),
(2, 53, 'krulb01', 1),
(102, 103, 'krul', 1);

-- --------------------------------------------------------

--
-- Table structure for table `task_complete_seq`
--

CREATE TABLE `task_complete_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task_complete_seq`
--

INSERT INTO `task_complete_seq` (`next_val`) VALUES
(251);

-- --------------------------------------------------------

--
-- Table structure for table `task_seq`
--

CREATE TABLE `task_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task_seq`
--

INSERT INTO `task_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `fullname` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `fullname`) VALUES
('darkie', '123', 'darkie'),
('krul', '123', 'krulzilla'),
('krulb01', '123', 'krul zZz');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task_complete`
--
ALTER TABLE `task_complete`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=254;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=254;

--
-- AUTO_INCREMENT for table `task_complete`
--
ALTER TABLE `task_complete`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
