/**
 * @description 最短路径之弗洛伊德(Floyd)算法(即求网图G中各顶点i到其余顶点j的最短路径prev[i][j]及带权长度dist[i][j])
 *              输入 --> G：无向有权图                          
 *              输出 --> 最短距离数组及长度
 * @author      GongchuangSu
 * @since       2016.04.18
 * @version     v1.0
 */
public class Floyd {
    WeightedGraph G;
    int vlen;     // 顶点个数
    int[][] prev; // 前驱顶点数组
    int[][] dist; // 最短路径数组
    private static int INF = Integer.MAX_VALUE;

    public void floyd(WeightedGraph G) {
        this.G = G;
        vlen = G.size();
        prev = new int[vlen][vlen];
        dist = new int[vlen][vlen];

        // 初始化前驱顶点数组和最短路径数组
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                dist[i][j] = G.getWeight(i, j); // 顶点i到顶点j的路径长度为i到j的权值
                prev[i][j] = j;                 // 顶点i到顶点j的最短距离是经过顶点j
            }
        }

        // 三重循环，找出所有顶点到所有顶点的最短距离
        for (int k = 0; k < vlen; k++) {
            for (int v = 0; v < vlen; v++) {
                for (int w = 0; w < vlen; w++) {
                	// 如果经过k顶点的路径比原两点间路径更短，则将当前两点间权值设为更小的一个
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
     * 功能：打印最短路径数组和前驱顶点数组
     */
    public void print() {
        System.out.printf("Floyd:\n");
        System.out.printf("最短路径数组:\n");
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++)
                System.out.printf("%2d ", dist[i][j]);
            System.out.printf("\n");
        }
        System.out.printf("前驱顶点数组:\n");
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++)
                System.out.printf("%d ", prev[i][j]);
            System.out.printf("\n");
        }
    }

    /**
     * 功能：根据起点source和终点target输出最短路径
     */
    public void getPath(int source, int target) {
        System.out.printf("(%d,%d)最短路径为：\n", source, target);
        System.out.printf("%d", target);
        int k = target;
        while (prev[k][source] != k) {
            System.out.printf(" <-- %d", prev[k][source]);
            k = prev[k][source];
        }
    }
}