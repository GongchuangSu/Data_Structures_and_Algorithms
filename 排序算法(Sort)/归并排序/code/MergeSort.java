/**
 * @description 对顺序表作归并非递归排序
 * @author GongchuangSu
 * @since 2016.03.27
 * @version v1.0
 */
public class MergeSort {
    public static void main(String[] args) {
    	// SR[0]和TR[0]用作哨兵或临时变量
        int[] SR = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        int[] TR = new int[10];
        TR[0] = 1000;
        int k = 1;
        while (k < SR.length) {
            MergePass(SR, TR, k, SR.length - 1);
            k = 2 * k;
            MergePass(TR, SR, k, SR.length - 1);
            k = 2 * k;
        }
        for (int i = 0; i < TR.length; i++) {
            System.out.println( String.valueOf(SR[i]));
        }
    }

    /**
     * 功能：将SR[]中相邻长度为s的子序列两两归并到TR[]
     */
    private static void MergePass(int SR[], int TR[], int s, int n) {
        int i = 1;
        int j;
        while (i <= n - 2 * s + 1) {
            Merge(SR, TR, i, i + s - 1, i + 2 * s - 1);
            i = i + 2 * s;
        }
        if (i < n - s + 1) // 归并最后两个序列
            Merge(SR, TR, i, i + s - 1, n);
        else // 若最后只剩下单个子序列
            for (j = i; j <= n; j++)
                TR[j] = SR[j];
    }

    /**
     * 功能：将有序的SR[i...m]和SR[m+1...n]归并为有序的TR[i...n]
     */
    private static void Merge(int SR[], int TR[], int i, int m, int n) {
        int j, k, l;
        // 将SR中记录由小到大归并入TR
        for (j = m + 1, k = i; i <= m && j <= n; k++) {
            if (SR[i] < SR[j]) {
                TR[k] = SR[i];
                i = i + 1;
            } else {
                TR[k] = SR[j];
                j = j + 1;
            }
        }
        // 将剩余的SR[i...m]复制到TR
        if (i <= m) {
            for (l = 0; l <= m - i; l++)
                TR[k + l] = SR[i + l];
        }
        // 将剩余的SR[j..n]复制到TR
        if (j <= n) {
            for (l = 0; l <= n - j; l++)
                TR[k + l] = SR[j + l];
        }
    }
}