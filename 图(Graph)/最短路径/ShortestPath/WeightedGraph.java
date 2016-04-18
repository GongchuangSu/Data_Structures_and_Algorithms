/**
 * @description �ڽӾ����ʾ�Ĵ���Ȩ�ص�����ͼ(AdjMatrix Weighted Undirected Graph)
 * @author      GongchuangSu
 * @since       2016.04.13
 * @version     v1.0
 */
public class WeightedGraph {
    private int[][] edges;   // �ڽӾ���
    private Object[] labels; // ��ǩ

    /**
     * ���ܣ���ʼ���������������
     */
    public WeightedGraph(int n) {
        edges = new int[n][n];
        labels = new Object[n];
    }

    /**
     * ���ܣ������ڽӾ����ά��
     */
    public int size() {
        return labels.length;
    }

    /**
     * ���ܣ���ָ�������ñ�ǩ
     */
    public void setLabel(int vertex, Object label) {
        labels[vertex] = label;
    }

    /**
     * ���ܣ���ȡָ����ı�ǩ
     */
    public Object getLabel(int vertex) {
        return labels[vertex];
    }

    /**
     * ���ܣ���ӱ�
     */
    public void addEdge(int source, int target, int weight) {
        edges[source][target] = weight;
        edges[target][source] = weight;
    }

    /**
     * ���ܣ��Ƴ���
     */
    public void removeEdge(int source, int target) {
        edges[source][target] = 0;
    }

    /**
     * ���ܣ���ȡָ���ߵ�Ȩ��
     */
    public int getWeight(int source, int target) {
        return edges[source][target];
    }

    /**
     * ���ܣ���ȡ�ߵĸ���
     */
    public int getEdgNum() {
        int mEdgNum = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                if (edges[i][j] != 0)
                    mEdgNum++;
            }
        }
        return mEdgNum;
    }

    /**
     * ���ܣ��ж��Ƿ����ָ����
     */
    public boolean isEdge(int source, int target) {
        return edges[source][target] > 0;
    }

    /**
     * ���ܣ���ȡָ������ڽӵ�
     */
    public int[] getNighbors(int vertex) {
        int count = 0;
        for (int i = 0; i < edges[vertex].length; i++) {
            if (edges[vertex][i] > 0)
                count++;
        }
        final int[] answer = new int[count];
        count = 0;
        for (int i = 0; i < edges[vertex].length; i++) {
            if (edges[vertex][i] > 0)
                answer[count++] = i;
        }
        return answer;
    }

    /**
     * ���ܣ���ӡ
     */
    public void print() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.printf("%d ", edges[i][j]);
            }
            System.out.println();
        }
    }
}