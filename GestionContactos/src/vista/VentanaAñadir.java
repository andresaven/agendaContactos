package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAñadir extends JDialog {
	
	//Defino los atributos
	
	private JLabel icono, etiquetaNombre, etiquetaTelefono;	
	private JTextField campoNombre, campoTelefono;
	private JButton botonOk, botonCancel;
	
	public VentanaAñadir() {
		
		
		setBounds(800,200,350,400);
		setTitle("Añadir Contacto");
		ImageIcon iconoAdd = new ImageIcon("notebook.png");
	    setIconImage(iconoAdd.getImage());
		getContentPane().setLayout(new BorderLayout());				
		
		 	JPanel panel = new JPanel();
	        panel.setBorder(new EmptyBorder(10, 10, 10, 10));	        
	        Color colorFondo = new Color(193,211,254);
	        panel.setBackground(colorFondo);
	        panel.setLayout(null);

	        etiquetaNombre = new JLabel("Nombre:");
	        etiquetaNombre.setBounds(20, 80, 80, 20);
	        etiquetaNombre.setFont(new Font("Dialog", Font.ITALIC, 16));
	        etiquetaNombre.setForeground(Color.BLACK);
	        panel.add(etiquetaNombre);

	        campoNombre = new JTextField();
	        campoNombre.setBounds(100, 80, 200, 20);
	        campoNombre.setBorder(null);
	        
	        
	        panel.add(campoNombre);

	        etiquetaTelefono = new JLabel("Teléfono:");
	        etiquetaTelefono.setBounds(20, 130, 80, 20);
	        etiquetaTelefono.setFont(new Font("Roboto", Font.ITALIC, 16));
	        etiquetaTelefono.setForeground(Color.BLACK);
	        panel.add(etiquetaTelefono);

	        campoTelefono = new JTextField();
	        campoTelefono.setBounds(100, 130, 200, 20);
	        campoTelefono.setBorder(null);
	        
	        panel.add(campoTelefono);

	        botonOk = new JButton(new ImageIcon("comprobado.png"));
	        Color colorFondo1 = new Color(193,211,254);
	        botonOk.setBackground(colorFondo1);
	        botonOk.setBounds(100, 240, 60, 40);
	        botonOk.setBorderPainted(false);
	        panel.add(botonOk);

	        botonCancel = new JButton(new ImageIcon("cancel.png"));
	        Color colorFondo2 = new Color(193,211,254);
	        botonCancel.setBackground(colorFondo2);
	        botonCancel.setBounds(200, 240, 60, 40);
	        botonCancel.setBorderPainted(false);
	        panel.add(botonCancel);

	        getContentPane().add(panel, BorderLayout.CENTER);
	    }

	    // Agrega los getters para acceder a los datos ingresados
	    public JTextField getCampoNombre() {
	        return campoNombre;
	    }

	    public JTextField getCampoTelefono() {
	        return campoTelefono;
	    }

	    public JButton getBotonOk() {
	        return botonOk;
	    }

	    public JButton getBotonCancel() {
	        return botonCancel;
	    }
	
		
		
		
		
	}
		
