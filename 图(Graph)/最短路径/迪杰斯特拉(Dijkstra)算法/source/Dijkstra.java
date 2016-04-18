/**
 * @description ���·��֮�Ͻ�˹����(Dijkstra)�㷨��������ĳ���㵽����������������·������Ȩ����
 *              ���� -->    G��������Ȩͼ
 *                      start:��ʼ����(�����㶥��s�������������̾���)                            
 *              ��� --> ��̾������鼰����
 * @author      GongchuangSu
 * @since       2016.04.18
 * @version     v1.0
 */

public class Dijkstra {
    int vlen;       // �������
    boolean[] flag; // flag[i]=true��ʾ����start������i�����·�������
    private static int INF = Integer.MAX_VALUE;
    int start;      // ��ʼ����
    int[] prev;     // ǰ����������
    int[] dist;     // ���·������

    public void dijkstra(WeightedGraph G, int start) {
        this.start = start;
        vlen = G.size();
        flag = new boolean[vlen];
        prev = new int[vlen];
        dist = new int[vlen];

        // ��ʼ��
        for (int i = 0; i < vlen; i++) {
            flag[i] = false;
            prev[i] = start;
            dist[i] = G.getWeight(start, i);
        }

        // ��ʼ����ʼ����
        flag[start] = true;
        dist[start] = 0;

        // ��ʼ��ѭ����ÿ�������ʼ���㵽����ĳ���������̾���
        int k = 0;
        for (int i = 0; i < vlen; i++) {
            int min = INF;                   // ��ǰ��֪����ʼ������������
            for (int j = 0; j < vlen; j++) { // Ѱ������ʼ��������Ķ���
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }

            flag[k] = true; // ����ǰ�ҵ�������Ķ�����

            // ������ǰ���·��������
            for (int j = 0; j < vlen; j++) {
                int temp = (G.getWeight(k, j) == INF ? INF : (min + G.getWeight(k, j)));
                if (!flag[j] && (temp < dist[j])) {
                    dist[j] = temp;
                    prev[j] = k;
                }
            }
        }
    }

    /**
     * ���ܣ���ӡ���·�������ǰ����������
     */
    public void print() {
        System.out.printf("Dijkstra(%d):\n", start);
        System.out.printf("���·������:\n");
        for (int i = 0; i < vlen; i++)
            System.out.printf("%d ", dist[i]);
        System.out.print("\n");
        System.out.print("ǰ����������:\n");
        for (int i = 0; i < vlen; i++)
            System.out.printf("%d ", prev[i]);
        System.out.printf("\n");
    }
    
    /**
     * ���ܣ��������source���յ�target������·��
     */
    public void getPath(int target){
    	System.out.printf("(%d,%d)���·��Ϊ��\n" ,start ,target);
    	System.out.printf("%d", target);
    	int k = target;
    	while(prev[k] != k){
    		System.out.printf(" <-- %d", prev[k]);
    		k = prev[k];
    	}
    	System.out.printf("\n");
    }
}