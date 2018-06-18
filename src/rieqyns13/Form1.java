package rieqyns13;

import java.awt.EventQueue;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


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
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
public class Form1 {

	private JFrame frmProfileMatchingProgram;
	private JTabbedPane tabbedPane;
	private JLayeredPane layeredPane;
	private JButton btnAddAlternatif;
	private JScrollPane scrollPane;
	private JTextField txtAlternatif;
	private JButton btnHapusItem;
	private JTable tableAlternatif;
	private JLayeredPane layeredPane_1;
	private JTextField kodeAspek;
	private JTextField txtNamaAspek;
	private JLabel lblNamaAspek;
	private JLabel lblPersentase;
	private JTextField txtPersentaseAspek;
	private JScrollPane scrollPane_1;
	private JTable tblAspek;

	private Form1 form1;
	private JLabel lblAspek;
	private JTextField txtAspek2;
	private JTextField txtKodeKriteria;
	private JTextField txtNamaKriteria;
	private JTable tblKriteria;
	private JTextField txtNilaiKriteria;
	private JRadioButton radioButtonCore;
	private JRadioButton radioButtonSecondary;
	private JTextField txtKodeAlternatif;
	private JComboBox comboBox;
	private JButton btnTambahKriteria;
	private JLayeredPane layeredPane_3;
	private JComboBox comboBoxAspek2;
	private JTextField txtNilaiProfile;
	private JComboBox comboBoxKriteria;
	private JLabel lblAngka_1;
	private JButton btnTambahProfil;
	private JTable tblProfile;
	private JComboBox comboBoxAlternatif;
	private JTable tblHitung;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 window = new Form1();
					window.frmProfileMatchingProgram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	void loadAlternatif()throws SQLException{
		try {
			DataTable d=new DataTable(this.tableAlternatif);
			String query="SELECT * FROM `tbl_alternatif` order by id asc";
			Object[][] asu=d.getAllData(query, new String[] {"id","kode","nama_alternatif"});

			for(int i=0; i<asu.length; i++) {
				Object[] obj=new Object[3];
				obj[0]=new MbuhData(String.valueOf(asu[i][0]), String.valueOf((i+1)));
				
				obj[1]=asu[i][1];
				obj[2]=asu[i][2];
				d.tambahBaris(obj);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
		}
	}
	void loadAspek() {
		try {
			
			
			DataTable d=new DataTable(this.tblAspek);
			d.hapusSemuaRow();
			String query="SELECT * FROM `tbl_aspek` order by id asc";
			Object[][] asu=d.getAllData(query, new String[] {"id","kode","nama_aspek","persentase"});

			for(int i=0; i<asu.length; i++) {
				Object[] obj=new Object[4];
				obj[0]=new MbuhData(String.valueOf(asu[i][0]), String.valueOf((i+1)));
				
				obj[1]=asu[i][1];
				obj[2]=asu[i][2];
				obj[3]=asu[i][3];
				d.tambahBaris(obj);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	void loadComboBox(JComboBox combobox) {
		try {
			combobox.removeAllItems();
			combobox.addItem("Pilih item");
			DataTable d=new DataTable();
			Object[][] obj=d.getAllData("select * from tbl_aspek order by id asc",new String[] {"id","kode","nama_aspek"});
			for(int i=0; i<obj.length; i++) {
				combobox.addItem(new ComboItem(obj[i][0], (String)obj[i][1],(String)obj[i][2]));
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	void loadComboBoxKriteria(JComboBox combobox, ComboItem item) {
		try {
			combobox.removeAllItems();
			combobox.addItem("Pilih item");
			DataTable d=new DataTable();
			Object[][] obj=d.getAllData("select * from tbl_kriteria where id_aspek="+item.getId()+" order by id asc",new String[] {"id","kode","nama_kriteria"});
			for(int i=0; i<obj.length; i++) {
				combobox.addItem(new ComboItem(obj[i][0], (String)obj[i][1],(String)obj[i][2]));
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	void loadComboBoxAlternatif(JComboBox combobox) {
		try {
			combobox.removeAllItems();
			combobox.addItem("Pilih item");
			DataTable d=new DataTable();
			Object[][] obj=d.getAllData("select * from tbl_alternatif order by id asc",new String[] {"id","kode","nama_alternatif"});
			for(int i=0; i<obj.length; i++) {
				combobox.addItem(new ComboItem(obj[i][0], (String)obj[i][1],(String)obj[i][2]));
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	void loadDataKriteria() {
		try {
			DataTable d=new DataTable(tblKriteria);
			d.hapusSemuaRow();
			
			String query="SELECT * FROM `tbl_kriteria` a inner join `tbl_aspek` b on a.id_aspek=b.id order by b.kode, a.id asc";
			Object[][] asu=d.getAllData(query, new String[] {"kode","nama_aspek","nama_kriteria","nilai","factor"});
			for(int i=0; i<asu.length; i++) {
				if(asu[i][4].equals("1"))asu[i][4]="Core";
				else asu[i][4]="Secondary";
				d.tambahBaris(true,asu[i]);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		
		}
	
	}
	void loadProfile() {
		try {
			HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
			ComboItem comboitem=(ComboItem)this.comboBoxAspek2.getSelectedItem();
			Object id=comboitem.getId();
			DataTable dataTable=new DataTable(form1.tblProfile);
			Object[][] obj=dataTable.getAllData("select * from tbl_kriteria where id_aspek = "+id+" order by kode", 
					new String[] {"id","id_aspek","kode","nama_kriteria","nilai","factor"});
			String[] kolom = new String[obj.length+1];
			kolom[0]="Alternatif/Kriteria";
			for(int i=0; i<obj.length; i++) {
				kolom[i+1]=(String)obj[i][2];
				hm.put((Integer)obj[i][0], i+1); //(i+1) adalah letak kolum	
			}
			HashMap<Object, Profile> hm2=new HashMap<Object,Profile>();
			int jumkolom=obj.length;
			obj=dataTable.getAllData("select a.id as id_a,a.kode as kode_a,a.nama_alternatif,"
					+ "b.*,c.* from tbl_alternatif a left join tbl_profile b on b.id_alternatif=a.id left join " + 
					"tbl_kriteria c on b.id_kriteria=c.id where c.id_aspek = "+id, 
					new String[] {"id_a","kode_a","id_kriteria","nama_alternatif","nilai_profile","id_aspek"});
			for(int i=0; i<obj.length; i++) {
				Object idx=obj[i][0];
				Profile profil=null;
				if(!hm2.containsKey(idx)) {
					profil=new Profile(jumkolom+1);
					profil.kode_alternatif = obj[i][1];
					profil.obj[hm.get(obj[i][2])] = obj[i][4];
					hm2.put(idx, profil);
				}else {
					profil=hm2.get(idx);
					profil.obj[hm.get(obj[i][2])] = obj[i][4];
					hm2.put(idx, profil);
				}
			}
			Object[][] mbuh=new Object[hm2.size()][jumkolom+1];
			int i=0;
			for(Profile profil:hm2.values()) {
				mbuh[i][0]=profil.kode_alternatif;
				System.out.println(jumkolom+1);
				for(int j=1; j<profil.obj.length; j++) {
					mbuh[i][j]=profil.obj[j];
				}
				i++;
				
			}
			form1.tblProfile.setModel(new DefaultTableModel(
					mbuh,
					kolom));
			
		//	String sql="select * from tbl_kriteria";
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public Form1() {
		initialize();
		 
	     this.form1=this;
	     
	     	try {
				DataTable d=new DataTable(tableAlternatif);
				
				JLabel lblNamaAlternatif = new JLabel("Nama Alternatif");
				lblNamaAlternatif.setBounds(28, 60, 97, 16);
				layeredPane.add(lblNamaAlternatif);
				
				JLabel lblKodeAlternatif = new JLabel("Kode Alternatif");
				lblKodeAlternatif.setBounds(28, 25, 97, 16);
				layeredPane.add(lblKodeAlternatif);
				
				txtKodeAlternatif = new JTextField();
				txtKodeAlternatif.setBounds(137, 22, 116, 22);
				layeredPane.add(txtKodeAlternatif);
				txtKodeAlternatif.setColumns(10);
				loadAlternatif();
				d=new DataTable(tblAspek);
				
				layeredPane_3 = new JLayeredPane();
				tabbedPane.addTab("Nilai Profile", null, layeredPane_3, null);
				
				JLabel lblPilihAspek_1 = new JLabel("Pilih Aspek");
				lblPilihAspek_1.setBounds(12, 13, 73, 16);
				layeredPane_3.add(lblPilihAspek_1);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(12, 183, 621, 268);
				layeredPane_3.add(scrollPane_2);
				
				tblProfile = new JTable();
				tblProfile.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
					}
				));
				scrollPane_2.setViewportView(tblProfile);
				
				comboBoxAspek2 = new JComboBox();
				comboBoxAspek2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(arg0.getStateChange() == ItemEvent.SELECTED) {
							if(form1.comboBoxAspek2.getSelectedIndex()>0) {
								try {
									loadProfile();
									ComboItem item=(ComboItem)comboBoxAspek2.getSelectedItem();
									
									form1.loadComboBoxKriteria(form1.comboBoxKriteria,item);
									
								}catch(Exception ex) {
									ex.printStackTrace();
								}
							}
						}
					}
				});
				comboBoxAspek2.setBounds(112, 10, 324, 22);
				layeredPane_3.add(comboBoxAspek2);
				
				JButton btnRefresh2 = new JButton("Refresh");
				btnRefresh2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						loadComboBox(form1.comboBoxAspek2);
					}
				});
				btnRefresh2.setBounds(450, 9, 97, 25);
				layeredPane_3.add(btnRefresh2);
				
				JLabel lblPilihKriteria = new JLabel("Pilih Kriteria");
				lblPilihKriteria.setBounds(12, 48, 97, 16);
				layeredPane_3.add(lblPilihKriteria);
				
				comboBoxKriteria = new JComboBox();
				comboBoxKriteria.setBounds(112, 45, 324, 22);
				layeredPane_3.add(comboBoxKriteria);
				
				JLabel lblNewLabel_2 = new JLabel("Nilai Profile");
				lblNewLabel_2.setBounds(12, 116, 73, 16);
				layeredPane_3.add(lblNewLabel_2);
				
				txtNilaiProfile = new JTextField();
				txtNilaiProfile.setBounds(110, 113, 116, 22);
				layeredPane_3.add(txtNilaiProfile);
				txtNilaiProfile.setColumns(10);
				
				lblAngka_1 = new JLabel("Angka 1-9");
				lblAngka_1.setBounds(239, 116, 67, 16);
				layeredPane_3.add(lblAngka_1);
				
				btnTambahProfil = new JButton("Tambah");
				btnTambahProfil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(comboBoxAspek2.getSelectedIndex()>0 && form1.comboBoxKriteria.getSelectedIndex()>0 && form1.comboBoxAlternatif.getSelectedIndex()>0) {
								DataTable datatable=new DataTable(form1.tblProfile);
								ComboItem kriteria=(ComboItem)comboBoxKriteria.getSelectedItem();
								ComboItem alternatif=(ComboItem)comboBoxAlternatif.getSelectedItem();
								int cek=datatable.cekApakahAda("tbl_profile", new String[] {"id_alternatif","id_kriteria"}, new Object[] {alternatif.getId(),kriteria.getId()});
								if(cek==0) {
									Byte a=Byte.parseByte(form1.txtNilaiProfile.getText().trim());
									if(a>0 && a<10) {
										ComboItem aspek=(ComboItem)comboBoxAspek2.getSelectedItem();
										
										DataTable table=new DataTable(form1.tblProfile);
										table.insertData("tbl_profile", new Object[] {"id_alternatif","id_kriteria","nilai_profile"}, new Object[] {alternatif.getId(),kriteria.getId(),form1.txtNilaiProfile.getText().trim()});
										form1.loadProfile();
									}else {
										JOptionPane.showMessageDialog(form1.frmProfileMatchingProgram, "Nilai profile harus di antara 1-9");
									}
								}else
									JOptionPane.showMessageDialog(form1.frmProfileMatchingProgram, "Kode "+kriteria.getKey()+" sudah mempunyai nilai kriteria "+kriteria.getKey());
							}else {
								JOptionPane.showMessageDialog(form1.frmProfileMatchingProgram, "Data belum lengkap");
							}
						}catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(form1.frmProfileMatchingProgram, "Format angka salah");
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
						
					}
				});
				btnTambahProfil.setBounds(12, 145, 97, 25);
				layeredPane_3.add(btnTambahProfil);
				
				JLabel lblNewLabel_3 = new JLabel("Pilih Alternatif");
				lblNewLabel_3.setBounds(12, 77, 80, 16);
				layeredPane_3.add(lblNewLabel_3);
				
				comboBoxAlternatif = new JComboBox();
				comboBoxAlternatif.setBounds(112, 80, 324, 22);
				layeredPane_3.add(comboBoxAlternatif);
				
				JLayeredPane layeredPane_2_1 = new JLayeredPane();
				tabbedPane.addTab("Perhitungan", null, layeredPane_2_1, null);
				
				JButton btnHitung = new JButton("Hitung");
				btnHitung.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String sql="select sum(`persentase`) as jumlah from tbl_aspek";
							Connection conn = Koneksi.getConnection();
				            PreparedStatement pstmt = conn.prepareStatement(sql);
				            ResultSet rs = pstmt.executeQuery();
				            rs.next();
				            double p=rs.getDouble(1);
				            if(p==100) {
				            	sql="SELECT a.id as id_profil,a.id_alternatif,b.nama_alternatif,b.kode as kode_alternatif,c.id as id_kriteria, c.kode as kode_kriteria,d.id as id_aspek,d.kode as kode_aspek,d.persentase,a.nilai_profile,c.nilai as nilai_kriteria,c.factor FROM `tbl_profile` a inner join tbl_alternatif b on a.id_alternatif=b.id inner join `tbl_kriteria` c on a.`id_kriteria`=c.id inner join tbl_aspek d on c.id_aspek=d.id order by b.kode";
								conn = Koneksi.getConnection();
					            pstmt = conn.prepareStatement(sql);
					            rs = pstmt.executeQuery();
					            HashMap<Object, Hitung> mbuh=new HashMap<Object,Hitung>();//utama
					            while(rs.next()) {
					            	Object id_a=rs.getObject("id_alternatif");      	
					            	Kriteria k=new Kriteria();
				            		k.id=rs.getObject("id_kriteria");
				            		k.kode=rs.getObject("kode_kriteria");
				            		k.nilai=rs.getObject("nilai_kriteria");
				            		k.factor=rs.getObject("factor");
				            		Aspek a=new Aspek();
				            		a.id=rs.getObject("id_aspek");
				            		a.kode=rs.getObject("kode_aspek");
				            		a.persentase=rs.getObject("persentase");
				            		k.aspek=a;
				            		Hitung cuk;
					            	if(mbuh.containsKey(id_a)){
					            		cuk=mbuh.get(id_a);
					            	}else {
					            		cuk=new Hitung(rs.getObject("kode_alternatif"));
					            	}
					            	cuk.id_alternatif=id_a;
					            	cuk.nama_alternatif=rs.getObject("nama_alternatif");
					            	cuk.aspek.put(a.id, a);
					            	cuk.kriteria.add(k);	
					            	cuk.nilai_profile.add(rs.getObject("nilai_profile"));
					            	mbuh.put(id_a, cuk);

					            }
					            HashMap<Object,Hitung> njir=new HashMap<Object,Hitung>();
					            for(Map.Entry<Object, Hitung> me:mbuh.entrySet()) {
					            	Hitung v=me.getValue();
					            	
					            	System.out.println(v.kode_alternatif);
					            	Double core_f = 0d;
					            	Double secondary_f = 0d;
					            	for(int i=0; i<v.nilai_profile.size(); i++) {
					            		Integer np=(Integer)v.nilai_profile.get(i);
					            		Integer nk=(Integer)v.kriteria.get(i).nilai;
					            		Double bobot=Hitung.getBobot(np-nk); //dapatkan bobot berdasarkan table bobot
					            		
					            		Object id_aspek=v.kriteria.get(i).aspek.id;
					            		Aspek aspek=v.aspek.get(id_aspek);
					            		if(v.kriteria.get(i).factor.equals("1")) {	
					                		aspek.core_factor+=bobot;		
					                		aspek.jumlah_item_core++;
					            		}else {
					            			aspek.secondary_factor+=bobot;
					            			aspek.jumlah_item_secondary++;
					            		}
					            		v.aspek.put(id_aspek,aspek);
					            	}
					            	Double ranking=0d;
					            	for(Map.Entry<Object, Aspek> me2:v.aspek.entrySet()) {
					            		Aspek aspek=me2.getValue();
					            		aspek.total=(0.7*aspek.core_factor/aspek.jumlah_item_core)+(0.3*aspek.secondary_factor/aspek.jumlah_item_secondary);
					            		Double persentase=(Double)aspek.persentase/100;
					            		ranking+=aspek.total*persentase;
					            		v.aspek.put(me2.getKey(), aspek);
					            	}
					            	v.ranking=ranking;
					         
					            	njir.put(me.getKey(), v);
					            }	
				            	Hitung[] hitung=new Hitung[mbuh.size()];
				            	int x=0;
				            	for(Map.Entry<Object, Hitung> me:njir.entrySet()) 
				            		hitung[x++]=me.getValue();
				            	
				            	for(int i=0; i<mbuh.size(); i++) {
				            		for(int j=i; j<mbuh.size(); j++) {
				            			if(hitung[j].ranking>hitung[i].ranking) {
				            				Hitung tmp=hitung[i];
				            				hitung[i]=hitung[j];
				            				hitung[j]=tmp;
				            			}
				            		}	
				            	}
				            	sql="select * from tbl_aspek order by id";
				            	conn = Koneksi.getConnection();
					            pstmt = conn.prepareStatement(sql);
					            rs = pstmt.executeQuery();
					            HashMap<Object,Aspek> gay=new HashMap<Object,Aspek>();
					            int jumkolom=0;   	
					            while(rs.next()) {
					            	Aspek aspek=new Aspek();
					            	aspek.id=rs.getObject("id");
					            	aspek.kode=rs.getObject("kode");
					            	aspek.nama_aspek=rs.getObject("nama_aspek");
					            	aspek.persentase=rs.getObject("persentase");
					            	gay.put(rs.getObject("id"), aspek);
					            	jumkolom++;
					            }
					            Object[][] data=new Object[hitung.length+1][jumkolom+3]; 
				            	data[0][0]="Persentase";
				            	data[0][1]="ads";
					            String[] kolom=new String[jumkolom+3];
				            	kolom[0]="Alternatif";
				            	x=1;
				            	int z=1;
					            for(Aspek a:gay.values()) {
					            	kolom[x++]=(String)a.nama_aspek;
					            	data[0][z++]=a.persentase+"%";
					            }
					            kolom[x++]="Total";
					            kolom[x]="Rank";
					            data[0][z++]="";
					            data[0][z]="";      
				            	for(int i=0; i<hitung.length; i++) {
				            		data[i+1][0]=hitung[i].kode_alternatif+" "+hitung[i].nama_alternatif;
				            		int j=1;
				            		for(Aspek me:gay.values()) {
				            			String t;
				            			if(hitung[i].aspek.containsKey(me.id))t=String.format("%.3f", hitung[i].aspek.get(me.id).total);
				            			else t="-";
				            			data[i+1][j++]=t;
				            		}
				            		data[i+1][j++]=String.format("%.3f",hitung[i].ranking);
				            		data[i+1][j]=i+1;
				            	}
				            	tblHitung.setModel(new DefaultTableModel(data,kolom));
				            }else {
				            	JOptionPane.showMessageDialog(form1.frmProfileMatchingProgram, "Jumlah persentasi dari keseluruhan aspek harus 100, jumlah sekarang "+p);
				            }
						}catch(SQLException ex) {
							ex.printStackTrace();
						}catch(NullPointerException exx) {
							exx.printStackTrace();
							JOptionPane.showMessageDialog(form1.frmProfileMatchingProgram, "Masih ada data yang belum lengkap");
						}
						catch(Exception e) {
							e.printStackTrace();
							
						}
					}
				});
				btnHitung.setBounds(12, 13, 97, 25);
				layeredPane_2_1.add(btnHitung);
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(12, 51, 635, 400);
				layeredPane_2_1.add(scrollPane_3);
				
				tblHitung = new JTable();
				scrollPane_3.setViewportView(tblHitung);
				loadAspek();
				loadDataKriteria();
				loadComboBox(form1.comboBox);
				loadComboBox(form1.comboBoxAspek2);
				loadComboBoxAlternatif(form1.comboBoxAlternatif);

				
			}catch(SQLException x) {
				x.printStackTrace();
			}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfileMatchingProgram = new JFrame();
		frmProfileMatchingProgram.setTitle("Profile Matching Program");
		frmProfileMatchingProgram.setBounds(100, 100, 682, 541);
		frmProfileMatchingProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmProfileMatchingProgram.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		layeredPane = new JLayeredPane();
		tabbedPane.addTab("Alternatif", null, layeredPane, null);
		
		btnAddAlternatif = new JButton("Tambah");
		btnAddAlternatif.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					DataTable d=new DataTable(tableAlternatif);
					int cek=d.cekApakahAda("tbl_alternatif",new String[] {"kode"},new Object[] {form1.txtKodeAlternatif.getText().trim()});
						if(cek==0) {
						d.insertData("tbl_alternatif", new Object[] {"kode","nama_alternatif"}, new Object[] {form1.txtKodeAlternatif.getText(),form1.txtAlternatif.getText()});
						d.hapustextField(new JTextField[] {form1.txtKodeAlternatif,form1.txtAlternatif});
						d.hapusSemuaRow();
						d.loadDatakeTable("tbl_alternatif", new String[] {"kode","nama_alternatif"},true);
						loadComboBoxAlternatif(form1.comboBoxAlternatif);
					}else if(cek==1) {
						JOptionPane.showMessageDialog(frmProfileMatchingProgram, "Data dengan kode "+txtKodeAlternatif.getText()+" sudah ada");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				//JOptionPane.showMessageDialog(frame,a+"");
			}
		});
		btnAddAlternatif.setBounds(28, 81, 97, 25);
		layeredPane.add(btnAddAlternatif);
		
		scrollPane = new JScrollPane();
		scrollPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if ("tableCellEditor".equals(arg0.getPropertyName())) {
					
				}
			}
		});
		scrollPane.setBounds(28, 119, 472, 294);
		layeredPane.add(scrollPane);
		
		tableAlternatif = new JTable();
		tableAlternatif.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableAlternatif.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Kode", "Nama Alternatif"
			}
		));
		scrollPane.setViewportView(tableAlternatif);
		
		txtAlternatif = new JTextField();
		txtAlternatif.setColumns(10);
		txtAlternatif.setBounds(137, 57, 295, 22);
		layeredPane.add(txtAlternatif);
		
		btnHapusItem = new JButton("Hapus item yang dipilih");
		btnHapusItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(tableAlternatif.getSelectedRowCount()>0) {
						int c=JOptionPane.showConfirmDialog(frmProfileMatchingProgram, "Hapus "+tableAlternatif.getSelectedRowCount()+" data ?");
						if(c==0) {
							//System.out.println(c);
							DataTable d=new DataTable(tableAlternatif);
							d.frame=frmProfileMatchingProgram;
							d.hapusItemYangDipilih("tbl_alternatif");
							d.hapusSemuaRow();
							form1.loadAlternatif();
							loadComboBoxAlternatif(form1.comboBoxAlternatif);
						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frmProfileMatchingProgram, ex.toString());
				}
				
			}
		});
		btnHapusItem.setBounds(28, 426, 185, 25);
		layeredPane.add(btnHapusItem);
		
		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Aspek", null, layeredPane_1, null);
		
		JLabel lblKodeAspek = new JLabel("Kode Aspek");
		lblKodeAspek.setBounds(25, 29, 99, 16);
		layeredPane_1.add(lblKodeAspek);
		
		kodeAspek = new JTextField();
		kodeAspek.setBounds(114, 26, 116, 22);
		layeredPane_1.add(kodeAspek);
		kodeAspek.setColumns(10);
		
		txtNamaAspek = new JTextField();
		txtNamaAspek.setBounds(114, 67, 218, 22);
		layeredPane_1.add(txtNamaAspek);
		txtNamaAspek.setColumns(10);
		
		lblNamaAspek = new JLabel("Nama Aspek");
		lblNamaAspek.setBounds(25, 70, 77, 16);
		layeredPane_1.add(lblNamaAspek);
		
		lblPersentase = new JLabel("Persentase");
		lblPersentase.setBounds(25, 105, 82, 16);
		layeredPane_1.add(lblPersentase);
		
		txtPersentaseAspek = new JTextField();
		txtPersentaseAspek.setBounds(114, 102, 67, 22);
		layeredPane_1.add(txtPersentaseAspek);
		txtPersentaseAspek.setColumns(10);
		
		JButton btnTambahAspek = new JButton("Tambah Aspek");
		btnTambahAspek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					DataTable d=new DataTable(form1.tblAspek);
					int cek=d.cekApakahAda("tbl_aspek", new String[] {"kode"}, new Object[] {form1.kodeAspek.getText().trim()});
					if(cek==0) {
						String sql="SELECT sum(persentase) as tot FROM `tbl_aspek`";
						Connection conn = Koneksi.getConnection();
			            PreparedStatement pstmt = conn.prepareStatement(sql);
			            ResultSet rs = pstmt.executeQuery();
			            rs.next();
			            double b=100-rs.getDouble(1);
			            if(b==0)throw new Exception("Total nilai persentase sudah 100%, tidak bisa menambah lagi");
			            double p=Double.parseDouble(form1.txtPersentaseAspek.getText());
			            if(p<0 || p>b)throw new Exception("Nilai persentase harus positif dan lebih kecil atau sama dengan "+b);
			            d.insertData("tbl_aspek", new Object[] {"kode","nama_aspek","persentase"}, 
			            		new Object[] {form1.kodeAspek.getText().trim(),form1.txtNamaAspek.getText().trim(), form1.txtPersentaseAspek.getText().trim()});
			        	
			        	loadAspek();
			        	loadComboBox(comboBox);
			        	loadComboBox(comboBoxAspek2);
						/*Table2 table=new Table2(tblAspek);
						DefaultTableModel model=table.getTableModel();
						Object[][] obj=table.getAllRow();
						for(int i=0; i<obj.length; i++) {
							if(obj[i][1].toString().equalsIgnoreCase(form1.kodeAspek.getText()))
								throw new Exception("Kode aspek "+form1.kodeAspek.getText()+" sudah ada");
							
						}
						double curr=0;
						for(int i=0; i<tblAspek.getRowCount(); i++) {
							curr += Double.parseDouble(tblAspek.getValueAt(i, 3).toString());
						}
						double p=Double.parseDouble(form1.txtPersentaseAspek.getText());
						double b=100-curr;
						if(b==0)throw new Exception("Total nilai persentase sudah 100%, tidak bisa menambah lagi");
						if(p<0 || p>b)throw new Exception("Nilai persentase harus positif dan lebih kecil atau sama dengan "+b);*/
					}else if(cek==1) {
						JOptionPane.showMessageDialog(frmProfileMatchingProgram, "Data dengan kode "+kodeAspek.getText()+" sudah ada");
					}
					

				}catch(NumberFormatException ee) {
					JOptionPane.showMessageDialog(frmProfileMatchingProgram, "Format angka salah");
				}catch(SQLException eq) {
					eq.printStackTrace();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(frmProfileMatchingProgram, e.getMessage());
				}
			}
		});
		btnTambahAspek.setBounds(25, 134, 130, 25);
		layeredPane_1.add(btnTambahAspek);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 172, 580, 213);
		layeredPane_1.add(scrollPane_1);
		
		tblAspek = new JTable();
		tblAspek.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblAspek.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Kode Aspek", "Nama Aspek", "Persentase"
			}
		));
		scrollPane_1.setViewportView(tblAspek);
		
		JButton btnHapusAspek = new JButton("Hapus item yang dipilih");
		btnHapusAspek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(tblAspek.getSelectedRowCount()>0) {
						int c=JOptionPane.showConfirmDialog(frmProfileMatchingProgram, "Hapus "+tblAspek.getSelectedRowCount()+" data ?");
						if(c==0) {
							//System.out.println(c);
							DataTable d=new DataTable(tblAspek);
							d.frame=frmProfileMatchingProgram;
							d.hapusItemYangDipilih("tbl_aspek");
							d.hapusSemuaRow();
							form1.loadAspek();
							form1.loadComboBox(comboBox);
							form1.loadComboBox(comboBoxAspek2);
						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frmProfileMatchingProgram, ex.toString());
				}
			}
		});
		btnHapusAspek.setBounds(167, 134, 173, 25);
		layeredPane_1.add(btnHapusAspek);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				JOptionPane.showMessageDialog(frmProfileMatchingProgram, "ASU");
			}
		});
		tabbedPane.addTab("Kriteria", null, layeredPane_2, null);
		
		JLabel lblPilihAspek = new JLabel("Pilih Aspek:");
		lblPilihAspek.setBounds(12, 23, 72, 16);
		layeredPane_2.add(lblPilihAspek);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					if(comboBox.getSelectedIndex()>0) {
						//JOptionPane.showMessageDialog(frame, comboBox.getSelectedIndex()+"");
						Object obj=comboBox.getSelectedItem();
						ComboItem c=(ComboItem)obj;
						txtAspek2.setText(c.getKey()+" - "+c.getValue());
						txtKodeKriteria.setText(c.getKey()+"?");
						form1.btnTambahKriteria.setEnabled(true);
					}else {
						txtAspek2.setText("");
						form1.btnTambahKriteria.setEnabled(false);
						txtKodeKriteria.setText("");
					}
					//JOptionPane.showMessageDialog(frame, c.getKey());
				}
				
			}
		});
		comboBox.setBounds(96, 20, 326, 22);
		layeredPane_2.add(comboBox);
		
		JButton btnRefreshAspek = new JButton("Refresh");
		btnRefreshAspek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadComboBox(comboBox);
				
			}
		});
		btnRefreshAspek.setBounds(434, 19, 97, 25);
		layeredPane_2.add(btnRefreshAspek);
		
		lblAspek = new JLabel("Aspek:");
		lblAspek.setBounds(62, 72, 56, 16);
		layeredPane_2.add(lblAspek);
		
		txtAspek2 = new JTextField();
		txtAspek2.setEnabled(false);
		txtAspek2.setBounds(130, 69, 266, 22);
		layeredPane_2.add(txtAspek2);
		txtAspek2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kode Kriteria:");
		lblNewLabel.setBounds(24, 101, 83, 16);
		layeredPane_2.add(lblNewLabel);
		
		txtKodeKriteria = new JTextField();
		txtKodeKriteria.setBounds(130, 98, 116, 22);
		layeredPane_2.add(txtKodeKriteria);
		txtKodeKriteria.setColumns(10);
		
		txtNamaKriteria = new JTextField();
		txtNamaKriteria.setBounds(130, 127, 266, 22);
		layeredPane_2.add(txtNamaKriteria);
		txtNamaKriteria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nama Kriteria:");
		lblNewLabel_1.setBounds(24, 130, 103, 16);
		layeredPane_2.add(lblNewLabel_1);
		
		btnTambahKriteria = new JButton("Tambah Kriteria");
		btnTambahKriteria.setEnabled(false);
		btnTambahKriteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					DataTable d=new DataTable(form1.tblKriteria);
					int cek=d.cekApakahAda("tbl_kriteria", new String[] {"kode"}, new Object[] {txtKodeKriteria.getText().trim()});
					if(cek==0) {
						int nilai=Integer.parseInt(form1.txtNilaiKriteria.getText().trim());
						if(nilai>=1 && nilai<=9) {
							Object factor;
							if(form1.radioButtonCore.isSelected())factor=1;
							else factor=2;
							ComboItem mbuh=(ComboItem)comboBox.getSelectedItem();
							d.insertData("tbl_kriteria", new Object[] {"id_aspek","kode","nama_kriteria","nilai","factor"},
									new Object[] {mbuh.getId(),txtKodeKriteria.getText().trim(),txtNamaKriteria.getText().trim(),
											txtNilaiKriteria.getText().trim(),factor});
							form1.loadDataKriteria();
							form1.loadProfile();
							form1.loadComboBoxKriteria(form1.comboBoxKriteria,(ComboItem)form1.comboBoxAspek2.getSelectedItem());
							
						}else {
							JOptionPane.showMessageDialog(frmProfileMatchingProgram, "Nilai kriteria harus direntang 1-9");
						}
					}else if(cek==1) 
						JOptionPane.showMessageDialog(frmProfileMatchingProgram, "Data kriteria dengan kode "+txtKodeKriteria.getText()+" sudah ada");
					

					
				}catch(NumberFormatException ee) {
					JOptionPane.showMessageDialog(frmProfileMatchingProgram, "Format angka pada Nilai Kriteria salah");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(frmProfileMatchingProgram, e.getMessage());
				}
			}
		});
		btnTambahKriteria.setBounds(24, 219, 151, 25);
		layeredPane_2.add(btnTambahKriteria);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(24, 257, 625, 190);
		layeredPane_2.add(scrollPane_2);
		
		tblKriteria = new JTable();
		tblKriteria.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Kode Kriteria", "Aspek", "Nama Kriteria", "Nilai", "Factor"
			}
		));
		scrollPane_2.setViewportView(tblKriteria);
		
		JLabel lblNilai = new JLabel("Nilai:");
		lblNilai.setBounds(76, 159, 42, 16);
		layeredPane_2.add(lblNilai);
		
		txtNilaiKriteria = new JTextField();
		txtNilaiKriteria.setBounds(130, 156, 116, 22);
		layeredPane_2.add(txtNilaiKriteria);
		txtNilaiKriteria.setColumns(10);
		
		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setBounds(62, 190, 56, 16);
		layeredPane_2.add(lblFactor);
		
		radioButtonCore = new JRadioButton("Core");
		radioButtonCore.setSelected(true);
		radioButtonCore.setBounds(126, 187, 65, 25);
		layeredPane_2.add(radioButtonCore);
		
		radioButtonSecondary = new JRadioButton("Secondary");
		radioButtonSecondary.setBounds(195, 186, 97, 25);
		layeredPane_2.add(radioButtonSecondary);
		
		ButtonGroup btnGroup=new ButtonGroup();
		btnGroup.add(radioButtonCore);
		btnGroup.add(radioButtonSecondary);
		
		JLabel lblAngka = new JLabel("Angka 1-9");
		lblAngka.setBounds(256, 159, 116, 16);
		layeredPane_2.add(lblAngka);
		
		tblKriteria.getModel().addTableModelListener(new TableModelListener() {

		      public void tableChanged(TableModelEvent e) {
		         //System.out.println(e);
		      }
		    });
	}
}
