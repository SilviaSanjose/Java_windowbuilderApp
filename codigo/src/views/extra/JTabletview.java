package views.extra;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Curso;


public class JTabletview extends AbstractTableModel{
	String [] headers = {"CURSO", "PLATAFORMA", "HORAS", "CATEGORIA"};
	
	String [][] data =null;
	
	public JTabletview(ArrayList<Curso> cursos) {
		data = new String [cursos.size()][4];
		
		for (int c=0; c<cursos.size();c++) {
			data[c] = new String[4];
			data[c][0] = cursos.get(c).getCourse();
			data[c][1] = cursos.get(c).getPlatform();
			data[c][2] = Integer.toString(cursos.get(c).getHours());
			data[c][3] = cursos.get(c).getCategory();
		}
		
	}
	
	@Override //cambio el nombre de los títulos
	public String getColumnName(int colum) {
		// TODO Auto-generated method stub
		return headers[colum];
	}

	@Override
	public int getColumnCount() {
		// cantidad de arrays que son la cantidad de arrays
			return headers.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

}
