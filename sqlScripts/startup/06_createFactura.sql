CREATE OR REPLACE
            PROCEDURE pr_create_factura(numV FACTURA.NUM_FAC%TYPE, 
                       fechaV FACTURA.FECHA%TYPE, subV FACTURA.SUBTOTAL%TYPE,
                       ivaV FACTURA.IVA%TYPE, totalV FACTURA.TOTAL%TYPE, 
                       rutV FACTURA.RUT%TYPE)
               IS 
                 numU VARCHAR2(5);
                 fechaU TO_DATE ('dd/mm/yyyy');
                 subU NUMBER := 0;
                 ivaU NUMBER := 0;
                 totalU NUMBER := 0;
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

END pr_create_factura;

//

CREATE OR REPLACE 
          PROCEDURE pr_create_Venta
          (rCantidad        IN VENTA.CANTIDAD%TYPE,
           rNumF            IN VENTA.NUM_FAC%TYPE,
           rCodigo          IN VENTA.CODIGO%TYPE
          )
          
          IS 
          
BEGIN 
    INSERT INTO VENTA (cantidad, 
                num_fac,
                codigo)
    VALUES (rCantidad,
            rNumF,
            rCodigo);
            
END pr_create_Venta;
/
