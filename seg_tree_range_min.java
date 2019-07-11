package segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class stree{
	int[] a;
	stree(int n){
		a=new int[4*n];
	}
	void build(int[] arr,int in,int l,int r) {
		if(l==r) {
			a[in]=arr[l];
		}
		else {
			int mid=(l+r)/2;
			build(arr,2*in+1,l,mid);
			build(arr,2*in+2,mid+1,r);
			a[in]=Math.min(a[2*in+1], a[2*in+2]);
		}
	}
	int query(int in,int l,int r,int x,int y) {
		if(y<l || x>r) {
			return Integer.MAX_VALUE;
		}
		else if(x<=l && r<=y) {
			return a[in];
		}
		else {
			int mid=(l+r)/2;
			return Math.min(query(2*in+1,l,mid,x,y), query(2*in+2,mid+1,r,x,y));
		}
	}
}

public class range_min {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int[] no=Reader.nextIntArray(2);
		int[] arr=Reader.nextIntArray(no[0]);
		stree tree=new stree(no[0]);
		tree.build(arr, 0,0,arr.length-1);
//		for(int i=0;i<tree.a.length;i++) {
//			System.out.print(tree.a[i]+" ");
//		}
//		System.out.println();
		for(int i=0;i<no[1];i++) {
			int[] q=Reader.nextIntArray(2);
			int r=tree.query(0, 0, arr.length-1, q[0], q[1]);
			System.out.println(r);
		}
	}

}

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
    static long nextLong() throws IOException {
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
