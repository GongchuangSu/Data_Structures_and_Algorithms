/**
 * @description 邻接矩阵表示的有向图(Matrix Directed Graph)的
 *              深度优先遍历算法(DFS)和广度优先遍历算法(BFS)
 * @author GongchuangSu
 * @since 2016.03.28
 * @version v1.0
 */
public class MatrixDG {
    private static char[] mVexs;    // 顶点集合
    private static int[][] mMatrix; // 邻接矩阵
    private boolean[] visited;      // 访问标志的数组
    
    public MatrixDG(char[] vexs, char[][] edges) {
        // 初始化顶点个数和边个数
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化顶点
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = vexs[i];
        }

        // 初始化边
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起点和终点坐标信息
            int llabel = getPosition(edges[i][0]);
            int rlabel = getPosition(edges[i][1]);
            // 将坐标信息写入邻接矩阵
            mMatrix[llabel][rlabel] = 1;
        }

        // 初始化访问标志数组
        visited = new boolean[mVexs.length];
    }

    /**
     * 功能：邻接矩阵的深度优先遍历递归算法
     */
    private void DFS(int[][] mMatrix, int i) {
        visited[i] = true;
        System.out.print(mVexs[i]); // 打印顶点
        for (int j = 0; j < mVexs.length; j++)
            if (mMatrix[i][j] == 1 && !visited[j])
                DFS(mMatrix, j);    // 对未访问的邻接顶点递归调用
    }

    /**
     * 功能：邻接矩阵的深度遍历操作
     */
    private void DFSTraverse(int[][] mMatrix) {
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;  // 初始化所有顶点状态为未访问状态

        System.out.printf("DFS:");

        for (int i = 0; i < mVexs.length; i++)
            if (!visited[i])
                DFS(mMatrix, i); // 对未访问过的顶点调用DFS,若是连通图，只会执行一次
        System.out.printf("\n");
    }

    /**
     * 功能：邻接矩阵的广度遍历算法
     */
    private void BFSTraverse(int[][] mMatrix) {
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
            while (head != rear) {                           // 若当前队列不为空
                int k = queue[head++];                           // 将队中元素出队列，赋值给i
                for (int j = 0; j < mVexs.length; j++) {
                    if (mMatrix[k][j] == 1 && !visited[j]) { // 判断其他顶点是否与当前顶点存在边且未被访问过
                        visited[j] = true;                   // 将找到的此顶点标记为已访问
                        System.out.printf("%c", mVexs[j]);   // 打印此顶点
                        queue[rear++] = j;                   // 将找到的此顶点入队列
                    }
                }
            }
        }
    }

    /**
     * 功能：打印邻接矩阵
     */
    private void print() {
        System.out.printf("Matrix Directed Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }

    /**
     * 功能：返回字符所在位置
     */
    private int getPosition(char c) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i] == c)
                return i;
        }
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
                'E', 'G'
            }, {
                'F', 'G'
            }
        };
        MatrixDG matrixDG = new MatrixDG(vexs, edges);
        matrixDG.print();
        matrixDG.DFSTraverse(mMatrix);
        matrixDG.BFSTraverse(mMatrix);
    }
}
