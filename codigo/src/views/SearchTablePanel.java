package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SearchTablePanel extends JPanel {
	private JTable jtable;
	private JButton btnEditTable;
	private JButton btnDeleteTable;
	private JButton btnInfo;

	/**
	 * Create the panel.
	 */
	public SearchTablePanel() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		btnInfo = new JButton("INFO");
		btnInfo.setFont(new Font("Verdana", Font.BOLD, 14));
		btnInfo.setBounds(341, 374, 97, 25);
		add(btnInfo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(230, 230, 250));
		scrollPane_1.setBounds(70, 74, 677, 251);
		add(scrollPane_1);
		
		jtable = new JTable();
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtable.setFont(new Font("Verdana", Font.PLAIN, 15));
		jtable.setBackground(new Color(230, 230, 250));
		scrollPane_1.setViewportView(jtable);
		
		JLabel lblTablaDeCursos = new JLabel("TABLA DE CURSOS");
		lblTablaDeCursos.setBounds(341, 25, 157, 20);
		lblTablaDeCursos.setFont(new Font("Verdana", Font.BOLD, 15));
		add(lblTablaDeCursos);
		
		btnEditTable = new JButton("EDITAR");
		btnEditTable.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEditTable.setBounds(231, 431, 97, 25);
		add(btnEditTable);
		
		btnDeleteTable = new JButton("BORRAR");
		btnDeleteTable.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDeleteTable.setBounds(459, 431, 110, 25);
		add(btnDeleteTable);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setIcon(new ImageIcon("img/cursosuavel.jpg"));
		lblNewLabel.setBounds(0, -1, 865, 561);
		add(lblNewLabel);

	}
	public JButton getBtnEditTable() {
		return btnEditTable;
	}
	public JButton getBtnDeleteTable() {
		return btnDeleteTable;
	}
	public JTable getJtable() {
		return jtable;
	}
	public JButton getBtnInfo() {
		return btnInfo;
	}
}
