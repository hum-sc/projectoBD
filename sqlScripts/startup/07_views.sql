CREATE OR REPLACE
    VIEW datosVenta ( factura, cantidad, codigoProducto,
    descripcionProducto, precioUnitario, total)
AS
SELECT
        f.NUM_FAC as factura,
        v.CANTIDAD AS cantidad,
        p.CODIGO AS codigoProducto,
        p.DESCRIPCION AS descripcionProducto,
        p.PRECIO_UNI AS precioUnitario,
        v.TOTAL AS total
FROM FACTURA F, VENTA V, PRODUCTO P, CLIENTE C
WHERE F.NUM_FAC = V.NUM_FAC AND V.CODIGO = P.CODIGO AND F.RUT = C.RUT;
/

CREATE OR REPLACE
    VIEW datosFactura(numero, fecha, rut, nombre, domicilio, telefono, subtotal, iva, total, num_ventas)
AS
SELECT
    f.num_fac as numero,
    f.fecha as fecha,
    c.rut as rut,
    c.NOMBRE || ' ' || c.APELLIDO_PAT || ' ' || c.APELLIDO_MAT as nombre,
    c.DOMICILIO as domicilio,
    c.TELEFONO as telefono,
    f.subtotal as subtotal,
    f.iva as iva,
    f.total as total,
    (SELECT COUNT(*) FROM VENTA WHERE NUM_FAC = f.NUM_FAC) AS num_ventas
FROM FACTURA F, CLIENTE C
WHERE F.RUT = C.RUT;
/

select * from datosFactura;