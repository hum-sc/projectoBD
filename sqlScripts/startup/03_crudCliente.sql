-- Procedimiento de creacion de cliente
CREATE OR REPLACE
    PROCEDURE createCliente(rutP IN CLIENTE.RUT%TYPE,
                            nombreP IN CLIENTE.NOMBRE%TYPE,
                            apellido_patP IN CLIENTE.APELLIDO_PAT%TYPE,
                            apellido_matP IN CLIENTE.APELLIDO_MAT%TYPE,
                            domicilioP IN CLIENTE.DOMICILIO%TYPE,
                            telefonoP IN CLIENTE.TELEFONO%TYPE)
    IS
BEGIN
    INSERT INTO CLIENTE(RUT, NOMBRE, APELLIDO_PAT, APELLIDO_MAT, DOMICILIO, TELEFONO)
    VALUES (rutP, nombreP, apellido_patP, apellido_matP, domicilioP, telefonoP);
END;
/

-- Procedmientos de actualizacion de cliente

CREATE OR REPLACE
    PROCEDURE updateNombreCliente(rutP IN CLIENTE.RUT%TYPE, nombreP IN CLIENTE.NOMBRE%TYPE)
    IS
BEGIN
    UPDATE CLIENTE
        SET NOMBRE = nombreP
        WHERE RUT = rutP;
END;
/

CREATE OR REPLACE
    PROCEDURE updateApellidoPaternoCliente(rutP IN CLIENTE.RUT%TYPE, apellido IN CLIENTE.APELLIDO_PAT%TYPE)
    IS
BEGIN
    UPDATE CLIENTE
        SET APELLIDO_PAT = apellido
        WHERE RUT = rutP;
END;
/

CREATE OR REPLACE
    PROCEDURE updateApellidoMaternoCliente(rutP IN CLIENTE.RUT%TYPE, apellido IN CLIENTE.APELLIDO_MAT%TYPE)
    IS
BEGIN
    UPDATE CLIENTE
        SET APELLIDO_MAT = apellido
        WHERE RUT = rutP;
END;
/

CREATE OR REPLACE
    PROCEDURE updateDomicilioCliente(rutP IN CLIENTE.RUT%TYPE, domicilioP IN CLIENTE.DOMICILIO%TYPE)
    IS
BEGIN
    UPDATE CLIENTE
    SET DOMICILIO = domicilioP
    WHERE RUT = rutP;
END;
/

CREATE OR REPLACE
    PROCEDURE updateTelefonoCliente(rutP IN CLIENTE.RUT%TYPE, telefonoP IN CLIENTE.TELEFONO%TYPE)
    IS
BEGIN
    UPDATE CLIENTE
        SET TELEFONO = telefonoP
        WHERE RUT = rutP;
END;
/

CREATE OR REPLACE
    PROCEDURE deleteCliente(rutP IN CLIENTE.RUT%TYPE)
    IS
BEGIN
    DELETE CLIENTE
        WHERE RUT = UPPER(rutP);
END;
/

-- read cliente
CREATE OR REPLACE
    FUNCTION getClienteByRut(rutP IN CLIENTE.RUT%TYPE)
    RETURN VARCHAR2
    IS
    consulta CLIENTE%rowtype;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Rut: ' || rutP);
    SELECT * INTO consulta
        FROM CLIENTE
        WHERE RUT = UPPER(rutP);
    RETURN consulta.RUT || ' ' || consulta.NOMBRE || ' ' || consulta.APELLIDO_PAT || ' ' || consulta.APELLIDO_MAT || ' ' || consulta.DOMICILIO || ' ' || consulta.TELEFONO||'';
end;
/

CREATE OR REPLACE
    FUNCTION getClienteByNombre(nombreP IN CLIENTE.NOMBRE%TYPE)
    RETURN VARCHAR2
    IS
    consulta VARCHAR2(32767);
    CURSOR tabla IS
    SELECT * FROM CLIENTE
        WHERE NOMBRE = upper(nombreP)
    ORDER BY NOMBRE;
BEGIN

    consulta := RPAD('RUT', 12) || ' ' || RPAD('NOMBRE', 30) || ' ' || RPAD('APELLIDO PATERNO', 30)
                || ' ' || RPAD('APELLIDO MATERNO', 30) || ' ' || RPAD('DOMICILIO',80) || ' ' || RPAD('TELEFONO',10)||CHR(10);
    FOR row IN tabla
        LOOP
            consulta := consulta || ' ' || RPAD(row.RUT, 12)
                                 || ' ' || RPAD(row.NOMBRE, 30)
                                 || ' ' || RPAD(row.APELLIDO_PAT, 30)
                                 || ' ' || RPAD(row.APELLIDO_MAT, 30)
                                 || ' ' || RPAD(row.DOMICILIO, 80)
                                 || ' ' || LPAD(row.TELEFONO, 10)
                                 || ' ' || chr(10) ;
        end loop;
    return consulta;
end;
/

CREATE OR REPLACE
    FUNCTION getClientes
    RETURN VARCHAR2
    IS
    consulta VARCHAR2(32767);
    CURSOR tabla IS
        SELECT * FROM CLIENTE
        ORDER BY NOMBRE;
BEGIN

    consulta := RPAD('RUT', 12) || ' ' || RPAD('NOMBRE', 30) || ' ' || RPAD('APELLIDO PATERNO', 30)
        || ' ' || RPAD('APELLIDO MATERNO', 30) || ' ' || RPAD('DOMICILIO',80) || ' ' || RPAD('TELEFONO',10)||CHR(10);
    FOR row IN tabla
        LOOP
            consulta := consulta || ' ' || RPAD(row.RUT, 12)
                || ' ' || RPAD(row.NOMBRE, 30)
                || ' ' || RPAD(row.APELLIDO_PAT, 30)
                || ' ' || RPAD(row.APELLIDO_MAT, 30)
                || ' ' || RPAD(row.DOMICILIO, 80)
                || ' ' || LPAD(row.TELEFONO, 10)
                || ' ' || chr(10) ;
        end loop;
    return consulta;
end;
/

CREATE OR REPLACE
    FUNCTION getNombreCliente(rutP IN CLIENTE.RUT%TYPE)
    RETURN VARCHAR2
    IS
    nombre CLIENTE.NOMBRE%TYPE;
BEGIN
    SELECT NOMBRE INTO nombre
        FROM CLIENTE
        WHERE RUT = UPPER(rutP);
    RETURN nombre;
end;
/

CREATE OR REPLACE
    FUNCTION getApellidoPaternoCliente(rutP IN CLIENTE.RUT%TYPE)
    RETURN VARCHAR2
    IS
    apellido CLIENTE.APELLIDO_PAT%TYPE;
BEGIN
    SELECT APELLIDO_PAT INTO apellido
        FROM CLIENTE
        WHERE RUT = UPPER(rutP);
    RETURN apellido;
end;

CREATE OR REPLACE
    FUNCTION getApellidoMaternoCliente(rutP IN CLIENTE.RUT%TYPE)
    RETURN VARCHAR2
    IS
    apellido CLIENTE.APELLIDO_MAT%TYPE;
BEGIN
    SELECT APELLIDO_MAT INTO apellido
        FROM CLIENTE
        WHERE RUT = UPPER(rutP);
    RETURN apellido;
end;

CREATE OR REPLACE
    FUNCTION getDomicilioCliente(rutP IN CLIENTE.RUT%TYPE)
    RETURN VARCHAR2
    IS
    domicilio CLIENTE.DOMICILIO%TYPE;
BEGIN
    SELECT DOMICILIO INTO domicilio
        FROM CLIENTE
        WHERE RUT = UPPER(rutP);
    RETURN domicilio;
end;

CREATE OR REPLACE
    FUNCTION getTelefonoCliente(rutP IN CLIENTE.RUT%TYPE)
    RETURN NUMBER
    IS
    telefono CLIENTE.TELEFONO%TYPE;
BEGIN
    SELECT TELEFONO INTO telefono
        FROM CLIENTE
        WHERE RUT = UPPER(rutP);
    RETURN telefono;
end;

CREATE OR REPLACE
    PROCEDURE deleteCliente(rutP IN CLIENTE.RUT%TYPE)
    IS
BEGIN
    DELETE FROM CLIENTE
        WHERE RUT = UPPER(rutP);
end;
