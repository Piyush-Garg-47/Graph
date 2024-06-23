import java.util.*;
public class TopologicalSortByBFS{
    static class Edge {
        int dis;

        public Edge(int s, int d) {
            this.dis = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
      public static void calcindeg(ArrayList<Edge>[] graph , int indegree []){

        for(int i =0; i<graph.length ; i++){
            int v=i ;
            for(int j =0 ; j<graph[v].size() ; j++) {
              Edge e = graph[v].get(j) ;
              indegree[e.dis]++;

            }
        }
      }
    public static void topsort(ArrayList<Edge>[] graph){
        int indegree [] =new int[graph.length] ;
        calcindeg(graph , indegree) ;
        Queue<Integer> q = new LinkedList<>() ; 

        for(int i =0 ; i<indegree.length ;i++){
            if(indegree[i] == 0 ){
                q.add(i) ;
            }
        }
        while(!q.isEmpty()) {
            int curr = q.remove() ; 
            System.out.print(curr +" ") ; 

            for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e =graph[curr].get(i) ; 
            indegree[e.dis] -- ;
            if(indegree[e.dis] == 0 ){
                 q.add(e.dis) ; 
            }
            }
        }
        System.out.println() ;
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
       topsort(graph) ; 
    }
}