/**
 * @description 最短路径之迪杰斯特拉(Dijkstra)算法，即计算某顶点到其它各个顶点的最短路径及带权长度
 *              输入 -->    G：无向有权图
 *                      start:起始顶点(即计算顶点s到其它顶点的最短距离)                            
 *              输出 --> 最短距离数组及长度
 * @author      GongchuangSu
 * @since       2016.04.18
 * @version     v1.0
 */

public class Dijkstra {
    int vlen;       // 顶点个数
    boolean[] flag; // flag[i]=true表示顶点start到顶点i的最短路径已求得
    private static int INF = Integer.MAX_VALUE;
    int start;      // 起始顶点
    int[] prev;     // 前驱顶点数组
    int[] dist;     // 最短路径数组

    public void dijkstra(WeightedGraph G, int start) {
        this.start = start;
        vlen = G.size();
        flag = new boolean[vlen];
        prev = new int[vlen];
        dist = new int[vlen];

        // 初始化
        for (int i = 0; i < vlen; i++) {
            flag[i] = false;
            prev[i] = start;
            dist[i] = G.getWeight(start, i);
        }

        // 初始化起始顶点
        flag[start] = true;
        dist[start] = 0;

        // 开始主循环，每次求得起始顶点到其它某个顶点的最短距离
        int k = 0;
        for (int i = 0; i < vlen; i++) {
            int min = INF;                   // 当前所知离起始顶点的最近距离
            for (int j = 0; j < vlen; j++) { // 寻找离起始顶点最近的顶点
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }

            flag[k] = true; // 将当前找到的最近的顶点标记

            // 修正当前最短路径及距离
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
     * 功能：打印最短路径数组和前驱顶点数组
     */
    public void print() {
        System.out.printf("Dijkstra(%d):\n", start);
        System.out.printf("最短路径数组:\n");
        for (int i = 0; i < vlen; i++)
            System.out.printf("%d ", dist[i]);
        System.out.print("\n");
        System.out.print("前驱顶点数组:\n");
        for (int i = 0; i < vlen; i++)
            System.out.printf("%d ", prev[i]);
        System.out.printf("\n");
    }
    
    /**
     * 功能：根据起点source和终点target输出最短路径
     */
    public void getPath(int target){
    	System.out.printf("(%d,%d)最短路径为：\n" ,start ,target);
    	System.out.printf("%d", target);
    	int k = target;
    	while(prev[k] != k){
    		System.out.printf(" <-- %d", prev[k]);
    		k = prev[k];
    	}
    	System.out.printf("\n");
    }
}