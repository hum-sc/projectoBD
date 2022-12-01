CREATE OR REPLACE
    FUNCTION getFacturaByNum(numFactP FACTURA.NUM_FAC%TYPE)
    RETURN VARCHAR2
    IS
    consulta VARCHAR2(32767);
    factura DATOSFACTURA%rowtype;
    CURSOR ventas IS
        SELECT * FROM DATOSVENTA
        WHERE FACTURA = numFactP;
BEGIN
    SELECT * INTO factura FROM DATOSFACTURA
    WHERE NUMERO = numFactP;
    consulta := 'Factura: [ ' || numFactP || ' ]' || chr(10)||
                ' Fecha: [' || factura.FECHA ||' ]' || chr(10)||
                ' RUT: [' || factura.RUT || ' ]' || chr(10)||
                'Nombre: [' || factura.NOMBRE || ' ]' || chr(10)||
                'Domicilio: [' || factura.DOMICILIO || ' ]' || chr(10)||
                'Telefono: [' || factura.TELEFONO || ' ]' || chr(10)||
                '----------------------------------------------------------------------' || chr(10)||
                RPAD('Codigo', 10) || RPAD('Descripcion', 30) || LPAD('Cantidad',10) ||
                LPAD('Precio', 10) || LPAD('Total', 10) || chr(10);
    consulta := consulta || '----------------------------------------------------------------------' || chr(10);
    FOR v IN ventas LOOP
            consulta := consulta ||  RPAD(v.CODIGOPRODUCTO, 10) || RPAD(v.DESCRIPCIONPRODUCTO, 30)
                || LPAD(v.CANTIDAD, 10) || LPAD(v.PRECIOUNITARIO, 10) || LPAD(v.TOTAL, 10) || chr(10);
        END LOOP;
    consulta := consulta || '----------------------------------------------------------------------' || chr(10)||
                '.'||LPAD('Subtotal: ' || chr(36) || factura.SUBTOTAL || '',69) || chr(10)||
                '.'||LPAD('IVA: ' || chr(36) || factura.IVA || '',69) || chr(10)||
                '.'||LPAD('Total: ' || chr(36) || factura.TOTAL || '',69) || chr(10);
    RETURN consulta;
END getFacturaByNum;
/
CREATE OR REPLACE
    FUNCTION getNumVentasByFactura(rutP FACTURA.NUM_FAC%type)
    RETURN NUMBER
    IS
    numVentas NUMBER;
    BEGIN
        SELECT NUM_VENTAS into numVentas FROM DATOSFACTURA
        WHERE RUT = UPPER(rutP);
        RETURN numVentas;
    END getNumVentasByFactura;
    /

CREATE OR REPLACE
    FUNCTION getFacturas
    RETURN VARCHAR2
    IS
    consulta VARCHAR2(32767);
    numeroFactura DATOSFACTURA.NUMERO%TYPE;
    CURSOR facturas IS
        SELECT * FROM DATOSFACTURA
        WHERE NUM_VENTAS >0
        ORDER BY NUMERO;
    CURSOR ventas IS
        SELECT * FROM DATOSVENTA
        WHERE FACTURA = numeroFactura;
BEGIN
    consulta := '';
    FOR f IN facturas
        LOOP
            numeroFactura := f.NUMERO;
            consulta := consulta || 'Factura: [ ' || f.NUMERO || ' ]' || chr(10)||
                        ' Fecha: [' || f.FECHA ||' ]' || chr(10)||
                        ' RUT: [' || f.RUT || ' ]' || chr(10)||
                        'Nombre: [' || f.NOMBRE || ' ]' || chr(10)||
                        'Domicilio: [' || f.DOMICILIO || ' ]' || chr(10)||
                        'Telefono: [' || f.TELEFONO || ' ]' || chr(10)||
                        '----------------------------------------------------------------------' || chr(10)||
                        RPAD('Codigo', 10) || RPAD('Descripcion', 30) || LPAD('Cantidad',10) ||
                        LPAD('Precio', 10) || LPAD('Total', 10) || chr(10);
            consulta := consulta || '----------------------------------------------------------------------' || chr(10);
            FOR v IN ventas

                LOOP
                    consulta := consulta ||  RPAD(v.CODIGOPRODUCTO, 10) || RPAD(v.DESCRIPCIONPRODUCTO, 30)
                            || LPAD(v.CANTIDAD, 10) || LPAD(v.PRECIOUNITARIO, 10) || LPAD(v.TOTAL, 10) || chr(10);
                END LOOP;
            consulta := consulta || '----------------------------------------------------------------------' || chr(10)||
                        '.'||LPAD('Subtotal: ' || chr(36) || f.SUBTOTAL || '',69) || chr(10)||
                        '.'||LPAD('IVA: ' || chr(36) || f.IVA || '',69) || chr(10)||
                        '.'||LPAD('Total: ' || chr(36) || f.TOTAL || '',69) || chr(10);
    END LOOP;
    RETURN consulta;
END getFacturas;
/
