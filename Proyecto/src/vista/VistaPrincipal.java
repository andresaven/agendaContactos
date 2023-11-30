package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.Font;
import controlador.Controlador;
import modelo.ListaContactos;

public class VistaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labelAdd, lFav, lExport, lUpdate;
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane scrollPane;
	JButton fav, searchContact, export, delete, addContact, update;
	
	ListaContactos lCG;
	Favoritos favoritos;
	Add add;
	Update upd;
	Buscar b;
	

	public Update getUpd() {
		return upd;
	}

	public void setUpd(Update upd) {
		this.upd = upd;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JButton getFav() {
		return fav;
	}

	public void setFav(JButton fav) {
		this.fav = fav;
	}

	public JButton getSearchContact() {
		return searchContact;
	}

	public void setSearchContact(JButton searchContact) {
		this.searchContact = searchContact;
	}

	public JButton getExport() {
		return export;
	}

	public void setExport(JButton export) {
		this.export = export;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getAddContact() {
		return addContact;
	}

	public void setAddContact(JButton addContact) {
		this.addContact = addContact;
	}

	public JButton getUpdate() {
		return update;
	}

	public void setUpdate(JButton update) {
		this.update = update;
	}
	

	public VistaPrincipal(ListaContactos lCG) {
		this.lCG = lCG;
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		ImageIcon contactsIcon = new ImageIcon("img/contactos2.png");
		setIconImage(contactsIcon.getImage());
		setTitle("Contactos");
		setBounds(770, 125, 390, 844 );
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		varInit();
		setVisible(true);
	}
	
	private void varInit () {
		
		Font fontPlain = new Font("SansSerif", Font.PLAIN, 12);
		getContentPane().setLayout(null);
		
		String [] columsName = {"Nombre", "Teléfono"};
		tableModel = new DefaultTableModel(columsName, 0);
		
		table = new JTable(tableModel);
		table.setRowHeight(35);
		table.setRowMargin(20);
		table.setFont(new Font("SansSerif", Font.PLAIN, 17));
		JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(fontPlain);
        
       
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        table.getColumnModel().getColumn(1).setCellRenderer(Alinear);

		
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(22, 137, 330, 519);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 20));
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		
		fav = new JButton();
		ImageIcon favIcon = new ImageIcon("img/megusta.png");
		fav.setIcon(favIcon);
		fav.setBounds(34, 37, 48, 48);
		fav.setBackground(Color.WHITE);
		fav.setBorderPainted(false);
		getContentPane().add(fav);
		
		lFav = new JLabel("Favoritos");
		lFav.setBounds(30, 90, 58, 14);
		lFav.setHorizontalAlignment(SwingConstants.CENTER);
		lFav.setFont(fontPlain);
		getContentPane().add(lFav);
		
		
		searchContact = new JButton();
		ImageIcon searchIcon = new ImageIcon("img/lupa.png");
		searchContact.setIcon(searchIcon);
		searchContact.setBorderPainted(false);
		searchContact.setBackground(Color.WHITE);
		searchContact.setBounds(162, 37, 48, 48);
		getContentPane().add(searchContact);
		
		JLabel lSearch = new JLabel("Buscar");
		lSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lSearch.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lSearch.setBounds(162, 90, 48, 14);
		getContentPane().add(lSearch);

		export = new JButton();
		ImageIcon optionsIcon = new ImageIcon("img/exportar.png");
		export.setIcon(optionsIcon);
		export.setBounds(287, 37, 48, 48);
		export.setBackground(Color.WHITE);
		export.setBorderPainted(false);
		getContentPane().add(export);
		
		lExport = new JLabel("Exportar");
		lExport.setBounds(282, 90, 58, 14);
		lExport.setHorizontalAlignment(SwingConstants.CENTER);
		lExport.setFont(fontPlain);
		getContentPane().add(lExport);
		
		
		delete = new JButton();
		ImageIcon dltIcon = new ImageIcon("img/eliminar.png");
		delete.setIcon(dltIcon);
		delete.setBounds(46, 702, 48, 48);
		delete.setBackground(Color.WHITE);
		delete.setBorderPainted(false);
		getContentPane().add(delete);	
		
		JLabel lDelete = new JLabel("Eliminar");
		lDelete.setBounds(46, 758, 48, 14);
		lDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lDelete.setFont(fontPlain);
		getContentPane().add(lDelete);
		

		addContact = new JButton();
		ImageIcon addIcon = new ImageIcon("img/mas.png");
		addContact.setIcon(addIcon);
		addContact.setBounds(152, 687, 66, 66);
		addContact.setBackground(Color.WHITE);
		addContact.setBorderPainted(false);
		getContentPane().add(addContact);
		
		JLabel lAdd = new JLabel("Añadir");
		lAdd.setBounds(152, 758, 60, 14);
		lAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lAdd.setFont(fontPlain);
		getContentPane().add(lAdd);

		
		update = new JButton();
		ImageIcon updtIcon = new ImageIcon("img/editar.png");
		update.setIcon(updtIcon);
		update.setBounds(273, 702, 48, 48);
		update.setBackground(Color.WHITE);
		update.setBorderPainted(false);
		getContentPane().add(update);
		
		lUpdate = new JLabel("Editar");
		lUpdate.setBounds(273, 758, 48, 14);
		lUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lUpdate.setFont(fontPlain);
		getContentPane().add(lUpdate);

		
		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 374, 805);
		getContentPane().add(background);
		
		
		Controlador controlador = new Controlador(lCG, this, favoritos, add, upd, b);
		controlador.cargarTablas();
		
	}
	
	
	//Comunicar controlador
	public void establecerListeners(Controlador controlador) {
		fav.addActionListener(controlador);
		addContact.addActionListener(controlador);
		update.addActionListener(controlador);
		delete.addActionListener(controlador);
		searchContact.addActionListener(controlador);
		export.addActionListener(controlador);
		
	}
	
	//Verifica si se ha seleccionado una fila y cuál
	public int getSelectedRow() {
	    return table.getSelectedRow();
	}
	
	//Eliminar con un panel
	public boolean confirmarEliminacion() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar el contacto seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        return opcion == JOptionPane.YES_OPTION;
    }
	
	
}
