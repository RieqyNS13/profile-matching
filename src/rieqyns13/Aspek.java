package rieqyns13;


public class Aspek{
	public Object id;
	public Object kode;
	public Object persentase;
	public Double core_factor;
	public Double secondary_factor;
	public Double total;
	public Object nama_aspek;
	public Integer jumlah_item_core;
	public Integer jumlah_item_secondary;
	public Aspek() {
		id=null;
		kode=null;
		nama_aspek=null;
		core_factor=0d;
		secondary_factor=0d;
		persentase=null;
		total=0d;
		jumlah_item_core=0;
		jumlah_item_secondary=0;
	}
	public void setId(Object id) {
		this.id=id;
	}
	public Object getId() {
		return id;
	}
	
	public void setKode(Object kode) {
		this.kode=kode;
	}
	public Object getKode() {
		return kode;
	}
}
