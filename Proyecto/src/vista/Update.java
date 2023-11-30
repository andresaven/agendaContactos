package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorUpdate;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Update extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel add, lAdd;
	private DefaultTableModel tableModel;
	private JButton volver;
	private JLabel lVolver;
	private JLabel lNombre;
	private JLabel lApellido;
	private JLabel lTelefono;
	private JTextField tNom;
	private JTextField tAp;
	private JTextField tTelf;
	private JCheckBox chekFav;
	private JButton bAdd;
	
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JTextField gettNom() {
		return tNom;
	}

	public void settNom(JTextField tNom) {
		this.tNom = tNom;
	}

	public JTextField gettAp() {
		return tAp;
	}

	public void settAp(JTextField tAp) {
		this.tAp = tAp;
	}

	public JTextField gettTelf() {
		return tTelf;
	}

	public void settTelf(JTextField tTelf) {
		this.tTelf = tTelf;
	}

	public JCheckBox getChekFav() {
		return chekFav;
	}

	public void setChekFav(JCheckBox chekFav) {
		this.chekFav = chekFav;
	}

	public JButton getbAdd() {
		return bAdd;
	}

	public void setbAdd(JButton bAdd) {
		this.bAdd = bAdd;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}


	public Update(JFrame vistaPrincipal) {
		
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		ImageIcon contactsIcon = new ImageIcon("contactos2.png");
		setIconImage(contactsIcon.getImage());
		setTitle("Editar contacto");
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
		
		
		add = new JLabel();
		ImageIcon contactIcon = new ImageIcon("img/editar.png");
		add.setIcon(contactIcon);
		add.setBounds(163, 27, 48, 48);
		add.setBackground(Color.WHITE);
		getContentPane().add(add);
		
		lAdd = new JLabel("Editar contacto");
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
		
		lNombre = new JLabel("Nombre");
		lNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lNombre.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lNombre.setBounds(149, 170, 76, 31);
		getContentPane().add(lNombre);
		
		lApellido = new JLabel("Apellido");
		lApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lApellido.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lApellido.setBounds(149, 270, 76, 31);
		getContentPane().add(lApellido);
		
		lTelefono = new JLabel("Teléfono");
		lTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lTelefono.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lTelefono.setBounds(149, 370, 76, 38);
		getContentPane().add(lTelefono);
		
		tNom = new JTextField();
		tNom.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tNom.setBounds(86, 212, 202, 30);
		getContentPane().add(tNom);
		tNom.setColumns(10);
		
		tAp = new JTextField();
		tAp.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tAp.setColumns(10);
		tAp.setBounds(86, 312, 202, 30);
		getContentPane().add(tAp);
		
		tTelf = new JTextField();
		tTelf.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tTelf.setColumns(10);
		tTelf.setBounds(86, 412, 202, 30);
		getContentPane().add(tTelf);
		
		chekFav = new JCheckBox("Añadir a Favoritos");
		chekFav.setHorizontalAlignment(SwingConstants.CENTER);
		chekFav.setFont(new Font("SansSerif", Font.PLAIN, 17));
		chekFav.setBackground(Color.WHITE);
		chekFav.setBounds(86, 486, 202, 23);
		getContentPane().add(chekFav);
		
		bAdd = new JButton("Actualizar");
		bAdd.setForeground(new Color(255, 255, 255));
		bAdd.setBackground(new Color(33, 115, 70));
		bAdd.setFont(new Font("SansSerif", Font.PLAIN, 17));
		bAdd.setBounds(132, 558, 110, 38);
		getContentPane().add(bAdd);
		
		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 374, 805);
		getContentPane().add(background);
		

	}
	

	public void establecerListeners(ControladorUpdate controladorUpdate) {
		volver.addActionListener(controladorUpdate);
		bAdd.addActionListener(controladorUpdate);
		
	}
}
