/**
 * @description 邻接表表示的无向图(Matrix Undirected Graph)的
 *              深度优先遍历算法(DFS)和广度优先遍历算法(BFS)
 * @author GongchuangSu
 * @since 2016.03.28
 * @version v1.0
 */
public class AdjListUDG {
    private static char[] mVexs;                // 顶点集合
    private static VertexNode[] vertexNodeList; // 顶点数组
    private boolean[] visited;                  // 访问标志的数组
    int vlen;
    int elen;

    public AdjListUDG(char[] vexs, char[][] edges) {
        // 初始化顶点个数和边个数
        vlen = vexs.length;
        elen = edges.length;

        // 初始化顶点,建立顶点表
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = vexs[i];
        }

        vertexNodeList = new VertexNode[vlen];
        for (int i = 0; i < vlen; i++) {
            vertexNodeList[i] = new VertexNode();
            vertexNodeList[i].vertex = vexs[i];
            vertexNodeList[i].firstedge = null;
        }

        // 初始化边，利用头插法建立邻接表
        for (int i = 0; i < elen; i++) {
            EdgeNode edgeNode_1 = new EdgeNode();
            EdgeNode edgeNode_2 = new EdgeNode();
            int vi = getPosition(edges[i][0], vexs);
            int vj = getPosition(edges[i][1], vexs);

            edgeNode_1.adjvex = edges[i][1];
            edgeNode_1.next = vertexNodeList[vi].firstedge;
            vertexNodeList[vi].firstedge = edgeNode_1;

            edgeNode_2.adjvex = edges[i][0];
            edgeNode_2.next = vertexNodeList[vj].firstedge;
            vertexNodeList[vj].firstedge = edgeNode_2;
        }

        // 初始化访问标志数组
        visited = new boolean[vexs.length];
    }

    /**
     *  功能：顶点表结点
     */
    private class VertexNode {
        char vertex;        // 顶点域，存储顶点信息
        EdgeNode firstedge; // 边表头指针
    }

    /**
     *  功能：边表结点
     */
    private class EdgeNode {
        char adjvex;   // 邻接点域，存储该顶点对应的下标
        EdgeNode next; // 链域，指向下一个邻接点
    }

    /**
     * 功能：邻接矩阵的深度优先遍历递归算法
     */
    private void DFS(VertexNode[] vertexNodeList, int i) {
        EdgeNode p;
        visited[i] = true;
        System.out.print(vertexNodeList[i].vertex); // 打印顶点
        p = vertexNodeList[i].firstedge;
        while (p != null) {
            if (!visited[getPosition(p.adjvex, mVexs)])
                DFS(vertexNodeList, getPosition(p.adjvex, mVexs));
            p = p.next;
        }
    }

    /**
     * 功能：邻接矩阵的深度遍历操作
     */
    private void DFSTraverse(VertexNode[] vertexNodeList) {
        for (int i = 0; i < vertexNodeList.length; i++)
            visited[i] = false;         // 初始化所有顶点状态为未访问状态

        System.out.printf("DFS:");

        for (int i = 0; i < vertexNodeList.length; i++)
            if (!visited[i])
                DFS(vertexNodeList, i); // 对未访问过的顶点调用DFS,若是连通图，只会执行一次
        System.out.printf("\n");
    }

    /**
     * 功能：邻接矩阵的广度遍历算法
     */
    private void BFSTraverse(VertexNode[] vertexNodeList) {
        EdgeNode p;
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];   // 辅组队列
        for (int i = 0; i < mVexs.length; i++) // 初始化所有顶点状态为未访问状态
            visited[i] = false;

        System.out.printf("BFS:");

        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {                     // 若是未访问就处理
                visited[i] = true;                 // 设置当前顶点访问过
                System.out.printf("%c", mVexs[i]); // 打印顶点
                queue[rear++] = i;                 // 将此顶点入队列
            }
            while (head != rear) {                 // 若当前队列不为空
                int k = queue[head++];             // 将队中元素出队列，赋值给k
                p = vertexNodeList[k].firstedge;   // 找到当前顶点边表链表头指针
                while (p != null) {
                    if (!visited[getPosition(p.adjvex, mVexs)]) {     // 判断此顶点是否被访问过
                        visited[getPosition(p.adjvex, mVexs)] = true; // 将找到的此顶点标记为已访问
                        System.out.printf("%c", p.adjvex);            // 打印此顶点
                        queue[rear++] = getPosition(p.adjvex, mVexs); // 将找到的此顶点入队列                   
                    }
                    p = p.next;                                       // 指向下一个邻接点
                }
            }
        }
    }

    /**
     * 功能：打印邻接表
     */
    private void print() {
        System.out.printf("AdjList Undirected Graph:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "-->");
            if (vertexNodeList[i].firstedge != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstedge;
                System.out.print(mEdgeNode.adjvex);
                while (mEdgeNode.next != null) {
                    mEdgeNode = mEdgeNode.next;
                    System.out.print(mEdgeNode.adjvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }

    /**
     * 功能：返回字符所在位置
     */
    private int getPosition(char c, char[] vexs) {
        for (int i = 0; i < vexs.length; i++)
            if (vexs[i] == c)
                return i;
        return -1;
    }

    /**
     * 主函数
     */
    public static void main(String[] args) {
        char[] vexs = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G'
        };
        char[][] edges = new char[][] {
            {
                'A', 'C'
            }, {
                'A', 'D'
            }, {
                'A', 'F'
            }, {
                'B', 'C'
            }, {
                'C', 'D'
            }, {
                'G', 'E'
            }, {
                'F', 'G'
            }
        };
        AdjListUDG adjListUDG = new AdjListUDG(vexs, edges);
        adjListUDG.print();
        adjListUDG.DFSTraverse(vertexNodeList);
        adjListUDG.BFSTraverse(vertexNodeList);
    }
}