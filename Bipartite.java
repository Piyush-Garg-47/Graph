import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    static class Edge{
        int dis ;
        int src ; 
      
        public Edge(int s , int d){
            this.dis = d ;
            this.src = s ;
           
        }
 
    }
    static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
      
         
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2,  4));

        graph[3].add(new Edge(3,1));
      graph[3].add(new Edge(3, 4));
      
        graph[4].add(new Edge(4, 2));
      graph[4].add(new Edge(4, 3));

       
    }

     public static boolean isbipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length] ;
        for(int i =0 ;i <graph.length ;i ++ ){
            col[i] = -1 ;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0 ; i<graph.length ; i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0 ; // yellow color 
                while(!q.isEmpty()){
                    int curr = q.remove() ; 
                    for(int j =0 ; j<graph[curr].size() ;j++){
                        Edge e =graph[curr].get(j) ; 
                        if(col[e.dis] == -1){
                            int nextcol = col[curr]==0 ? 1 :0 ;
                            col[e.dis] = nextcol ;
                            q.add(e.dis) ; 
                         }else if (col[e.dis] == col[curr]){
                            return false ; 
                         }
                    }
                }
            }
        }
        return true ;
     }
     public static void main(String[] args) {
    int v = 5 ;
   ArrayList<Edge>graph[] =new ArrayList[v] ;
   creategraph(graph) ; 
    System.out.println( isbipartite(graph));
}
}