CREATE OR REPLACE PROCEDURE pr_calcular_iva (numfac factura.num_fac%TYPE)
    IS
    costofinal NUMBER;
    costo      NUMBER;
    iva        NUMBER;
BEGIN
    SELECT
        total
    INTO costofinal
    FROM
        factura
    WHERE
        num_fac = numfac;

    costo := costofinal / 1.16;
    iva := costofinal - costo;
    dbms_output.put_line('PRODUCTO'
                         || numfac
                         || ': '
                         || to_char(costo, '9,999.99')
                         || ' + '
                         || to_char(iva, '9,999.99')
                         || ' = '
                         || to_char(costofinal, '9,999.99'));

END pr_calcular_iva;
/

CREATE OR REPLACE PROCEDURE createFactura(numV IN VARCHAR2, fechaV DATE, subV IN NUMBER,
ivaV IN NUMBER, totalV IN NUMBER, rutV IN VARCHAR2)

    IS 
    numU VARCHAR2(5);
    fechaU TO_DATE ('dd/mm/yyyy');
    subU NUMBER(7,2);
    ivaU NUMBER(7,2);
    totalU NUMBER(7,2);
    rutV VARCHAR2(10);

BEGIN 
          numU := UPPER(numV);
          fechaU := UPPER(fechaV);
          subU := UPPER(subV);
          ivaU := UPPER(ivaV);
          totalU := UPPER(totalV);
          rutV := UPPER(rutV);

INSERT INTO FACTURA(NUM_FAC, FECHA, SUBTOTAL, IVA, TOTAL, RUT)
VALUES (numU, fechaU, subU, ivaU, totalU, rutV);
END;








