package rieqyns13;

import java.util.*;

class Asu{
	private int jumkolom;
	public Object[] obj;
	public Asu(int j) {
		setJumkolom(j);
		obj=new Object[j];
	}
	public void setJumkolom(int j) {
		this.jumkolom=j;
	}
	
}
public class Test {
	public static void main(String[] args) {
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		hm.put(1, 333);
		hm.put(2,111);
		int x=0;
		for(Integer i:hm.values()) {
			Object[] a=hm.values().toArray();
			System.out.println(a[x++]);
		}
		
	}
		
}
