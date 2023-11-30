package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import controlador.ControladorBuscar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Buscar extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel add, lAdd;
	private JButton volver;
	private JLabel lVolver;
	private JLabel bNombre;
	private JLabel bTelefono;
	private JTextField tBNombre;
	private JTextField tBTelf;
	private JButton bSearch;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;


	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JTextField gettBNombre() {
		return tBNombre;
	}

	public void settBNombre(JTextField tAp) {
		this.tBNombre = tAp;
	}

	public JTextField gettBTelf() {
		return tBTelf;
	}

	public void settBTelf(JTextField tBTelf) {
		this.tBTelf = tBTelf;
	}


	public JButton getbSearch() {
		return bSearch;
	}

	public void setbSearch(JButton bSearch) {
		this.bSearch = bSearch;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}


	public Buscar(VistaPrincipal vistaPrincipal) {
		
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		ImageIcon contactsIcon = new ImageIcon("contactos2.png");
		setIconImage(contactsIcon.getImage());
		setTitle("Buscar contactos");
		setBounds(770, 125, 390, 844 );
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		varInit();
		setVisible(false);
	}
	
	private void varInit () {
		
		Font fontPlain = new Font("SansSerif", Font.PLAIN, 12);
		
		getContentPane().setLayout(null);
		
		String [] columsName = {"Nombre", "Teléfono"};
		tableModel = new DefaultTableModel(columsName, 0);
		
		table = new JTable(tableModel);
		table.setRowHeight(35);
		table.setRowMargin(20);
		table.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(fontPlain);
        
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        table.getColumnModel().getColumn(1).setCellRenderer(Alinear);

		
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(22, 408, 330, 248);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 14));
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		add = new JLabel();
		ImageIcon lupaIcon = new ImageIcon("img/lupa.png");
		add.setIcon(lupaIcon);
		add.setBounds(163, 27, 48, 48);
		add.setBackground(Color.WHITE);
		getContentPane().add(add);
		
		lAdd = new JLabel("Buscar contacto");
		lAdd.setBounds(86, 81, 202, 14);
		lAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lAdd.setFont(fontPlain);
		getContentPane().add(lAdd);
		
		volver = new JButton();
		ImageIcon vIcon = new ImageIcon("img/volver.png");
		volver.setIcon(vIcon);
		volver.setBounds(163, 689, 48, 48);
		volver.setBackground(Color.WHITE);
		volver.setBorderPainted(false);
		getContentPane().add(volver);
		
		lVolver = new JLabel("Volver");
		lVolver.setHorizontalAlignment(SwingConstants.CENTER);
		lVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lVolver.setBounds(163, 740, 48, 14);
		getContentPane().add(lVolver);
		
		bNombre = new JLabel("Busca por nombre:");
		bNombre.setHorizontalAlignment(SwingConstants.CENTER);
		bNombre.setFont(new Font("SansSerif", Font.PLAIN, 16));
		bNombre.setBounds(86, 129, 202, 31);
		getContentPane().add(bNombre);
		
		bTelefono = new JLabel("Busca por teléfono:");
		bTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		bTelefono.setFont(new Font("SansSerif", Font.PLAIN, 16));
		bTelefono.setBounds(86, 224, 202, 38);
		getContentPane().add(bTelefono);
		
		tBNombre = new JTextField();
		tBNombre.setColumns(10);
		tBNombre.setBounds(86, 171, 202, 30);
		getContentPane().add(tBNombre);
		
		tBTelf = new JTextField();
		tBTelf.setColumns(10);
		tBTelf.setBounds(86, 266, 202, 30);
		getContentPane().add(tBTelf);
		
		bSearch = new JButton("Buscar");
		bSearch.setForeground(new Color(255, 255, 255));
		bSearch.setBackground(new Color(33, 115, 70));
		bSearch.setFont(new Font("SansSerif", Font.PLAIN, 17));
		bSearch.setBounds(130, 330, 110, 38);
		getContentPane().add(bSearch);

		
		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 374, 805);
		getContentPane().add(background);
		
	}
	

	public void establecerListeners(ControladorBuscar controladorBuscar) {
		volver.addActionListener(controladorBuscar);
		bSearch.addActionListener(controladorBuscar);
		
	}
}
