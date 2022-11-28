package Factura.presentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatosC extends JPanel {
	private JPanel Campos;
	private JTextField CampoIngreso;
	private JLabel nombreCampo;

	public PanelDatosC() {
		this.setLayout(new GridLayout(6,1));
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Rut del cliente");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Nombre del cliente");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Apellido Paterno del cliente");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Apellido Paterno del cliente");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Direccion del cliente");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Telefono del cliente");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
	}
	
	
}
