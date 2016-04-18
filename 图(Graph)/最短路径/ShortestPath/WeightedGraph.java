/**
 * @description 邻接矩阵表示的带有权重的无向图(AdjMatrix Weighted Undirected Graph)
 * @author      GongchuangSu
 * @since       2016.04.13
 * @version     v1.0
 */
public class WeightedGraph {
    private int[][] edges;   // 邻接矩阵
    private Object[] labels; // 标签

    /**
     * 功能：初始化，需给定顶点数
     */
    public WeightedGraph(int n) {
        edges = new int[n][n];
        labels = new Object[n];
    }

    /**
     * 功能：返回邻接矩阵的维数
     */
    public int size() {
        return labels.length;
    }

    /**
     * 功能：给指定点设置标签
     */
    public void setLabel(int vertex, Object label) {
        labels[vertex] = label;
    }

    /**
     * 功能：获取指定点的标签
     */
    public Object getLabel(int vertex) {
        return labels[vertex];
    }

    /**
     * 功能：添加边
     */
    public void addEdge(int source, int target, int weight) {
        edges[source][target] = weight;
        edges[target][source] = weight;
    }

    /**
     * 功能：移除边
     */
    public void removeEdge(int source, int target) {
        edges[source][target] = 0;
    }

    /**
     * 功能：获取指定边的权重
     */
    public int getWeight(int source, int target) {
        return edges[source][target];
    }

    /**
     * 功能：获取边的个数
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
     * 功能：判断是否存在指定边
     */
    public boolean isEdge(int source, int target) {
        return edges[source][target] > 0;
    }

    /**
     * 功能：获取指定点的邻接点
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
     * 功能：打印
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