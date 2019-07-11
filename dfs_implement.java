package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Reader1 {
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

class Node1{
	int data;
	Node1 next;
	Node1(int n){
		data=n;
		next=null;
	}
	void set_data(int k) {
		data=k;
	}
	int get_data() {
		return data;
	}
	void set_next(Node1 nptr) {
		next=nptr;
	}
	Node1 get_next() {
		return next;
	}
}

class Stack{
	Node1 top;
	int size;
	Stack(){
		top=null;
		size=0;
	}
	void push(Node1 nptr) {
		if(top==null) {
			top=nptr;
			size++;
		}
		else {
			nptr.set_next(top);
			top=nptr;
			size++;
		}
	}
	Node1 pop() {
		if(top==null) {
			return null;
		}
		else {
			Node1 temp=top;
			top=top.get_next();
			size--;
			return temp;
		}
	}
}

class Graph1{
	int v;
	ArrayList<Integer> adj[];
	Graph1(int s){
		v=s;
		adj=new ArrayList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new ArrayList();
		}
	}
	void DFS_implement(int source) {
		boolean[] visited=new boolean[v];
		long[] distance=new long[v];
		for(int i=0;i<v;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[source]=0;
		//visited[source]=true;
		//for(int i=0;i<v;i++) {
			//if(!visited[i]) {
				DFS_visit(source,visited);
			//}
		//}
	}
	void DFS_visit(int s,boolean[] visited) {
		visited[s]=true;
		System.out.println(s);
		for(int j=0;j<adj[s].size();j++) {
			int next=adj[s].get(j);
			if(!visited[next]) {
				DFS_visit(next,visited);
			}
		}
	}
}



public class dfs_implement {
	
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader1.init(System.in);
		int[] no=Reader1.nextIntArray(2);
		Graph1 my_graph=new Graph1(no[0]);
		for(int i=0;i<no[1];i++) {
			int[] a=Reader1.nextIntArray(2);
			my_graph.adj[a[0]].add(a[1]);
		}
		int source=Reader1.nextInt();
		my_graph.DFS_implement(source);

	}

}
