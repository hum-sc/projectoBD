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
        WHERE RUT = rutP;
END;
/

-- read cliente
CREATE OR REPLACE
    FUNCTION getClienteByRut(rutP IN CLIENTE.RUT%TYPE)
    RETURN STRING
    IS
    consulta CLIENTE%rowtype;
BEGIN
    SELECT * INTO consulta
        FROM CLIENTE
        WHERE RUT = rutP;
    RETURN consulta.RUT || ' ' || consulta.NOMBRE || ' ' || consulta.APELLIDO_PAT || ' ' || consulta.APELLIDO_MAT || ' ' || consulta.DOMICILIO || ' ' || consulta.TELEFONO||'';
end;
/

CREATE OR REPLACE
    FUNCTION getClienteByNombre(nombreP IN CLIENTE.NOMBRE%TYPE)
    RETURN STRING
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
    FUNCTION getClientes(nombreP IN CLIENTE.NOMBRE%TYPE)
    RETURN STRING
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
    PROCEDURE deleteCliente(rutP IN CLIENTE.RUT%TYPE)
    IS
BEGIN
    DELETE FROM CLIENTE
        WHERE RUT = rutP;
end;
