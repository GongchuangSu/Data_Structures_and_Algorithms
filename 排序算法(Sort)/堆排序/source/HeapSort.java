/**
 * @description 对顺序表L作堆排序
 * @author GongchuangSu
 * @since 2016.04.01
 * @version v1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        // sqList[0]用作哨兵或临时变量
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        heapSort(sqList);
        // 输出打印
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * 功能：对顺序表L进行堆排序
     */
    private static void heapSort(int[] sqList) {
        int i;
        /*
         * 第一步：将sqList构建成一个大顶堆
         */
        for (i = (sqList.length - 1) / 2; i > 0; i--)
            heapAdjust(sqList, i, sqList.length - 1);
        /*
         * 第二步：将堆顶记录和当前未经排序子序列的最后一个记录交换，并且再调整其成为大顶堆
         */
        for (i = sqList.length - 1; i > 1; i--) {
            sqList[i] = returnFirst(sqList[1], sqList[1] = sqList[i]);
            heapAdjust(sqList, 1, i - 1);
        }
    }

    /**
     * 功能：已知sqList[s..m]中记录的关键字除sqList[s]外均满足堆的定义
     *       该函数调整sqList[s]的关键字，使sqList[s..m]成为一个大顶堆
     */
    private static void heapAdjust(int[] sqList, int s, int m) {
        int temp, j;
        temp = sqList[s];
        // 沿关键字较大的孩子结点向下筛选
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && sqList[j] < sqList[j + 1])
                ++j; // j为关键字中较大的记录的下标
            if (temp >= sqList[j])
                break;
            sqList[s] = sqList[j];
            s = j;
        }
        sqList[s] = temp; // 插入
    }

    /**
     * 功能：用于两个数据的交换，相当于C/C++中的swap()函数
     */
    private static int returnFirst(int x, int y) {
        return x;
    }
}