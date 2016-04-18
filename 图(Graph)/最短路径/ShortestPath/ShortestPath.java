/**
 * @description 最短路径算法(迪杰斯特拉(Dijkstra)算法和弗洛伊德(Floyd)算法)
 * @author      GongchuangSu
 * @since       2016.04.18
 * @version     v1.0
 */
public class ShortestPath {
    private static int INF = Integer.MAX_VALUE;

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
        // 其他的边全都赋值为INF
        for (int i = 0; i < graph.size(); i++)
            for (int j = i + 1; j < graph.size(); j++)
                if (graph.getWeight(i, j) == 0)
                    graph.addEdge(i, j, INF);
        graph.print();

        System.out.print("------------------------------------\n");

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0);
        dijkstra.print();
        dijkstra.getPath(3);

        System.out.print("------------------------------------\n");

        Floyd floyd = new Floyd();
        floyd.floyd(graph);
        floyd.print();
        floyd.getPath(0, 3);
    }
}