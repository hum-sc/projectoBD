package view.panels;

import view.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Clientes extends BigPanel {
    private Title title;
    // Menu productos
    private  MenuPanel menuPanel;
    private Button consultarMenuButton;
    private Button registrarMenuButton;
    private Button actualizarMenuButton;

    // Consultar clientes
    private ContentPanel consultar;

    private Text buscarNombre;
    private Text buscarRut;

    private TextField nombreConsulta;
    private TextField rutConsulta;

    private TextArea consultaArea;

    private Button buscarNombreButton;
    private Button buscarRutButton;

    private Button buscarTodosButton;
    private Button eliminarRutButton;

    // Registrar clientes
    private ContentPanel registrar;

    private Text nombreLabel;
    private Text rutLabel;
    private Text direccionLabel;
    private Text telefonoLabel;
    private Text apellidoPatLabel;
    private Text apellidoMatLabel;

    private TextField nombreField;
    private TextField rutField;
    private TextField direccionField;
    private TextField telefonoField;
    private TextField apellidoPatField;
    private TextField apellidoMatField;

    private Button registrarButton;

    // Actualizar clientes
    private ContentPanel actualizar;

    private Text buscarRutActualizar;
    private Text datosActuales;
    private Text nombreLabelActualizar;
    private Text apellidoPatLabelActualizar;
    private Text apellidoMatLabelActualizar;
    private Text domicilioLabelActualizar;
    private Text telefonoLabelActualizar;

    private TextField buscarRutActualizarField;
    private TextField nombreFieldActualizar;
    private TextField apellidoPatFieldActualizar;
    private TextField apellidoMatFieldActualizar;
    private TextField domicilioFieldActualizar;
    private TextField telefonoFieldActualizar;

    private TextArea datosActualesArea;

    private Button buscarRutActualizarButton;
    private Button nombreActualizarButton;
    private Button apellidoPatActualizarButton;
    private Button apellidoMatActualizarButton;
    private Button domicilioActualizarButton;
    private Button telefonoActualizarButton;
    public Clientes(){
        super();
        title = new Title("Clientes");
        title.setLocation(170,30);

        createMenuProductos();

        //Ver productos panel
        createVerProductosPanel();

        // crear producto panel

        createNuevoProductoPanel();

        createActualizarProductoPanel();

        add(title);
        add(menuPanel);
        add(consultar);
        add(registrar);
        add(actualizar);
        showConsultarPanel();
}

    private void createMenuProductos(){
        menuPanel = new MenuPanel();
        menuPanel.setLocation(700, 0);

        consultarMenuButton = new Button("Consultar", menuPanel.buttonsColor, "consultarMenu");
        registrarMenuButton = new Button("Registrar", menuPanel.buttonsColor, "registrarMenu");
        actualizarMenuButton = new Button("Actualizar", menuPanel.buttonsColor, "actualizarMenu");

        consultarMenuButton.setBounds(10, 175, 130, 40);
        registrarMenuButton.setBounds(10, 225, 130, 40);
        actualizarMenuButton.setBounds(10,275,130,40);

        menuPanel.add(consultarMenuButton);
        menuPanel.add(registrarMenuButton);
        menuPanel.add(actualizarMenuButton);
    }
    private void createVerProductosPanel(){
        consultar = new ContentPanel();

        buscarNombre = new Text("Buscar por nombre:");
        buscarRut = new Text("Buscar por RUT: ");

        nombreConsulta = new TextField();
        rutConsulta = new TextField();

        buscarNombreButton = new Button("Buscar", consultar.colorButtons, "consultarNombre");
        buscarRutButton = new Button("Buscar", consultar.colorButtons, "consultarRut");
        buscarTodosButton = new Button("Buscar todos", consultar.colorButtons, "consultarTodos");
        eliminarRutButton = new Button("Eliminar", consultar.colorButtons, "eliminarConsulta");

        consultaArea = new TextArea("");

        buscarNombre.setBounds(20, 10, 200, 30);
        nombreConsulta.setBounds(20, 40, 250, 30);

        buscarRut.setBounds(20, 80, 200, 30);
        rutConsulta.setBounds(20, 110, 250, 30);

        buscarNombreButton.setBounds(280,40, 100, 30);
        buscarTodosButton.setBounds(390, 40, 100, 30);
        buscarRutButton.setBounds(280, 110, 100, 30);
        eliminarRutButton.setBounds(390, 110, 100, 30);

        consultaArea.setBounds(20, 150, 650, 240);

        consultar.add(buscarNombre);
        consultar.add(buscarRut);
        consultar.add(nombreConsulta);
        consultar.add(rutConsulta);
        consultar.add(buscarNombreButton);
        consultar.add(buscarRutButton);
        consultar.add(eliminarRutButton);
        consultar.add(consultaArea);
        consultar.add(buscarTodosButton);
    }
    private void createNuevoProductoPanel(){
        registrar = new ContentPanel();

        rutLabel = new Text("RUT: ");
        nombreLabel = new Text("Nombre: ");
        apellidoPatLabel = new Text("Apellido Paterno: ");
        apellidoMatLabel = new Text("Apellido Materno: ");
        direccionLabel = new Text("Domicilio: ");
        telefonoLabel = new Text("Telefono: ");

        rutField = new TextField();
        nombreField = new TextField();
        apellidoPatField = new TextField();
        apellidoMatField = new TextField();
        direccionField = new TextField();
        telefonoField = new TextField();

        registrarButton = new Button("Registrar", registrar.colorButtons, "registrarCliente");

        rutLabel.setBounds(20, 10, 200, 30);
        rutField.setBounds(20, 40, 250, 30);

        nombreLabel.setBounds(20, 80, 200, 30);
        nombreField.setBounds(20, 110, 250, 30);

        apellidoPatLabel.setBounds(20, 145, 200, 30);
        apellidoPatField.setBounds(20, 175, 250, 30);

        apellidoMatLabel.setBounds(20, 210, 200, 30);
        apellidoMatField.setBounds(20, 240, 250, 30);

        direccionLabel.setBounds(20, 275, 200, 30);
        direccionField.setBounds(20, 305, 250, 30);

        telefonoLabel.setBounds(20, 340, 200, 30);
        telefonoField.setBounds(20, 370, 250, 30);

        registrarButton.setBounds(280, 370, 100, 30);

        registrar.add(rutLabel);
        registrar.add(nombreLabel);
        registrar.add(apellidoPatLabel);
        registrar.add(apellidoMatLabel);
        registrar.add(direccionLabel);
        registrar.add(telefonoLabel);

        registrar.add(rutField);
        registrar.add(nombreField);
        registrar.add(apellidoPatField);
        registrar.add(apellidoMatField);
        registrar.add(direccionField);
        registrar.add(telefonoField);

        registrar.add(registrarButton);

    }
    private void createActualizarProductoPanel(){
        actualizar = new ContentPanel();

        buscarRutActualizar = new Text("Rut: ");
        datosActuales = new Text("Datos cliente: ");
        nombreLabelActualizar = new Text("Nombre: ");
        apellidoPatLabelActualizar = new Text("Apellido Paterno: ");
        apellidoMatLabelActualizar = new Text("Apellido Materno: ");
        domicilioLabelActualizar = new Text("Domicilio: ");
        telefonoLabelActualizar = new Text("Telefono: ");

        buscarRutActualizarField = new TextField();
        nombreFieldActualizar = new TextField();
        apellidoPatFieldActualizar = new TextField();
        apellidoMatFieldActualizar = new TextField();
        domicilioFieldActualizar = new TextField();
        telefonoFieldActualizar = new TextField();

        datosActualesArea = new TextArea("");

        buscarRutActualizarButton = new Button("Buscar", actualizar.colorButtons, "buscarRutActualizar");
        nombreActualizarButton = new Button("Actualizar", actualizar.colorButtons, "actualizarNombre");
        apellidoPatActualizarButton = new Button("Actualizar", actualizar.colorButtons, "actualizarApellidoPat");
        apellidoMatActualizarButton = new Button("Actualizar", actualizar.colorButtons, "actualizarApellidoMat");
        domicilioActualizarButton = new Button("Actualizar", actualizar.colorButtons, "actualizarDomicilio");
        telefonoActualizarButton = new Button("Actualizar", actualizar.colorButtons, "actualizarTelefono");

        buscarRutActualizar.setBounds(20, 10, 120, 30);
        buscarRutActualizarField.setBounds(140, 10, 200, 30);
        buscarRutActualizarButton.setBounds(350, 10, 100, 30);

        datosActuales.setBounds(20, 50, 200, 30);
        datosActualesArea.setBounds(20, 80, 460, 40);

        nombreLabelActualizar.setBounds(20, 130, 120, 30);
        nombreFieldActualizar.setBounds(140, 130, 200, 30);
        nombreActualizarButton.setBounds(350, 130, 100, 30);

        apellidoPatLabelActualizar.setBounds(20, 170, 120, 30);
        apellidoPatFieldActualizar.setBounds(140, 170, 200, 30);
        apellidoPatActualizarButton.setBounds(350, 170, 100, 30);

        apellidoMatLabelActualizar.setBounds(20, 210, 120, 30);
        apellidoMatFieldActualizar.setBounds(140, 210, 200, 30);
        apellidoMatActualizarButton.setBounds(350, 210, 100, 30);

        domicilioLabelActualizar.setBounds(20, 250, 120, 30);
        domicilioFieldActualizar.setBounds(140, 250, 200, 30);
        domicilioActualizarButton.setBounds(350, 250, 100, 30);

        telefonoLabelActualizar.setBounds(20, 290, 120, 30);
        telefonoFieldActualizar.setBounds(140, 290, 200, 30);
        telefonoActualizarButton.setBounds(350, 290, 100, 30);

        actualizar.add(buscarRutActualizar);
        actualizar.add(datosActuales);
        actualizar.add(nombreLabelActualizar);
        actualizar.add(apellidoPatLabelActualizar);
        actualizar.add(apellidoMatLabelActualizar);
        actualizar.add(domicilioLabelActualizar);
        actualizar.add(telefonoLabelActualizar);

        actualizar.add(buscarRutActualizarField);
        actualizar.add(nombreFieldActualizar);
        actualizar.add(apellidoPatFieldActualizar);
        actualizar.add(apellidoMatFieldActualizar);
        actualizar.add(domicilioFieldActualizar);
        actualizar.add(telefonoFieldActualizar);

        actualizar.add(datosActualesArea);

        actualizar.add(buscarRutActualizarButton);
        actualizar.add(nombreActualizarButton);
        actualizar.add(apellidoPatActualizarButton);
        actualizar.add(apellidoMatActualizarButton);
        actualizar.add(domicilioActualizarButton);
        actualizar.add(telefonoActualizarButton);
    }
    public String getNombreConsulta(){
        return nombreConsulta.getText();
    }
    public String getRutConsulta(){
        return rutConsulta.getText();
    }

    public String getRutRegistro(){
        return rutField.getText();
    }
    public String getNombreRegistro(){
        return nombreField.getText();
    }
    public String getApellidoPatRegistro(){
        return apellidoPatField.getText();
    }
    public String getApellidoMatRegistro(){
        return apellidoMatField.getText();
    }
    public String getDireccionRegistro(){
        return direccionField.getText();
    }
    public String getTelefonoRegistro(){
        return telefonoField.getText();
    }

    public String getRutActualizar(){
        return buscarRutActualizarField.getText();
    }
    public String getNombreActualizar(){
        return nombreFieldActualizar.getText();
    }
    public String getApellidoPatActualizar(){
        return apellidoPatFieldActualizar.getText();
    }
    public String getApellidoMatActualizar(){
        return apellidoMatFieldActualizar.getText();
    }
    public String getDireccionActualizar(){
        return domicilioFieldActualizar.getText();
    }
    public String getTelefonoActualizar(){
        return telefonoFieldActualizar.getText();
    }
    public void setTextConsultaArea(String text){
        consultaArea.setText(text);
    }

    public void setTextDatosActualesArea(String text){
        datosActualesArea.setText(text);
    }

    public void showConsultarPanel(){
        consultar.setVisible(true);
        registrar.setVisible(false);
        actualizar.setVisible(false);
    }

    public void showRegistrarPanel(){
        consultar.setVisible(false);
        registrar.setVisible(true);
        actualizar.setVisible(false);
    }

    public void showActualizarPanel(){
        consultar.setVisible(false);
        registrar.setVisible(false);
        actualizar.setVisible(true);
    }

    public void setActionListener(ActionListener actionListener){
        consultarMenuButton.addActionListener(actionListener);
        registrarMenuButton.addActionListener(actionListener);
        actualizarMenuButton.addActionListener(actionListener);

        buscarNombreButton.addActionListener(actionListener);
        buscarRutButton.addActionListener(actionListener);
        eliminarRutButton.addActionListener(actionListener);

        registrarButton.addActionListener(actionListener);

        buscarRutActualizarButton.addActionListener(actionListener);
        nombreActualizarButton.addActionListener(actionListener);
        apellidoPatActualizarButton.addActionListener(actionListener);
        apellidoMatActualizarButton.addActionListener(actionListener);
        domicilioActualizarButton.addActionListener(actionListener);
        telefonoActualizarButton.addActionListener(actionListener);
        buscarTodosButton.addActionListener(actionListener);
    }
}
