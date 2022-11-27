-- Procedimiento de creacion de productos 
CREATE OR REPLACE
    PROCEDURE createProducto(codigoP IN PRODUCTO.CODIGO%TYPE, descripcionP IN PRODUCTO.DESCRIPCION%TYPE, precioUniP IN PRODUCTO.PRECIO_UNI%TYPE)
    IS
BEGIN
    INSERT INTO PRODUCTO(CODIGO, DESCRIPCION, PRECIO_UNI)
    VALUES (codigoP, descripcionP, precioUniP);
END createProducto;
/

-- Procedmientos de actualizacion de productos

CREATE OR REPLACE
    PROCEDURE updateDescripcionProducto(codigoP IN PRODUCTO.CODIGO%TYPE, descripcionP IN PRODUCTO.DESCRIPCION%TYPE)
    IS
BEGIN
    UPDATE PRODUCTO
    SET DESCRIPCION = descripcionP
    WHERE CODIGO = codigoP;
END updateDescripcionProducto;
/

CREATE OR REPLACE
    PROCEDURE updatePrecioUnitarioProducto(codigoP IN PRODUCTO.CODIGO%TYPE, precioU IN PRODUCTO.PRECIO_UNI%TYPE)
    IS
BEGIN
    UPDATE PRODUCTO
    SET PRECIO_UNI = precioU
    WHERE CODIGO = codigoP;
END updatePrecioUnitarioProducto;
/

-- Procedmientos de eliminacion de productos

CREATE OR REPLACE
    PROCEDURE deleteProducto(codP IN VARCHAR2)
    IS

BEGIN
    DELETE FROM PRODUCTO
    WHERE CODIGO = codP;
END deleteProducto;
/

-- Procedmientos de consultar de productos

CREATE OR REPLACE
    FUNCTION getProductoByCodigo(codigoP IN VARCHAR2)
    RETURN VARCHAR2
    IS
    consulta PRODUCTO%rowtype;
BEGIN
    SELECT * INTO consulta FROM PRODUCTO
    WHERE CODIGO = codigoP;

    RETURN consulta.CODIGO || ' ' || consulta.DESCRIPCION || ' ' || consulta.PRECIO_UNI;
END getProductoByCodigo;
/


CREATE OR REPLACE
    FUNCTION getProductosBetweenPrecios(minimo IN PRODUCTO.PRECIO_UNI%TYPE, maximo IN PRODUCTO.PRECIO_UNI%TYPE)
    RETURN VARCHAR2
    IS
    consulta VARCHAR2(32767);
    CURSOR tabla IS
        SELECT * FROM PRODUCTO
            WHERE PRECIO_UNI BETWEEN minimo AND maximo;
BEGIN
    consulta := RPAD('CODIGO', 5) || ' ' || RPAD('DESCRIPCION', 70) || ' ' || LPAD('PRECIO UNITARIO',10) || CHR(10);
    FOR row IN tabla
        LOOP
            consulta := consulta || ' ' || RPAD(row.CODIGO, 5)
                                 || ' ' || RPAD(row.DESCRIPCION, 70)
                                 || ' ' || LPAD(row.PRECIO_UNI, 10)
                                 || CHR(10);
        end loop;
    RETURN consulta;
end getProductosBetweenPrecios;
/

CREATE OR REPLACE
    FUNCTION getProductos
    RETURN VARCHAR2
    IS
    consulta VARCHAR2(32767);
    CURSOR tabla IS
        SELECT * FROM PRODUCTO;
BEGIN
    consulta := RPAD('CODIGO', 5) || ' ' || RPAD('DESCRIPCION', 70) || ' ' || LPAD('PRECIO UNITARIO',10) || CHR(10);
    FOR row IN tabla
        LOOP
            consulta := consulta || ' ' || RPAD(row.CODIGO, 5)
                || ' ' || RPAD(row.DESCRIPCION, 70)
                || ' ' || LPAD(row.PRECIO_UNI, 10)
                || CHR(10);
        end loop;
    RETURN consulta;
end getProductos;
/