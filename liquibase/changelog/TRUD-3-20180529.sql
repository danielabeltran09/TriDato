-- Datos prueba aguas calientes
CREATE TABLE `aguascalientes_acuerdos` (
  `AcuerdoID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Numero` int(11) DEFAULT NULL,
  `AreaID` int(11) DEFAULT NULL,
  `Documento` varchar(50) DEFAULT NULL,
  `Naturaleza` varchar(50) DEFAULT NULL,
  `Partes` text,
  `Extracto` text,
  `PermisoVerTexto` tinyint(1) DEFAULT NULL,
  `TipoAcuerdoID` int(11) DEFAULT NULL,
  `FechaPublicacion` varchar(50) DEFAULT NULL,
  `FecDictado` varchar(50) DEFAULT NULL,
  `Editar` tinyint(1) DEFAULT NULL,
  `DescripcionClasificacion` text,
  `Publicado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`AcuerdoID`)
) ENGINE=MyISAM AUTO_INCREMENT=1166118 DEFAULT CHARSET=latin1;

INSERT INTO aguascalientes_acuerdos values(1166110, 1, 53, '0007/2017', 'CARPETA DIGITAL', 'SAUL ADOLFO TELLEZ NAVARRO', 'SE RECIBE INFORME NO SE PRESENTÓ IMPUTADO PARA LA REALIZACIÓN DEL EXAMEN TOXICOLÓGICO CORRESPONDIENTE AL DÍA VEINTINUEVE DE OCTUBRE DEL PRESENTE AÑO.', false, 3, '/Date(1509516000000)/', '/Date(-62135575200000)/', false, '', false);
INSERT INTO aguascalientes_acuerdos values (1166117, 2, 53, '0019/2017', 'CARPETA DIGITAL', 'DAVID ISRAEL MORENO MARTÍNEZ
EDGAR ALBERTO ORTEGA MACÍAS', 'SE RINDE INFORME A EJECUCIÓN DE PENAS Y MEDIDAS DE SEGURIDAD DEL ESTADO.', false, 3, '/Date(1509516000000)/', '/Date(-62135575200000)/', false, '', false);

