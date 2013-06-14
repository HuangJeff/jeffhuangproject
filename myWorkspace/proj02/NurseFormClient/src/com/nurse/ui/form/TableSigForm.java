/**
 * 
 */
package com.nurse.ui.form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import com.jidesoft.grid.TableScrollPane;
import com.jidesoft.grid.TreeTableModel;
import com.jidesoft.plaf.LookAndFeelFactory;
import com.jidesoft.utils.Lm;

import java.awt.*;
/**
 * @author test
 *
 */
@SuppressWarnings("serial")
public class TableSigForm extends JPanel {
	
	/**
	 * 
	 */
	public TableSigForm() {
		try {
			//要注冊，否則一直會有訊息Box出現
			Lm.verifyLicense("Hong Cheng International Technology Inc.",
	    			"TBD", "hJyPaSzoW2D7GROHaDVAsTLJee0t8EC");
	        LookAndFeelFactory.installDefaultLookAndFeelAndExtension();
			
			//塞值方式二：TableModel
//			JTable table = new JTable(new MyTableModel());
//			JScrollPane scrollPane = new JScrollPane(table);
//			this.add(scrollPane, BorderLayout.CENTER);
			
			this.add(this.createTable(), BorderLayout.CENTER);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 建立 TableScrollPane 物件<br>
	 * TableScrollPane = JTable + JScrollPane
	 * @return TableScrollPane 物件
	 * @throws Exception
	 */
	public TableScrollPane createTable() throws Exception {
		TableScrollPane tableScrollPane = new TableScrollPane(new MyTableModel(), true);
		
		return tableScrollPane;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	class MyTableModel extends TreeTableModel {
		private String[] columnNames = {"First Name",
				"Last Name",
				"Sport",
				"# of Years",
				"Vegetarian"};
		private Object[][] data = {
					{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)},
					{"John", "Doe","Rowing", new Integer(3), new Boolean(true)},
					{"Sue", "Black","Knitting", new Integer(2), new Boolean(false)},
					{"Jane", "White","Speed reading", new Integer(20), new Boolean(true)},
					{"Joe", "Brown","Pool", new Integer(10), new Boolean(false)}
				};
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public int getRowCount() {
			return data.length;
		}
		
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		
		/*
		* JTable uses this method to determine the default renderer/
		* editor for each cell.  If we didn't implement this method,
		* then the last column would contain text ("true"/"false"),
		* rather than a check box.
		*/
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
		
		/*
		* Don't need to implement this method unless your table's
		* editable.
		*/
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}
		
		/*
		* Don't need to implement this method unless your table's
		* data can change.
		*/
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			//fireTableCellUpdated(row, col); //通知所有偵聽器，已更新 [row, column] 處的單元格值
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame("Frame Test");
				f.setLayout(new BorderLayout());
				f.add(new TableSigForm(), BorderLayout.CENTER);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setLocationRelativeTo(null);
				f.pack();
				f.setVisible(true);
			}
		});
	}
}
