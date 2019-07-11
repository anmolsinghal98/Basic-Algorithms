package graphs;

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

class Node{
	int data;
	Node next;
	Node(int n){
		data=n;
		next=null;
	}
	void set_data(int k) {
		data=k;
	}
	int get_data() {
		return data;
	}
	void set_next(Node nptr) {
		next=nptr;
	}
	Node get_next() {
		return next;
	}
}

class Queue{
	Node front,rear;
	int size;
	Queue(){
		front=null;
		rear=null;
		size=0;
	}
	void enqueue(Node nptr) {
		if(front==null) {
			front=rear=nptr;
			size++;
		}
		else {
			rear.set_next(nptr);
			rear=nptr;
			size++;
		}
	}
	Node dequeue() {
		if(front==null) {
			return null;
		}
		else {
			Node temp=front;
			front=front.get_next();
			size--;
			if(front==null) {
				rear=null;
			}
			return temp;
		}
	}
}

class Graph{
	int v;
	ArrayList<Integer> adj[];
	Graph(int s){
		v=s;
		adj=new ArrayList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new ArrayList();
		}
	}
	void find_sink() {
		
	}
	int check_bipartie(int source) {
		boolean[] visited=new boolean[v];
		int[] colour=new int[v];
		Queue my_queue=new Queue();
		for(int i=0;i<v;i++) {
			colour[i]=-1;
		}
		colour[source]=0;
		visited[source]=true;
		Node nptr=new Node(source);
		my_queue.enqueue(nptr);
		while(my_queue.rear!=null) {
			Node ptr=my_queue.dequeue();
			int val=ptr.get_data();
			for(int i=0;i<adj[val].size();i++) {
				
			}
		}
	}
	
	void BFS_traversal(int s) {
		int[] distance=new int[v];
		for(int i=0;i<v;i++) {
			distance[i]=Integer.MAX_VALUE;		
			}
		Queue q1=new Queue();
		Node n=new Node(s);
		q1.enqueue(n);
		distance[s]=0;
		while(q1.rear!=null) {
			Node ptr=q1.dequeue();
			int val=ptr.get_data();
			for(int i=0;i<adj[val].size();i++) {
				int next=adj[val].get(i);
				if(distance[next]==Integer.MAX_VALUE) {
					distance[next]=distance[val]+1;
					Node nptr=new Node(next);
					q1.enqueue(nptr);
				}
			}
		}
		for(int k=0;k<v;k++) {
			if(distance[k]==Integer.MAX_VALUE) {
				distance[k]=-1;
			}
			System.out.print(distance[k]+" ");
		}
		System.out.println();
	}
	
}

public class bfs_implementation {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int[] no=Reader.nextIntArray(2);
		Graph my_graph=new Graph(no[0]);
		for(int i=0;i<no[1];i++) {
			int[] a=Reader.nextIntArray(2);
			my_graph.adj[a[0]].add(a[1]);
		}
		int source=Reader.nextInt();
		my_graph.BFS_traversal(source);
	}

}
