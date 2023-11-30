package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Contacto;
import modelo.ListaContactos;
import vista.Favoritos;
import vista.VistaPrincipal;

public class ControladorFav implements ActionListener{

	ListaContactos lCG;
	Favoritos favoritos;
	VistaPrincipal vp;
	
	public ControladorFav(ListaContactos lCG, Favoritos favoritos) {
		this.lCG = lCG;
		this.favoritos = favoritos;
	}
	
	public void cargarTablas() {
		for (Contacto i : lCG.getListaCFav()) {
			favoritos.getTableModel().addRow(new String [] {i.getNombre(), i.getTelefono()});
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == favoritos.getVolver()) {
			favoritos.setVisible(false);
			
		}
		
		
	}
}
