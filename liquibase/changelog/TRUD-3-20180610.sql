-- Datos prueba aguas calientes
DROP TABLE IF EXISTS aguascalientes_acuerdos
CREATE TABLE `aguascalientes_acuerdos` (
  `AcuerdoID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Numero` int(11) DEFAULT NULL,
  `AreaID` int(11) DEFAULT NULL,
  `Documento` varchar(255) DEFAULT NULL,
  `Naturaleza` varchar(255) DEFAULT NULL,
  `Partes` text,
  `PermisoVerTexto` varchar(255) DEFAULT NULL,
  `Extracto` text,
  `TipoAcuerdoID` int(11) DEFAULT NULL,
  `FechaPublicacion` varchar(255) DEFAULT NULL,
  `FecDictado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AcuerdoID`)
) ENGINE=MyISAM AUTO_INCREMENT=3441024 DEFAULT CHARSET=latin1;

