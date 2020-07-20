package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JMenuItem menuAnadir;
	private JMenuItem menuVer;
	private JMenu mInicio;
	private JMenuItem menuInicio;
	private JMenuItem menuTabla;

	/**
	 * Launch the application.
	 */
//main no utilizable
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setTitle(" Cursos para todos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mInicio = new JMenu("Inicio");
		mInicio.setFont(new Font("Verdana", Font.BOLD, 15));
		menuBar.add(mInicio);
		
		menuInicio = new JMenuItem("Volver Inicio");
		mInicio.add(menuInicio);
		
		JMenu mnNewMenu = new JMenu("Cursos");
		mnNewMenu.setFont(new Font("Verdana", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		menuAnadir = new JMenuItem("A\u00F1adir Curso");
		menuAnadir.setFont(new Font("Verdana", Font.BOLD, 14));
		mnNewMenu.add(menuAnadir);
		
		menuVer = new JMenuItem("Ver Cursos");
		menuVer.setFont(new Font("Verdana", Font.BOLD, 14));
		mnNewMenu.add(menuVer);
		
		menuTabla = new JMenuItem("Tabla Cursos");
		menuTabla.setFont(new Font("Verdana", Font.BOLD, 14));
		mnNewMenu.add(menuTabla);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public JMenuItem getMenuAnadir() {
		return menuAnadir;
	}
	public JMenuItem getMenuVer() {
		return menuVer;
	}
	
	public JMenuItem getMenuInicio() {
		return menuInicio;
	}
	public JMenuItem getMenuTabla() {
		return menuTabla;
	}
}
