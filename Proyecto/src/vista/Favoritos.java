package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import controlador.ControladorFav;
import modelo.ListaContactos;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Favoritos extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel fav, lFav;
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane scrollPane;
	JButton volver;
	JLabel lVolver;

	ListaContactos lCG;
	
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}


	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public Favoritos(ListaContactos lCG, JFrame vistaPrincipal) {
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		ImageIcon contactsIcon = new ImageIcon("contactos2.png");
		setIconImage(contactsIcon.getImage());
		setTitle("Favoritos");
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
		table.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(fontPlain);
        
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(22, 106, 330, 550);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 20));
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		
		fav = new JLabel();
		ImageIcon favIcon = new ImageIcon("img/megusta.png");
		fav.setIcon(favIcon);
		fav.setBounds(163, 11, 48, 48);
		fav.setBackground(Color.WHITE);
		getContentPane().add(fav);
		
		lFav = new JLabel("Favoritos");
		lFav.setBounds(159, 64, 58, 14);
		lFav.setHorizontalAlignment(SwingConstants.CENTER);
		lFav.setFont(fontPlain);
		getContentPane().add(lFav);
		
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
		
		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 374, 805);
		getContentPane().add(background);	

	}
	
	public void establecerListeners(ControladorFav controladorFav) {
		volver.addActionListener(controladorFav);
		
	}
	
	public int getSelectedRow() {
	    return table.getSelectedRow();
	}
	
}
