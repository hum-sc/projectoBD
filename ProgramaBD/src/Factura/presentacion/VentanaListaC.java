package ProgramaBD.src.Factura.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaListaC extends JFrame implements ActionListener{
	private JPanel plp;
	private JTextField CampoIngreso;
	private JLabel nombreCampo;
	private JButton btn;
	private vistaMenu vM;
	
	public VentanaListaC() {
		this.setBounds(0, 0, 600, 400);
		this.getContentPane().setLayout (new GridBagLayout());
		JTextArea areaTexto = new JTextArea ("Consulta de los Clientes");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		
		constraints.gridwidth = 2; 
		constraints.gridheight = 2; 
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		this.getContentPane().add (areaTexto, constraints);
		
		
		plp = new JPanel();
		plp.setLayout(new GridLayout(2,1));
		nombreCampo = new JLabel("Rut del cliente");
		CampoIngreso = new JTextField();
		plp.add(nombreCampo);
		plp.add(CampoIngreso);
		this.add(plp); 
		
		constraints.gridx = 2; 
		constraints.gridy = 0; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1; 
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.getContentPane().add (plp, constraints);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 1.0;
		
		btn = new JButton("Buscar");
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weighty = 1.0;
		
		btn.setActionCommand("SelectC");
		btn.addActionListener(this);
		
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.fill = GridBagConstraints.NONE;
		this.getContentPane().add (btn, constraints);
		constraints.weightx = 0.0;
		constraints.anchor = GridBagConstraints.CENTER;
		
		
		btn = new JButton("Regresar");
		constraints.gridx = 2; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1; 
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		this.getContentPane().add (btn, constraints);
		btn.setActionCommand("VentanaM");
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		try {
			switch (comando) {
			case "VentanaM":
				vM = new vistaMenu();
				this.dispose();
				vM.setVisible(true);
				break;
			case "SelectC":
				// Buscar La lista de los clientes
				break;
			default:
				
				break;
			}
		} catch (Exception e2) {
			System.out.println("Error");
		}
	}
}
