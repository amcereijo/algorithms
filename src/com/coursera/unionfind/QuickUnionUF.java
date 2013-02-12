package com.coursera.unionfind;

import com.coursera.ext.StdIn;

/**
 * 
 * @author angelcereijo
 *
 */
public class QuickUnionUF{
	private int[] d;

	public QuickUnionUF(int n){
		d = new int[n];
		for(int i=0;i<n;i++){
			d[i] = i;
		}
	}

	private int root(int q){
		while(q != d[q]){
			q = d[q];
		}
		return q;
	}

	private boolean isConnected(int p, int q){
		return root(p) == root(q);
	}

	private void union(int p, int q){
		int np = root(p);
		int nq = root(q);
		d[p] = nq;
	}

	public int[] getId(){
		return d;
	}

	public static void main(String[] args){
		System.out.print("ptimes:");
		int n = StdIn.readInt();
		QuickUnionUF uf = new QuickUnionUF(n);
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