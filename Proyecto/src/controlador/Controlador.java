package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modelo.Contacto;
import modelo.ListaContactos;
import vista.Add;
import vista.Buscar;
import vista.Favoritos;
import vista.Update;
import vista.VistaPrincipal;

public class Controlador implements ActionListener{
	ListaContactos lCG;
	VistaPrincipal vistaPrincipal;
	Favoritos favoritos;
	Add add;
	Update upd;
	ControladorDelete controladorDelete;
	Buscar b;

	
	public Controlador(ListaContactos lCG, VistaPrincipal vistaPrincipal, Favoritos favoritos, Add add, Update upd, Buscar b) {
		this.lCG = lCG;
		this.vistaPrincipal = vistaPrincipal;
		this.favoritos = favoritos;
		this.add = add;
		this.upd = upd;
		this.b = b;
	}
	
	public void cargarTablas() {
		for (Contacto i : lCG.getListaC()) {
			vistaPrincipal.getTableModel().addRow(new String [] {i.getNombre(), i.getTelefono()});
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaPrincipal.getFav()) {
			favoritos.setVisible(true);
			
		}
		
		if (e.getSource() == vistaPrincipal.getSearchContact()) {
			b.setVisible(true);
		}
		
		if (e.getSource() == vistaPrincipal.getExport()) {
			ControladorExportar controladorExportar = new ControladorExportar(lCG);
			int opcion = JOptionPane.showConfirmDialog(vistaPrincipal, "¿Quieres exportar los contactos?", "Exportar", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				controladorExportar.exportarCSV("agendaContactos/");
				JOptionPane.showMessageDialog(null, "Los contactos han sido exportados\nen el directorio del proyecto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Los contactos no han sido exportados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if (e.getSource() == vistaPrincipal.getDelete()) {
			System.out.println("Ha entrado");
			ControladorDelete controladorDelete = new ControladorDelete(lCG, vistaPrincipal, favoritos);
			controladorDelete.actionPerformed(e);
		}
		
		if (e.getSource() == vistaPrincipal.getAddContact()) {
			add.setVisible(true);
		}
		
		if (e.getSource() == vistaPrincipal.getUpdate()) {
			int selectedRow = vistaPrincipal.getSelectedRow();
			
		    if(selectedRow != -1) {
		    	System.out.println(lCG.getListaC());
		    	Contacto contactoSeleccionado = lCG.getListaC().get(selectedRow);
		    	String[] nombreApellido = contactoSeleccionado.getNombre().split(" ");
		    	String nombre = nombreApellido[0];
		    	String apellido = nombreApellido[1];
		    	upd.gettNom().setText(nombre);
		    	upd.gettAp().setText(apellido);
		    	upd.gettTelf().setText(contactoSeleccionado.getTelefono());
		    	upd.getChekFav().setSelected(contactoSeleccionado.isFavorito());
		    	upd.setVisible(true);
		    }else {
		    	JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		    }
			
		}
	}
}
