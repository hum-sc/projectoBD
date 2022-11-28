-- Procedimiento de creacion de productos 
CREATE OR REPLACE
    PROCEDURE createProductos (cod IN VARCHAR2, descP IN VARCHAR2, precioUP IN NUMBER)
    IS
    codU          VARCHAR2(5);
    descPU        VARCHAR2(60);

BEGIN
    codU := UPPER(cod);
    descU := UPPER(descP);
    
INSERT INTO PRODUCTO(CODIGO, DESCRIPCION, PRECIO_UNI)
VALUES (codU, descU, precioUP);
END;
/


