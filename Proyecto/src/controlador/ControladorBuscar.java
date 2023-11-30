package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Contacto;
import modelo.ListaContactos;
import vista.Buscar;
import vista.VistaPrincipal;

public class ControladorBuscar implements ActionListener {
    private ListaContactos lCG;
    private Buscar b;

    public ControladorBuscar(ListaContactos lCG, VistaPrincipal vistaPrincipal, Buscar dialogoBuscar) {
        this.lCG = lCG;
        this.b = dialogoBuscar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == b.getVolver()) {
			b.setVisible(false);
		} else if (e.getSource() == b.getbSearch()) {
	        String nombreBuscado = b.gettBNombre().getText();
	        String telefonoBuscado = b.gettBTelf().getText();

	        if (nombreBuscado.isEmpty() && telefonoBuscado.isEmpty()) {
	            JOptionPane.showMessageDialog(b, "Ingrese al menos un criterio de búsqueda");
	            return;
	        }

	        DefaultTableModel modeloTabla = (DefaultTableModel) b.getTableModel();
	        modeloTabla.setRowCount(0); // Limpiar la tabla

	        for (Contacto contacto : lCG.getListaC()) {
	        	String nombreTabla = contacto.getNombre().toLowerCase();
	        	System.out.println(nombreTabla);
	        	
	        	if (nombreBuscado.isEmpty()) {
	        		if (contacto.getTelefono().contains(telefonoBuscado)) {
		            	b.getTableModel().addRow(new String [] {contacto.getNombre(), contacto.getTelefono()});
		            	b.gettBTelf().setText("");
	        		}
	        	}
	        	
	        	if (telefonoBuscado.isEmpty()) {
	        		if (nombreTabla.contains(nombreBuscado.toLowerCase())) {
		            	b.getTableModel().addRow(new String [] {contacto.getNombre(), contacto.getTelefono()});
		            	b.gettBNombre().setText("");
	        		}
	        	}
	            
	        }

	        if (modeloTabla.getRowCount() == 0) {
	            JOptionPane.showMessageDialog(b, "No se encontraron contactos con los criterios dados");
	        }
	    }
    	
    }

}
