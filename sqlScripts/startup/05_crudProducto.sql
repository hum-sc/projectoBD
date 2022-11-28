-- Procedmientos de actualizacion de productos

CREATE OR REPLACE
    PROCEDURE updateDescripcionProducto(codP IN VARCHAR2, descP IN VARCHAR2)
    IS
    descU VARCHAR2(60);
BEGIN
    descU := UPPER(descP);
    UPDATE PRODUCTO
        SET DESCRIPCION = descU
        WHERE CODIGO = codP;
END;
/

CREATE OR REPLACE
    PROCEDURE updatePrecioUnitarioProducto(codP IN VARCHAR2, precioUP IN NUMBER)
    IS
    precioUU NUMBER(7,2);
BEGIN
    UPDATE PRODUCTO
        SET PRECIO_UNI = precioU
        WHERE CODIGO = codP;
END;
/

-- Procedmientos de eliminacion de productos

CREATE OR REPLACE
    PROCEDURE deleteProducto(codP IN VARCHAR2)
    IS
    
BEGIN
    DELETE FROM PRODUCTO
    WHERE CODIGO = codP;
END;
/

-- Procedmientos de consultar de productos

CREATE OR REPLACE
    PROCEDURE selectProducto(codP IN VARCHAR2)
    IS

BEGIN
    SELECT * FROM PRODUCTO 
    WHERE CODIGO = codP;
END;
/