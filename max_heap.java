package max_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    static String[] nextStringArray(int length) throws IOException {
    	String[] arr = new String[length];
    	for (int i=0; i<length; i++) {
    		arr[i] = nextLine();
    		if(i==1) {
    			if(arr[0].equals("INSERT")) {
    				arr[2]="null";
    				break;
    			}
    		}

    	}
    	return arr;    	
    }
}

class BinaryHeap {
	int size;
	BinaryHeap(){
		size=0;
	}
	public void heapsort(int[] heap) {
		build_heap(heap,size);
//		for(int j=0;j<heap.length;j++) {
//		System.out.print(heap[j]+" ");
//	}
//	System.out.println();
		//System.out.println(size);
		for(int i=size-1;i>=0;i--) {
			int temp=heap[0];
			heap[0]=heap[i];
			heap[i]=temp;
			System.out.println(heap[i]);
			//System.out.println(heap[0]);
			max_heapify(heap,0,i);
//			for(int k=0;k<heap.length;k++) {
//				System.out.print(heap[k]+" ");
//			}
//			System.out.println();
		}
		
	}
	
	public int extract_max(int[] heap) {
		//System.out.println(size);
		int max=heap[0];
		heap[0]=heap[size-1];
		heap[size-1]=max;
		size--;
		max_heapify(heap,0,size);
		return heap[size];
	}
	
	public void max_heapify(int[] heap,int x,int n) {
		int largest=x;
		int left=2*x+1;
		int right=2*x+2;
		if(left<n && heap[x]<heap[left]) {
			largest=left;
		}
		else {
			largest=x;
		}
		if(right<n && heap[right]>=heap[largest]) {
			largest=right;
		}
		if(largest!=x) {
			int temp=heap[x];
			heap[x]=heap[largest];
			heap[largest]=temp;
			//System.out.println("hi");
			max_heapify(heap,largest,n);
		}
		
		
	}
	
	public void build_heap(int[] heap,int n) {
		size=n;
		for(int i=(n/2)-1;i>=0;i--) {
			max_heapify(heap,i,n);
			
		}
//		for(int j=0;j<heap.length;j++) {
//			System.out.print(heap[j]+" ");
//		}
//		System.out.println();
	}
	public void increase_key(int[] heap,int i,int d) {
		if(d<heap[i]) {
			System.out.println("small");
			return;
		}
		else {
			heap[i]=d;
		}
		while( i>0 && heap[(i-1)/2]<heap[i]) {
			int temp=heap[i];
			heap[i]=heap[(i-1)/2];
			heap[(i-1)/2]=temp;
			i=(i-1)/2;
		}
	}
}

public class basic_code {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader1.init(System.in);
		int size=Reader1.nextInt();
		int[] arr=Reader1.nextIntArray(size);
		BinaryHeap my_heap=new BinaryHeap();
		my_heap.build_heap(arr,size);
//		for(int j=0;j<arr.length;j++) {
//		System.out.print(arr[j]+" ");
//	}
//	System.out.println();
		for(int i=0;i<2;i++) {
		int r=my_heap.extract_max(arr);
		System.out.println(r);
		}
		my_heap.heapsort(arr);
		my_heap.increase_key(arr,5, 15);
		for(int j=0;j<my_heap.size;j++) {
		System.out.print(arr[j]+" ");
	}
	System.out.println();
	}

}
