package bst_implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	Node left;
	Node right;
	Node(int n){
		data=n;
		left=null;
		right=null;
	}
	Node(){
		data=-1;
		left=null;
		right=null;
	}
	void set_data(int x) {
		data=x;
	}
	int get_data() {
		return data;
	}
	void set_left(Node ptr) {
		left=ptr;
	}
	void set_right(Node ptr) {
		right=ptr;
	}
	Node get_left() {
		return left;
	}
	Node get_right() {
		return right;
	}
}

class Binary_Tree{
	Node root=new Node();
	Binary_Tree(){
		root=null;
	}
	Node Insert(Node r,Node nptr) {
		if(r==null) {
			r=nptr;
			//System.out.println(r.get_data());
		}
		else {
			if(nptr.get_data()<=r.get_data()) {
				r.set_left(Insert(r.left,nptr));
			}
			else {
				r.set_right(Insert(r.right,nptr));
			}
		}
		return r;
	}
	boolean search(Node root,int target) {
		Node r=root;
		if(r!=null) {
		if(r.get_data()==target) {
			return true;
		}
		else if(r.get_data()<target){
			return search(r.right,target);
		}
		else {
			return search(r.left,target);
		}
	}
		return false;
	}
	Node min_node(Node r) {
		if(r==null) {
			return null;
		}
		else {
			Node ptr=min_node(r.left);
			return ptr;
		}
	}
	Node delete(Node r,int value) {
		if(r==null) {
			return null;
		}
		if(r.get_data()<value) {
			return delete(r.right,value);
		}
		else if(r.get_data()>value) {
			return delete(r.left,value);
		}
		else {
			if(r.left==null && r.right==null) {
				r=null;
			}
			else if(r.left==null) {
				r=r.right;
			}
			else if(r.right==null) {
				r=r.left;
			}
			else {
				Node temp=r;
				Node min_right=min_node(temp.right);
				root.set_data(min_right.get_data());
				delete(r.right,min_right.get_data());
			}
		}
		return r;
	}
	void pre_order(Node r) {
		if(r!=null) {
			pre_order(r.left);
			System.out.print(r.get_data()+" ");
			pre_order(r.right);
		}
	}
	int find_height(Node r) {
		if(r==null) {
			return 0;
		}
		else {
			return 1+Math.max(find_height(r.left), find_height(r.right));
		}
	}
}

public class bst {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int size=Reader.nextInt();
		Node r=new Node();
		int[] arr=Reader.nextIntArray(size);
		Binary_Tree tree=new Binary_Tree();
		r=tree.root;
		for(int i=0;i<size;i++) {
			Node n=new Node(arr[i]);
			r=tree.Insert(r, n);
			//tree.pre_order(r);
		}
		tree.pre_order(r);
		System.out.println();
		int ht=tree.find_height(r);
		
		System.out.println(ht);
	}

}
