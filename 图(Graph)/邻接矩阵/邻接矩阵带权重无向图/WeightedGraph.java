/**
 * @description 邻接矩阵表示的带权重的无向图(Matrix Weighted Undirected Graph)
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class WeightedGraph {
    private int[][] edges;   // 邻接矩阵
    private Object[] labels; // 标签

    /**
     * 功能：初始化，需给定顶点数
     * @param n
     */
    public WeightedGraph(int n) {
        edges = new int[n][n];
        labels = new Object[n];
    }

    /**
     * 功能：返回邻接矩阵的维数
     * @return
     */
    public int size() {
        return labels.length;
    }

    /**
     * 功能：给指定点设置标签
     * @param vertex
     * @param label
     */
    public void setLabel(int vertex, Object label) {
        labels[vertex] = label;
    }

    /**
     * 功能：获取指定点的标签
     * @param vertex
     * @return
     */
    public Object getLabel(int vertex) {
        return labels[vertex];
    }

    /**
     * 功能：添加边
     * @param source
     * @param target
     * @param weight
     */
    public void addEdge(int source, int target, int weight) {
        edges[source][target] = weight;
		edges[target][source] = weight;
    }

    /**
     * 功能：移除边
     * @param source
     * @param target
     */
    public void removeEdge(int source, int target) {
        edges[source][target] = 0;
    }

    /**
     * 功能：获取指定边的权重
     * @param source
     * @param target
     * @return
     */
    public int getWeight(int source, int target) {
        return edges[source][target];
    }

    /**
     * 功能：判断是否存在指定边
     * @param source
     * @param target
     * @return
     */
    public boolean isEdge(int source, int target) {
        return edges[source][target] > 0;
    }

    /**
     * 功能：获取指定点的邻接点
     * @param vertex
     * @return
     */
    public int[] neighbors(int vertex) {
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

    public static void main(String args[]) {
        WeightedGraph t = new WeightedGraph(6);
        t.setLabel(0, "v0");
        t.setLabel(1, "v1");
        t.setLabel(2, "v3");
        t.setLabel(3, "v3");
        t.setLabel(4, "v4");
        t.setLabel(5, "v5");
        t.addEdge(0, 1, 2);
        t.addEdge(0, 5, 9);
        t.addEdge(1, 2, 8);
        t.addEdge(1, 3, 15);
        t.addEdge(1, 5, 6);
        t.addEdge(2, 3, 1);
		t.addEdge(2, 4, 7);
        t.addEdge(3, 4, 3);
        t.addEdge(4, 5, 3);
        t.print();
    }
}