/**
 * @description 最小生成树算法（普里姆(Prim)算法和克鲁斯卡尔(Kruskal)算法）
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class MST {
    public static void main(String args[]) {
        WeightedGraph graph = new WeightedGraph(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 5, 9);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 5, 6);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 3);
        graph.print();

        // Prim算法
        Prim prim = new Prim();
        prim.prim(graph, 0);

        // Kruskal算法
        Kruskal kruskal = new Kruskal();
        kruskal.kruskal(graph);
    }
}