package rieqyns13;

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
import java.sql.*;
import java.util.*;

public class DataTable extends Table{
	public DataTable(JTable table) {
		super(table);
	}
	public DataTable() {
		super(null);
	}
	public JFrame frame;
	public Object[][] getAllData(String sql,String[] koloms) throws SQLException {
		Statement stmt = null;
		String query=null;
		ArrayList<Object[]> objList=new ArrayList<Object[]>();
		try {
			stmt=Koneksi.getConnection().createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 while (rs.next()) {
				 ArrayList<Object> objList2=new ArrayList<Object>();
				 	for(String kolom:koloms) {
				 		objList2.add(rs.getObject(kolom));
				 	}
				 	objList.add(objList2.toArray());
		     }
			Object[][] obj=new Object[objList.size()][koloms.length];
			for(int i=0; i<objList.size(); i++) {
				for(int j=0; j<koloms.length; j++) {
					obj[i][j]=objList.get(i)[j];
				}
			}
			 if (stmt != null) stmt.close();
			 return obj;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	 public void insertData(String tbl_name,Object[] kolom, Object[] value) {
		 	String as="";
		 	String asu="";
		 	for(int i=0; i<kolom.length; i++) {
		 		as+=kolom[i];
		 		if(i<kolom.length-1)as+=",";
		 		asu+="?";
		 		if(i<kolom.length-1)asu+=",";
		 	}
	        String sql = "INSERT INTO `"+tbl_name+"`("+as+") VALUES("+asu+")";
	 
	        try {
	        	Connection conn = Koneksi.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            
	            for(int i=0; i<kolom.length; i++) {
	            	 pstmt.setObject(i+1, value[i]);
	            }
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        
	        
	  }
	 public int cekApakahAda(String table_name, String[] name, Object[] value) {
			String sql=null,njir="";
	        try {
	        	for(int i=0; i<name.length; i++) {
	        		njir+="`"+name[i]+"` = ? ";
	        		if(i<name.length-1)njir+=" and ";
	        	}
	        	sql="select * from `"+table_name+"` where "+njir;
	        	
	        	Connection conn = Koneksi.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            for(int i=0; i<value.length; i++) {
	            	pstmt.setObject(i+1, value[i]);
	            }
	            
				 ResultSet rs = pstmt.executeQuery();
				 if(rs.next())return 1;
				 else return 0;
				
	        } catch (SQLException e) {
	            e.printStackTrace();
	            if(frame!=null)JOptionPane.showMessageDialog(frame, e.getMessage());
	            return 2;
	        }catch(Exception ee) {
	        	ee.printStackTrace();
	        	return 2;
	        }
	 }
	 public void deleteData(String tbl_name,int id) {
	        String sql = "DELETE FROM `"+tbl_name+"` WHERE `id` = ?";
	 
	        try {
	        	Connection conn = Koneksi.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	 
	          
	            pstmt.setInt(1, id);
	           
	            pstmt.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            if(frame!=null)JOptionPane.showMessageDialog(frame, e.getMessage());
	        }
	    }
	 public void hapusItemYangDipilih(String tbl_name) {
		 int[] rows=getTable().getSelectedRows();
		 for(int i=0; i<rows.length; i++) {
			 MbuhData obj=(MbuhData)getTable().getValueAt(rows[i], 0);
			 System.out.println(obj.getKey().toString());
			 this.deleteData(tbl_name, Integer.parseInt(obj.getKey().toString()));
		 }
	 }
	public void loadDatakeTable(String str,String[] koloms, boolean b) throws SQLException {
		Statement stmt = null;
		String query=null;
		if(b)
			query = "select * from " + str + " order by id asc";
		else 
			query = str;
		try {
			stmt=Koneksi.getConnection().createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			
			 while (rs.next()) {
				 	ArrayList<Object> objList=new ArrayList<Object>();
				 	int i=0;
				 	for(String kolom:koloms) {
			            objList.add(rs.getString(kolom));
			            ++i;
				 	}
				 	this.tambahBaris(true,objList.toArray());
		        }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (stmt != null) { stmt.close(); }
		
		}
	}
	
	public void loadDatakeTable(String sql, int[] column_index) throws SQLException {
		Statement stmt = null;
	    String query = sql;
		try {
			stmt=Koneksi.getConnection().createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			
			 while (rs.next()) {
				 	ArrayList<Object> objList=new ArrayList<Object>();
				 	int i=0;
				 	for(int kolom:column_index) {
			            objList.add(rs.getString(kolom));
			            ++i;
				 	}
				 	this.tambahBaris(true,objList.toArray());
		        }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (stmt != null) { stmt.close(); }
		
		}
	}

}
