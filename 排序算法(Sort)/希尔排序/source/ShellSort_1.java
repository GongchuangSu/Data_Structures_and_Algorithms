/**
 * @description 对顺序表L作希尔排序
 * @author GongchuangSu
 * @since 2016.04.01
 * @version v1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        // sqList[0]用作哨兵或临时变量
        int[] sqList = {
            50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        shellSort(sqList);
        // 输出打印
        for (int i = 0; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * 功能：希尔排序
     */
    public static void shellSort(int[] arr){
    	int i, j;
    	int temp = arr[0];
    	int len = arr.length;
    	int gap = len/2;
    	for(; gap > 0; gap /= 2){
    		for(i = gap; i < len; i++){
    			temp = arr[i];
    			for(j = i - gap; j >= 0 && arr[j] > temp; j -= gap){
    				arr[j+gap] = arr[j];
    			}
    			arr[j+gap] = temp;
    		}
    	}
    }
}