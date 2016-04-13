/**
 * @description 邻接矩阵表示的无向图(Matrix Undirected Graph)
 * @author GongchuangSu
 * @since 2016.04.11
 * @version v1.0
 */
public class MatrixUDG {
    private static char[] mVexs;    // 顶点集合
    private static int[][] mMatrix; // 邻接矩阵

    public MatrixUDG(char[] vexs, char[][] edges) {
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
            mMatrix[rlabel][llabel] = 1;
        }
    }
    
    /**
     * 功能：打印邻接矩阵
     */
    private void print() {
        System.out.printf("Matrix Undirected Graph:\n");
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
        MatrixUDG matrixUDG = new MatrixUDG(vexs, edges);
        matrixUDG.print();
    }
}