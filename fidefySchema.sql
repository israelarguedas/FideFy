-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: fidefy
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistaseguidores`
--

DROP TABLE IF EXISTS `artistaseguidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistaseguidores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreartista` varchar(45) NOT NULL,
  `nombreusuario` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistaseguidores`
--

LOCK TABLES `artistaseguidores` WRITE;
/*!40000 ALTER TABLE `artistaseguidores` DISABLE KEYS */;
/*!40000 ALTER TABLE `artistaseguidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `artista` varchar(45) NOT NULL,
  `album` varchar(45) NOT NULL,
  `año` varchar(45) NOT NULL,
  `genero` varchar(25) NOT NULL,
  `megusta` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancionescomentarios`
--

DROP TABLE IF EXISTS `cancionescomentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancionescomentarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `comentario` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancionescomentarios`
--

LOCK TABLES `cancionescomentarios` WRITE;
/*!40000 ALTER TABLE `cancionescomentarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `cancionescomentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listareproduccion`
--

DROP TABLE IF EXISTS `listareproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listareproduccion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombrelista` varchar(45) NOT NULL,
  `nombreusuario` varchar(25) NOT NULL,
  `titulocancion` varchar(45) NOT NULL,
  `visibilidad` tinyint NOT NULL,
  `megusta` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listareproduccion`
--

LOCK TABLES `listareproduccion` WRITE;
/*!40000 ALTER TABLE `listareproduccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `listareproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listareproduccioncomentarios`
--

DROP TABLE IF EXISTS `listareproduccioncomentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listareproduccioncomentarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombrelista` varchar(45) NOT NULL,
  `nombreusuario` varchar(25) NOT NULL,
  `comentario` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listareproduccioncomentarios`
--

LOCK TABLES `listareproduccioncomentarios` WRITE;
/*!40000 ALTER TABLE `listareproduccioncomentarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `listareproduccioncomentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferenciasmusicales`
--

DROP TABLE IF EXISTS `preferenciasmusicales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferenciasmusicales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreusuario` varchar(45) NOT NULL,
  `electronica` tinyint DEFAULT NULL,
  `pop` tinyint DEFAULT NULL,
  `jazz` tinyint DEFAULT NULL,
  `rock` tinyint DEFAULT NULL,
  `clasica` tinyint DEFAULT NULL,
  `latina` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombreusuario_UNIQUE` (`nombreusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferenciasmusicales`
--

LOCK TABLES `preferenciasmusicales` WRITE;
/*!40000 ALTER TABLE `preferenciasmusicales` DISABLE KEYS */;
INSERT INTO `preferenciasmusicales` VALUES (1,'aplomrk',1,1,1,0,0,0),(4,'juan512',1,1,0,1,0,1),(5,'ygonzalez',0,1,1,0,1,1),(6,'loly1',1,0,0,1,0,0),(7,'señogato',1,1,0,0,1,0),(8,'rpmtv',1,1,0,0,1,0),(9,'usuario',1,0,1,1,0,0),(10,'usuario2',1,1,0,0,1,0),(11,'Dora',1,0,0,0,1,1);
/*!40000 ALTER TABLE `preferenciasmusicales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguidores`
--

DROP TABLE IF EXISTS `seguidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguidores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreusuario` varchar(25) NOT NULL,
  `nombreusuarioseguidor` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguidores`
--

LOCK TABLES `seguidores` WRITE;
/*!40000 ALTER TABLE `seguidores` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `nombreusuario` varchar(25) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Marcos','aplomrk','banano'),(8,'Juano','juan512','holas'),(9,'Yorleny','ygonzalez','panycafe'),(10,'Karol','loly1','kiko'),(11,'Juan vindas','señogato','gatos'),(18,'Ramon G','rpmtv','celular'),(22,'test','123456','hola'),(24,'prueba2','usuario','taller'),(25,'test4','usuario2','holas'),(26,'candy R','confite','viviana'),(27,'Marco','mhernandez','hola'),(28,'karla m','holaK','holas'),(30,'El Dorado','Dora','laexplorer');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-15 21:19:47
