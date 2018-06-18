package rieqyns13;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Table {
	private JTable table;
	public void setTable(JTable table) {
		this.table=table;
	}
	public JTable getTable() {
	
		return this.table;
	}
	public Table(JTable table) {
		this.setTable(table);
	}
	public DefaultTableModel getTableModel() {
		return (DefaultTableModel) this.table.getModel();
	}
	public DefaultTableModel getTableModel(JTable table) {
		return (DefaultTableModel) table.getModel();
	}
	
	public void tambahBaris(Object[] obj) {
		int a=this.table.getRowCount();
		DefaultTableModel model = getTableModel(this.table);
		model.addRow(obj);             
	}
	public Object[][] getAllRow() {
		Object[][] obj=new Object[table.getRowCount()][table.getColumnCount()];
		for(int i=0; i<table.getRowCount(); i++) {
			for(int j=0; j<table.getColumnCount(); j++) {
				obj[i][j]=table.getValueAt(i, j);
			}
		}
		return obj;
	}
	public void hapustextField(JTextField[] txt) {
		for(JTextField x:txt) {
			x.setText("");
		}
	}
	public void hapusSemuaRow() {
		DefaultTableModel moel=this.getTableModel();
		while(table.getRowCount()>0)moel.removeRow(0);
	}
	public void tambahBaris(boolean penomoran,Object[] obj) {
		if(penomoran) {
			int a=this.table.getRowCount();
			a++;
			Object[] obj2=new Object[obj.length+1];
			obj2[0]=a;
			for(int i=0;i<obj.length;i++) {
				obj2[i+1]=obj[i];
			}
			tambahBaris(obj2);
		}else tambahBaris(obj);
	}
	public Object[] getAllRow(int index,int mulaikolom) {
		int c=this.table.getColumnCount();
		Object[] obj=new Object[c];
		for(int i=mulaikolom; i<c; i++)obj[i]=this.table.getValueAt(index, i);
		return obj;
		
	}
	public void hapusBarisYgDipilih(boolean is_penomoran) {
		try {
			DefaultTableModel model=getTableModel(this.table);
			int[] c=this.table.getSelectedRows();
			while(this.table.getSelectedRowCount()>0) {
				model.removeRow(this.table.getSelectedRows()[0]);
			}
			if(is_penomoran) {
				int a=this.table.getRowCount();
				for(int i=0; i<a; i++) {
					model.setValueAt((Object)(i+1), i, 0);
				}
			}
		}catch(Exception ex) {
		//	JOptionPane.showMessageDialog(, ex.toString());
			ex.printStackTrace();
		}
	}
	///SQL

}
