package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.GestorEventos;

public class VentanaPrincipal extends JFrame {
	
	//Defino los atributos que necesitaremos para el funcionamiento de la aplicacion.
	
	private JLabel icono;	
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;	
	private JButton botonAdd, botonEdit, botonDelete;
	
	//Creamos el constructor de la clase, en él vamos a darle tamaño, localización y funcionalidad
	//a la ventana principal.
	
	public VentanaPrincipal() {
		
		//Creamos un panel para dar estilo a la ventana principal, le damos un color de fondo		
		getContentPane().setBackground(new Color(215,227,252));
		setBounds(500, 500, 600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AGENDA CONTACTOS");		
		setIconImage(Toolkit.getDefaultToolkit().getImage("notebook.png"));
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		inicializarVariables();//Función que inicializa las variables declaradas		
		setVisible(true);
		
	}

	
	private void inicializarVariables() {		
		
		//Titulo cabecera ventana principal.
		JLabel labelTitulo = new JLabel("MI AGENDA");
		labelTitulo.setFont(new Font("Roboto", Font.CENTER_BASELINE, 26)); 
		labelTitulo.setForeground(new Color(0, 100, 200));
		labelTitulo.setBounds(210, 60, 180, 30); 
		add(labelTitulo);		

		/*Tabla: primero defino un array con el nombre de las columnas que va a tener,
		*luego le paso al constructor del componente tableModel, el nombre del array y el número de filas
		*que va a tener nada más arrancar.
		*/
		String[]nombreColumnas= { "Nombre", "Telefono"};		
		tableModel = new DefaultTableModel(nombreColumnas, 0);
		
		//Creo la tabla.
		
		table=new JTable(tableModel);
		
		//Creo el ScroolPane y le doy ubicación y tamaño.
		
		scrollPane=new JScrollPane(table);
		scrollPane.setBounds(140, 130, 300, 300);
		 
		add(scrollPane);
		
		botonAdd=new JButton(new ImageIcon("usuario.png"));
		botonAdd.setBounds(235, 470, 100, 70);
		Color colorFondoAdd = new Color(215,227,252);
        botonAdd.setBackground(colorFondoAdd);
		botonAdd.setFont(new Font("Dialog", Font.BOLD, 18));
		botonAdd.setForeground(new Color(0,100,200));
		botonAdd.setBorderPainted(false);
		botonAdd.setToolTipText("Añadir");
		add(botonAdd);
		
		botonEdit=new JButton(new ImageIcon("archivo.png"));
		botonEdit.setBounds(150, 550, 60, 60);
		Color colorFondoEdit = new Color(215,227,252);
        botonEdit.setBackground(colorFondoEdit);
		botonEdit.setFont(new Font("Dialog", Font.BOLD, 18));
		botonEdit.setForeground(new Color(0,100,200));
		botonEdit.setBorderPainted(false);
		botonEdit.setToolTipText("Editar");
		add(botonEdit);
		
		botonDelete=new JButton(new ImageIcon("papelera.png"));
		Color colorFondoDelete = new Color(215,227,252);
        botonDelete.setBackground(colorFondoDelete);
		botonDelete.setFont(new Font("Dialog", Font.BOLD, 18));
		botonDelete.setForeground(new Color(0,100,200));
		botonDelete.setBounds(380,550,60,60);
		botonDelete.setBorderPainted(false);
		botonDelete.setToolTipText("Eliminar");
		add(botonDelete);
		
	}

		//Pongo a la escucha los botones y llamao al método que se ejecuta al hacer click en cada botón.
	
	 	public void establecerListeners(GestorEventos gestor) {
	 		
	        botonAdd.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                gestor.Añadir(e);
	            }
	        });

	        botonEdit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                gestor.Editar(e);
	            }
	        });

	        botonDelete.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                gestor.Eliminar(e);
	            }
	        });
	    
	 	}
        
	
	//Creamos los getters necesarios par apoder acceder a la informacion tanto de los botones como de la tabla

	public DefaultTableModel getTableModel() {
		return tableModel;
	}


	public JButton getBotonAdd() {
		return botonAdd;
	}


	public JButton getBotonEdit() {
		return botonEdit;
	}


	public JButton getBotonDelete() {
		return botonDelete;
	}


	public JTable getTable() {
		return table;
	}
	
        
	 	}





