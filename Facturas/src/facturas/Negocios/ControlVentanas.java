package Factura.Negocios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Factura.presentacion.VentanaCliente;
import Factura.presentacion.VentanaListaC;
import Factura.presentacion.VentanaListaP;
import Factura.presentacion.VentanaProducto;
import Factura.presentacion.vistaMenu;

public class ControlVentanas implements ActionListener{
	private vistaMenu vM;
	private VentanaCliente vC;
	private VentanaProducto vP;
	private VentanaListaC vLc;
	private VentanaListaP vLp;
	public void cambiarVentana(String cV) {
		
		switch (cV) {
		case "VentanaC": 
			vC = new VentanaCliente();
			vM = new vistaMenu();
			vC.setVisible(true);
			vM.setVisible(false);
			break;
		case "VentanaP": 
			vP = new VentanaProducto();
			vM = new vistaMenu();
			vP.setVisible(true);
			vM.setVisible(false);
			break;
			
		case "VentanaListaC": 
			vLc = new VentanaListaC();
			vM = new vistaMenu();
			vLc.setVisible(true);
			vM.setVisible(false);
			break;
		case "VentanaListaP": 
			vLp = new VentanaListaP();
			vM = new vistaMenu();
			vLp.setVisible(true);
			vM.setVisible(false);
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
