-- Procedimiento de creacion de cliente
CREATE OR REPLACE
    PROCEDURE createCliente(rutP IN VARCHAR2, nombreP IN VARCHAR2, apellido_patP IN VARCHAR2,
        apellido_matP IN VARCHAR2, domicilioP in VARCHAR2, telefonoP IN NUMBER)
    IS
    rutU          VARCHAR2(12);
    nombreU       VARCHAR2(30);
    apellido_patU VARCHAR2(30);
    apellido_matU VARCHAR2(30);
    domicilioU    VARCHAR2(80);

BEGIN
    rutU := UPPER(rutP);
    nombreU := UPPER(nombreP);
    apellido_patU := UPPER(apellido_patP);
    apellido_matU := UPPER(apellido_matP);
    domicilioU := UPPER(domicilioP);
INSERT INTO CLIENTE(RUT, NOMBRE, APELLIDO_PAT, APELLIDO_MAT, DOMICILIO, TELEFONO)
VALUES (rutU, nombreU, apellido_patU, apellido_matU, domicilioU, telefonoP);
END;
/

-- Procedmientos de actualizacion de cliente

CREATE OR REPLACE
    PROCEDURE updateNombreCliente(rutP IN VARCHAR2, nombreP IN VARCHAR2)
    IS
    nombreU VARCHAR2(30);
BEGIN
    nombreU := UPPER(nombreP);
    UPDATE CLIENTE
        SET NOMBRE=nombreU
        WHERE RUT = rutP;
END;
/

CREATE OR REPLACE
    PROCEDURE updateApellidoPaternoCliente(rutP IN VARCHAR2, apellidoP IN VARCHAR2)
    IS
    rutU VARCHAR2(12);
    apellido VARCHAR2(30);
BEGIN
    rutU := UPPER(rutP);
    apellido := UPPER(apellidoP);
    UPDATE CLIENTE
        SET APELLIDO_PAT = apellido
        WHERE RUT = rutU;
END;
/

CREATE OR REPLACE
    PROCEDURE updateApellidoMaternoCliente(rutP IN VARCHAR2, apellidoP IN VARCHAR2)
    IS
    rutU VARCHAR2(12);
    apellido VARCHAR(12);
BEGIN
    apellido := UPPER(apellidoP);
    rutU := UPPER(rutP);
    UPDATE CLIENTE
        SET APELLIDO_MAT = apellido
        WHERE RUT = rutU;
END;
/

CREATE OR REPLACE
    PROCEDURE updateDomicilioCliente(rutP IN VARCHAR2, domicilioP IN VARCHAR2)
    IS
    rutU VARCHAR2(12);
    domicilio VARCHAR (80);
BEGIN
    rutU := UPPER(rutP);
    domicilio := UPPER(domicilioP);
    UPDATE CLIENTE
        SET DOMICILIO = domicilio
        WHERE RUT = rutU;
END;
/

CREATE OR REPLACE
    PROCEDURE updateTelefonoCliente(rutP IN VARCHAR2, telefonoP IN NUMBER)
    IS
    rutU VARCHAR2(12);
BEGIN
    rutU := UPPER(rutP);
    UPDATE CLIENTE
        SET TELEFONO = telefonoP
        WHERE RUT = rutU;
END;
