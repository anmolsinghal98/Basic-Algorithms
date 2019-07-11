package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.io.Reader;
import java.util.StringTokenizer;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String nextLine() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( nextLine() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( nextLine() );
    }
    
    static float nextFloat() throws IOException {
    	return Float.parseFloat( nextLine() );
    }
    static int[] nextIntArray(int length) throws IOException {
    	int[] arr = new int[length];
    	for (int i=0; i<length; i++) {
    		arr[i] = Integer.parseInt( nextLine() );
    	}
    	return arr;    	
    }
    static long[] nextLongArray(int length) throws IOException {
    	long[] arr = new long[length];
    	for (int i=0; i<length; i++) {
    		arr[i] = Long.parseLong( nextLine() );
    	}
    	return arr;    	
    }
}

class BinaryHeap {
	int size;
	int flag;
	BinaryHeap(){
		size=0;
		flag=0;
	}
	public void heapsort(int[] heap) {
		//build_heap(heap,size);
//		for(int j=0;j<heap.length;j++) {
//		System.out.print(heap[j]+" ");
//	}
//	System.out.println();
		//System.out.println(size);
		for(int i=size-1;i>=0;i--) {
			int temp=heap[0];
			heap[0]=heap[i];
			heap[i]=temp;
			//System.out.println(heap[i]);
			//System.out.println(heap[0]);
			min_heapify(heap,0,i);
//			for(int k=0;k<heap.length;k++) {
//				System.out.print(heap[k]+" ");
//			}
//			System.out.println();
		}
		
	}
	
	public int extract_min(int[] heap) {
		//System.out.println(size);
		int min=heap[0];
		heap[0]=heap[size-1];
		heap[size-1]=min;
		size--;
		min_heapify(heap,0,size);
		return heap[size];
	}
	
	public void min_heapify(int[] heap,int x,int n) {
		int smallest=x;
		int left=2*x+1;
		int right=2*x+2;
		if(left<n && heap[x]>heap[left]) {
			smallest=left;
		}
		else {
			smallest=x;
		}
		if(right<n && heap[right]<=heap[smallest]) {
			smallest=right;
		}
		if(smallest!=x) {
			int temp=heap[x];
			heap[x]=heap[smallest];
			heap[smallest]=temp;
			//System.out.println("hi");
			min_heapify(heap,smallest,n);
		}
		
		
	}
	
	public void build_heap(int[] heap,int n) {
		size=n;
		for(int i=(n/2)-1;i>=0;i--) {
			min_heapify(heap,i,n);
			
		}
//		for(int j=0;j<heap.length;j++) {
//			System.out.print(heap[j]+" ");
//		}
//		System.out.println();
	}
	public void decrease_key(int[] heap,int i,int d) {
		if(i>size) {
			return;
		}
		if(d>heap[i]) {
			System.out.println("big");
			return;
		}
		else {
			heap[i]=d;
		}
		while( i>0 && heap[(i-1)/2]>heap[i]) {
			int temp=heap[i];
			heap[i]=heap[(i-1)/2];
			heap[(i-1)/2]=temp;
			i=(i-1)/2;
		}
	}
	public int minimum(int[] heap) {
		return heap[0];
	}
	public void insert(int[] heap,int data) {
		if(size==heap.length) {
			return;
		}
		else {
			size++;
			heap[size-1]=Integer.MAX_VALUE;
			decrease_key(heap,size-1,data);
		}
	}
}

class Graph{
	int v;
	ArrayList<Integer> adj[];
	Graph(int a){
		v=a;
		adj=new ArrayList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new ArrayList();
		}
	}
	void prim_algo(int source,int[][] weight) {
		int[] p=new int[v];
		int[] d=new int[v];
		boolean[] visited=new boolean[v];
		for(int i=0;i<v;i++) {
			d[i]=Integer.MAX_VALUE;
		}
		d[source]=0;
		p[source]=-1;
		visited[source]=true;
		BinaryHeap my_heap=new BinaryHeap();
		my_heap.build_heap(d, v);
		while(my_heap.size!=0) {
			int u=my_heap.extract_min(d);
			visited[u]=true;
			for(int j=0;j<adj[u].size();j++) {
				int v=adj[u].get(j);
				if(weight[u][v]<d[v] && !visited[v]) {
					p[v]=u;
					d[v]=weight[u][v];
					my_heap.min_heapify(d,0,my_heap.size);
				}
			}
		}
		
	}
}


public class mst_implement {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
	}

}
