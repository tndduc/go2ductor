-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 29, 2023 at 05:27 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `go2doctor`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `end_dt_time` datetime DEFAULT NULL,
  `start_dt_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `id_patient` bigint(20) DEFAULT NULL,
  `id_physician` bigint(20) NOT NULL,
  `id_room` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `title`, `end_dt_time`, `start_dt_time`, `status`, `id_patient`, `id_physician`, `id_room`) VALUES
(1, 'okela', '2023-04-23 22:06:03', '2023-04-23 18:06:03', 'patient_confirm', 1, 1, 1),
(2, NULL, '2023-04-23 22:06:03', '2023-04-23 18:06:03', 'available', 1, 1, 1),
(3, NULL, '2023-04-22 05:06:03', '2023-04-22 03:06:03', 'available', 1, 1, 1),
(4, NULL, '2023-04-14 05:06:03', '2023-04-13 19:06:03', 'available', 1, 1, 1),
(5, NULL, '2023-04-30 05:06:03', '2023-04-29 19:06:03', 'available', 1, 1, 1),
(8, NULL, '2023-05-23 14:06:03', '2023-05-23 15:06:03', 'available', NULL, 1, 1),
(7, NULL, '2023-05-02 05:06:03', '2023-05-02 00:00:00', 'available', 1, 1, 1),
(9, NULL, '2023-02-02 15:06:03', '2023-02-02 14:06:03', 'Patient Booking', 2, 5, 1),
(12, NULL, '2023-05-02 23:05:00', '2023-05-02 23:05:00', 'available', 1, 5, 1),
(11, NULL, '2023-05-02 23:03:00', '2023-05-02 23:03:00', 'physician_confirm', 1, 5, 2),
(13, 'New Appointment', '2023-05-02 23:11:00', '2023-05-02 23:11:00', 'Patient Booking', 2, 5, 2),
(14, NULL, '2023-05-02 23:15:00', '2023-05-02 23:15:00', 'available', 1, 5, 2),
(15, NULL, '2023-05-02 23:16:00', '2023-05-02 23:16:00', 'Patient Booking', 2, 5, 1),
(16, NULL, '2023-05-02 23:19:00', '2023-05-02 23:19:00', 'Patient Booking', 2, 5, 1),
(17, NULL, '2023-05-02 23:21:00', '2023-05-02 23:21:00', 'available', NULL, 5, 1),
(18, NULL, '2023-05-02 23:22:00', '2023-05-02 23:22:00', 'available', NULL, 5, 1),
(19, NULL, '2023-05-02 23:25:00', '2023-05-02 23:25:00', 'available', NULL, 5, 1),
(20, NULL, '2023-05-02 23:05:00', '2023-05-02 23:05:00', 'patient_confirm', 1, 5, 2),
(21, NULL, '2023-05-02 23:05:00', '2023-05-02 23:05:00', 'physician_confirm', 1, 5, 2),
(22, NULL, '2023-05-02 23:05:00', '2023-05-02 23:05:00', 'physician_confirm', 1, 5, 1),
(23, NULL, '2023-01-02 23:05:00', '2023-01-02 23:05:00', 'available', 1, 5, 2),
(24, NULL, '2023-05-02 23:05:00', '2023-05-02 23:05:00', 'patient_confirm', 1, 5, 1),
(25, NULL, '2023-05-02 23:05:00', '2023-05-02 23:05:00', 'patient_confirm', 1, 5, 1),
(26, NULL, '2023-05-07 21:38:00', '2023-05-07 21:38:00', 'available', NULL, 5, 1),
(27, NULL, '2023-05-07 21:38:00', '2023-05-07 21:38:00', 'available', NULL, 5, 1),
(47, 'New Appointment', '2023-06-03 09:29:00', '2023-06-03 09:29:00', 'Patient Booking', 2, 5, 1),
(46, 'New Appointment', '2023-05-12 20:54:00', '2023-05-12 20:54:00', 'available', 1, 5, 2),
(45, 'New Appointment', '2023-05-12 08:34:00', '2023-05-12 08:34:00', 'available', 1, 5, 2),
(44, 'New Appointment', '2023-05-11 21:14:00', '2023-05-11 21:14:00', 'available', 1, 5, 1),
(43, 'New Appointment', '2023-05-11 21:14:00', '2023-05-11 21:14:00', 'available', 1, 5, 2),
(42, NULL, '2023-05-11 21:12:00', '2023-05-11 21:12:00', 'patient_confirm', 1, 5, 1),
(48, 'New Appointment', '2023-06-03 09:29:00', '2023-06-03 09:29:00', 'physician_confirm', NULL, 5, 1),
(49, 'New Appointment', '2023-06-09 20:12:00', '2023-06-09 19:12:00', 'available', NULL, 5, 1),
(50, 'New Appointment', '2023-06-10 20:19:00', '2023-06-10 20:19:00', 'Patient Booking', 2, 5, 1),
(51, 'New Appointment', '2023-06-09 23:30:00', '2023-06-09 22:30:00', 'Patient Booking', 2, 5, 1),
(54, 'New Appointment', '2023-06-14 10:30:00', '2023-06-14 08:30:00', 'available', NULL, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `medical_history`
--

CREATE TABLE `medical_history` (
  `id` bigint(20) NOT NULL,
  `date_re_examination` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `appointment_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `medical_history`
--

INSERT INTO `medical_history` (`id`, `date_re_examination`, `note`, `status`, `appointment_id`) VALUES
(1, NULL, 'string', 'ducker', 1),
(2, NULL, 'string', 'update', 2),
(4, NULL, 'string', 'string', 4),
(5, NULL, 'string', 'string', 5),
(6, NULL, 'she still okela ', 'okela', 8),
(13, NULL, 'on update 1', 'update hehe', 7),
(14, NULL, 'string', 'Waiting for payment', 25),
(15, NULL, 'on pay', 'watting', 42),
(16, NULL, 'okelaaa', 'string', 51),
(17, NULL, 'duck at dusk', 'Waiting for payment', 50);

-- --------------------------------------------------------

--
-- Table structure for table `medician`
--

CREATE TABLE `medician` (
  `id` bigint(20) NOT NULL,
  `composition` varchar(255) DEFAULT NULL,
  `contraindications` varchar(255) DEFAULT NULL,
  `dosage_form` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `indications` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `side_effects` varchar(255) DEFAULT NULL,
  `storage_instructions` varchar(255) DEFAULT NULL,
  `strength` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `medician`
--

INSERT INTO `medician` (`id`, `composition`, `contraindications`, `dosage_form`, `image`, `indications`, `manufacturer`, `name`, `price`, `side_effects`, `storage_instructions`, `strength`) VALUES
(3, '1', '1', '1', '1', '1', '1', '1', '1.00', '1', '1', '1'),
(2, '2', '2', '2', '2', '2', '2', '2', '2.00', '2', '2', '2');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `health_insurance` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `dob`, `first_name`, `health_insurance`, `id_card`, `image`, `last_name`, `note`, `password`, `phone`, `sex`, `username`) VALUES
(1, NULL, 'Duck', '1', '1', '1', 'Baka', '1', '1', '1', '1', '1'),
(2, NULL, 'Duck', NULL, 'string', 'E:/Program files/Intellij/IntelliJ IDEA Community Edition 2022.3.1/Spring Project/go2ductor/src/main/resources/static/images/269991461_321481763202676_5134771183316457137_n.png', 'At Dusk', NULL, '$2a$10$xfYOWgNRbakhV9Yltf7kN.D2Y1Sp7r0lJAWKBEBzQTtZwTmiFyaja', NULL, NULL, '123');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL,
  `date` time DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `service` varchar(255) DEFAULT NULL,
  `id_medical_history` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `physician`
--

CREATE TABLE `physician` (
  `id` bigint(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `physician`
--

INSERT INTO `physician` (`id`, `dob`, `education`, `experience`, `first_name`, `id_card`, `image`, `last_name`, `note`, `password`, `phone`, `sex`, `specialization`, `username`) VALUES
(1, NULL, NULL, NULL, '123', '321', 'E:/Image/duck/315199745_543780020918152_721970736603803744_n.jpg', '123', NULL, '$2a$10$66eh2BPnAg.Q.F8CaKSgzOkWZ7WN3qaSAFLVqnx0sTsHADAKD9GCa', NULL, NULL, NULL, 'string'),
(2, NULL, NULL, NULL, 'Duck', '123321', 'E:/Image/duck/Screenshot 2023-04-14 063112.png', 'Ky', NULL, '$2a$10$8xQfDxJNWcUMjyD3E.GEde/Isf0j6pnnQVOtCNLygaqsqaMstVKje', NULL, NULL, NULL, 'string1'),
(3, NULL, NULL, NULL, 'duc', '321123', '334958014_130713109724883_1906010329443841685_n.png', 'ker', NULL, '$2a$10$kOmiROOLNaarABKHB7jme.48I7x.91fho7eXCLJDxoAOfb3aXynf.', NULL, NULL, NULL, 'string2'),
(4, NULL, NULL, NULL, 'ewq', 'qưe', '2.jpg', 'string5', NULL, '$2a$10$.ntviv/KShGbVhKBMbLY3uPJUJyNxXAz.zSkYTwiuxB8zudDSedEG', NULL, NULL, NULL, 'ewq'),
(5, NULL, NULL, NULL, 'Ducker', 'qưe', '2.jpg', 'Doger', NULL, '$2a$10$y0KRuv7gPMqh6.ckpLi68OFsPcnBhh5xipTRYBE88fB0my2ODNtZ2', NULL, NULL, NULL, 'string5'),
(6, NULL, NULL, NULL, 'ewq', 'qưe', '76874304.png', 'string5', NULL, '$2a$10$/fpK.CkPUkbikxG/cZmbDuX8h8e3ZQ0Z9mVpMxDCufbFqW5bHnlne', NULL, NULL, NULL, 'string6');

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `id` bigint(20) NOT NULL,
  `dosage` varchar(255) DEFAULT NULL,
  `id_medical_history` bigint(20) DEFAULT NULL,
  `id_medicine` bigint(20) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`id`, `dosage`, `id_medical_history`, `id_medicine`, `amount`, `price`) VALUES
(2, 'string', 5, 1, 4, NULL),
(12, 'once a day', 13, 1, 5, NULL),
(11, 'twice a day', 13, 2, 4, NULL),
(13, 'once a day', 14, 1, 15, '1.00'),
(14, 'once a day', 15, 1, 16, '1.00'),
(15, 'twice a day', 16, 3, 10, '1.00'),
(16, 'twice a day', 17, 2, 4, '2.00'),
(17, 'once a day', 17, 3, 10, '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `id_medical_history` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `service` varchar(255) DEFAULT NULL,
  `working_hours` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `name`, `position`, `service`, `working_hours`) VALUES
(1, '101', 'tầng 1 phòng 1', 'Tai mũi họng', '1'),
(2, '102', 'Tầng 1 phòng 2', 'Da liễu', '7h-11h \r\n13h30-16h30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7mgsjrxjhqelje801yaod8c10` (`id_patient`),
  ADD KEY `FK83gvuwls4stcirtppuxna90bl` (`id_physician`),
  ADD KEY `FK212hx6nouxiwufobhnelcrijp` (`id_room`);

--
-- Indexes for table `medical_history`
--
ALTER TABLE `medical_history`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_kkam2qbfb4dupity22s3phcgx` (`appointment_id`);

--
-- Indexes for table `medician`
--
ALTER TABLE `medician`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_oehrri31n7ywy72m6930l1dmb` (`id_medical_history`);

--
-- Indexes for table `physician`
--
ALTER TABLE `physician`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK96negael57fy2ouj0c98nwqrw` (`id_medical_history`),
  ADD KEY `FKiqw5v2d4b4l5jlpw6v463llc5` (`id_medicine`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiegbfh5p76msmqg3k8saysll7` (`id_medical_history`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `medical_history`
--
ALTER TABLE `medical_history`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `medician`
--
ALTER TABLE `medician`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `physician`
--
ALTER TABLE `physician`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
