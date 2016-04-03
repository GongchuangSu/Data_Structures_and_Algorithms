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
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        shellSort(sqList);
        // 输出打印
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * 功能：希尔排序
     */
    private static void shellSort(int[] sqList) {
        int i, j;
        int increment = sqList.length - 1;
        do {
        	// 增量序列
            increment = increment / 3 + 1;
            for (i = increment + 1; i < sqList.length; i++) {
                if (sqList[i] < sqList[i - increment]) {
                	// 需将sqList[i]插入有序增量子表
                    sqList[0] = sqList[i]; // 暂存sqList[0]
                    // 记录后移，查找插入位置
                    for (j = i - increment; j > 0 && sqList[0] < sqList[j]; j -= increment)
                        sqList[j + increment] = sqList[j];
                    sqList[j + increment] = sqList[0];
                }
            }
        } while (increment > 1);
    }
}