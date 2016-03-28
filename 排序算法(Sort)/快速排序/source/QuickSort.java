/**
 * @description ��˳���L����������
 * @author GongchuangSu
 * @since 2016.03.28
 * @version v1.0
 */
public class QuickSort {
    private static final int MAX_LENGTH_INSERT_SORT = 7; // ���鳤����ֵ

    public static void main(String[] args) {
    	// sqList[0]�����ڱ�����ʱ����
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        QSort(sqList, 1, sqList.length - 1);
        // �����ӡ
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    private static void QSort(int[] sqList, int low, int high) {
        int pivot;
        if ((high - low) > MAX_LENGTH_INSERT_SORT) { // ��high - low���ڳ���ʱ�ÿ�������
            while (low < high) {
                // ��sqList[low...high]һ��Ϊ�������������ֵpivot
                pivot = partition(sqList, low, high);
                QSort(sqList, low, pivot - 1); // �Ե��ӱ�ݹ�����
                low = pivot + 1;
            }
        } else { // ��high - lowС�ڵ��ڳ���ʱ��ֱ�Ӳ�������
            insertSort(sqList);
        }
    }

    /**
     * ���ܣ�ѡȡ�ؼ��㣬ʹ���Ϊ���ᣬ������������λ��
     */
    private static int partition(int[] sqList, int low, int high) {
        int pivotkey;
        // ����ȡ��
        int m = low + (high - low) / 2;
        if (sqList[low] > sqList[high])
            sqList[low] = returnFirst(sqList[high], sqList[high] = sqList[low]);
        if (sqList[m] > sqList[high])
            sqList[m] = returnFirst(sqList[high], sqList[high] = sqList[m]);
        if (sqList[m] > sqList[low])
            sqList[low] = returnFirst(sqList[m], sqList[m] = sqList[low]);
        pivotkey = sqList[low];
        sqList[0] = pivotkey; // ������ؼ��ֱ��ݵ�sqList[0]
        while (low < high) {
            while (low < high && sqList[high] >= pivotkey)
                high--;
            sqList[low] = sqList[high]; // �����滻�����ǽ����ķ�ʽ���в��������������¼С�ļ�¼�滻���Ͷ�
            while (low < high && sqList[low] <= pivotkey)
                low++;
            sqList[high] = sqList[low]; // �����滻�����ǽ����ķ�ʽ���в��������������¼					
        }
        sqList[low] = sqList[0]; // ��������ֵ�滻��sqList[low]	
        return low; // ������������λ��
    }

    /**
     * ���ܣ�ֱ�Ӳ�������
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
     * ���ܣ������������ݵĽ������൱��C/C++�е�swap()����
     */
    private static int returnFirst(int x, int y) {
        return x;
    }
}