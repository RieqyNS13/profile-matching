package rieqyns13;

import java.util.*;

public class Hitung {
	public Object id_alternatif;
	public Object kode_alternatif;
	public Object nama_alternatif;
	public ArrayList<Object> nilai_profile;
	public ArrayList<Kriteria> kriteria;
	public HashMap<Object, Aspek> aspek;
	public Double ranking;
	//public HashMap<Object, Object> total;
	public Hitung(Object obj) {
		aspek=new HashMap<Object, Aspek>();
		//total=new HashMap<Object, Object>();
		nilai_profile=new ArrayList<Object>();
		this.kode_alternatif=obj;
		ranking=0d;
		nama_alternatif=null;
		this.kriteria=new ArrayList<Kriteria>();
		id_alternatif=null;
	}
	public static Double getBobot(Integer val) {
		if(val<-4)val=-4;
		HashMap<Integer,Double> obj=new HashMap<Integer,Double>();
		obj.put(0, 5d);
		obj.put(1,4.5d);
		obj.put(-1, 4d);
		obj.put(2, 3.5);
		obj.put(-2,3d);
		obj.put(3, 2.5);
		obj.put(-3,2d);
		obj.put(4, 1.5);
		obj.put(-4,1d);
		return obj.get(val);
	}
	
}
