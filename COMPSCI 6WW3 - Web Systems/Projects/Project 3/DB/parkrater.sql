-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 27 Kas 2019, 02:11:14
-- Sunucu sürümü: 10.4.6-MariaDB
-- PHP Sürümü: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `parkrater`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `park`
--

CREATE TABLE `park` (
  `park_id` int(10) NOT NULL,
  `park_name` varchar(50) NOT NULL,
  `description` varchar(550) DEFAULT NULL,
  `latitude` decimal(20,10) NOT NULL,
  `longitude` decimal(20,10) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `images_path` varchar(100) DEFAULT NULL,
  `video_path` varchar(100) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  `date_updated` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `park`
--

INSERT INTO `park` (`park_id`, `park_name`, `description`, `latitude`, `longitude`, `country`, `region`, `city`, `address`, `postal_code`, `images_path`, `video_path`, `date_created`, `date_updated`) VALUES
(1, 'Highland Garden\'s Park', 'Empty field in Hamilton.', '43.2455570000', '-79.8922284000', 'Canada', 'Ontario', 'Hamilton', '1 Hillcrest Avenue', 'L8P 2X3', NULL, NULL, '2019-11-10 19:25:17', '2019-11-20 18:45:31'),
(2, 'Victoria Park', 'Near the bus stop.', '43.0000000000', '-79.0000000000', 'Canada', 'Ontario', 'Hamilton', '500 King St W', NULL, NULL, NULL, '2019-11-22 03:15:02', '2019-11-23 21:49:24'),
(3, 'Hill Street Park', 'Dog park.', '43.2567212000', '-79.8878275000', 'Canada', 'Ontario', 'Hamilton', '12 Hill St', NULL, NULL, NULL, '2019-11-22 03:19:42', '2019-11-23 21:49:35'),
(4, 'Chedoke Civic Golf Course', 'Golf course in Hamilton.', '43.2473753000', '-79.9111090000', 'Canada', 'Ontario', 'Hamilton', '565 Aberdeen Ave', NULL, NULL, NULL, '2019-11-25 18:07:16', NULL),
(19, 'Test Park', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages', '43.2516200000', '-79.8867000000', '', '', '', '', NULL, '../../Park_Data/Images/Test Park/', '../../Park_Data/Videos/Test Park/', '2019-11-25 20:56:52', '2019-11-26 02:28:26');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `review`
--

CREATE TABLE `review` (
  `review_id` int(10) NOT NULL,
  `content` varchar(550) DEFAULT NULL,
  `rating` int(1) NOT NULL,
  `user_id` int(10) NOT NULL,
  `park_id` int(10) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  `date_updated` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `review`
--

INSERT INTO `review` (`review_id`, `content`, `rating`, `user_id`, `park_id`, `date_created`, `date_updated`) VALUES
(1, 'First review', 9, 1, 1, '2019-11-10 20:20:30', NULL),
(2, 'Second', 7, 4, 2, '2019-11-22 16:12:10', NULL),
(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec orci augue. In at quam lacus. Proin in erat a neque tempus pharetra. In ante nibh, luctus quis risus vitae, molestie porta justo. Fusce leo neque, tincidunt nec justo in, egestas mollis arcu. Aliquam erat volutpat. In pharetra commodo augue non commodo. Nullam ultrices, tortor ac imperdiet tempor, quam mi placerat enim, viverra porta erat urna nec arcu. Maecenas auctor nulla nec maximus convallis. Nunc lacinia risus in diam interdum feugiat. Vivamus vehicula nisi ut ornare sempe', 6, 5, 2, '2019-11-24 00:59:03', '2019-11-24 01:00:25'),
(4, 'Best park ever!', 10, 6, 2, '2019-11-24 00:59:03', NULL),
(5, '', 2, 6, 1, '2019-11-24 21:23:56', NULL),
(17, 'Test Park is the best Park', 10, 4, 19, '2019-11-26 20:32:33', NULL),
(18, 'Good for running.', 7, 4, 1, '2019-11-26 20:52:47', NULL),
(19, 'I don\'t play golf.', 2, 4, 4, '2019-11-26 20:54:05', NULL),
(20, 'I love this park. I can walk with my dog.', 7, 4, 3, '2019-11-26 20:54:59', NULL),
(21, '@test222 I don\'t think its that good.', 3, 6, 19, '2019-11-26 20:58:20', NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` longtext NOT NULL,
  `user_city` varchar(50) DEFAULT NULL,
  `phone` text DEFAULT NULL,
  `visit_frequency` int(3) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  `date_updated` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `password`, `user_city`, `phone`, `visit_frequency`, `date_created`, `date_updated`) VALUES
(0, 'admin', 'admin@parkrater.com', 'admin', NULL, NULL, NULL, '2019-11-10 19:38:52', NULL),
(1, 'test', 'test@parkrater.com', 'test123', NULL, NULL, NULL, '2019-11-10 19:38:52', NULL),
(2, 'test123', 'test@test.com', '$2y$10$J2WLVCnDrW9iM5gJwoYzt.bx28/2hRBZOmMgFDKNbe5yPyObKI1W2', NULL, NULL, NULL, '2019-11-20 22:26:32', NULL),
(4, 'test222', 'test222@test.com', '$2y$10$niFpAQN8j.tVvA1qDylfuOxyrt39TsWFEjdTLiiiADOM7u74M3dn6', 'Hamilton', '2147483647', 12, '2019-11-21 21:45:01', NULL),
(5, 'test333', 'test333@test.com', '$2y$10$nxpfmcasHLk/LPhqwwWTDOO4rKP/cQRuKRzLJwWuw4l0/YDnjtRY6', '', '2147483647', 364, '2019-11-21 21:46:51', NULL),
(6, 'test444', 'test444@parkrater.com', '$2y$10$vnlU00U56dT4aXm0RAZ3NuPBNTl8JsXjHBCCliMdbem1TIRRbvC3S', '', '0', 0, '2019-11-21 21:58:12', NULL);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `park`
--
ALTER TABLE `park`
  ADD PRIMARY KEY (`park_id`);

--
-- Tablo için indeksler `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`review_id`),
  ADD UNIQUE KEY `user_park_unique` (`user_id`,`park_id`),
  ADD KEY `review_park_FK` (`park_id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username_unique` (`username`),
  ADD UNIQUE KEY `email_unique` (`email`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `park`
--
ALTER TABLE `park`
  MODIFY `park_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Tablo için AUTO_INCREMENT değeri `review`
--
ALTER TABLE `review`
  MODIFY `review_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_park_FK` FOREIGN KEY (`park_id`) REFERENCES `park` (`park_id`),
  ADD CONSTRAINT `review_user_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
