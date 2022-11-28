package Factura.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaProducto extends JFrame implements ActionListener{
	private PanelDatosP pp;
	private PanelBotones pb;
	private JTextField CampoIngreso;
	private JButton btn;
	private vistaMenu vM;
	
	public VentanaProducto() {
		this.setBounds(0, 0, 450, 200);
		this.getContentPane().setLayout (new GridBagLayout());
		pp = new PanelDatosP();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		constraints.fill = GridBagConstraints.HORIZONTAL;

		constraints.anchor = GridBagConstraints.NORTH;
		constraints.gridwidth = 2; 
		constraints.gridheight = 0; 
		constraints.weightx = 1.0;
		this.getContentPane().add (pp, constraints);
		
		
		pb = new PanelBotones();
		constraints.gridx = 2; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		
		//Esto es para identificar desde cual ventana se apretaron los botones, en este caso la ventana Cliente es 0
		pb.setCoP(1);
		
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add (pb, constraints);
		
		
		CampoIngreso = new JTextField();
		constraints.gridx = 1; 
		constraints.gridy = 3; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1; 
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weighty = 1.0;
		this.getContentPane().add (CampoIngreso, constraints);
		
		btn = new JButton("Regresar");
		constraints.gridx = 2; 
		constraints.gridy = 3; 
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
			vM = new vistaMenu();
			this.dispose();
			vM.setVisible(true);
		} catch (Exception e2) {
			
		}
	}
	
}
