-- MySQL Script generated by MySQL Workbench
-- Wed Feb 24 17:59:58 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema RestauranteLiChan
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `RestauranteLiChan`;

-- -----------------------------------------------------
-- Schema RestauranteLiChan
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RestauranteLiChan` DEFAULT CHARACTER SET utf8 ;
USE `RestauranteLiChan` ;

-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_usuarios` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_usuarios` (
  `idUsuario` INT NOT NULL,
  `login` VARCHAR(15) NOT NULL,
  `password` CHAR(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_cargo` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_cargo` (
  `idCargo` INT NOT NULL,
  `descripcionCargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCargo`),
  UNIQUE INDEX `descripcionCargo_UNIQUE` (`descripcionCargo` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_tipo_documento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_tipo_documento` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_tipo_documento` (
  `idTipoDocumento` INT NOT NULL,
  `NombreTipo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idTipoDocumento`),
  UNIQUE INDEX `NombreTipo_UNIQUE` (`NombreTipo` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_clientes` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_clientes` (
  `idCliente` VARCHAR(10) NOT NULL,
  `nombreCliente` VARCHAR(45) NOT NULL,
  `apellidoCliente` VARCHAR(45) NOT NULL,
  `direccionCliente` VARCHAR(50) NOT NULL,
  `numeroTelefonico` INT NOT NULL,
  `idtipoDocumento` INT NOT NULL,
  `numeroDocumento` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `numeroTelefonico_UNIQUE` (`numeroTelefonico` ASC) ,
  UNIQUE INDEX `direccionCliente_UNIQUE` (`direccionCliente` ASC) ,
  UNIQUE INDEX `numeroDocumento_UNIQUE` (`numeroDocumento` ASC) ,
  INDEX `fr_tbClientes_tbTipoDocumento:idTipoDocumento_idx` (`idtipoDocumento` ASC) ,
  CONSTRAINT `fr_tbClientes_tbTipoDocumento:idTipoDocumento`
    FOREIGN KEY (`idtipoDocumento`)
    REFERENCES `RestauranteLiChan`.`tb_tipo_documento` (`idTipoDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_producto` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_producto` (
  `idProducto` VARCHAR(10) NOT NULL,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `precioProducto` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE INDEX `nombreProducto_UNIQUE` (`nombreProducto` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_empleado` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_empleado` (
  `idEmpleado` VARCHAR(10) NOT NULL,
  `nombreEmpleado` VARCHAR(45) NOT NULL,
  `apellidoEmpleado` VARCHAR(45) NOT NULL,
  `idTipoDocumento` INT NOT NULL,
  `numeroDocumento` VARCHAR(12) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `idCargo` INT NOT NULL,
  `genero` VARCHAR(5) NOT NULL,
  `estado` VARCHAR(8) NOT NULL DEFAULT 'activo',
  `idUsuario` INT NOT NULL,
   PRIMARY KEY (`idEmpleado`),
  INDEX `fk_tbEmpleado_tbCargo:idCargo_idx` (`idCargo` ASC) ,
  UNIQUE INDEX `numeroDocumento_UNIQUE` (`numeroDocumento` ASC) ,
  INDEX `fk_tbEmpleado_tbTipoDocumento:idTipoDocumento_idx` (`idTipoDocumento` ASC) ,
  INDEX `fk_tbEmpleado_tbUsuarios:idUsuarios_idx` (`idUsuario` ASC) ,
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) ,
  CONSTRAINT `fk_tbEmpleado_tbCargo:idCargo`
    FOREIGN KEY (`idCargo`)
    REFERENCES `RestauranteLiChan`.`tb_cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbEmpleado_tbTipoDocumento:idTipoDocumento`
    FOREIGN KEY (`idTipoDocumento`)
    REFERENCES `RestauranteLiChan`.`tb_tipo_documento` (`idTipoDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbEmpleado_tbUsuarios:idUsuarios`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `RestauranteLiChan`.`tb_usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_recepcionista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_recepcionista` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_recepcionista` (
  `idEmpleado` VARCHAR(10) NOT NULL,
  `numHorasPorDia` INT NOT NULL,
  `diasLaborales` INT NOT NULL,
  `pagoPorHora` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  CONSTRAINT `fk_tbRecepcionista_tbEmpelado:idEmpleado`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `RestauranteLiChan`.`tb_empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_boleta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_boleta` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_boleta` (
  `idBoleta` VARCHAR(10) NOT NULL,
  `fecha` DATE NOT NULL,
  `idCliente` VARCHAR(10) NOT NULL,
  `idRecepcionista` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idBoleta`),
  INDEX `fk_tbBoleta_tbClientes:idCliente_idx` (`idCliente` ASC) ,
  INDEX `fk_tbBoleta_tbRecepcionista:idRecepcionista_idx` (`idRecepcionista` ASC) ,
  CONSTRAINT `fk_tbBoleta_tbClientes:idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `RestauranteLiChan`.`tb_clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbBoleta_tbRecepcionista:idRecepcionista`
    FOREIGN KEY (`idRecepcionista`)
    REFERENCES `RestauranteLiChan`.`tb_recepcionista` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_boleta_detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_boleta_detalle` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_boleta_detalle` (
  `idBoleta` VARCHAR(10) NOT NULL,
  `idProducto` VARCHAR(10) NOT NULL,
  `cantidadProducto` INT NOT NULL,
  `precioTotalProducto` DECIMAL(8,2) NOT NULL,
  INDEX `fk_DetalleCompraProducos_tbProducto:idProducto_idx` (`idProducto` ASC) ,
  CONSTRAINT `fk_tbBoletaDetalle_tbProducto:idProducto`
    FOREIGN KEY (`idProducto`)
    REFERENCES `RestauranteLiChan`.`tb_producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbBoletaDetalle_tbBoleta:idBoleta`
    FOREIGN KEY (`idBoleta`)
    REFERENCES `RestauranteLiChan`.`tb_boleta` (`idBoleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_administrador` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_administrador` (
  `idEmpleado` VARCHAR(10) NOT NULL,
  `sueldo` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  CONSTRAINT `fk_tbAdministrador_tbEmpleado:idEmpleado`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `RestauranteLiChan`.`tb_empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `RestauranteLiChan`.`tb_ClienteProducto_Temporal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RestauranteLiChan`.`tb_ClienteProducto_Temporal` ;

CREATE TABLE IF NOT EXISTS `RestauranteLiChan`.`tb_ClienteProducto_Temporal` (
  `idTemporal` INT NOT NULL AUTO_INCREMENT,
  `numItem`	INT NOT NULL,
  `idBoleta` VARCHAR(45) NOT NULL,
  `idCliente` VARCHAR(45) NOT NULL,
  `idProducto` VARCHAR(45) NOT NULL,
  `CantidadProducto` INT NOT NULL,
  `TotalProductoSeleccinado` DECIMAL(8,2) NOT NULL,
  `NombreProducto` VARCHAR(45) NOT NULL,
  `PrecioUnitProducto` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`idTemporal`))
ENGINE = InnoDB;

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES=0;

-- ------------------------
-- DATOS TB_CARGO
-- ------------------------

INSERT INTO `tb_cargo` VALUES (1, "Administrador");
INSERT INTO `tb_cargo` VALUES (2, "Recepcionista");


--------------------------
-- DATOS TB_TIPO_DOCUMENTO
--------------------------

INSERT INTO `tb_tipo_documento` VALUES (1, "DNI");
INSERT INTO `tb_tipo_documento` VALUES (2, "PASAPORTE");


-- ------------------------
-- DATOS TB_CLIENTES
-- ------------------------

INSERT INTO `tb_clientes` VALUES ('C0001', 'Luis Erick'	  	 , 'Palomino Carranza'	,'Av. los Alisos 450' , 980526474,1,65935856);
INSERT INTO `tb_clientes` VALUES ('C0002', 'Jhomira'	 	 , 'Vega Galan'	   		,'Av las Palmeras 850', 965587430,2,'P20198056933');
INSERT INTO `tb_clientes` VALUES ('C0003', 'Carlos Miguel'   , 'Ramos Marin'	   	,'Jr los Incas 2563'  , 960254793,2,'P20196358505');
INSERT INTO `tb_clientes` VALUES ('C0004', 'Monica Fiorella' , 'Hernandez Sanchez'	,'Av. Argentina 1050' , 921347580,1,63587423);
INSERT INTO `tb_clientes` VALUES ('C0005', 'Enrique'		 , 'Correa Flores'	   	,'Av. Colonial 700'   , 999674210,1,65423196);


-- ------------------------
-- DATOS TB_PRODUCTOS
-- ------------------------

INSERT INTO `tb_producto` VALUES ('P0001', 'Chaufa con Pollo'		  , 9.00);
INSERT INTO `tb_producto` VALUES ('P0002', 'Sopa Wantan'			  , 8.50);
INSERT INTO `tb_producto` VALUES ('P0003', 'Caldo de Pollo c/ Verdura', 9.50);
INSERT INTO `tb_producto` VALUES ('P0004', 'Carne de Res a la Plancha', 26.00);
INSERT INTO `tb_producto` VALUES ('P0005', 'Tallarin con Pollo'		  , 23.00);



-- ------------------------
-- DATOS TB_USUARIOS
-- ------------------------

INSERT INTO `tb_usuarios` VALUES(0001, "AD01", "ADMIN01");
INSERT INTO `tb_usuarios` VALUES(0002, "AD02", "ADMIN02");
INSERT INTO `tb_usuarios` VALUES(0003, "RC01", "RECEP01");
INSERT INTO `tb_usuarios` VALUES(0004, "RC02", "RECEP02");
INSERT INTO `tb_usuarios` VALUES(0005, "RC03", "RECEP03");


-- ------------------------
-- DATOS TB_EMPLEADO
-- ------------------------

INSERT INTO `tb_empleado` VALUES ('A0001','CARLOS','AVALOS',1,'98125647'	,'2002-01-14',1,'men' ,'activo',0001);
INSERT INTO `tb_empleado` VALUES ('A0002','EDSON' ,'MENDO' ,1,'94678135'	,'1999-03-04',1,'men'  ,'activo',0002);
INSERT INTO `tb_empleado` VALUES ('R0001','JUAN'  ,'MENDEZ',1,'45612378'	,'1995-10-18',2,'men'  ,'activo',0003);
INSERT INTO `tb_empleado` VALUES ('R0002','MARIA' ,'LOPEZ' ,2,'P20154687913','1990-12-07',2,'woman','activo',0004);
INSERT INTO `tb_empleado` VALUES ('R0003','ABBY'  ,'LOPEZ' ,2,'P20176542676','1985-08-27',2,'woman','activo',0005);


-- ------------------------
-- DATOS TB_ADMINISTRADOR
-- ------------------------

INSERT INTO `tb_administrador` VALUES('A0001', 2500.00);
INSERT INTO `tb_administrador` VALUES('A0002', 2500.00);


-- ------------------------
-- DATOS TB_RECEPCIONISTA
-- ------------------------

INSERT INTO `tb_recepcionista` VALUES('R0001',5,6,16);
INSERT INTO `tb_recepcionista` VALUES('R0002',4,5,15);
INSERT INTO `tb_recepcionista` VALUES('R0003',7,4,14);


-- ------------------------
-- DATOS TB_BOLETA
-- ------------------------

INSERT INTO `tb_boleta` VALUES('B0001','2021-01-14','C0001','R0003');
INSERT INTO `tb_boleta` VALUES('B0002','2021-01-15','C0003','R0002');
INSERT INTO `tb_boleta` VALUES('B0003','2021-01-16','C0005','R0003');
INSERT INTO `tb_boleta` VALUES('B0004','2021-01-17','C0004','R0002');
INSERT INTO `tb_boleta` VALUES('B0005','2021-02-01','C0002','R0001');


-- ------------------------
-- DATOS TB_BOLETA
-- ------------------------

INSERT INTO `tb_boleta_detalle` VALUES('B0001','P0001',2,18.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0001','P0002',1,08.50);
INSERT INTO `tb_boleta_detalle` VALUES('B0002','P0005',2,46.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0002','P0004',1,26.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0003','P0005',3,69.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0004','P0003',2,19.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0005','P0005',5,115.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0005','P0001',2,18.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0005','P0004',3,75.00);
INSERT INTO `tb_boleta_detalle` VALUES('B0005','P0003',4,38.00);


-- ------------------------
-- --- PROCEDIMIENTOS -----
-- ------------------------    

-- -------------------
--     EMPLEADOS
-- -------------------

		-- ------------------------
		-- REGISTRAR ADMINISTRADOR
		-- ------------------------
DELIMITER $$
CREATE PROCEDURE ins_empleadoAdmin(
	`idEmpleado` 		VARCHAR(10),
	`nombreEmpleado` 	VARCHAR(45),
	`apellidoEmpleado` 	VARCHAR(45),
	`idTipoDocumento` 	INT,
	`numeroDocumento` 	VARCHAR(12),
	`fechaNacimiento` 	DATE,
	`idCargo` 			INT,
	`genero` 			VARCHAR(5) ,
	`estado` 			VARCHAR(8),
	`idUsuario` 		INT,
	`login` 			VARCHAR(15),
	`password` 			CHAR(20),
    `sueldo`			DECIMAL(8,2)
)
BEGIN
	INSERT INTO `tb_usuarios` VALUES(`idUsuario`, `login`, `password`);
	INSERT INTO `tb_empleado` VALUES (`idEmpleado`,`nombreEmpleado`,`apellidoEmpleado`,`idTipoDocumento`,`numeroDocumento`,`fechaNacimiento`,`idCargo`,`genero`,`estado`,`idUsuario`);
	INSERT INTO `tb_administrador` VALUES (`idEmpleado`, `sueldo`);
END $$
DELIMITER ;
/*PRUEBA*/
-- CALL ins_empleadoAdmin ('A0003','NombreAdmin','Aprueba',1,'76498513','2000-07-04',1,'woman','activo',0007,'loginAprueba','contraseña',3500);


			-- -------------------------
			-- ACTUALIZAR ADMINISTRADOR
			-- -------------------------

DELIMITER $$ 
CREATE PROCEDURE upd_EmpleadoAdmin(
	`idEmpleado` 		VARCHAR(10),
	`nombreEmpleado` 	VARCHAR(45),
	`apellidoEmpleado` 	VARCHAR(45),
	`estado` 			VARCHAR(8),
	`password` 			CHAR(20),
    `sueldo`			DECIMAL(8,2)
)
BEGIN 
	UPDATE `tb_empleado`
    INNER JOIN `tb_usuarios` 		ON `tb_empleado`.`idUsuario`=`tb_usuarios`.`idUsuario`
    INNER JOIN `tb_administrador`	ON `tb_empleado`.`idEmpleado`=`tb_administrador`.`idEmpleado`
	SET `tb_empleado`.`nombreEmpleado`=`nombreEmpleado`,
		`tb_empleado`.`apellidoEmpleado`=`apellidoEmpleado`,
        `tb_empleado`.`estado`=`estado`,
        `tb_usuarios`.`password`=`password`,
        `tb_administrador`.`sueldo`=`sueldo`
	WHERE `tb_empleado`.`idEmpleado` = `idEmpleado`;
END $$
DELIMITER ;

-- CALL upd_EmpleadoAdmin('A0002','SETCH','ELADMIN','activo','password',9999);

/*
-- Listar Recepcionista
 select * from tb_empleado 
	inner join tb_recepcionista on tb_empleado.idEmpleado=tb_recepcionista.idEmpleado
	inner join tb_usuarios 		on tb_empleado.idUsuario=tb_usuarios.idUsuario;
 -- Listar Admins
 select * from tb_empleado 
	inner join tb_administrador on tb_empleado.idEmpleado=tb_administrador.idEmpleado
    inner join tb_usuarios 		on tb_empleado.idUsuario=tb_usuarios.idUsuario
*/


			-- ------------------------
			-- REGISTRAR RECEPCIONISTA
			-- ------------------------

DELIMITER $$
CREATE PROCEDURE ins_empleadoRecep(
	`idEmpleado` 		VARCHAR(10),
	`nombreEmpleado` 	VARCHAR(45),
	`apellidoEmpleado` 	VARCHAR(45),
	`idTipoDocumento` 	INT,
	`numeroDocumento` 	VARCHAR(12),
	`fechaNacimiento` 	DATE,
	`idCargo` 			INT,
	`genero` 			VARCHAR(5) ,
	`estado` 			VARCHAR(8),
	`idUsuario` 		INT,
	`login` 			VARCHAR(15),
	`password` 			CHAR(20),
    `numHorasPorDia`	INT,
    `diasLaborales`		INT,
    `pagoPorHora`		DECIMAL(8,2)
)
BEGIN
	INSERT INTO `tb_usuarios` 		VALUES(`idUsuario`, `login`, `password`);
	INSERT INTO `tb_empleado` 		VALUES (`idEmpleado`,`nombreEmpleado`,`apellidoEmpleado`,`idTipoDocumento`,`numeroDocumento`,`fechaNacimiento`,`idCargo`,`genero`,`estado`,`idUsuario`);
	INSERT INTO `tb_recepcionista`	VALUES (`idEmpleado`, `numHorasPorDia`,`diasLaborales`,`pagoPorHora`);
END $$
DELIMITER ;
/*PRUEBA*/
-- CALL ins_empleadoRecep ('R0004','NombreRecep','Aprueba',1,'76489123','2002-01-14',2,'men'  ,'activo',0006,'loginRprueba','contraseña',8,6,17.5);


			-- -------------------------
			-- ACTUALIZAR RECEPCIONISTA
			-- -------------------------

DELIMITER $$ 
CREATE PROCEDURE upd_EmpleadoRecep(
	`idEmpleado` 		VARCHAR(10),
	`nombreEmpleado` 	VARCHAR(45),
	`apellidoEmpleado` 	VARCHAR(45),
	`estado` 			VARCHAR(8),
	`password` 			CHAR(20),
    `numHorasPorDia`	INT,
    `diasLaborales`		INT,
    `pagoPorHora`		DECIMAL(8,2)
)
BEGIN 
	UPDATE `tb_empleado`
    INNER JOIN `tb_usuarios` 		ON `tb_empleado`.`idUsuario` =`tb_usuarios`.`idUsuario`
    INNER JOIN `tb_recepcionista`	ON `tb_empleado`.`idEmpleado`=`tb_recepcionista`.`idEmpleado`
		SET `tb_empleado`.`nombreEmpleado`		=`nombreEmpleado`,
			`tb_empleado`.`apellidoEmpleado`	=`apellidoEmpleado`,
			`tb_empleado`.`estado`				=`estado`,
			`tb_usuarios`.`password`			=`password`,
			`tb_recepcionista`.`numHorasPorDia`	=`numHorasPorDia`,
			`tb_recepcionista`.`diasLaborales`	=`diasLaborales`,
			`tb_recepcionista`.`pagoPorHora`	=`pagoPorHora`
	WHERE `tb_empleado`.`idEmpleado` = `idEmpleado`;
END $$
DELIMITER ;
/*PRUEBA*/
--  CALL upd_EmpleadoRECEP('R0004','SETCH','ELRECEP','activo','password',9,9,99);
 

		-- ------------------
		-- ELIMINAR EMPLEADO
		-- ------------------

DELIMITER $$
CREATE PROCEDURE del_Empleado(
	`codigoEmpleado` 	VARCHAR(10)
)
BEGIN 
	DELETE `tb_empleado`,
        `tb_usuarios`,
        `tb_administrador`,
        `tb_recepcionista`
	FROM `tb_empleado`
    INNER JOIN `tb_usuarios`	 ON `tb_empleado`.`idUsuario`=`tb_usuarios`.`idUsuario` 
	LEFT JOIN `tb_recepcionista` ON `tb_empleado`.`idEmpleado`=`tb_recepcionista`.`idEmpleado`
    LEFT JOIN `tb_administrador` ON `tb_empleado`.`idEmpleado`=`tb_administrador`.`idEmpleado`
    WHERE `tb_empleado`.`idEmpleado` = `codigoEmpleado`;
END $$
DELIMITER ;

/*ELIMINAR EMPLEADO PRUEBA*/
-- CALL del_Empleado ('R0004')

-- -------------------
-- VISTAS
-- -------------------
CREATE VIEW view_Administrador
AS
SELECT `tb_empleado`.*, `tb_usuarios` .`login`, `tb_administrador`.`sueldo`
FROM `tb_empleado` 
INNER JOIN `tb_administrador` ON `tb_empleado`.`idEmpleado`=`tb_administrador`.`idEmpleado`
INNER JOIN `tb_usuarios` 	  ON `tb_empleado`.`idUsuario`=`tb_usuarios`.`idUsuario`;

CREATE VIEW view_Recepcionista
AS
SELECT `tb_empleado`.*,`tb_usuarios` .`login`,`tb_recepcionista`.`numHorasPorDia`,`tb_recepcionista`.`diasLaborales`, `tb_recepcionista`.`pagoPorHora`
FROM `tb_empleado` 
INNER JOIN `tb_recepcionista` ON `tb_empleado`.`idEmpleado`=`tb_recepcionista`.`idEmpleado`
INNER JOIN `tb_usuarios` 	  ON `tb_empleado`.`idUsuario`=`tb_usuarios`.`idUsuario`;


/*VISTAR ADMINISTRADOR*/
-- SELECT * FROM view_Administrador WHERE idEmpleado = 'A0001'
/*VISTAR RECEPECIONISTA*/
-- SELECT * FROM view_Recepcionista WHERE idEmpleado = 'R0001'
		
        
        -- -------------------------------------------
		-- REGISTRAR PRODUCTOS DEL CLIENTE (TEMPORAL)
		-- -------------------------------------------
DELIMITER $$
CREATE PROCEDURE ins_productoClienteTemporal(
  `numItem`						INT,
  `idBoleta` 					VARCHAR(45),
  `idCliente` 					VARCHAR(45),
  `idProducto` 					VARCHAR(45),
  `CantidadProducto` 			INT,
  `TotalProductoSeleccinado` 	DECIMAL(8,2),
  `NombreProducto` 				VARCHAR(45) ,
  `PrecioUnitProducto` 			DECIMAL(8,2) 
)
BEGIN 
	INSERT INTO `tb_clienteproducto_temporal` 
		values	(null,
				 `numItem`					,
				 `idBoleta` 				,
				 `idCliente` 				,
				 `idProducto` 				,
				 `CantidadProducto` 		,
				 `TotalProductoSeleccinado` ,
			     `NombreProducto` 			,
			     `PrecioUnitProducto`);
END $$
DELIMITER ;

        -- ----------------------------------------------------
		-- ELIMINAR PRODUCTO SELCCIONADO DEL CLIENTE (TEMPORAL)
		-- -----------------------------------------------------

DELIMITER $$
CREATE PROCEDURE del_productoClienteTemporal(
    `idCliente` 					VARCHAR(45),
	`numItem`						INT
)
BEGIN 
	delete  `tb_clienteproducto_temporal` 
		from `tb_clienteproducto_temporal` 
    where `tb_clienteproducto_temporal`.`idCliente` = `idCliente` AND `tb_clienteproducto_temporal`.`numItem`=`numItem`;
END $$
DELIMITER ;

        -- -------------------------------------------------
		-- SUMA TOTAL DE PRODUCTOS SELCCIONADOS DEL CLIENTE 
		-- -------------------------------------------------

DELIMITER $$
CREATE PROCEDURE sum_TotalproductoClienteTemporal(
    `idCliente` 					VARCHAR(45)
)
BEGIN 
	SELECT sum(`tb_clienteproducto_temporal`.`TotalProductoSeleccinado`)
		FROM `tb_clienteproducto_temporal`
	WHERE `tb_clienteproducto_temporal`.`idCliente` = `idCliente`;
END $$
DELIMITER ;


--  CALL ins_productoClienteTemporal(1,'B0006','C0001','P0002',2,18.00,'PRUDCTO2',9);
--  CALL ins_productoClienteTemporal(2,'B0006','C0001','P0002',2,18.00,'PRUDCTO2',9);
--  CALL ins_productoClienteTemporal(1,'B0006','C0002','P0002',2,18.00,'PRUDCTO2',9);
--  CALL ins_productoClienteTemporal(2,'B0006','C0002','P0005',2,18.00,'PRUDCTO2',9);
--  CALL ins_productoClienteTemporal(3,'B0006','C0002','P0003',2,18.00,'PRUDCTO2',9);
--  SELECT * FROM `tb_ClienteProducto_Temporal`;
--  CALL del_productoClienteTemporal('C0001',2);
--  CALL del_productoClienteTemporal('C0004',1);
--  CALL sum_TotalproductoClienteTemporal('C0001');


		-- ------------------------
		-- OBTENER ID RECEPCIONISTA
		-- ------------------------

DELIMITER $$
CREATE PROCEDURE get_IdRecepcionista(
    `idUsuario` 					INT
)
BEGIN 
	SELECT `tb_empleado`.`idEmpleado`
		FROM `tb_empleado`
	INNER JOIN `tb_usuarios` on `tb_empleado`.`idUsuario`=`tb_usuarios`.`idUsuario`
	WHERE `tb_usuarios`.`idUsuario` = `idUsuario`;
END $$
DELIMITER ;

CALL get_IdRecepcionista (3);

		-- ------------------
		-- REGISTRAR BOLETA
		-- ------------------


DELIMITER $$
CREATE PROCEDURE ins_Boleta(
  `idBoleta` 		VARCHAR(10),
  `fecha`			DATE,
  `idCliente` 		VARCHAR(10),
  `idRecepcionista` VARCHAR(10)
)
BEGIN 
	SELECT sum(`tb_clienteproducto_temporal`.`TotalProductoSeleccinado`)
		FROM `tb_clienteproducto_temporal`
	WHERE `tb_clienteproducto_temporal`.`idCliente` = `idCliente`;
END $$
DELIMITER ;

		-- ------------------------
		-- REGISTRAR DETALLE BOLETA
		-- ------------------------



  `idBoleta` VARCHAR(10) NOT NULL,
  `idProducto` VARCHAR(10) NOT NULL,
  `cantidadProducto` INT NOT NULL,
  `precioTotalProducto` DECIMAL(8,2) NOT NULL,

		-- ------------------
		-- ACCEDER USUARIO
		-- ------------------
            
DELIMITER $$
CREATE PROCEDURE accessUser(
	`user` VARCHAR(15),
    `password` VARCHAR(20)
)
BEGIN
	SELECT  `tb_usuarios`.`idUsuario`,
			`tb_usuarios`.`login`,
			`tb_usuarios`.`password`,
            `tb_empleado`.`idCargo`,
			`tb_empleado`.`genero`,
            `tb_empleado`.`nombreEmpleado`,
            `tb_empleado`.`apellidoEmpleado`
	FROM `tb_usuarios`
    INNER JOIN `tb_empleado` ON `tb_usuarios`.`idUsuario`=`tb_empleado`.`idUsuario`
    WHERE `tb_usuarios`.`login` = `user` AND `tb_usuarios`.`password` = `password`;
END $$
DELIMITER ;

-- CALL accessUser("AD01", "ADMIN01");

-- SELECT SUBSTRING(MAX(`tb_empleado`.`idEmpleado`),2) FROM `tb_empleado` WHERE `tb_empleado`.`idCargo` = 2



/*  ACTUALIZAR CLIENTE*/
delimiter $$
create procedure upd_actulizaCliente(
	id varchar(10),
    nom varchar(45),
    ape varchar(45),
    direc varchar(45),
    telef int,
    tipo int,
    doc varchar(12))
begin 
	update tb_clientes 
		set nombreCliente=nom,
			apellidoCliente=ape,
            direccionCliente=direc,
            numeroTelefonico=telef,
            idtipoDocumento=tipo,
            numeroDocumento=doc
    where idCliente = id;
end $$
delimiter ;


/***** CONSULTA CLIENTE ****/
delimiter $$
create procedure usp_consultaCliente()
begin
	select 
		c.idCliente,
        c.nombreCliente,
        c.apellidoCliente,
        c.direccionCliente,
        c.numeroTelefonico,
        c.numeroDocumento
	from tb_clientes c;
end $$
delimiter ;

-- call usp_consultaCliente();