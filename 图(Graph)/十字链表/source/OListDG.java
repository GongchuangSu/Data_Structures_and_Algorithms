/*
 * 作者：GongchuangSu
 * 时间：2016.03.12
 * 功能：十字链表有向图（已提供参数）
 * 输入说明：vexs  --  顶点数组
 * 		   edges  --  边数组
 * 输出说明：十字链表（即对每个顶点vi都建立一个链接为vi为弧尾和弧头的表）
 */
package test;
public class OListDG {
    int vlen; // 顶点个数
    int elen; // 边个数
    VertexNode[] vertexNodeList; // 顶点数组
    EdgeNode edgeNode;

    /**
     * 构造函数
     * @param vexs
     * @param edges
     */
    public OListDG(char[] vexs, char[][] edges) {
        vlen = vexs.length;
        elen = edges.length;

        // 初始化顶点,建立顶点表
        vertexNodeList = new VertexNode[vlen];
        for (int i = 0; i < vlen; i++) {
            vertexNodeList[i] = new VertexNode();
            vertexNodeList[i].vertex = vexs[i];
            vertexNodeList[i].firstIn = null;
            vertexNodeList[i].firstOut = null;
        }

        // 初始化边，利用头插法建立十字链表
        for (int i = 0; i < elen; i++) {
            EdgeNode edgeNode_1 = new EdgeNode();
            EdgeNode edgeNode_2 = new EdgeNode();
            int vi = getPosition(edges[i][0], vexs);
            int vj = getPosition(edges[i][1], vexs);
             
            edgeNode_1.tailvex = vi;
            edgeNode_1.headvex = vj;
            edgeNode_1.taillink = vertexNodeList[vi].firstOut;
            vertexNodeList[vi].firstOut = edgeNode_1;
            
            edgeNode_2.tailvex = vi;
            edgeNode_2.headvex = vj;
            edgeNode_2.headlink = vertexNodeList[vj].firstIn;
            vertexNodeList[vj].firstIn = edgeNode_2;

        }
    }

    /**
     *  功能：顶点表结点结构
     *  参数：vertex --> 顶点域，存储顶点信息
     *       firstIn --> 入边表头指针，指向该顶点的入边表中第一个结点
     *       firstOut --> 出边表头指针，指向该顶点的出边表中第一个结点
     */
    private class VertexNode {
        char vertex; 
        EdgeNode firstIn;
        EdgeNode firstOut; 
    }

    /**
     *  功能：边表结点
     *  参数：tailvex --> 弧起点在顶点表的下标
     *        headvex --> 弧终点在顶点表的下标
     *        headlink --> 入边表指针域,指向终点相同的下一条边
     *        taillink --> 边表指针域，指向起点相同的下一条边
     */
    private class EdgeNode {
    	int tailvex;
    	int headvex;
    	EdgeNode headlink;
    	EdgeNode taillink;
    }

    /**
     *  功能：返回ch位置
     */
    private int getPosition(char ch, char[] vexs) {
        for (int i = 0; i < vlen; i++)
            if (vexs[i] == ch)
                return i;
        return -1;
    }

    /**
     *  功能：打印邻接表和逆邻接表
     */
    public void print() {
        System.out.printf("AdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "-->");
            if (vertexNodeList[i].firstOut != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstOut;
                System.out.print(mEdgeNode.headvex);
                while (mEdgeNode.taillink != null) {
                    mEdgeNode = mEdgeNode.taillink;
                    System.out.print(mEdgeNode.headvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
        
        System.out.print("----------\n");
        
        System.out.printf("InvAdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "<--");
            if (vertexNodeList[i].firstIn != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstIn;
                System.out.print(mEdgeNode.tailvex);
                while (mEdgeNode.headlink != null) {
                    mEdgeNode = mEdgeNode.headlink;
                    System.out.print(mEdgeNode.tailvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }

    /**
     * 主函数
     */
    public static void main(String args[]) {
    	// 顶点数组
        char[] vexs = {
            'A', 'B', 'C', 'D'
        };
        // 边数组
        char[][] edges = new char[][] {
            {
                'A', 'B'
            }, {
                'A', 'C'
            }, {
                'A', 'D'
            }, {
                'B', 'D'
            }, {
                'C', 'D'
            }
        };

        OListDG listUDG = new OListDG(vexs, edges);
        listUDG.print();
    }
}
