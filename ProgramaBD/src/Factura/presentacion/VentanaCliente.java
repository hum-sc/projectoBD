package ProgramaBD.src.Factura.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaCliente extends JFrame implements ActionListener{
	private PanelDatosC pc;
	private PanelBotones pb;
	private JTextField CampoIngreso;
	private JButton btn;
	private vistaMenu vM;

	public VentanaCliente() {
		this.setBounds(0, 0, 450, 400);
		this.getContentPane().setLayout (new GridBagLayout());
		pc = new PanelDatosC();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		constraints.fill = GridBagConstraints.HORIZONTAL;

		constraints.anchor = GridBagConstraints.NORTH;
		constraints.gridwidth = 2; 
		constraints.gridheight = 0; 
		constraints.weightx = 1.0;
		this.getContentPane().add (pc, constraints);
		
		
		pb = new PanelBotones();
		constraints.gridx = 2; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		
		//Esto es para identificar desde cual ventana se apretaron los botones, en este caso la ventana Cliente es 0
		pb.setCoP(0);
		
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add (pb, constraints);
		
		CampoIngreso = new JTextField();
		constraints.gridx = 0; 
		constraints.gridy = 3; 
		constraints.gridwidth = 2; 
		constraints.gridheight = 1; 
		constraints.fill = GridBagConstraints.HORIZONTAL;
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
