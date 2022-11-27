CREATE OR REPLACE
    PROCEDURE createFactura(num_facP FACTURA.NUM_FAC%TYPE,
           rutP FACTURA.RUT%TYPE)
    IS
     num VARCHAR2(5);
     sub NUMBER := 0;
     iva NUMBER := 0;
     total NUMBER := 0;
     rut VARCHAR2(10);

 BEGIN

INSERT INTO FACTURA(NUM_FAC, FECHA, SUBTOTAL, IVA, TOTAL, RUT)
             VALUES (num_facP, TO_DATE(to_char(SYSDATE, 'dd/mm/yyyy'),'dd/mm/yyyy') , 0,0,0, rutP);
END createFactura;

/

CREATE OR REPLACE
    PROCEDURE delateFactura
    (numFactP FACTURA.NUM_FAC%TYPE)
    IS
BEGIN
    DELETE FROM FACTURA
    WHERE NUM_FAC = numFactP;
END delateFactura;
/


