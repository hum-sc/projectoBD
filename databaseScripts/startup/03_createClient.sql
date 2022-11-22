CREATE OR REPLACE
    PROCEDURE createClient(rutP IN VARCHAR2, nombreP IN VARCHAR2, apellido_patP IN VARCHAR2,
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