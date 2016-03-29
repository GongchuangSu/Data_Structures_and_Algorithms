/**
 * @description 对顺序表L作冒泡排序
 * @author GongchuangSu
 * @since 2016.03.29
 * @version v1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        // sqList[0]用作哨兵或临时变量
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        bubbleSort(sqList);
        // 输出打印
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * 功能：冒泡排序法
     */
    private static void bubbleSort(int[] sqList) {
        int i, j;
        boolean flag = true;
        for (i = 1; i < sqList.length - 1 && flag; i++) {
            flag = false;
            for (j = sqList.length - 2; j >= i; j--) {
                if (sqList[j] > sqList[j + 1]) {
                    // 交换sqList[j]和sqList[j+1]的值
                    sqList[j] = returnFirst(sqList[j + 1], sqList[j + 1] = sqList[j]);
                    // 如果有数据交换，则flag为true
                    flag = true;
                }
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