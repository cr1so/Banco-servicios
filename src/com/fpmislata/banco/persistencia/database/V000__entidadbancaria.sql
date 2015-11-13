CREATE TABLE If NOT EXISTS `entidadbancaria` (
	`idEntidadBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(30) NULL DEFAULT NULL,
	`codigoEntidad` INT(11) NULL DEFAULT NULL,
	`fechaCreacion` DATETIME NULL DEFAULT NULL,
	`direccion` VARCHAR(50) NULL DEFAULT NULL,
	`cif` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idEntidadBancaria`),
	INDEX `idEntidadBancaria` (`idEntidadBancaria`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
