package disjoint_sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static long nextLong() throws IOException{
    	 return Long.parseLong(nextLine());
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

class Disj_set{
	int vertices;
	ArrayList<Integer> adj[];
	Disj_set(int v){
		vertices=v;
		adj=new ArrayList[vertices];
		for(int i=0;i<v;i++) {
			adj[i]=new ArrayList();
		}
	}
	int find(int node,int[] parent,int[] size) {
		if(parent[node]==node) {
			return node;
		}
		else {
			parent[node]=find(parent[node],parent,size);
			return parent[node];
		}
	}
	void union(int n1,int n2,int[] parent,int[] size) {
		int x1=find(n1,parent,size);
		int x2=find(n2,parent,size);
		if(x1!=x2) {
			if(size[x1]<size[x2]) {
				parent[x1]=parent[x2];
				size[x2]+=size[x1];
			}
			else {
				parent[x2]=parent[x1];
				size[x1]+=size[x2];
			}
		}
	}
	int check_cycle(){
		int[] p=new int[vertices];
		int[] s=new int[vertices];
		
		for(int k=0;k<vertices;k++) {
			p[k]=k;
			s[k]=1;
		}
		
		for(int i=0;i<vertices;i++) {
			int x1=find(i,p,s);
			for(int j=0;j<adj[i].size();j++) {
				int x2=find(adj[i].get(j),p,s);
				if(x1==x2) {
					return 1;
				}
				union(x1,x2,p,s);
			}
		}
		return 0;
	}
	
}

public class dsj_sets {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int v=Reader.nextInt();
		Disj_set my_set=new Disj_set(v);
		int no_edge=Reader.nextInt();
		for(int i=0;i<no_edge;i++) {
			int[] a=Reader.nextIntArray(2);
			my_set.adj[a[0]].add(a[1]);
		}
		int r=my_set.check_cycle();
		if(r==0) {
			System.out.println("no");
		}
		else {
			System.out.println("yes");
		}
	}

}
