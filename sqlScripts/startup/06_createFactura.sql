CREATE OR REPLACE
            PROCEDURE pr_create_factura(numV FACTURA.NUM_FAC%TYPE, 
                       fechaV FACTURA.FECHA%TYPE,
                       rutV FACTURA.RUT%TYPE)
               IS 
                 numU VARCHAR2(5);
                 subU NUMBER := 0;
                 ivaU NUMBER := 0;
                 totalU NUMBER := 0;
                 rutU VARCHAR2(10);

             BEGIN 
                 numU := UPPER(numV);
                 rutU := UPPER(rutV);

INSERT INTO FACTURA(NUM_FAC, FECHA, SUBTOTAL, IVA, TOTAL, RUT)
             VALUES (numU, fechaV, 0,0,0, rutU);

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
