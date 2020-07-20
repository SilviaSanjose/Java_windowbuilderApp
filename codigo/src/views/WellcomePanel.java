package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class WellcomePanel extends JPanel {
	private JLabel aaa;

	/**
	 * Create the panel.
	 */
	public WellcomePanel() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("busca los cursos ofertados.");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(424, 164, 416, 22);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Publica tus cursos o ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(295, 129, 416, 22);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("APRENDE SIN L\u00CDMITES");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(327, 31, 323, 38);
		add(lblNewLabel);
		
		aaa = new JLabel("");
		aaa.setHorizontalAlignment(SwingConstants.CENTER);
		aaa.setIcon(new ImageIcon("img/cursoincio.jpg"));
		aaa.setBounds(0, 0, 865, 561);
		add(aaa);

	}

	public JLabel getAaa() {
		return aaa;
	}
}
