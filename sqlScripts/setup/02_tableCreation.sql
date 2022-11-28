
    ---------------- TABLA CLIENTE -----------------
CREATE TABLE CLIENTE (
    rut                 VARCHAR (12) NOT NULL,
    nombre              VARCHAR (30) NOT NULL,
    apellido_pat        VARCHAR (30) NOT NULL,
    apellido_mat        VARCHAR (30) NOT NULL,
    domicilio           VARCHAR (80) NOT NULL,
    telefono            NUMBER(10) NOT NULL,
    CONSTRAINT CLIENTE_PK PRIMARY KEY (rut)
);

---------------- TABLA FACTURA ----------------
CREATE TABLE FACTURA(
    num_fac             VARCHAR (5) NOT NULL,
    fecha               DATE NOT NULL,
    subtotal            NUMBER (7, 2) NOT NULL,
    iva                 NUMBER (7, 2) NOT NULL,
    total               NUMBER (7, 2) NOT NULL,
    rut                 VARCHAR (12)  NOT NULL,
    CONSTRAINT FACTURA_PK PRIMARY KEY (num_fac),
    CONSTRAINT RUT_FK FOREIGN KEY (rut) REFERENCES CLIENTE,
    CONSTRAINT NUM_FACT_CHK CHECK ( REGEXP_LIKE(num_fac, '[A-Z]\d{4}')),
    CONSTRAINT SUBTOTAL_CHK CHECK (subtotal >= 0),
    CONSTRAINT TOTAL_CHK CHECK (total >= 0)
);
--------------- TABLA PRODUCTO ------------------
CREATE TABLE PRODUCTO (
    codigo              VARCHAR (5) NOT NULL,
    descripcion         VARCHAR (60) NOT NULL,
    precio_uni          NUMBER (7, 2) NOT NULL,
    CONSTRAINT PRODUCTO_PK PRIMARY KEY (codigo),
    CONSTRAINT PRECIO_UNI_CHK CHECK (precio_uni >= 0)
);

--------------- TABLA VENTA -----------------
CREATE TABLE VENTA(
    cantidad        NUMBER (4) NOT NULL,
    total          NUMBER (7, 2) NOT NULL,
    num_fac         VARCHAR (5) NOT NULL,
    codigo          VARCHAR (5) NOT NULL,
    CONSTRAINT VENTA_PK PRIMARY KEY (num_fac, codigo),
    CONSTRAINT NUM_FAC_FK FOREIGN KEY (num_fac) REFERENCES FACTURA,
    CONSTRAINT CODIGO_FK FOREIGN KEY (codigo) REFERENCES PRODUCTO,
    CONSTRAINT CANTIDAD_CHK CHECK (cantidad >= 0),
    CONSTRAINT TOTAL_VENTA_CHK CHECK (total >= 0)
);