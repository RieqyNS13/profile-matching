-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2018 at 09:49 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_alternatif`
--

CREATE TABLE `tbl_alternatif` (
  `id` int(10) NOT NULL,
  `kode` varchar(10) DEFAULT NULL,
  `nama_alternatif` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_alternatif`
--

INSERT INTO `tbl_alternatif` (`id`, `kode`, `nama_alternatif`) VALUES
(2, '4611416002', 'Midare Toushirou'),
(3, '4611416026', 'Ryuunosuke Akasaka\r\n'),
(4, '4611416028', 'Kashuu Kiyomitsu'),
(5, '4611416012', 'Yamatonokami Yasusada'),
(6, '4611416011', 'Mikazuki Munechika'),
(7, '4611416009', 'Tsurumaru Kuninaga'),
(8, '4611416014', 'Izuminokami Kanesada'),
(9, '4611416001', 'Yamanbagiri Kunihiro '),
(15, '4611416027', 'いずみのかみかねさだ'),
(19, '4611416013', 'Kogitsunemaru');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_aspek`
--

CREATE TABLE `tbl_aspek` (
  `id` int(10) NOT NULL,
  `kode` varchar(10) DEFAULT NULL,
  `nama_aspek` varchar(30) DEFAULT NULL,
  `persentase` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_aspek`
--

INSERT INTO `tbl_aspek` (`id`, `kode`, `nama_aspek`, `persentase`) VALUES
(3, 'A1', 'Aspek Survival', 20),
(15, 'A2', 'Aspek Killing Blow', 30),
(16, 'A3', 'Aspek Range', 50);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kriteria`
--

CREATE TABLE `tbl_kriteria` (
  `id` int(10) NOT NULL,
  `id_aspek` int(10) NOT NULL,
  `kode` varchar(30) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `nilai` int(4) NOT NULL,
  `factor` enum('1','2') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_kriteria`
--

INSERT INTO `tbl_kriteria` (`id`, `id_aspek`, `kode`, `nama_kriteria`, `nilai`, `factor`) VALUES
(3, 3, 'A1a', 'Kriteria 1', 6, '1'),
(4, 15, 'A21', 'Jancok', 9, '2'),
(5, 3, 'A12', 'asdadad', 5, '2'),
(6, 3, 'A15', 'Asdad', 6, '1'),
(7, 15, 'A22', 'Kontol kau', 7, '1'),
(8, 16, 'A31', 'Bajingan 1', 6, '1'),
(9, 16, 'A32', 'Bajingan 2', 4, '1'),
(10, 16, 'A33', 'Bajingan 3', 5, '2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_profile`
--

CREATE TABLE `tbl_profile` (
  `id` int(10) NOT NULL,
  `id_alternatif` int(10) NOT NULL,
  `id_kriteria` int(10) NOT NULL,
  `nilai_profile` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_profile`
--

INSERT INTO `tbl_profile` (`id`, `id_alternatif`, `id_kriteria`, `nilai_profile`) VALUES
(1, 9, 3, 5),
(2, 9, 5, 3),
(3, 9, 6, 3),
(4, 19, 3, 5),
(5, 19, 5, 3),
(6, 19, 6, 4),
(7, 15, 3, 6),
(8, 15, 5, 5),
(9, 15, 6, 3),
(10, 4, 6, 4),
(11, 4, 3, 4),
(12, 4, 5, 3),
(13, 5, 5, 6),
(14, 5, 3, 4),
(15, 5, 6, 6),
(16, 2, 4, 5),
(17, 2, 7, 6),
(18, 19, 4, 3),
(19, 19, 7, 4),
(20, 2, 3, 4),
(21, 2, 5, 4),
(22, 2, 6, 4),
(23, 4, 4, 7),
(24, 4, 7, 5),
(25, 5, 4, 5),
(26, 5, 7, 7),
(27, 9, 4, 7),
(28, 9, 7, 4),
(29, 15, 7, 4),
(30, 15, 4, 5),
(31, 2, 8, 6),
(32, 2, 9, 5),
(33, 2, 10, 4),
(34, 19, 8, 3),
(35, 19, 9, 4),
(36, 19, 10, 6),
(37, 5, 10, 6),
(38, 5, 9, 6),
(39, 5, 8, 6),
(40, 4, 8, 6),
(41, 4, 10, 6),
(42, 4, 9, 6),
(43, 8, 8, 4),
(44, 8, 9, 5),
(45, 8, 10, 4),
(46, 9, 8, 7),
(47, 9, 9, 6),
(48, 9, 10, 7),
(49, 15, 8, 7),
(50, 15, 9, 5),
(51, 15, 10, 6),
(52, 8, 4, 6),
(53, 8, 7, 3),
(54, 8, 3, 3),
(55, 8, 5, 3),
(56, 8, 6, 5),
(57, 7, 3, 6),
(58, 7, 5, 7),
(59, 7, 6, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_alternatif`
--
ALTER TABLE `tbl_alternatif`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_aspek`
--
ALTER TABLE `tbl_aspek`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aspek_idx` (`id_aspek`) USING BTREE;

--
-- Indexes for table `tbl_profile`
--
ALTER TABLE `tbl_profile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kriteria_idx` (`id_alternatif`,`id_kriteria`),
  ADD KEY `id_kriteria` (`id_kriteria`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_alternatif`
--
ALTER TABLE `tbl_alternatif`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbl_aspek`
--
ALTER TABLE `tbl_aspek`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_profile`
--
ALTER TABLE `tbl_profile`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  ADD CONSTRAINT `tbl_kriteria_ibfk_1` FOREIGN KEY (`id_aspek`) REFERENCES `tbl_aspek` (`id`);

--
-- Constraints for table `tbl_profile`
--
ALTER TABLE `tbl_profile`
  ADD CONSTRAINT `tbl_profile_ibfk_1` FOREIGN KEY (`id_kriteria`) REFERENCES `tbl_kriteria` (`id`),
  ADD CONSTRAINT `tbl_profile_ibfk_2` FOREIGN KEY (`id_alternatif`) REFERENCES `tbl_alternatif` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
