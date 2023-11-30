package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Contacto;
import modelo.ListaContactos;
import vista.Favoritos;
import vista.VistaPrincipal;

public class ControladorDelete implements ActionListener{
	
	ListaContactos lCG;
	VistaPrincipal vp;
	Favoritos fav;
	
	
	public ControladorDelete(ListaContactos lCG, VistaPrincipal vp, Favoritos fav) {
		this.lCG = lCG;
		this.vp = vp;
		this.fav = fav;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == vp.getDelete()) {
		        int fila = vp.getSelectedRow();
		        if (fila >= 0) {
		            if (vp.confirmarEliminacion()) {
		                Contacto contactoAEliminar = lCG.getListaC().get(fila);
		                lCG.getListaC().remove(fila);
		                vp.getTableModel().removeRow(fila);

		                // Eliminar también de favoritos si está presente
		                boolean isFav = false;
						if(contactoAEliminar.isFavorito()) {
							isFav = true;			
						}
		                
						if (isFav) {
			                for (int i = 0; i < lCG.getListaCFav().size(); i++) {
			                    if (lCG.getListaCFav().get(i).getTelefono().equalsIgnoreCase(contactoAEliminar.getTelefono())) {
			                        lCG.getListaCFav().remove(i);
			                        fav.getTableModel().removeRow(i);
			                        break;
			                    }
			                }
						}
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "No hay ningún contacto seleccionado para eliminar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        }
		}
		
		
	}
}
