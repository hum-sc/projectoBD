package ProgramaBD.src.Factura.presentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener {
	private JPanel Campo;
	private JButton btn;
	private int CoP;
	
	
	
	public int getCoP() {
		return CoP;
	}


	public void setCoP(int coP) {
		CoP = coP;
	}


	public PanelBotones() {
		this.setLayout(new GridLayout(3,1));
		Campo = new JPanel();
		Campo.setLayout(new FlowLayout());
		
		btn = new JButton("Ingresar");
		btn.setMinimumSize(new Dimension(50,20));
		btn.setMaximumSize(new Dimension(150,60));
		btn.setPreferredSize(new Dimension(100,30));
		btn.setActionCommand("Incert");
		btn.addActionListener(this);
		Campo.add(btn);
		this.add(Campo);
		
		Campo = new JPanel();
		Campo.setLayout(new FlowLayout());
		btn = new JButton("Modificar");
		btn.setMinimumSize(new Dimension(50,20));
		btn.setMaximumSize(new Dimension(150,60));
		btn.setPreferredSize(new Dimension(100,30));
		btn.setActionCommand("Mod");
		btn.addActionListener(this);
		Campo.add(btn);
		this.add(Campo);
		
		Campo = new JPanel();
		Campo.setLayout(new FlowLayout());
		btn = new JButton("Borrar");
		btn.setMinimumSize(new Dimension(50,20));
		btn.setMaximumSize(new Dimension(150,60));
		btn.setPreferredSize(new Dimension(100,30));
		btn.setActionCommand("Del");
		btn.addActionListener(this);
		Campo.add(btn);
		this.add(Campo);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		int opcion = this.getCoP();
		
		try {
			switch (comando) {
			case "Incert":
				if (opcion == 0) {
					//Incert a la tabla clientes
					System.out.println("Entro en clientes");
				} else if (opcion == 1) {
					//Incert a la tabla productos
					System.out.println("Entro en productos");
				} else {
					System.out.println("Error");
				}
				break;
			case "Mod":
				if (opcion == 0) {
					//UPDATE  a la tabla clientes
					System.out.println("Entro en clientes");
				} else if (opcion == 1) {
					//UPDATE  a la tabla productos
					System.out.println("Entro en productos");
				} else {
					System.out.println("Error");
				}
				break;
			case "Del":
				if (opcion == 0) {
					//DELETE a la tabla clientes
					System.out.println("Entro en clientes");
				} else if (opcion == 1) {
					//DELETE a la tabla productos
					System.out.println("Entro en productos");
				} else {
					System.out.println("Error");
				}
				break;
			default:
				break;
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
	
	
}
