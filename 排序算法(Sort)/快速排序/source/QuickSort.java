/**
 * @description 对顺序表L作快速排序
 * @author GongchuangSu
 * @since 2016.03.28
 * @version v1.0
 */
public class QuickSort {
    private static final int MAX_LENGTH_INSERT_SORT = 7; // 数组长度阈值

    public static void main(String[] args) {
    	// sqList[0]用作哨兵或临时变量
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        QSort(sqList, 1, sqList.length - 1);
        // 输出打印
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    private static void QSort(int[] sqList, int low, int high) {
        int pivot;
        if ((high - low) > MAX_LENGTH_INSERT_SORT) { // 当high - low大于常数时用快速排序
            while (low < high) {
                // 将sqList[low...high]一分为二，并算出枢轴值pivot
                pivot = partition(sqList, low, high);
                QSort(sqList, low, pivot - 1); // 对低子表递归排序
                low = pivot + 1;
            }
        } else { // 当high - low小于等于常数时用直接插入排序
            insertSort(sqList);
        }
    }

    /**
     * 功能：选取关键点，使其成为枢轴，并返回其所在位置
     */
    private static int partition(int[] sqList, int low, int high) {
        int pivotkey;
        // 三数取中
        int m = low + (high - low) / 2;
        if (sqList[low] > sqList[high])
            sqList[low] = returnFirst(sqList[high], sqList[high] = sqList[low]);
        if (sqList[m] > sqList[high])
            sqList[m] = returnFirst(sqList[high], sqList[high] = sqList[m]);
        if (sqList[m] > sqList[low])
            sqList[low] = returnFirst(sqList[m], sqList[m] = sqList[low]);
        pivotkey = sqList[low];
        sqList[0] = pivotkey; // 将枢轴关键字备份到sqList[0]
        while (low < high) {
            while (low < high && sqList[high] >= pivotkey)
                high--;
            sqList[low] = sqList[high]; // 采用替换而不是交换的方式进行操作，将比枢轴记录小的记录替换到低端
            while (low < high && sqList[low] <= pivotkey)
                low++;
            sqList[high] = sqList[low]; // 采用替换而不是交换的方式进行操作，将比枢轴记录					
        }
        sqList[low] = sqList[0]; // 将枢轴数值替换回sqList[low]	
        return low; // 返回枢轴所在位置
    }

    /**
     * 功能：直接插入排序法
     */
    private static void insertSort(int[] sqList) {
        int i, j;
        for (i = 2; i <= sqList.length - 1; i++) {
            if (sqList[i] < sqList[i - 1]) {
                sqList[0] = sqList[i];
                for (j = i - 1; sqList[j] > sqList[0]; j--)
                    sqList[j + 1] = sqList[j];
                sqList[j + 1] = sqList[0];
            }
        }
    }

    /**
     * 功能：用于两个数据的交换，相当于C/C++中的swap()函数
     */
    private static int returnFirst(int x, int y) {
        return x;
    }
}