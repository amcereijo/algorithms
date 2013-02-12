package com.coursera.unionfind;

import com.coursera.ext.StdIn;

/**
 * Advanced search and union algorithm
 * @author angelcereijo
 *
 */
public class QuickUnionImprovementUF{
	private int[] id;//elements
	private int[] sz; //size of elements

	public QuickUnionImprovementUF(int n){
		id = new int[n];
		sz = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int q){
		while(q != id[q]){
			q = id[q];
		}
		return q;
	}

	private boolean isConnected(int p, int q){
		return root(p) == root(q);
	}

	private void union(int p, int q){
		printArray();
		int np = root(p);
		int nq = root(q);
		System.out.println("np:"+np+ " , nq:"+nq);
		System.out.println("sz[np]:"+sz[np]+ " , sz[nq]:"+sz[nq]);
		if((np != nq)){
			if(np != nq && sz[np]<sz[nq]){
				id[np] = nq; 
				sz[nq] += sz[np];
			}else{
				id[nq] = np; 
				sz[np] += sz[nq];
			}
		}
	}


	public int[] getId(){
		return id;
	}

	public void printArray(){
		for(int i=0;i<getId().length;i++){
			System.out.print(getId()[i]+" ");	
		}
	}

	public static void main(String[] args){
		System.out.print("ptimes:");
		int n = StdIn.readInt();
		QuickUnionImprovementUF uf = new QuickUnionImprovementUF(n);

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
			uf.printArray();
			System.out.print("Conitnue  s/n:");
		}while("s".equalsIgnoreCase(StdIn.readString()));
		uf.printArray();
		
	}

}