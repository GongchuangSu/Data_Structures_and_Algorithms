/**
 * @description ��˳���L��ϣ������
 * @author GongchuangSu
 * @since 2016.04.01
 * @version v1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        // sqList[0]�����ڱ�����ʱ����
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        shellSort(sqList);
        // �����ӡ
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * ���ܣ�ϣ������
     */
    private static void shellSort(int[] sqList) {
        int i, j;
        int increment = sqList.length - 1;
        do {
        	// ��������
            increment = increment / 3 + 1;
            for (i = increment + 1; i < sqList.length; i++) {
                if (sqList[i] < sqList[i - increment]) {
                	// �轫sqList[i]�������������ӱ�
                    sqList[0] = sqList[i]; // �ݴ�sqList[0]
                    // ��¼���ƣ����Ҳ���λ��
                    for (j = i - increment; j > 0 && sqList[0] < sqList[j]; j -= increment)
                        sqList[j + increment] = sqList[j];
                    sqList[j + increment] = sqList[0];
                }
            }
        } while (increment > 1);
    }
}