-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-03-2022 a las 23:03:40
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practics4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `exp` int(11) NOT NULL,
  `DNI` varchar(100) DEFAULT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Apellidos` varchar(30) DEFAULT NULL,
  `Fnac` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`exp`, `DNI`, `Nombre`, `Apellidos`, `Fnac`) VALUES
(1, 'HRc×öÏ^\0$ßÛŠÏûc', 'Oriol', 'Herrera', '1111-11-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centro`
--

CREATE TABLE `centro` (
  `Cod_centro` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `director` varchar(30) DEFAULT NULL,
  `localidad` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `centro`
--

INSERT INTO `centro` (`Cod_centro`, `nombre`, `director`, `localidad`) VALUES
(1, 'U-tad', 'Joaquin', 'Las Rozas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `director`
--

CREATE TABLE `director` (
  `name` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `dni` varchar(10) NOT NULL,
  `foto` mediumblob DEFAULT NULL,
  `usr` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `director`
--

INSERT INTO `director` (`name`, `lastname`, `dni`, `foto`, `usr`) VALUES
('Joaquin', 'Cassinello', '23252453A', NULL, 'Joaquin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `Cif` varchar(9) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `Cod_centro` int(11) DEFAULT NULL,
  `NumConv` int(11) DEFAULT NULL,
  `anex1` date DEFAULT NULL,
  `Localidad` varchar(30) DEFAULT NULL,
  `representante` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`Cif`, `nombre`, `direccion`, `telefono`, `email`, `Cod_centro`, `NumConv`, `anex1`, `Localidad`, `representante`) VALUES
('11111111A', 'Microsoft', 'Calle A', '666666666', 'microsoft@microsoft.com', 1, 1, '2022-03-11', 'California', 'Bill Gates'),
('11111111B', 'OnlyFans', 'Calle B', '666666667', 'onlyfans@onlyfans.com', 1, 2, '2022-03-11', 'California', 'Darlene Huerta'),
('11111111C', 'Facebook', 'Calle C', '666666668', 'facebook@facebook.com', 1, 3, '2022-03-11', 'Miami', 'Mark Zuckelberg'),
('25338463K', 'Cohetes korea', 'Calle J', '637485593', 'coheteskorea@coheteskorea.com ', 1, 12, '2022-03-11', 'Pyonyang', 'Kim Jong Un'),
('35465768F', 'Valve', 'Calle D', '647196415', 'valve@valve.com', 1, 4, '2022-03-11', 'Los Angeles', 'Manuel'),
('63788473H', 'Google', 'Calle H', '630384421', 'google@google.com', 1, 10, '2022-06-12', 'Los Angeles', 'John Cena'),
('64338243G', 'Tesla', 'Miami', '638276634', 'Tesla@Tesla.com', 1, 7, '2022-04-15', 'Miami', 'Elon Musk'),
('64338749T', 'Oracle', 'Calle E', '647386439', 'oracle@oracle.com', 1, 5, '2022-03-11', 'Los Angeles', 'Angel Maxwell'),
('68348249K', 'Space X', 'Calle G', '693453345', 'spacex@spaex.com', 1, 8, '2022-05-27', 'Miami', 'Elon Mask'),
('737994734', 'Space X', 'Calle G', '638273344', 'spacex@spaex.com', 1, 9, '2022-04-18', 'Miami', 'Elon Musk'),
('73994627R', 'Supercell', 'Calle F', '637485593', 'supercell@supercell.com ', 1, 6, '2022-03-11', 'Los Angeles', 'Rex Dangerbest'),
('74339273A', 'Ubisoft', 'Calle I', '666666666', 'ubisoft@ubisoft.com', 1, 1, '2022-03-10', 'California', 'Randy Orton'),
('83447326M', 'EA', 'Miami', '638276634', 'ea@ea.com', 1, 11, '2022-04-15', 'Miami', 'Donald Trump');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestiona`
--

CREATE TABLE `gestiona` (
  `Cod_gestion` int(11) NOT NULL,
  `anex2_2` date DEFAULT NULL,
  `acad` date DEFAULT NULL,
  `DNI_tutor` varchar(15) DEFAULT NULL,
  `Cod_grupo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `gestiona`
--

INSERT INTO `gestiona` (`Cod_gestion`, `anex2_2`, `acad`, `DNI_tutor`, `Cod_grupo`) VALUES
(1, NULL, NULL, '11111111A', 1),
(2, NULL, NULL, '01554834H', 2),
(3, NULL, NULL, '99999999W', 3),
(4, NULL, NULL, '01554834H', 1),
(5, '2022-02-18', NULL, '11111111A', 1),
(6, '2021-12-14', NULL, '99999999W', 2),
(7, '2022-03-18', NULL, '11111111A', 1),
(8, '2021-11-18', NULL, '99999999W', 2),
(9, '2021-11-20', NULL, '11111111A', 1),
(10, '2022-01-15', NULL, '99999999W', 2),
(11, '2022-02-12', NULL, '11111111A', 3),
(12, '2022-04-19', NULL, '99999999W', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `Cod_grupo` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `clave_ciclo` varchar(30) DEFAULT NULL,
  `Nombre_ciclo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`Cod_grupo`, `Nombre`, `clave_ciclo`, `Nombre_ciclo`) VALUES
(1, 'J', '1A', 'DAMP1'),
(2, 'L', '1B', 'DAMP1'),
(3, 'H', '1C', 'DAMP1'),
(4, 'L', '1L', 'DAMP1'),
(5, 'M', '1M', 'DAMP1'),
(6, 'K', '1K', 'DAMP2'),
(7, 'Z', '1Z', 'DAMP2'),
(8, 'S', '1S', 'DAMP1'),
(9, 'T', '1T', 'DAMP1'),
(10, 'Y', '1Y', 'DAMP2'),
(11, 'B', '1B', 'DAMP1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pertenece`
--

CREATE TABLE `pertenece` (
  `cod_pertenece` int(11) NOT NULL,
  `cod_grupo` int(11) DEFAULT NULL,
  `exp_alumno` int(11) DEFAULT NULL,
  `acad` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pertenece`
--

INSERT INTO `pertenece` (`cod_pertenece`, `cod_grupo`, `exp_alumno`, `acad`) VALUES
(1, 1, 11111, NULL),
(2, 2, 22222, NULL),
(3, 3, 33333, NULL),
(4, 4, 44444, NULL),
(5, 5, 22222, NULL),
(6, 6, 55555, NULL),
(7, 9, 22222, NULL),
(8, 2, 33333, NULL),
(9, 6, 44444, NULL),
(10, 6, 11111, NULL),
(12, 2, 22222, NULL),
(2345, 1, 12345, '2000-05-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practica`
--

CREATE TABLE `practica` (
  `cod_practica` varchar(11) NOT NULL,
  `cif_empresa` varchar(9) DEFAULT NULL,
  `exp_alumno` int(11) DEFAULT NULL,
  `fecha_ini` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `acad` date DEFAULT NULL,
  `horario` varchar(20) DEFAULT NULL,
  `tutor` varchar(20) DEFAULT NULL,
  `acad_practica` varchar(20) DEFAULT NULL,
  `anex2_1` date DEFAULT NULL,
  `anex3` date DEFAULT NULL,
  `anex7` date DEFAULT NULL,
  `anex8` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutor`
--

CREATE TABLE `tutor` (
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Apellido` varchar(30) DEFAULT NULL,
  `Cod_centro` int(11) DEFAULT NULL,
  `usr` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tutor`
--

INSERT INTO `tutor` (`DNI`, `Nombre`, `Apellido`, `Cod_centro`, `usr`) VALUES
('01554834H', 'Enrique', 'Arnaiz', 1, 'Enrique'),
('11111111A', 'Pedro', 'Camacho', 1, 'Pedro'),
('12345678L', 'Jaime', 'Latorre', 1, NULL),
('23456789C', 'Meritxell', 'Bretos', 1, NULL),
('98765432Z', 'Sergio', 'Redondo', 1, NULL),
('99999999W', 'Luis', 'Campoy', 1, NULL),
('pablo', 'pablo', 'pablo', 1, 'pablo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `usr` varchar(30) NOT NULL,
  `pwd` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  `photo` mediumblob DEFAULT NULL,
  `email` varbinary(9999) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`usr`, `pwd`, `role`, `photo`, `email`) VALUES
('Enrique', '4321', 'Tutor', '', 0x656e72697175657061736140676d61696c2e636f6d),
('Joaquin', ' ,¹b¬Y[–K-#Kp', 'Director', '', 0x6a6f617175696e40676d61696c2e636f6d),
('pablo', '�Ü›ÛRÐMÂ\06ÛØ1>ÐU', 'Tutor', '', 0x66c2ad7dc2a2541fc3ad5f07c3bb02c2b34640c2a83ae2809ac2b21f403029c39f686e131fc2abc3a9e28093c2bcc3bb0fc2a7c3b9e28099c3b4c380c2aa46c5bdc390c39877c3b3c3b62d42c39a3fc39ae2809ac2b05442e2809ce2809ac2ae2d7cc39b40127fc5a142051839c3b509c2b3c397c2b3091778efbfbd780c5950c39775c2b44cc5bd116de280ba56c39c4a12e280ba6d17526a62c2a7e284a26ec39c681a3e1bc38acb9cc3b1c2a7c387e2809ac397c2a22b3700c6922dc2b3674e73e2809d0b1015c398c38138c3880567c2b2c2b5c38ee2809ae2809825c38e4d14c3934103c5a1520bc3b0c2a44be2809d67c2a24c752bc3b6c3bfc2ac48c2b67f003973c392c5b81cc3bd4700c382efbfbdc2ba24c3ab2e0d06e284a213c2a647103ec5a1c3996504c6922ec39b6f0f31c3a91041e2809ac389c2ab496e6265c3bac5a00dc3acc2bb42c2a96dc3ab7d39321d7128c2a5efbfbdc396c5a00720c388e280a0c382c2bf30efbfbdc3b32c09c3876ec3ad61c397efbfbdc2bfc3b7c39dc39d02c2b524c3a22bc2ac),
('Pedro', '1234', 'Tutor', '', 0x706564726f40676d61696c2e636f6d);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`exp`);

--
-- Indices de la tabla `centro`
--
ALTER TABLE `centro`
  ADD PRIMARY KEY (`Cod_centro`);

--
-- Indices de la tabla `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `director_usr_fk` (`usr`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`Cif`),
  ADD KEY `Cod_centro` (`Cod_centro`);

--
-- Indices de la tabla `gestiona`
--
ALTER TABLE `gestiona`
  ADD PRIMARY KEY (`Cod_gestion`),
  ADD KEY `Cod_grupo` (`Cod_grupo`),
  ADD KEY `dni_tutor` (`DNI_tutor`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`Cod_grupo`);

--
-- Indices de la tabla `pertenece`
--
ALTER TABLE `pertenece`
  ADD PRIMARY KEY (`cod_pertenece`);

--
-- Indices de la tabla `practica`
--
ALTER TABLE `practica`
  ADD PRIMARY KEY (`cod_practica`),
  ADD KEY `cif_empresa` (`cif_empresa`),
  ADD KEY `exp_alumno` (`exp_alumno`);

--
-- Indices de la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `Cod_centro_fk` (`Cod_centro`),
  ADD KEY `user___fk` (`usr`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`usr`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `director`
--
ALTER TABLE `director`
  ADD CONSTRAINT `director_usr_fk` FOREIGN KEY (`usr`) REFERENCES `users` (`usr`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `Cod_centro` FOREIGN KEY (`Cod_centro`) REFERENCES `centro` (`Cod_centro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `gestiona`
--
ALTER TABLE `gestiona`
  ADD CONSTRAINT `Cod_grupo` FOREIGN KEY (`Cod_grupo`) REFERENCES `grupo` (`Cod_grupo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dni_tutor` FOREIGN KEY (`DNI_tutor`) REFERENCES `tutor` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `practica`
--
ALTER TABLE `practica`
  ADD CONSTRAINT `cif_empresa` FOREIGN KEY (`cif_empresa`) REFERENCES `empresa` (`Cif`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `exp_alumno` FOREIGN KEY (`exp_alumno`) REFERENCES `alumno` (`exp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `Cod_centro_fk` FOREIGN KEY (`Cod_centro`) REFERENCES `centro` (`Cod_centro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user___fk` FOREIGN KEY (`usr`) REFERENCES `users` (`usr`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
