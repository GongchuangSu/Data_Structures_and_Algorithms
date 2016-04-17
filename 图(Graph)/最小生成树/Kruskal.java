/**
 * @description 最小生成树之克鲁斯卡尔(Kruskal)算法
 *              输入 --> 无向有权图
 *              输出 --> 打印最小生成树边及其对应的权重
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class Kruskal {
	int vlen;      // 顶点个数
	int elen;      // 边个数
	Edge[] edges;  // 边集数组
	Edge[] result; // 最小生成树数组
	int[] parent;  // 用来判断边与边是否形成环路
	WeightedGraph G;
	
	public void kruskal(WeightedGraph G){
	    vlen = G.size();           
	    elen = G.getEdgNum();      
		edges = new Edge[elen];
		result = new Edge[vlen-1];
		parent = new int[vlen];
		this.G = G;
		
		edges = getEdges();  // 获取图中所有的边
		sortEdges(edges);    // 对边进行排序
		
		// 初始化数组值为0
		for(int i = 0; i < vlen; i++){
			parent[i] = 0;
		}
				
		// 循环每一条边
		int index = 0;
		for(int i = 0; i < elen; i++){               
			int n = getEnd(parent, edges[i].source);
			int m = getEnd(parent, edges[i].target);
			// 如果n与m不相等，说明此边没有与现有生成树形成环路
			if(n != m){ 
				parent[n] = m;
				result[index++] = new Edge(edges[i].source, edges[i].target, edges[i].weight);
			}
		}
		
		// 打印结果
		print();
	}
	
	/**
	 * 功能：边集结构体
	 */
	private static class Edge{
		int source;
		int target;
		int weight;
		public Edge(int source, int target, int weight){
			this.source = source;
			this.target = target;
			this.weight = weight;
		}
	}
	
	/**
	 * 功能：获取图中所有的边
	 */
	private Edge[] getEdges(){
		int index = 0;
		Edge[] edges = new Edge[elen];
		for(int i = 0; i < vlen; i++){
			for(int j = i + 1; j < vlen; j++)
				if(G.getWeight(i, j) != 0)
					edges[index++] = new Edge(i, j, G.getWeight(i, j));
		}
		return edges;
	}
	
	/**
	 * 功能：将边按照权值大小由小到大进行排序
	 */
	private void sortEdges(Edge[] edges){
		for(int i = 0; i < elen; i++)
			for(int j = i + 1; j < elen; j++)
				if(edges[i].weight > edges[j].weight){
					Edge temp = edges[i];
					edges[i] = edges[j];
					edges[j] = temp;
				}
	}
	
	/**
	 * 功能：查找顶点在该最小树中的终点下标
	 */
	private int getEnd(int[] parent, int i) {
		while( parent[i] > 0 )
			i = parent[i];
		return i;
	}
	
	/**
	 * 功能：打印结果
	 */
	private void print() {
		System.out.print("Kruskal:\n");
		for(int i = 0; i < vlen - 1; i++)
			System.out.printf("(%d, %d) %d \n",result[i].source, result[i].target, result[i].weight);
	}
}
