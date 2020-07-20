package manageWindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import daos.CursosDAO;
import daos.CursosDAOimplArchivo;
import daos.CursosDAOimplArrayList;
import model.Curso;
import views.EditPanel;
import views.MainWindow;
import views.SearchPanel;
import views.SearchTablePanel;
import views.UploadPanel;
import views.WellcomePanel;
import views.extra.JTabletview;

public class ManageWindow implements ActionListener {
	
	//indico que Dao voy a usar aqui para guardar los libros
	//CursosDAOimpl cursosDao = new CursosDAOimpl(); // con esto, se podrían llamar a métodos de la clase CursosDAOimpl
// asi aunque sea clase CursosDAOimpl, el objeto es de tipo de la interfaz, por lo que sólo permite los métodos de la interfaz
	CursosDAO cursosDao = new CursosDAOimplArchivo();  
	
	private MainWindow mainW = new MainWindow();
	private WellcomePanel wellcomeP = new WellcomePanel();
	private UploadPanel uploadP = new UploadPanel();
	private SearchPanel searchP = new SearchPanel();
	private EditPanel editP = new EditPanel();
	private SearchTablePanel searchTableP = new SearchTablePanel();
	
	int indiceEditar = -1;
	
	public ManageWindow() {
	//pongo los objetos de interactuar a la escucha de los eventos: menus y botones
		mainW.getMenuInicio().addActionListener(this);
		mainW.getMenuAnadir().addActionListener(this);
		mainW.getMenuVer().addActionListener(this);
		mainW.getMenuTabla().addActionListener(this);
		uploadP.getBtnGuardar().addActionListener(this);
		searchP.getBtnDelete().addActionListener(this);
		searchP.getBtnEdit().addActionListener(this);
		editP.getBtnUpdate().addActionListener(this);
		searchTableP.getBtnDeleteTable().addActionListener(this);
		searchTableP.getBtnEditTable().addActionListener(this);
		searchTableP.getBtnInfo().addActionListener(this);
		
		
		mainW.setContentPane(wellcomeP); //indico el panel por defecto al cargar la aplicación
		mainW.setVisible(true);

	}
	

	@Override //gestiono lo que pasa al seleccionar los menus y botones
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== mainW.getMenuInicio()) { //si pulsa inicio
			mainW.setContentPane(wellcomeP);
			
		}else if (e.getSource()== mainW.getMenuAnadir()) {  //si pulsa menu añadir curso
			mainW.setContentPane(uploadP);
			
		}else if (e.getSource()== uploadP.getBtnGuardar()) {  //si pulsa ratón guardar
			comprobarCamposyGuardar();
		
		}else if (e.getSource()== mainW.getMenuVer()) { //si pulsa menu ver cursos
			cargarDatosArchivo();
			
		}else if (e.getSource() == mainW.getMenuTabla()) {
			cargarDatostabla();
			
		}else if (e.getSource()== searchTableP.getBtnInfo()) {
			indiceEditar = searchTableP.getJtable().getSelectedRow();
			Curso ci = cursosDao.obtenerCursoId(indiceEditar);
			informacionAdicional(ci);
		}
		else if (e.getSource()== searchP.getBtnDelete()) {
			int indice = searchP.getJList().getSelectedIndex();
			cursosDao.borrarCurso(indice);
			cargarDatosArchivo(); //cargo datos para refrescar el listado
			
		}else if (e.getSource()== searchTableP.getBtnDeleteTable()) {
			int indiceTable =searchTableP.getJtable().getSelectedRow();
			cursosDao.borrarCurso(indiceTable);
			cargarDatostabla();

		}else if (e.getSource()== searchP.getBtnEdit()) {
			indiceEditar = searchP.getJList().getAnchorSelectionIndex();
			Curso c = cursosDao.obtenerCursoId(indiceEditar);  //recojo los datos del curso correspondiente al indice seleccionado
			
			mainW.setContentPane(editP); //cargo ventana
			cargarCursoAEditar(c);
		
		}else if (e.getSource()== searchTableP.getBtnEditTable()) {
			indiceEditar = searchTableP.getJtable().getSelectedRow();
			Curso ct = cursosDao.obtenerCursoId(indiceEditar);  //recojo los datos del curso correspondiente al indice seleccionado
			
			mainW.setContentPane(editP); //cargo ventana
			cargarCursoAEditar(ct);
			
		}else if (e.getSource() == editP.getBtnUpdate()) {
			actualizarDatos();
			
		}
	//refresco la ventana principal	
		SwingUtilities.updateComponentTreeUI(mainW);  
	}//actionPerformed
	
//comprobación de campos al registrar un nuevo curso y guardado.	
	public void comprobarCamposyGuardar() {
		boolean error = false; //creo variable para ver si hay campos vacios
		Curso newCourse = new Curso();  //creo objeto tipo curso
		
		
    //llamo a cada setter de los elementos de Curso y como valor le doy el getter del elemento,y obtengo el texto escrito en textfield

		if(uploadP.getInputCurso().getText().isEmpty() ||
				uploadP.getInputPlatform().getText().isEmpty() ||
				uploadP.getInputhours().getText().isEmpty() ||
				uploadP.getComboBoxCat().getSelectedItem().toString() == "Selecciona..." ||
				uploadP.getInputprice().getText().isEmpty() ){
			error = true;
		}
	
		else {
			String price = uploadP.getInputprice().getText(); //para que acepte comas; modificación de ',' por '.'
			for(int p=0; p<price.length();p++) {
				if (price.charAt(p)== ',') {
					price = price.replace(',','.' );
				}
			}//end for
			
			newCourse.setCourse(uploadP.getInputCurso().getText()); 
			newCourse.setPlatform(uploadP.getInputPlatform().getText());
			newCourse.setCategory(uploadP.getComboBoxCat().getSelectedItem().toString());
			try {
				newCourse.setHours(Integer.parseInt(uploadP.getInputhours().getText()));
				newCourse.setPrice(Double.parseDouble(price));
			}catch (NumberFormatException nfe){
				error = true;
			}
				
		}
	
		if(uploadP.getRbtnOnline().isSelected()) {
			newCourse.setType("Online");
		}else if(uploadP.getRbtnPresen().isSelected()) {
			newCourse.setType("Presencial");
		}else {
			newCourse.setType("No especificado");
		}
	//compruebo si hay algún campo vacio/error no se guarda el curso
		if(error) {
			JOptionPane.showMessageDialog(null, "No se ha guardado tu curso.\nDebes rellenar todos los campos correctamente" ,"Error", 0);
		}else {
			cursosDao.registrarCurso(newCourse);  //llamo al metodo para guardar el curso, dandole el nuevocurso a guardar.
			JOptionPane.showMessageDialog(null, "Curso Registrado", "Gracias", 1);

		   //vacio los campos una vez registrado
			uploadP.getInputCurso().setText("");
			uploadP.getInputPlatform().setText("");
			uploadP.getInputhours().setText("");
			uploadP.getComboBoxCat().setSelectedIndex(0);
			uploadP.getInputprice().setText("");
		}			
	}//end comprobarCampos
	
	public void cargarDatosArchivo() {
		mainW.setContentPane(searchP);
		
		ArrayList<Curso> courses = cursosDao.obtenerCursos();  //creo objeto llamando al metodo
		DefaultListModel<String> listModel = new DefaultListModel<String>(); //para trabajar con JList
		
		for (Curso c:courses) {
			listModel.addElement(c.toString());   //llama al método de la clase para mostrar los datos
		}
		searchP.getJList().setModel(listModel);
	}//end cargarDatosArchivo
	
	public void cargarDatostabla() { //visualización datos en tabla
		mainW.setContentPane(searchTableP);
		ArrayList<Curso> coursesT = cursosDao.obtenerCursos();  //creo objeto llamando al metodo
		
		TableModel table = new JTabletview(coursesT);
		searchTableP.getJtable().setModel(table);
	//modificacion tamaño columnas
		TableColumnModel tb = searchTableP.getJtable().getColumnModel();
		tb.getColumn(0).setPreferredWidth(264);
		tb.getColumn(1).setPreferredWidth(160);
		tb.getColumn(2).setPreferredWidth(60);
		tb.getColumn(3).setPreferredWidth(190);

	}

	
	public void informacionAdicional(Curso c) {
		JOptionPane.showMessageDialog(null,  c.getCourse().toUpperCase() + "\nPataforma: "+ c.getPlatform() + 
				"\nHoras del curso: " + c.getHours() + "\nPrecio: " + c.getPrice() , "Curso " +c.getType(), 1);
	}

	public void cargarCursoAEditar(Curso c) {
	//pongo los campos con los datos recogidos del curso a editar(c)	
		editP.getInputCurso().setText(c.getCourse());
		editP.getInputPlatform().setText(c.getPlatform());
		editP.getInputhours().setText(Integer.toString(c.getHours()));  //settext solo admite String, por lo que se pasa.
		
		switch(c.getCategory()) {
		case "Programación":
			editP.getComboBoxCat().setSelectedIndex(1);
			break;
		case "Desarrollo Web":
			editP.getComboBoxCat().setSelectedIndex(2);
			break;
		case "Redes y Seguridad":
			editP.getComboBoxCat().setSelectedIndex(3);
			break;
		case "Diseño Web":
			editP.getComboBoxCat().setSelectedIndex(4);
			break;
		case "Marketing Digital":
			editP.getComboBoxCat().setSelectedIndex(5);
		break;
		case "Gesti\u00F3n de Proyectos":
			editP.getComboBoxCat().setSelectedIndex(6);
		break;
		}
		editP.getInputprice().setText(Double.toString(c.getPrice()));
		if(c.getType() == "Presencial") {
			editP.getRbtnPresen().setSelected(true);
		}else {
			editP.getRbtnOnline().setSelected(true);
		}

	}//end cargarCursoAEditar

	public void actualizarDatos() {
		String course = editP.getInputCurso().getText();
		String platform = editP.getInputPlatform().getText();
		int hours = Integer.parseInt(editP.getInputhours().getText());  
		String category = editP.getComboBoxCat().getSelectedItem().toString();
		
		String priceEdit = editP.getInputprice().getText();
		for(int p=0; p<priceEdit.length();p++) {
			if (priceEdit.charAt(p)== ',') {
				priceEdit = priceEdit.replace(',','.' );
			}
		}
		double price = Double.parseDouble(priceEdit);
		
		String type = "";
		if(editP.getRbtnOnline().isSelected()) {
			type = "Online";
		}else {
			type ="Presencial";
		}
		cursosDao.editarCurso(course, platform, hours, category, price, type, indiceEditar);
	//para volver a Jlist o JTable:	
		String[] option ={"Listado", "Tabla"};
		int optionInt =JOptionPane.showOptionDialog(null, "¿Donde quieres volver?", "volver", 0, 3, null, option, null);
		if(optionInt == 0) {
			cargarDatosArchivo();
		}else {
			cargarDatostabla();
		}
	}
}//end class
