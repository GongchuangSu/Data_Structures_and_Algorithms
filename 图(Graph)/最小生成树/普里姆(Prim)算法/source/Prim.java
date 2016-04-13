/**
 * @description 最小生成树之普里姆(Prim)算法
 *              输入 --> 有向权重图和起始顶点下标
 *              输出 --> 最小生成树数组
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class Prim {
    public int[] prim(WeightedGraph G, int s) {
        final int[] dist = new int[G.size()];            // 相关顶点间边的权值
        final int[] pred = new int[G.size()];            // prim最小生成树结果数组
        final boolean[] visited = new boolean[G.size()]; // 顶点访问标记数组
        // 初始化
        for(int i = 0; i < dist.length; i++){
        	dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0; // 将起始点对应的最小权值设置为0
        
        for(int i = 0; i < dist.length; i++){
        	final int next = minVertex(dist, visited); // 在dist中寻找未被访问点所对应的最小权值，并返回该顶点坐标
        	visited[next] = true;                      // 将该顶点设置为已访问
        	
        	final int[] n = G.neighbors(next);         // 取得与该顶点相邻接的点
        	for(int j = 0; j < n.length; j++){       
        		final int v = n[j];
        		final int d = G.getWeight(next, v);
        		if(dist[v] > d){
        			dist[v] = d;    // 将更小权值保存至dist数组中
        			pred[v] = next; // 并将先前结点保存至pred数组中
        		}
        	}
        }
        	
        return pred; // 返回最小生成树结果数组
    }
    
    /**
     * 功能：在未遍历点中寻找距离最小的点，并返回该点位置
     */
    private static int minVertex(int[] dist, boolean[] v){
    	int x = Integer.MAX_VALUE;
    	int y = -1;
    	for(int i = 0; i < dist.length; i++){
    		if(!v[i] && dist[i] < x){
    			y = i;
    			x = dist[i];
    		}
    	}
    	return y;
    }
}