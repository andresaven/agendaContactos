package controlador;

import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();		
		GestorEventos gestor = new GestorEventos(ventana);
		ventana.establecerListeners(gestor);
		
	}
}
