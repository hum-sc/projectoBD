package ProgramaBD.src.Factura.presentacion;



import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class vistaMenu extends JFrame implements ActionListener {
	private JPanel Menu;

	private JButton btn;

	private VentanaCliente vC;
	private VentanaProducto vP;
	private VentanaListaC vLc;
	private VentanaListaP vLp;
	private VistaFactura vF;
	public vistaMenu(){
		this.setBounds(100, 100, 500, 450);
		this.setLayout(new GridLayout(5,1));
		Menu = new JPanel();
		Menu.setLayout(new FlowLayout());
		
		
		btn = new JButton("Ingresar, modificar o borrar cliente");
		btn.setMinimumSize(new Dimension(100,20));
		btn.setMaximumSize(new Dimension(350,60));
		btn.setPreferredSize(new Dimension(300,30));
		btn.setActionCommand("VentanaC");
		btn.addActionListener(this);
		
		Menu.add(btn);
		this.getContentPane().add(Menu); 
		
		Menu = new JPanel();
		Menu.setLayout(new FlowLayout());
		btn = new JButton("Ingresar, modificar o borrar producto");
		btn.setMinimumSize(new Dimension(100,20));
		btn.setMaximumSize(new Dimension(350,60));
		btn.setPreferredSize(new Dimension(300,30));
		btn.setActionCommand("VentanaP");
		btn.addActionListener(this);
		
		Menu.add(btn);
		this.getContentPane().add(Menu); 
		
		Menu = new JPanel();
		Menu.setLayout(new FlowLayout());
		btn = new JButton("Listados de clientes");
		btn.setMinimumSize(new Dimension(100,20));
		btn.setMaximumSize(new Dimension(350,60));
		btn.setPreferredSize(new Dimension(300,30));
		btn.setActionCommand("VentanaListaC");
		btn.addActionListener(this);
		
		Menu.add(btn);
		this.getContentPane().add(Menu); 
		
		Menu = new JPanel();
		Menu.setLayout(new FlowLayout());
		btn = new JButton("Listados de productos");
		btn.setMinimumSize(new Dimension(100,20));
		btn.setMaximumSize(new Dimension(350,60));
		btn.setPreferredSize(new Dimension(300,30));
		btn.setActionCommand("VentanaListaP");
		btn.addActionListener(this);
		
		Menu.add(btn);
		this.getContentPane().add(Menu); 
		
		Menu = new JPanel();
		Menu.setLayout(new FlowLayout());
		btn = new JButton("Consultar factura");
		btn.setMinimumSize(new Dimension(100,20));
		btn.setMaximumSize(new Dimension(350,60));
		btn.setPreferredSize(new Dimension(300,30));
		btn.setActionCommand("VentanaFac");
		btn.addActionListener(this);
		Menu.add(btn);
		
		this.getContentPane().add(Menu); 
	}
	
public void cambiarVentana(String cV) {
		
		switch (cV) {
		case "VentanaC": 
			vC = new VentanaCliente();
			vC.setVisible(true);
			this.dispose();
			break;
		case "VentanaP": 
			vP = new VentanaProducto();
			vP.setVisible(true);
			this.dispose();
			break;
			
		case "VentanaListaC": 
			vLc = new VentanaListaC();
			vLc.setVisible(true);
			this.dispose();
			break;
		case "VentanaListaP": 
			vLp = new VentanaListaP();
			vLp.setVisible(true);
			this.dispose();
			break;
		case "VentanaFac": 
			vF = new VistaFactura();
			vF.setVisible(true);
			this.dispose();
			break;
		default:
			
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		try {
			this.cambiarVentana(comando);
		} catch (Exception e2) {
			
		}
		
	}


	
	
	
}
