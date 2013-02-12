package com.coursera.unionfind;

import com.coursera.ext.StdIn;

/**
 * Implementing quick find and union algorithm
 * @author angelcereijo
 *
 */
public class QuickFindUF{
	
	private int[] id;
	public QuickFindUF(int n){
		id = new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
	}

	public boolean isConnected(int p, int q){
		return id[p] == id[q];
	}

	public void union(int p, int q){
		int np = id[p];
		int nq = id[q];
		for(int i=0;i<id.length;i++){
			if(id[i]==np){
				id[i] = nq;
			}
		}
	}

	public int[] getId(){
		return id;
	}
	
	public static void main(String[] args){
		System.out.print("ptimes:");
		int n = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(n);
		//while(!StdIn.isEmpty() ){
		do{	System.out.print("p:");
			int p = StdIn.readInt();
			System.out.print("q:");
			int q = StdIn.readInt();
			System.out.print("isConnected("+p+","+q+"):");
			if(!uf.isConnected(p,q)){
				System.out.println("! Connected");
				uf.union(p,q);
				System.out.println(p+" "+q);
			}else{
				System.out.println("Connected !");
			}
			System.out.print("Conitnue  s/n:");
		}while("s".equalsIgnoreCase(StdIn.readString()));
		for(int i=0;i<uf.getId().length;i++){
			System.out.print(uf.getId()[i]+" ");	
		}
		
	}

}