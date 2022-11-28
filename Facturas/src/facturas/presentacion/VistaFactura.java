package Factura.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaFactura extends JFrame implements ActionListener{
	private JPanel plp, pbtn;
	private JTextField CampoIngreso;
	private JLabel nombreCampo;
	private JButton btn;
	private vistaMenu vM;
	
	public VistaFactura() {
		this.setBounds(0, 0, 800, 400);
		this.getContentPane().setLayout (new GridBagLayout());
		JTextArea areaTexto = new JTextArea ("Consulta Factura");
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
		nombreCampo = new JLabel("Ingrese el codigo de factura");
		CampoIngreso = new JTextField();
		plp.add(nombreCampo);
		plp.add(CampoIngreso);
		this.add(plp); 
		
		constraints.gridx = 2; 
		constraints.gridy = 0; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1; 
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.NONE;
		this.getContentPane().add (plp, constraints);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0.0;
		
		pbtn = new JPanel();
		pbtn.setLayout(new BoxLayout(pbtn,BoxLayout.Y_AXIS));
		pbtn.setAlignmentX(btn.CENTER_ALIGNMENT);
		
		btn = new JButton("Buscar");
		this.pbtn.add(btn);
		
		btn.setActionCommand("SelectF");
		btn.addActionListener(this);

		btn = new JButton("Consultar cantidad de producto");
		this.pbtn.add(btn);
		
		btn.setActionCommand("SelectCP");
		btn.addActionListener(this);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weighty = 1.0;

		constraints.anchor = GridBagConstraints.NORTH;
		constraints.fill = GridBagConstraints.NONE;
		this.getContentPane().add (pbtn, constraints);
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
			case "SelectF":
				// Buscar la factura con el numero de factura
				break;
			case "SelectCP":
				// Buscar la cantidad de productos con el numero de factura
				break;
			default:
				
				break;
			}
		} catch (Exception e2) {
			System.out.println("Error");
		}
	}
}
