-- Clientes --
CREATE OR REPLACE
    TRIGGER upperCaseCliente
    BEFORE INSERT OR UPDATE
    ON CLIENTE
    FOR EACH ROW
BEGIN
    :NEW.RUT := UPPER(:NEW.RUT);
    :NEW.NOMBRE := UPPER(:NEW.NOMBRE);
    :NEW.APELLIDO_PAT := UPPER(:NEW.APELLIDO_PAT);
    :NEW.APELLIDO_MAT := UPPER(:NEW.APELLIDO_MAT);
    :NEW.DOMICILIO := UPPER(:NEW.DOMICILIO);
END upperCaseCliente;
/

--Productos--
CREATE OR REPLACE
    TRIGGER upperCaseProducto
    BEFORE INSERT OR UPDATE
    ON PRODUCTO
    FOR EACH ROW
BEGIN
    :NEW.DESCRIPCION := UPPER(:NEW.DESCRIPCION);
END upperCaseProducto;
/

CREATE OR REPLACE
    TRIGGER insertVenta
    BEFORE INSERT
    ON VENTA
    FOR EACH ROW
    DECLARE
        newIva FACTURA.IVA%TYPE;
        newSubTotal FACTURA.SUBTOTAL%TYPE;
        newTotal FACTURA.TOTAL%TYPE;
        facturaP FACTURA%rowtype;
        precioUnitario PRODUCTO.PRECIO_UNI%TYPE;
BEGIN
        SELECT PRECIO_UNI INTO precioUnitario FROM PRODUCTO
            WHERE CODIGO = :NEW.CODIGO;
        :NEW.TOTAL := precioUnitario * :NEW.CANTIDAD;

        SELECT * INTO facturaP FROM FACTURA
            WHERE NUM_FAC = :NEW.NUM_FAC;

        newSubTotal := facturaP.SUBTOTAL + :NEW.TOTAL;
        newTotal := newSubTotal*1.16;
        newIva := newTotaL - newSubTotal;

        UPDATE FACTURA
            SET SUBTOTAL = newSubTotal,
                TOTAL = newTotal,
                IVA = newIva
        WHERE NUM_FAC = :NEW.NUM_FAC;
end insertVenta;
/

CREATE OR REPLACE
    TRIGGER deleteVenta
    BEFORE DELETE
    ON VENTA
    FOR EACH ROW
    DECLARE
        newIva FACTURA.IVA%TYPE;
        newSubTotal FACTURA.SUBTOTAL%TYPE;
        newTotal FACTURA.TOTAL%TYPE;
        facturaP FACTURA%rowtype;
        precioUnitario PRODUCTO.PRECIO_UNI%TYPE;
BEGIN
        SELECT * INTO facturaP FROM FACTURA
            WHERE NUM_FAC = :OLD.NUM_FAC;
        newSubTotal := facturaP.SUBTOTAL - :OLD.TOTAL;
        newTotal := newSubTotal*1.16;
        newIva := newTotaL - newSubTotal;
        UPDATE FACTURA
            SET SUBTOTAL = newSubTotal,
                TOTAL = newTotal,
                IVA = newIva
        WHERE NUM_FAC = :OLD.NUM_FAC;
end;

CREATE OR REPLACE
    TRIGGER updateVenta
    BEFORE UPDATE
    ON VENTA
    FOR EACH ROW
    DECLARE
        newIva FACTURA.IVA%TYPE;
        newSubTotal FACTURA.SUBTOTAL%TYPE;
        newTotal FACTURA.TOTAL%TYPE;
        facturaP FACTURA%rowtype;
        precioUnitario PRODUCTO.PRECIO_UNI%TYPE;
BEGIN
        SELECT PRECIO_UNI INTO precioUnitario FROM PRODUCTO
            WHERE CODIGO = :NEW.CODIGO;
        :NEW.TOTAL := precioUnitario * :NEW.CANTIDAD;
        SELECT * INTO facturaP FROM FACTURA
            WHERE NUM_FAC = :NEW.NUM_FAC;
        newSubTotal := facturaP.SUBTOTAL - :OLD.TOTAL + :NEW.TOTAL;
        newTotal := newSubTotal*1.16;
        newIva := newTotaL - newSubTotal;
        UPDATE FACTURA
            SET SUBTOTAL = newSubTotal,
                TOTAL = newTotal,
                IVA = newIva
        WHERE NUM_FAC = :NEW.NUM_FAC;
    end;

-- Factura --
CREATE OR REPLACE
    TRIGGER upperCaseFactura
    BEFORE INSERT OR UPDATE
    ON FACTURA
    FOR EACH ROW
BEGIN
    :NEW.RUT := UPPER(:NEW.RUT);
    :NEW.NUM_FAC := UPPER(:NEW.NUM_FAC);
END upperCaseFactura;
/

CREATE OR REPLACE
    TRIGGER deleteFactura
    AFTER DELETE
    ON FACTURA
    FOR EACH ROW
BEGIN
    DELETE FROM VENTA
        WHERE NUM_FAC = :OLD.NUM_FAC;
END deleteFactura;
/



