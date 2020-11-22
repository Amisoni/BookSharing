-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 01, 2020 at 10:10 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id12346887_book_sharing`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_category`
--

CREATE TABLE `book_category` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(200) NOT NULL,
  `photo` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_category`
--

INSERT INTO `book_category` (`c_id`, `c_name`, `photo`) VALUES
(1, 'General Knowledge', '../images/balb.png'),
(2, 'Management', '../images/Dolar.png'),
(3, 'Coding', '../images/Code.png'),
(4, 'Technical', '../images/Setting.png'),
(5, 'Architecture', '../images/Bag.png'),
(6, 'Others', '../images/Dots.png');

-- --------------------------------------------------------

--
-- Table structure for table `donate_book`
--

CREATE TABLE `donate_book` (
  `d_id` int(11) NOT NULL,
  `book_name` varchar(200) NOT NULL,
  `author_name` varchar(200) NOT NULL,
  `publisher_name` varchar(200) NOT NULL,
  `edition` varchar(200) NOT NULL,
  `photo` varchar(600) NOT NULL,
  `book_detail` varchar(300) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `isActive` varchar(20) NOT NULL DEFAULT 'available',
  `book_category` varchar(100) NOT NULL,
  `r_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donate_book`
--

INSERT INTO `donate_book` (`d_id`, `book_name`, `author_name`, `publisher_name`, `edition`, `photo`, `book_detail`, `date`, `isActive`, `book_category`, `r_id`) VALUES
(31, 'java', 'pearson', 'oracle', '4th', 'java.png', 'this is a java book', '2020-02-26 06:18:46', 'available', 'Coding', 32),
(41, 'c programming', 'bala guruswami', 'pqr', '1st', 'cbalagu.jpg', 'javabook', '2020-02-26 11:49:47', 'available', 'Coding', 33),
(62, 'java', 'xyz', 'pqr', '1st', 'java.png', 'javabook', '2020-02-27 13:37:46', 'available', 'Coding', 28),
(63, 'PHP', ' Alan Forbes', 'Plum Island', 'Fifth Edition', 'php.jpg', 'This is the php book.', '2020-02-27 13:38:16', 'available', 'Coding', 33),
(64, 'Python', 'Anthony Brun', 'Eric Matthes', '1st', 'python.jpg', 'This is the Python Crash Course Book', '2020-02-27 13:39:21', 'available', 'Coding', 26),
(88, 'Financial ', 'Dr Anil Kumar dhagat', 'Kogent', 'Third', 'finacial.jpg', 'this is a finan book', '2020-02-27 23:47:29', 'available', 'Management', 27),
(89, 'Management Information System ', 'T lucy', '', '8th', 'mis.jpg', 'This is a management information book', '2020-02-27 23:49:42', 'available', 'Management', 35),
(90, 'General Knowledge', 'Dr p.k Panday', 'mahaveer publication', '2019', 'gk.jpg', 'This is a General Knowledge book', '2020-02-27 23:53:59', 'available', 'General Knowledge', 32),
(91, '2 States', 'Chetan Bhagat', 'Rupa Publications Pvt. Ltd', '', 'novel.jpg', '2 States: The Story of My Marriage', '2020-02-27 23:58:04', 'available', 'Other', 26),
(97, 'c++', 'abc', 'kk king', 'don', 'https://booksharing2020.000webhostapp.com/donate_book/c++.jpg', 'so so good', '2020-02-28 07:34:44', 'available', 'Technical', 32),
(98, 'c++', 'abc', 'kk king', 'don', 'https://booksharing2020.000webhostapp.com/donate_book/c++.jpg', 'so so good', '2020-02-28 07:34:51', 'available', 'Technical', 32),
(99, 'Deep Work', 'Cal Neeport', 'praful', '1st', 'https://booksharing2020.000webhostapp.com/donate_book/Deep Work.jpg', 'technical book for technical knowledge', '2020-02-28 08:29:03', 'available', 'Technical', 32);

-- --------------------------------------------------------

--
-- Table structure for table `imageinfo`
--

CREATE TABLE `imageinfo` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `url` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `imageinfo`
--

INSERT INTO `imageinfo` (`id`, `name`, `url`) VALUES
(11, '', 'https://booksharing2020.000webhostapp.com/uploads/.jpg'),
(10, 'Viral', 'https://booksharing2020.000webhostapp.com/uploads/Viral.jpg'),
(9, '', ''),
(8, 'ashish1', 'https://booksharing2020.000webhostapp.com/uploads/ashish1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL,
  `chat_room_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `myidea`
--

CREATE TABLE `myidea` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `myidea`
--

INSERT INTO `myidea` (`id`, `name`, `email`, `message`, `Date`) VALUES
(1, 'Ami Soni', 'amisoni1411@gmail.com', 'Digital platform for book sharing', '2020-02-28 05:42:42'),
(2, 'Reenal Patel', 'reenalpatel99@gmail.com', 'Gujrat Guide for guidance of all the districts of Gujarat', '2020-02-28 05:42:42'),
(3, 'Kajal Shah', 'shahkajal@gmail.com', 'Andriod is a mobile operating system based on a modified version of the kernal and other open source software.', '2020-02-28 05:44:33'),
(4, 'Aakash Patel', 'aakashpatel7979@gmail.com', 'Mobile Based attendance system. ', '2020-02-28 05:52:59');

-- --------------------------------------------------------

--
-- Table structure for table `receive_book`
--

CREATE TABLE `receive_book` (
  `id` int(11) NOT NULL,
  `book_name` varchar(200) NOT NULL,
  `authore` varchar(200) NOT NULL,
  `publisher` varchar(200) NOT NULL,
  `edition` varchar(200) NOT NULL,
  `d_id` varchar(200) NOT NULL,
  `photo` varchar(300) NOT NULL,
  `r_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receive_book`
--

INSERT INTO `receive_book` (`id`, `book_name`, `authore`, `publisher`, `edition`, `d_id`, `photo`, `r_id`) VALUES
(1, 'java', 'pearson', 'oracle', '4th', '32', 'java.png', 26),
(2, 'c programming', 'bala guruswami', 'pqr', '4th', '33', 'java.png', 27),
(3, 'java', 'xyz', 'pqr', '1st', '28', 'java.png', 32),
(4, 'PHP', 'Alan Forbes', 'Plum Island', 'Fifth Edition', '33', 'php.jpg', 27),
(5, 'Python', 'Anthony Brun', 'Eric Matthes', '1st', '26', 'python.jpg', 33),
(6, 'Financial', 'Dr Anil Kumar dhagat', 'Kogent', 'Third', '27', 'finacial.jpg', 31);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(300) NOT NULL,
  `mobile_no` text NOT NULL,
  `address` varchar(200) NOT NULL,
  `photo` varchar(300) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enrollment_no` bigint(30) NOT NULL,
  `user_type` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`id`, `name`, `email`, `mobile_no`, `address`, `photo`, `password`, `enrollment_no`, `user_type`) VALUES
(1, 'admin', 'admin@gmail.com', '7894561233', 'ahmedabad', '', 'admin', 0, 'admin'),
(26, 'Viral Chauhan', 'chauhanviral36@gmail.com', '7359880947', 'Ahmedabad', '', '123456', 195693693019, ''),
(27, 'Kunal Deore', 'kunaldeore35@gmail.com', '9558513657', 'Daman', '', 'kunal', 195693693007, ''),
(28, 'Praful R Divani', 'dpraful72@gmail.com', '7069882473', 'kutch', '', 'admin', 195693693002, ''),
(31, 'Aakash PaTel', 'aakashpatel7979@gmail.com', '9898989898', 'bapunager', '', 'asdfghjkl', 123456789012, ''),
(32, 'Ami Soni', 'amisoni1411@gmail.com', '7567701862', 'Ahmedabad ', '', 'abc', 185690693051, 'student'),
(33, 'Reenal Patel', 'reenalpatel99@gmail.com', '8866581368', 'Thakkarbapa nagar', '', 'reenal17', 185690693038, ''),
(35, 'kajal', 'shahkajal3443@gmail.com', '9408777443', 'ahmedabad', '', '1234567890', 195690693025, '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gcm_registration_id` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_category`
--
ALTER TABLE `book_category`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `donate_book`
--
ALTER TABLE `donate_book`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `imageinfo`
--
ALTER TABLE `imageinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receive_book`
--
ALTER TABLE `receive_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_category`
--
ALTER TABLE `book_category`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `donate_book`
--
ALTER TABLE `donate_book`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT for table `imageinfo`
--
ALTER TABLE `imageinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `receive_book`
--
ALTER TABLE `receive_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
