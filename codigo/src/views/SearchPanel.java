package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;

public class SearchPanel extends JPanel {
	private JButton btnEdit;
	private JButton btnDelete;
	private JList jList;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		btnDelete = new JButton("BORRAR");
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDelete.setBounds(524, 393, 110, 25);
		add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("LISTADO DE CURSOS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(260, 49, 198, 16);
		add(lblNewLabel);
		
		btnEdit = new JButton("EDITAR");
		btnEdit.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEdit.setBounds(238, 393, 97, 25);
		add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(56, 98, 737, 265);
		add(scrollPane);
		
		jList = new JList();
		scrollPane.setViewportView(jList);
		jList.setFont(new Font("Verdana", Font.PLAIN, 15));
		jList.setBackground(new Color(230, 230, 250));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(230, 230, 250));
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setIcon(new ImageIcon("img/cursosuavel.jpg"));
		lblNewLabel_1.setBounds(0, 0, 865, 561);
		add(lblNewLabel_1);

	}

	
	public JButton getBtnEdit() {
		return btnEdit;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JList getJList() {
		return jList;
	}
}
