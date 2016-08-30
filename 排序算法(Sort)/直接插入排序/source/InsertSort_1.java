/**
 * @description ��˳���L��ֱ�Ӳ�������
 * @author GongchuangSu
 * @since 2016.03.28
 * @version v1.0
 */
public class InsertSort {
	public static void main(String[] args) {
        int[] sqList = {
            50, 10, 90, 30, 70, 40, 80, 60, 20
        };
        insertSort(sqList);
        // �����ӡ
        for (int i = 0; i < sqList.length; i++)
            System.out.println(String.valueOf(sqList[i]));
    }

	/**
     * ���ܣ�ֱ�Ӳ�������
     */
	public static void insertSort(int[] arr){
		int len = arr.length;
		for(int i = 1; i < len; i++){
			int temp = arr[i];
			for(int j = i - 1; j >= 0 && arr[j] > temp; j--){
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
	}
}
