package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Contacto;
import modelo.ListaContactos;
import vista.Favoritos;
import vista.Update;
import vista.VistaPrincipal;

public class ControladorUpdate implements ActionListener{
	
	ListaContactos lCG;
	Update upd;
	VistaPrincipal vp;
	Favoritos fav;
	
	
	public ControladorUpdate(ListaContactos lCG, Update upd, VistaPrincipal vp, Favoritos fav) {
		this.lCG = lCG;
		this.upd = upd;
		this.vp = vp;
		this.fav = fav;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == upd.getVolver()) {
			upd.setVisible(false);
		}
		if (e.getSource() == upd.getbAdd()) {
			if (upd.gettNom().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else if (upd.gettAp().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else if (upd.gettTelf().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else {
				boolean isFav = false;
				if(upd.getChekFav().isSelected()) {
					isFav = true;			
				}
				String nombreCompleto = upd.gettNom().getText()+ " " +upd.gettAp().getText();
				int fila = vp.getSelectedRow();
				Contacto contacto = new Contacto(fila, nombreCompleto,upd.gettTelf().getText(), isFav);
				lCG.getListaC().set(fila, contacto);
				vp.getTableModel().setValueAt(nombreCompleto, fila, 0);
				vp.getTableModel().setValueAt(upd.gettTelf().getText(), fila, 1);
				
				boolean quitado = false;
				if (!isFav) {
				    for (int i = 0; i < lCG.getListaCFav().size(); i++) {
				        if (lCG.getListaCFav().get(i).getTelefono().equalsIgnoreCase(contacto.getTelefono())) {
				            lCG.getListaCFav().remove(i);
				            fav.getTableModel().removeRow(i);
				            quitado = true;
				            break;
				        }
				    }
					
				}else {
					boolean existeEnFavoritos = false;
					for (int i = 0; i < lCG.getListaCFav().size(); i++) {
				        if (lCG.getListaCFav().get(i).getTelefono().equalsIgnoreCase(contacto.getTelefono())) {
				            existeEnFavoritos = true;
				            lCG.getListaCFav().set(i, contacto);
				            fav.getTableModel().setValueAt(contacto.getNombre(), i, 0);
				            fav.getTableModel().setValueAt(contacto.getTelefono(), i, 1);
				            quitado = false;
				            break;
				        }
				        
				    }
					if (!existeEnFavoritos && quitado == false) {
				        lCG.getListaCFav().add(contacto);
				        fav.getTableModel().addRow(new Object[]{contacto.getNombre(), contacto.getTelefono()});
				    }
				   
				}
				
			}
			upd.setVisible(false);	
		}
		
		
	}
}
