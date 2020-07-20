package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class UploadPanel extends JPanel {
	private JTextField inputCurso;
	private JTextField inputPlatform;
	private JTextField inputhours;
	private JTextField inputprice;
	private JButton btnGuardar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbtnPresen;
	private JRadioButton rbtnOnline;
	private JComboBox comboBoxCat;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public UploadPanel() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u20AC");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3.setBounds(382, 298, 30, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Registra tu Curso");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(301, 31, 157, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Curso");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(145, 116, 128, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Plataforma");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(145, 167, 128, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Horas");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(145, 196, 128, 35);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Categor\u00EDa");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(145, 248, 128, 16);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Precio");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(145, 298, 128, 16);
		add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Modalidad");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(145, 347, 128, 16);
		add(lblNewLabel_1_6);
		
		inputCurso = new JTextField();
		inputCurso.setOpaque(false);
		inputCurso.setBackground(new Color(220, 220, 220));
		inputCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		inputCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputCurso.setBounds(317, 110, 374, 22);
		add(inputCurso);
		inputCurso.setColumns(10);
		
		inputPlatform = new JTextField();
		inputPlatform.setOpaque(false);
		inputPlatform.setFont(new Font("Verdana", Font.BOLD, 14));
		inputPlatform.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputPlatform.setColumns(10);
		inputPlatform.setBounds(317, 161, 374, 22);
		add(inputPlatform);
		
		inputhours = new JTextField();
		inputhours.setOpaque(false);
		inputhours.setFont(new Font("Verdana", Font.BOLD, 14));
		inputhours.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputhours.setColumns(10);
		inputhours.setBounds(317, 203, 104, 22);
		add(inputhours);
		
		inputprice = new JTextField();
		inputprice.setForeground(new Color(0, 0, 0));
		inputprice.setOpaque(false);
		inputprice.setFont(new Font("Verdana", Font.BOLD, 14));
		inputprice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputprice.setColumns(10);
		inputprice.setBounds(319, 289, 53, 22);
		add(inputprice);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnGuardar.setBounds(541, 372, 97, 25);
		add(btnGuardar);
		
		rbtnOnline = new JRadioButton("On-Line");
		rbtnOnline.setFont(new Font("Verdana", Font.BOLD, 14));
		rbtnOnline.setOpaque(false);
		buttonGroup.add(rbtnOnline);
		rbtnOnline.setBounds(312, 343, 127, 25);
		add(rbtnOnline);
		
		rbtnPresen = new JRadioButton("Presencial");
		rbtnPresen.setFont(new Font("Verdana", Font.BOLD, 14));
		rbtnPresen.setOpaque(false);
		buttonGroup.add(rbtnPresen);
		rbtnPresen.setBounds(312, 372, 127, 25);
		add(rbtnPresen);
		
		comboBoxCat = new JComboBox();
		comboBoxCat.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		comboBoxCat.setBackground(new Color(230, 230, 250));
		comboBoxCat.setFont(new Font("Verdana", Font.BOLD, 14));
		comboBoxCat.setModel(new DefaultComboBoxModel(new String[] {"Selecciona...", "Programaci\u00F3n", "Desarrollo Web", "Redes y Seguridad", "Dise\u00F1o Web", "Marketing Digital", "Gesti\u00F3n de Proyectos"}));
		comboBoxCat.setSelectedIndex(0);
		comboBoxCat.setBounds(317, 242, 157, 22);
		add(comboBoxCat);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("img/cursosuavel.jpg"));
		lblNewLabel_2.setBounds(0, -13, 865, 561);
		add(lblNewLabel_2);

	}

	public JTextField getInputCurso() {
		return inputCurso;
	}
	public JTextField getInputPlatform() {
		return inputPlatform;
	}
	public JTextField getInputhours() {
		return inputhours;
	}
	
	public JTextField getInputprice() {
		return inputprice;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JRadioButton getRbtnOnline() {
		return rbtnOnline;
	}
	public JRadioButton getRbtnPresen() {
		return rbtnPresen;
	}
	public JComboBox getComboBoxCat() {
		return comboBoxCat;
	}
}
