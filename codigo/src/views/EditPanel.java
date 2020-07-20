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

public class EditPanel extends JPanel {
	private JTextField inputCurso;
	private JTextField inputPlatform;
	private JTextField inputhours;
	private JTextField inputprice;
	private JButton btnUpdate;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbtnPresen;
	private JRadioButton rbtnOnline;
	private JComboBox comboBoxCat;

	/**
	 * Create the panel.
	 */
	public EditPanel() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u20AC");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3.setBounds(346, 290, 29, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Actualiza los datos");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(285, 32, 167, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Curso");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(145, 116, 128, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Plataforma");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(145, 155, 128, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Horas");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(145, 196, 128, 16);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Categor\u00EDa");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(145, 244, 128, 16);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Precio");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(145, 289, 128, 16);
		add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Modalidad");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(145, 346, 128, 16);
		add(lblNewLabel_1_6);
		
		inputCurso = new JTextField();
		inputCurso.setOpaque(false);
		inputCurso.setBackground(new Color(220, 220, 220));
		inputCurso.setFont(new Font("Verdana", Font.PLAIN, 14));
		inputCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputCurso.setBounds(285, 104, 374, 22);
		add(inputCurso);
		inputCurso.setColumns(10);
		
		inputPlatform = new JTextField();
		inputPlatform.setOpaque(false);
		inputPlatform.setFont(new Font("Verdana", Font.PLAIN, 14));
		inputPlatform.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputPlatform.setColumns(10);
		inputPlatform.setBounds(285, 153, 374, 22);
		add(inputPlatform);
		
		inputhours = new JTextField();
		inputhours.setOpaque(false);
		inputhours.setFont(new Font("Verdana", Font.PLAIN, 14));
		inputhours.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputhours.setColumns(10);
		inputhours.setBounds(285, 194, 104, 22);
		add(inputhours);
		
		inputprice = new JTextField();
		inputprice.setOpaque(false);
		inputprice.setFont(new Font("Verdana", Font.PLAIN, 14));
		inputprice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		inputprice.setColumns(10);
		inputprice.setBounds(285, 283, 51, 22);
		add(inputprice);
		
		btnUpdate = new JButton("Actualizar");
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 14));
		btnUpdate.setBounds(524, 372, 114, 25);
		add(btnUpdate);
		
		rbtnOnline = new JRadioButton("On-Line");
		rbtnOnline.setFont(new Font("Verdana", Font.PLAIN, 14));
		rbtnOnline.setOpaque(false);
		buttonGroup.add(rbtnOnline);
		rbtnOnline.setBounds(285, 325, 127, 25);
		add(rbtnOnline);
		
		rbtnPresen = new JRadioButton("Presencial");
		rbtnPresen.setFont(new Font("Verdana", Font.PLAIN, 14));
		rbtnPresen.setOpaque(false);
		buttonGroup.add(rbtnPresen);
		rbtnPresen.setBounds(285, 355, 127, 25);
		add(rbtnPresen);
		
		comboBoxCat = new JComboBox();
		comboBoxCat.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		comboBoxCat.setBackground(new Color(230, 230, 250));
		comboBoxCat.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBoxCat.setModel(new DefaultComboBoxModel(new String[] {"Selecciona...", "Programaci\u00F3n", "Desarrollo Web", "Redes y Seguridad", "Dise\u00F1o Web", "Marketing Digital", "Gesti\u00F3n de Proyectos"}));
		comboBoxCat.setSelectedIndex(0);
		comboBoxCat.setBounds(285, 241, 157, 22);
		add(comboBoxCat);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("img/cursosuavel.jpg"));
		lblNewLabel_2.setBounds(0, 0, 865, 561);
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
	public JRadioButton getRbtnOnline() {
		return rbtnOnline;
	}
	public JRadioButton getRbtnPresen() {
		return rbtnPresen;
	}
	public JComboBox getComboBoxCat() {
		return comboBoxCat;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
}
