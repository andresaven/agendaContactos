package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modelo.Contacto;
import modelo.ListaContactos;
import vista.Add;
import vista.Favoritos;
import vista.VistaPrincipal;

public class ControladorAdd implements ActionListener{
	
	ListaContactos lCG;
	Add add;
	VistaPrincipal vp;
	Favoritos fav;
	
	
	
	public ControladorAdd(ListaContactos lCG, Add add, VistaPrincipal vp, Favoritos fav) {
		this.lCG = lCG;
		this.add = add;
		this.vp = vp;
		this.fav = fav;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add.getVolver()) {
			add.setVisible(false);
		}
		
		if (e.getSource() == add.getbAdd()) {
			if (add.gettNom().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else if (add.gettAp().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else if (add.gettTelf().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else {
				boolean isFav = false;
				if(add.getChekFav().isSelected()) {
					isFav = true;
				}
				String nombreCompleto = add.gettNom().getText()+ " " +add.gettAp().getText();
				int id = lCG.getContador();
				Contacto contacto = new Contacto(id, nombreCompleto, add.gettTelf().getText(), isFav);
				lCG.getListaC().add(contacto);
				System.out.println(lCG.getListaC());
				vp.getTableModel().addRow(new String [] {nombreCompleto, contacto.getTelefono()});
				if (isFav) {
					lCG.getListaCFav().add(contacto);
					fav.getTableModel().addRow(new String [] {nombreCompleto, contacto.getTelefono()});
				}
			
			add.setVisible(false);	
			
			add.gettNom().setText("");
			add.gettAp().setText("");
			add.gettTelf().setText("");
			}
		}
		
		
	}
}
