/**
 * @description ���·��֮��������(Floyd)�㷨(������ͼG�и�����i�����ඥ��j�����·��prev[i][j]����Ȩ����dist[i][j])
 *              ���� --> G��������Ȩͼ                          
 *              ��� --> ��̾������鼰����
 * @author      GongchuangSu
 * @since       2016.04.18
 * @version     v1.0
 */
public class Floyd {
    WeightedGraph G;
    int vlen;     // �������
    int[][] prev; // ǰ����������
    int[][] dist; // ���·������
    private static int INF = Integer.MAX_VALUE;

    public void floyd(WeightedGraph G) {
        this.G = G;
        vlen = G.size();
        prev = new int[vlen][vlen];
        dist = new int[vlen][vlen];

        // ��ʼ��ǰ��������������·������
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                dist[i][j] = G.getWeight(i, j); // ����i������j��·������Ϊi��j��Ȩֵ
                prev[i][j] = j;                 // ����i������j����̾����Ǿ�������j
            }
        }

        // ����ѭ�����ҳ����ж��㵽���ж������̾���
        for (int k = 0; k < vlen; k++) {
            for (int v = 0; v < vlen; v++) {
                for (int w = 0; w < vlen; w++) {
                	// �������k�����·����ԭ�����·�����̣��򽫵�ǰ�����Ȩֵ��Ϊ��С��һ��
                    int temp = (dist[v][k] == INF || dist[k][w] == INF) ? INF : (dist[v][k] + dist[k][w]);
                    if (dist[v][w] > temp) {
                        dist[v][w] = temp;
                        prev[v][w] = prev[v][k];
                    }
                }
            }
        }
    }

    /**
     * ���ܣ���ӡ���·�������ǰ����������
     */
    public void print() {
        System.out.printf("Floyd:\n");
        System.out.printf("���·������:\n");
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++)
                System.out.printf("%2d ", dist[i][j]);
            System.out.printf("\n");
        }
        System.out.printf("ǰ����������:\n");
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++)
                System.out.printf("%d ", prev[i][j]);
            System.out.printf("\n");
        }
    }

    /**
     * ���ܣ��������source���յ�target������·��
     */
    public void getPath(int source, int target) {
        System.out.printf("(%d,%d)���·��Ϊ��\n", source, target);
        System.out.printf("%d", target);
        int k = target;
        while (prev[k][source] != k) {
            System.out.printf(" <-- %d", prev[k][source]);
            k = prev[k][source];
        }
    }
}