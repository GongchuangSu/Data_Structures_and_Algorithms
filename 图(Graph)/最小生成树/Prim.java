/**
 * @description 最小生成树之普里姆(Prim)算法
 *              输入 --> 无向有权图和起始顶点下标
 *              输出 --> 打印最小生成树边及其对应的权重
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class Prim {
    Edge[] result; // 最小生成树数组
    WeightedGraph G;

    public void prim(WeightedGraph G, int s) {
        result = new Edge[G.size() - 1];
        this.G = G;
        final int[] dist = new int[G.size()];            // 相关顶点间边的权值
        final int[] pred = new int[G.size()];            // prim最小生成树结果数组
        final boolean[] visited = new boolean[G.size()]; // 顶点访问标记数组

        // 初始化
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0; // 将起始点对应的最小权值设置为0

        for (int i = 0; i < dist.length; i++) {
            final int next = minVertex(dist, visited); // 在dist中寻找未被访问点所对应的最小权值，并返回该顶点坐标
            visited[next] = true;                      // 将该顶点设置为已访问

            final int[] n = G.getNighbors(next);       // 取得与该顶点相邻接的点
            for (int j = 0; j < n.length; j++) {
                final int v = n[j];
                final int d = G.getWeight(next, v);
                if (dist[v] > d && !visited[v]) {
                    dist[v] = d;    // 将更小权值保存至dist数组中
                    pred[v] = next; // 并将先前结点保存至pred数组中
                }
            }
        }

        // 将结果保存至最小生成树数组
        for (int i = 0; i < G.size() - 1; i++) {
            result[i] = new Edge(pred[i + 1], i + 1, G.getWeight(pred[i + 1], i + 1));
        }

        // 打印结果
        print();
    }

    /**
     * 功能：在未遍历点中寻找距离最小的点，并返回该点位置
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
     * 功能：边集结构体
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
     * 功能：打印结果
     */
    private void print() {
        System.out.print("Prim:\n");
        for (int i = 0; i < G.size() - 1; i++)
            System.out.printf("(%d, %d) %d \n", result[i].source, result[i].target, result[i].weight);
    }
}