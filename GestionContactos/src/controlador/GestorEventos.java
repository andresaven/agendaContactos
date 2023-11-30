package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import vista.VentanaAñadir;
import vista.VentanaEditar;
import vista.VentanaPrincipal;

public class GestorEventos implements ActionListener {
    
    private VentanaPrincipal ventana;
    
    public GestorEventos(VentanaPrincipal ventana) {
        this.ventana = ventana;
        
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    //Método que permite añadir un contacto nuevo a la tabla
    public void Añadir(ActionEvent e) {
        VentanaAñadir ventanaAdd = new VentanaAñadir();
        ventanaAdd.setVisible(true);
        
        ventanaAdd.getCampoNombre().setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextComponent textComponent = (JTextComponent) input;
                String texto = textComponent.getText();
                if (texto.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Introduzca solo letras en el nombre",
                            "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });

        // Validación para permitir solo números en el campo de teléfono
        ventanaAdd.getCampoTelefono().setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextComponent textComponent = (JTextComponent) input;
                String telefono = textComponent.getText();
                if (!telefono.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "Introduzca un número de teléfono de 9 dígitos",
                            "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });


        ventanaAdd.getBotonOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = ventanaAdd.getCampoNombre().getText();
                String telefono = ventanaAdd.getCampoTelefono().getText();
                
                //Mensaje de error si el usuario no introduce todos los campos
                if (nombre.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos",
                            "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object[] nuevoContacto = { nombre, telefono };
                ventana.getTableModel().addRow(nuevoContacto);

                ventanaAdd.dispose();
             
            }
        });

        ventanaAdd.getBotonCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAdd.dispose();
            }
        });
    }

    // Método que permite al usuario modificar los datos de un contacto ya existente.
    
    public void Editar(ActionEvent e) {
        VentanaEditar ventanaEdit = new VentanaEditar();
        int fila = ventana.getTable().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un contacto para editar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombreSeleccionado = (String) ventana.getTableModel().getValueAt(fila, 0);
            String telefonoSeleccionado = (String) ventana.getTableModel().getValueAt(fila, 1);

            ventanaEdit.getCampoNombre().setText(nombreSeleccionado);
            ventanaEdit.getCampoTelefono().setText(telefonoSeleccionado);
            ventanaEdit.setVisible(true);

            ventanaEdit.getBotonOk().addActionListener(new ActionListener() {
            	
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nuevoNombre = ventanaEdit.getCampoNombre().getText();
                    String nuevoTelefono = ventanaEdit.getCampoTelefono().getText();

                    if (nuevoNombre.isEmpty() || nuevoTelefono.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser rellenados",
                                "Error de entrada", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                   //Cambio los datos que tenia por los nuevos y lo actualizo en la tabla.
                    ventana.getTableModel().setValueAt(nuevoNombre, fila, 0);
                    ventana.getTableModel().setValueAt(nuevoTelefono, fila, 1);

                    ventanaEdit.dispose();
                }
            });

            ventanaEdit.getBotonCancel().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ventanaEdit.dispose();
                }
            });
        }
    }
    //Método que se ejecuta 
    public void Eliminar(ActionEvent e) {
        int fila= ventana.getTable().getSelectedRow();

        //Si no se selecciona ninguna fila sale un mensaje de error.
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el contacto de su agenda que desee eliminar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        	//Mensaje de advertencia de eliminación de contacto antes de confirmarlo
            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de que desea eliminar este contacto?", "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                ventana.getTableModel().removeRow(fila);
             
            }
        }
    }     
}  




