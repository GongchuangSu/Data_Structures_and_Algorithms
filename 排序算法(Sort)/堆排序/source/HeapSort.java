/**
 * @description ��˳���L��������
 * @author GongchuangSu
 * @since 2016.04.01
 * @version v1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        // sqList[0]�����ڱ�����ʱ����
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        heapSort(sqList);
        // �����ӡ
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * ���ܣ���˳���L���ж�����
     */
    private static void heapSort(int[] sqList) {
        int i;
        /*
         * ��һ������sqList������һ���󶥶�
         */
        for (i = (sqList.length - 1) / 2; i > 0; i--)
            heapAdjust(sqList, i, sqList.length - 1);
        /*
         * �ڶ��������Ѷ���¼�͵�ǰδ�����������е����һ����¼�����������ٵ������Ϊ�󶥶�
         */
        for (i = sqList.length - 1; i > 1; i--) {
            sqList[i] = returnFirst(sqList[1], sqList[1] = sqList[i]);
            heapAdjust(sqList, 1, i - 1);
        }
    }

    /**
     * ���ܣ���֪sqList[s..m]�м�¼�Ĺؼ��ֳ�sqList[s]�������ѵĶ���
     *       �ú�������sqList[s]�Ĺؼ��֣�ʹsqList[s..m]��Ϊһ���󶥶�
     */
    private static void heapAdjust(int[] sqList, int s, int m) {
        int temp, j;
        temp = sqList[s];
        // �عؼ��ֽϴ�ĺ��ӽ������ɸѡ
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && sqList[j] < sqList[j + 1])
                ++j; // jΪ�ؼ����нϴ�ļ�¼���±�
            if (temp >= sqList[j])
                break;
            sqList[s] = sqList[j];
            s = j;
        }
        sqList[s] = temp; // ����
    }

    /**
     * ���ܣ������������ݵĽ������൱��C/C++�е�swap()����
     */
    private static int returnFirst(int x, int y) {
        return x;
    }
}