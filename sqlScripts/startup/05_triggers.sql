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
END;
/

--Productos--
CREATE OR REPLACE
    TRIGGER upperCaseProducto
    BEFORE INSERT OR UPDATE
    ON PRODUCTO
    FOR EACH ROW
BEGIN
    :NEW.DESCRIPCION := UPPER(:NEW.DESCRIPCION);
END;
/

CREATE OR REPLACE
    TRIGGER calcularIVA
    BEFORE INSERT ON VENTA
    DECLARE
        newIva FACTURA.IVA%TYPE;
        newSubTotal FACTURA.SUBTOTAL%TYPE;
        newTotalFactura FACTURA.TOTAL%TYPE;
        subtotalFactura FACTURA.SUBTOTAL%TYPE;
        totalFactura FACTURA.TOTAL%TYPE;
        factura FACTURA%rowtype;
        precioUnitario PRODUCTO.PRECIO_UNI%TYPE;
BEGIN
        SELECT PRECIO_UNI INTO precioUnitario FROM PRODUCTO
            WHERE CODIGO = NEW.CODIGO;
        NEW.TOTAL := precioUnitario* NEW.CANTIDAD;
        SELECT * INTO factura FROM FACTURA
            WHERE NUM_FAC = NEW.NUM_FAC;
        newSubTotal := factura.SUBTOTAL + NEW.TOTAL;
        newTotalFactura := newSubTotal*1.16;
        newIva := newTotalFactura - newSubTotal;
        UPDATE FACTURA
            SET SUBTOTAL = newSubTotal,
                TOTAL = newTotalFactura,
                IVA = newIva
        WHERE

end;



