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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (1,'Deadmau5','Electronica'),(2,'Avicii','Electronica'),(3,'Martin Garrix','Electronica'),(4,'Major Lazer & DJ Snake feat. MØ','Electronica'),(5,'M83','Electronica'),(6,'Skrillex','Electronica'),(7,'Daft Punk feat. Pharrell Williams','Electronica'),(8,'David Guetta feat. Sia','Electronica'),(9,'The Prodigy','Electronica'),(10,'Meduza, Becky Hill, Goodboys','Electronica'),(11,'The Chemical Brothers','Electronica'),(12,'Eric Prydz','Electronica'),(13,'Calvin Harris feat. Rihanna','Electronica'),(14,'New Order','Electronica'),(15,'Ed Sheeran','Pop'),(16,'Michael Jackson','Pop'),(17,'Billie Eilish','Pop'),(18,'Mark Ronson feat. Bruno Mars','Pop'),(19,'Adele','Pop'),(20,'The Weeknd','Pop'),(21,'Katy Perry','Pop'),(22,'Taylor Swift','Pop'),(23,'Justin Bieber','Pop'),(24,'Camila Cabello feat. Young Thug','Pop'),(25,'Dua Lipa','Pop'),(26,'Justin Timberlake','Pop'),(27,'Sia','Pop'),(28,'ABBA','Pop'),(29,'Harry Styles','Pop'),(30,'Dave Brubeck','Jazz'),(31,'Miles Davis','Jazz'),(32,'John Coltrane','Jazz'),(33,'Benny Goodman','Jazz'),(34,'Art Blakey and The Jazz Messengers','Jazz'),(35,'Nina Simone','Jazz'),(36,'Cannonball Adderley','Jazz'),(37,'Weather Report','Jazz'),(38,'Billie Holiday','Jazz'),(39,'Herbie Hancock','Jazz'),(40,'Stan Getz & João Gilberto','Jazz'),(41,'Duke Ellington and John Coltrane','Jazz'),(42,'Led Zeppelin','Rock'),(43,'Queen','Rock'),(44,'Eagles','Rock'),(45,'Nirvana','Rock'),(46,'Guns N Roses','Rock'),(47,'AC/DC','Rock'),(48,'Bruce Springsteen','Rock'),(49,'The Rolling Stones','Rock'),(50,'Simon & Garfunkel','Rock'),(51,'Pink Floyd','Rock'),(52,'Dire Straits','Rock'),(53,'Red Hot Chili Peppers','Rock'),(54,'Aerosmith','Rock'),(55,'Black Sabbath','Rock'),(56,'Derek and the Dominos','Rock'),(57,'Samuel Barber','Clasica'),(58,'Itzhak Perlman','Clasica'),(59,'Orquesta Filarmónica de Berlín','Clasica'),(60,'Leonard Bernstein','Clasica'),(61,'Glenn Gould','Clasica'),(62,'Orquesta de Cámara Inglesa','Clasica'),(63,'Orquesta de París','Clasica'),(64,'Anne-Sophie Mutter','Clasica'),(65,'Orquesta Sinfónica de Chicago','Clasica'),(66,'Orquesta de Cleveland','Clasica'),(67,'Mstislav Rostropovich','Clasica'),(68,'Dúo de Pianistas Contiguglia','Clasica'),(69,'Marc Anthony','Latina'),(70,'Luis Fonsi','Latina'),(71,'Enrique Iglesias','Latina'),(72,'Shakira','Latina'),(73,'Don Omar','Latina'),(74,'Romeo Santos','Latina'),(75,'Daddy Yankee','Latina'),(76,'Maluma','Latina'),(77,'J Balvin','Latina'),(78,'Nicky Jam','Latina'),(79,'Anuel','Latina'),(80,'Juanes','Latina'),(81,'Aventura','Latina');
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
  `idartista` int NOT NULL,
  `idusuario` int NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
INSERT INTO `canciones` VALUES (1,'Strobe','Deadmau5','For Lack of a Better Name','2009','Electronica',NULL),(2,'Levels','Avicii','Levels','2011','Electronica',NULL),(3,'Animals','Martin Garrix','Gold Skies','2013','Electronica',NULL),(4,'Lean On','Major Lazer & DJ Snake feat. MØ','Peace is the Mission','2015','Electronica',NULL),(5,'Midnight City','M83','Hurry Up, We\'re Dreaming','2011','Electronica',NULL),(6,'Scary Monsters and Nice Sprites','Skrillex','Scary Monsters and Nice Sprites','2010','Electronica',NULL),(7,'Get Lucky','Daft Punk feat. Pharrell Williams','Random Access Memories','2013','Electronica',NULL),(8,'Titanium','David Guetta feat. Sia','Nothing but the Beat','2011','Electronica',NULL),(9,'Firestarter','The Prodigy','The Fat of the Land','1996','Electronica',NULL),(10,'Lose Control','Meduza, Becky Hill, Goodboys','Lose Control','2019','Electronica',NULL),(11,'Go','The Chemical Brothers','Born in the Echoes','2015','Electronica',NULL),(12,'Opus','Eric Prydz','Opus','2016','Electronica',NULL),(13,'We Found Love','Calvin Harris feat. Rihanna','Talk That Talk','2011','Electronica',NULL),(14,'Breathe','The Prodigy','The Fat of the Land','1997','Electronica',NULL),(15,'Blue Monday','New Order','Power, Corruption & Lies','1983','Electronica',NULL),(16,'Shape of You','Ed Sheeran','÷ (Divide)','2017','Pop',NULL),(17,'Billie Jean','Michael Jackson','Thriller','1982','Pop',NULL),(18,'Bad Guy','Billie Eilish','When We All Fall Asleep, Where Do We Go?','2019','Pop',NULL),(19,'Uptown Funk','Mark Ronson feat. Bruno Mars','Uptown Special','2014','Pop',NULL),(20,'Rolling in the Deep','Adele','21','2011','Pop',NULL),(21,'Blinding Lights','The Weeknd','After Hours','2020','Pop',NULL),(22,'Roar','Katy Perry','Prism','2013','Pop',NULL),(23,'Shake It Off','Taylor Swift','1989','2014','Pop',NULL),(24,'Sorry','Justin Bieber','Purpose','2015','Pop',NULL),(25,'Havana','Camila Cabello feat. Young Thug','Camila','2017','Pop',NULL),(26,'New Rules','Dua Lipa','Dua Lipa','2017','Pop',NULL),(27,'Cant Stop the Feeling!','Justin Timberlake','Trolls Soundtrack','2016','Pop',NULL),(28,'Cheap Thrills','Sia','This Is Acting','2016','Pop',NULL),(29,'Dancing Queen','ABBA','Arrival','1976','Pop',NULL),(30,'Watermelon Sugar','Harry Styles','Fine Line','2019','Pop',NULL),(31,'Take Five','Dave Brubeck','Time Out','1959','Jazz',NULL),(32,'So What','Miles Davis','Kind of Blue','1959','Jazz',NULL),(33,'My Favorite Things','John Coltrane','My Favorite Things','1961','Jazz',NULL),(34,'Sing, Sing, Sing','Benny Goodman','Hollywood Hotel','1937','Jazz',NULL),(35,'Moanin\'','Art Blakey and The Jazz Messengers','Moanin\'','1958','Jazz',NULL),(36,'Feeling Good','Nina Simone','I Put a Spell on You','1965','Jazz',NULL),(37,'Autumn Leaves','Cannonball Adderley','Somethin\' Else','1958','Jazz',NULL),(38,'Birdland','Weather Report','Heavy Weather','1977','Jazz',NULL),(39,'All Blues','Miles Davis','Kind of Blue','1959','Jazz',NULL),(40,'Strange Fruit','Billie Holiday','Commodore','1939','Jazz',NULL),(41,'Watermelon Man','Herbie Hancock','Takin\' Off','1962','Jazz',NULL),(42,'The Girl from Ipanema','Stan Getz & João Gilberto','Getz/Gilberto','1964','Jazz',NULL),(43,'In a Sentimental Mood','Duke Ellington and John Coltrane','Duke Ellington & John Coltrane','1963','Jazz',NULL),(44,'God Bless the Child','Billie Holiday','Lady Sings the Blues','1956','Jazz',NULL),(45,'Blue Rondo à la Turk','Dave Brubeck','Time Out','1959','Jazz',NULL),(46,'Stairway to Heaven','Led Zeppelin','Led Zeppelin IV','1971','Rock',NULL),(47,'Bohemian Rhapsody','Queen','A Night at the Opera','1975','Rock',NULL),(48,'Hotel California','Eagles','Hotel California','1976','Rock',NULL),(49,'Smells Like Teen Spirit','Nirvana','Nevermind','1991','Rock',NULL),(50,'Sweet Child o\' Mine','Guns N\' Roses','Appetite for Destruction','1987','Rock',NULL),(51,'Back In Black','AC/DC','Back In Black','1980','Rock',NULL),(52,'Born to Run','Bruce Springsteen','Born to Run','1975','Rock',NULL),(53,'Paint It Black','The Rolling Stones','Aftermath','1966','Rock',NULL),(54,'The Sound of Silence','Simon & Garfunkel','Sounds of Silence','1966','Rock',NULL),(55,'Another Brick in the Wall, Part 2','Pink Floyd','The Wall','1979','Rock',NULL),(56,'Sultans of Swing','Dire Straits','Dire Straits','1978','Rock',NULL),(57,'Under the Bridge','Red Hot Chili Peppers','Blood Sugar Sex Magik','1991','Rock',NULL),(58,'Dream On','Aerosmith','Aerosmith','1973','Rock',NULL),(59,'Paranoid','Black Sabbath','Paranoid','1970','Rock',NULL),(60,'Layla','Derek and the Dominos','Layla and Other Assorted Love Songs','1970','Rock',NULL),(106,'Adagio for Strings','Samuel Barber','Adagio for Strings','1938','Clasica',NULL),(107,'Concierto para violín Op64','Itzhak Perlman','Mendelssohn: Violin Concerto','1987','Clasica',NULL),(108,'Sinfonía No. 9','Orquesta Filarmónica de Berlín','Beethoven: Symphony No.9','1963','Clasica',NULL),(109,'Rapsodia en azul','Leonard Bernstein','Gershwin: Rhapsody in Blue','1959','Clasica',NULL),(110,'El arte de la fuga, BWV 1080','Glenn Gould','Bach: The Art of Fugue','1962','Clasica',NULL),(111,'Sinfonía No.40 en Sol menor K550','Orquesta de Cámara Inglesa','Mozart: Symphony No.40','1973','Clasica',NULL),(112,'Boléro','Orquesta de París','Ravel: Bolero','1975','Clasica',NULL),(113,'Las cuatro estaciones','Anne-Sophie Mutter','Vivaldi: The Four Seasons','1999','Clasica',NULL),(114,'Carmina Burana','Orquesta Sinfónica de Chicago','Orff: Carmina Burana','1992','Clasica',NULL),(115,'La consagración de la primavera','Orquesta de Cleveland','Stravinsky: The Rite of Spring','1969','Clasica',NULL),(116,'Concierto para cello en Si menor, Op. 104','Mstislav Rostropovich','Dvořák: Cello Concerto','1977','Clasica',NULL),(117,'Petite Suite','Dúo de Pianistas Contiguglia','Debussy: Petite Suite','1994','Clasica',NULL),(118,'Vivir Mi Vida','Marc Anthony','3.0','2013','Latina',NULL),(119,'Despacito','Luis Fonsi','Vida','2017','Latina',NULL),(120,'Bailando','Enrique Iglesias','SEX AND LOVE','2014','Latina',NULL),(121,'La Tortura','Shakira','Fijación Oral, Vol. 1','2005','Latina',NULL),(122,'Danza Kuduro','Don Omar','Meet the Orphans','2010','Latina',NULL),(123,'Propuesta Indecente','Romeo Santos','Fórmula, Vol. 2','2013','Latina',NULL),(124,'Gasolina','Daddy Yankee','Barrio Fino','2004','Latina',NULL),(125,'Hips Don’t Lie','Shakira','Oral Fixation, Vol. 2','2006','Latina',NULL),(126,'Felices los 4','Maluma','F.A.M.E.','2017','Latina',NULL),(127,'Mi Gente','J Balvin','Vibras','2017','Latina',NULL),(128,'El Perdón','Nicky Jam','Fénix','2015','Latina',NULL),(129,'Ella Quiere Beber','Anuel','Real Hasta la Muerte','2018','Latina',NULL),(130,'La Camisa Negra','Juanes','Mi Sangre','2005','Latina',NULL),(131,'Obsesión','Aventura','We Broke the Rules','2002','Latina',NULL),(132,'Chantaje','Shakira','El Dorado','2016','Latina',NULL);
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
  `idcancion` int NOT NULL,
  `idusuario` int NOT NULL,
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
  `idusuario` int NOT NULL,
  `visibilidad` tinyint NOT NULL,
  `megusta` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listareproduccion`
--

LOCK TABLES `listareproduccion` WRITE;
/*!40000 ALTER TABLE `listareproduccion` DISABLE KEYS */;
INSERT INTO `listareproduccion` VALUES (1,'Exitos musicales',1,1,0),(2,'Musica variada',1,1,0),(4,'Exitos musicales',1,1,0),(5,'Musica variada',1,1,0);
/*!40000 ALTER TABLE `listareproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listareproduccioncanciones`
--

DROP TABLE IF EXISTS `listareproduccioncanciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listareproduccioncanciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idlista` int NOT NULL,
  `idusuario` int NOT NULL,
  `idcancion` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listareproduccioncanciones`
--

LOCK TABLES `listareproduccioncanciones` WRITE;
/*!40000 ALTER TABLE `listareproduccioncanciones` DISABLE KEYS */;
INSERT INTO `listareproduccioncanciones` VALUES (1,1,1,3),(2,1,1,15),(3,1,1,19),(7,2,1,7),(8,2,1,27),(9,2,1,36);
/*!40000 ALTER TABLE `listareproduccioncanciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listareproduccioncomentarios`
--

DROP TABLE IF EXISTS `listareproduccioncomentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listareproduccioncomentarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idlista` int NOT NULL,
  `idusuario` int NOT NULL,
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
  `idusuario` int NOT NULL,
  `idusuarioseguidor` int NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2024-04-20 19:42:41
