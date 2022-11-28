package ProgramaBD.src.Factura.presentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatosP extends JPanel {
	private JPanel Campos;
	private JTextField CampoIngreso;
	private JLabel nombreCampo;

	public PanelDatosP() {
		this.setLayout(new GridLayout(3,1));
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Codigo del Producto");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Descripcion del Producto");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
		
		Campos = new JPanel();
		Campos.setLayout(new BoxLayout(Campos,BoxLayout.Y_AXIS));
		nombreCampo = new JLabel("Precio Unitario del Producto");
		CampoIngreso = new JTextField();
		Campos.add(nombreCampo);
		Campos.add(CampoIngreso);
		this.add(Campos); 
		
	}
	
	
}
