import java.util.*;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
        	String[] cs = sc.nextLine().split(" ");
			int len = cs.length;
			int[] src = new int[len];
			for(int i = 0; i < len; i++)
				src[i] = Integer.valueOf(cs[i]);
			System.out.println(Arrays.toString(buildMaxHeap(src)));
        }
        sc.close();
    }
	
	/**
	 *  功能：构建大顶堆
	 */
	private static int[] buildMaxHeap(int[] src){
		// 非叶子节点个数
		int num = (int)Math.floor((double)src.length/2);
		for(int i = num - 1; i >= 0; i--)
			maxHeapify( src, i);
		return src;
	}
	
	/**
	 * 功能：自上而下调整堆
	 */
	private static void maxHeapify(int[] src, int i){
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if(left < src.length && src[largest] < src[left])
			largest = left;
		if(right < src.length && src[largest] < src[right])
			largest = right;
		int temp = src[i];
		src[i] = src[largest];
		src[largest] = temp;
		if(largest != i)
			maxHeapify( src, largest);
	}
}