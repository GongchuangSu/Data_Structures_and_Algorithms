/**
 * @description 对顺序表L作简单选择排序
 * @author GongchuangSu
 * @since 2016.03.29
 * @version v1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        // sqList[0]用作哨兵或临时变量
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        selectSort(sqList);
        // 输出打印
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * 功能：简单选择排序
     */
    private static void selectSort(int[] sqList) {
        int i, j, min;
        for (i = 1; i < sqList.length - 1; i++) {
            // 将当前下标定义为最小值下标
            min = i;
            for (j = i + 1; j <= sqList.length - 1; j++) {
                // 如果有小于当前最小值的关键字，则将此关键字的下标赋值给min
                if (sqList[min] > sqList[j])
                    min = j;
            }
            // 如果min不等于i，说明找到比sqList[i]更小的值，则进行交换
            if (i != min)
                sqList[i] = returnFirst(sqList[min], sqList[min] = sqList[i]);
        }
    }

    /**
     * 功能：用于两个数据的交换，相当于C/C++中的swap()函数
     */
    private static int returnFirst(int x, int y) {
        return x;
    }
}