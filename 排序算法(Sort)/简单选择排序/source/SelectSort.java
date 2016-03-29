/**
 * @description ��˳���L����ѡ������
 * @author GongchuangSu
 * @since 2016.03.29
 * @version v1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        // sqList[0]�����ڱ�����ʱ����
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        selectSort(sqList);
        // �����ӡ
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * ���ܣ���ѡ������
     */
    private static void selectSort(int[] sqList) {
        int i, j, min;
        for (i = 1; i < sqList.length - 1; i++) {
            // ����ǰ�±궨��Ϊ��Сֵ�±�
            min = i;
            for (j = i + 1; j <= sqList.length - 1; j++) {
                // �����С�ڵ�ǰ��Сֵ�Ĺؼ��֣��򽫴˹ؼ��ֵ��±긳ֵ��min
                if (sqList[min] > sqList[j])
                    min = j;
            }
            // ���min������i��˵���ҵ���sqList[i]��С��ֵ������н���
            if (i != min)
                sqList[i] = returnFirst(sqList[min], sqList[min] = sqList[i]);
        }
    }

    /**
     * ���ܣ������������ݵĽ������൱��C/C++�е�swap()����
     */
    private static int returnFirst(int x, int y) {
        return x;
    }
}