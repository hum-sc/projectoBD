CREATE OR REPLACE
    PROCEDURE createVenta (cantidadP IN VENTA.CANTIDAD%TYPE,
                numFacP IN VENTA.NUM_FAC%TYPE,
                codigoProdP IN VENTA.CODIGO%TYPE)
    IS
    facturaFecha FACTURA.FECHA%TYPE;
    no_date_equal EXCEPTION;
BEGIN
    SELECT FECHA INTO facturaFecha FROM FACTURA WHERE NUM_FAC = numFacP;
    DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'DD/MM/YYYY')||':'||to_char(facturaFecha, 'DD/MM/YYYY'));
    IF (TO_CHAR(SYSDATE, 'DD/MM/YYYY') = TO_CHAR(facturaFecha, 'DD/MM/YYYY')) THEN
        INSERT INTO VENTA(cantidad, total, num_fac, codigo) VALUES (cantidadP, 0, numFacP, codigoProdP);
    ELSE
        RAISE no_date_equal;
    END IF;
EXCEPTION
    WHEN no_date_equal THEN
        RAISE_APPLICATION_ERROR(-20001,'No puedes agregar una venta a la facura porque la factura se creo un dia distinto a hoy');
END createVenta;
/

-- Update Venta


CREATE OR REPLACE
    PROCEDURE updateCantidadVenta(cantidadP IN VENTA.CANTIDAD%TYPE, codigoP IN VENTA.CODIGO%TYPE, num_facP IN VENTA.NUM_FAC%TYPE)
    IS
BEGIN
    UPDATE VENTA SET cantidad = cantidadP WHERE codigo = codigoP AND num_fac = num_facP;
END updateCantidadVenta;
/

CREATE OR REPLACE
    PROCEDURE updateCodigoVenta(newCodigoP IN VENTA.CODIGO%TYPE, codigoP IN VENTA.CODIGO%TYPE, num_facP IN VENTA.NUM_FAC%TYPE)
    IS
BEGIN
    UPDATE VENTA SET codigo = newCodigoP WHERE codigo = codigoP and num_fac = num_facP;
END updateCodigoVenta;
/

CREATE OR REPLACE
    FUNCTION getVenta(codigoP IN VENTA.CODIGO%TYPE, num_facP IN VENTA.NUM_FAC%TYPE)
    RETURN Varchar2
    IS
    ventaV VENTA%ROWTYPE;
BEGIN
    SELECT * INTO ventaV FROM VENTA WHERE codigo = codigoP AND num_fac = num_facP;
    RETURN ventaV.CODIGO || ' ' || ventaV.CANTIDAD || ' ' || ventaV.TOTAL || ' ' || ventaV.NUM_FAC;
END getVenta;
/

-- Delete Venta

CREATE OR REPLACE
    PROCEDURE deleteVenta( codigoP IN VENTA.CODIGO%TYPE, num_facP IN VENTA.NUM_FAC%TYPE)
    IS
BEGIN
    DELETE FROM VENTA WHERE codigo = codigoP and num_fac = num_facP;
END deleteVenta;
/