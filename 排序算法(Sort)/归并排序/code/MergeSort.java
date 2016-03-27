/**
 * @description ��˳������鲢�ǵݹ�����
 * @author GongchuangSu
 * @since 2016.03.27
 * @version v1.0
 */
public class MergeSort {
    public static void main(String[] args) {
    	// SR[0]��TR[0]�����ڱ�����ʱ����
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
     * ���ܣ���SR[]�����ڳ���Ϊs�������������鲢��TR[]
     */
    private static void MergePass(int SR[], int TR[], int s, int n) {
        int i = 1;
        int j;
        while (i <= n - 2 * s + 1) {
            Merge(SR, TR, i, i + s - 1, i + 2 * s - 1);
            i = i + 2 * s;
        }
        if (i < n - s + 1) // �鲢�����������
            Merge(SR, TR, i, i + s - 1, n);
        else // �����ֻʣ�µ���������
            for (j = i; j <= n; j++)
                TR[j] = SR[j];
    }

    /**
     * ���ܣ��������SR[i...m]��SR[m+1...n]�鲢Ϊ�����TR[i...n]
     */
    private static void Merge(int SR[], int TR[], int i, int m, int n) {
        int j, k, l;
        // ��SR�м�¼��С����鲢��TR
        for (j = m + 1, k = i; i <= m && j <= n; k++) {
            if (SR[i] < SR[j]) {
                TR[k] = SR[i];
                i = i + 1;
            } else {
                TR[k] = SR[j];
                j = j + 1;
            }
        }
        // ��ʣ���SR[i...m]���Ƶ�TR
        if (i <= m) {
            for (l = 0; l <= m - i; l++)
                TR[k + l] = SR[i + l];
        }
        // ��ʣ���SR[j..n]���Ƶ�TR
        if (j <= n) {
            for (l = 0; l <= n - j; l++)
                TR[k + l] = SR[j + l];
        }
    }
}