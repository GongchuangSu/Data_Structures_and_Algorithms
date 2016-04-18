/**
 * @description ��С������֮����ķ(Prim)�㷨
 *              ���� --> ������Ȩͼ����ʼ�����±�
 *              ��� --> ��ӡ��С�������߼����Ӧ��Ȩ��
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class Prim {
    Edge[] result; // ��С����������
    WeightedGraph G;

    public void prim(WeightedGraph G, int s) {
        result = new Edge[G.size() - 1];
        this.G = G;
        final int[] dist = new int[G.size()];            // ��ض����ߵ�Ȩֵ
        final int[] pred = new int[G.size()];            // prim��С�������������
        final boolean[] visited = new boolean[G.size()]; // ������ʱ������

        // ��ʼ��
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0; // ����ʼ���Ӧ����СȨֵ����Ϊ0

        for (int i = 0; i < dist.length; i++) {
            final int next = minVertex(dist, visited); // ��dist��Ѱ��δ�����ʵ�����Ӧ����СȨֵ�������ظö�������
            visited[next] = true;                      // ���ö�������Ϊ�ѷ���

            final int[] n = G.getNighbors(next);       // ȡ����ö������ڽӵĵ�
            for (int j = 0; j < n.length; j++) {
                final int v = n[j];
                final int d = G.getWeight(next, v);
                if (dist[v] > d && !visited[v]) {
                    dist[v] = d;    // ����СȨֵ������dist������
                    pred[v] = next; // ������ǰ��㱣����pred������
                }
            }
        }

        // �������������С����������
        for (int i = 0; i < G.size() - 1; i++) {
            result[i] = new Edge(pred[i + 1], i + 1, G.getWeight(pred[i + 1], i + 1));
        }

        // ��ӡ���
        print();
    }

    /**
     * ���ܣ���δ��������Ѱ�Ҿ�����С�ĵ㣬�����ظõ�λ��
     */
    private static int minVertex(int[] dist, boolean[] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!v[i] && dist[i] < x) {
                y = i;
                x = dist[i];
            }
        }
        return y;
    }

    /**
     * ���ܣ��߼��ṹ��
     */
    private static class Edge {
        int source;
        int target;
        int weight;
        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    /**
     * ���ܣ���ӡ���
     */
    private void print() {
        System.out.print("Prim:\n");
        for (int i = 0; i < G.size() - 1; i++)
            System.out.printf("(%d, %d) %d \n", result[i].source, result[i].target, result[i].weight);
    }
}