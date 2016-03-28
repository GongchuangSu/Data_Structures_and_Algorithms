/**
 * @description ��˳���L��ֱ�Ӳ�������
 * @author GongchuangSu
 * @since 2016.03.28
 * @version v1.0
 */
public class InsertSort {
	public static void main(String[] args) {
    	// sqList[0]�����ڱ�����ʱ����
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        insertSort(sqList);
        // �����ӡ
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
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
}
