/**
 * @description ��˳���L��ð������
 * @author GongchuangSu
 * @since 2016.03.29
 * @version v1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        // sqList[0]�����ڱ�����ʱ����
        int[] sqList = {
            1000, 50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        bubbleSort(sqList);
        // �����ӡ
        for (int i = 1; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

    /**
     * ���ܣ�ð������
     */
    private static void bubbleSort(int[] sqList) {
        int i, j;
        boolean flag = true;
        for (i = 1; i < sqList.length - 1 && flag; i++) {
            flag = false;
            for (j = sqList.length - 2; j >= i; j--) {
                if (sqList[j] > sqList[j + 1]) {
                    // ����sqList[j]��sqList[j+1]��ֵ
                    sqList[j] = returnFirst(sqList[j + 1], sqList[j + 1] = sqList[j]);
                    // ��������ݽ�������flagΪtrue
                    flag = true;
                }
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