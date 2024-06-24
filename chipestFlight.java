import java.util.*;
public class chipestFlight {
    static class Edge{
        int dest ;
        int src ; 
        int wt ; 
        public Edge(int s , int d, int w){
            this.dest = d ;
            this.src = s ;
            this .wt =w ;
        }
    }
     public static  void createGraph( int flights [][] ,  ArrayList<Edge> graph[] ){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] =new ArrayList<>() ;
        }

        for(int i=0 ; i<flights.length ; i++){
            int src =flights[i][0] ;
            int dest =flights[i][1] ;
            int wt = flights[i][2] ;

            Edge e = new Edge(src, dest, wt) ;
            graph[src].add(e) ;

         }
     }
     
      static class Info{
        int v ; 
        int cost ; 
        int stops ;

        public Info(int v , int c , int s ){
            this.v =v ; 
            this.cost = c ; 
            this.stops = s ;
        }
      }
     public static int cheapest( int n , int flights[] [] , int src  , int dest , int k  ){
        
        ArrayList<Edge> graph[] =new ArrayList[n] ;
        createGraph(flights , graph ) ; 

        int dist [ ] = new int[n] ;// i ->src to i 

        for(int i =0 ; i<n ; i++){
         if(i !=src){
           dist[i] = Integer.MAX_VALUE ;
         }
        } 

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src ,0, 0)); 

        while(!q.isEmpty()){
            Info curr = q.remove() ;
            if(curr.stops > k ){
                break ;
            }

            for(int i=0 ; i<graph[curr.v].size() ; i++){
                Edge e =graph[curr.v].get(i) ;

                int u = e.src ;
                int V =e.dest ;
                int wt =e.wt ;
                 
                if( curr.cost +wt <dist[V] &&  curr.stops<= k ){
                    dist[V] =curr.cost +wt ; 
                   q.add(new Info(V, dist[V], curr.stops+1)) ;
                 }
            }
        }
        if(dist[dest] ==Integer.MAX_VALUE){
            return -1 ; 
        }else{
            return dist[dest] ; 
        }
     }
    public static void main(String[] args) {
        int  n =4 ; 
        int flights [] [] =  {{0,1,100} , {1,2,100} ,{2,3,200} , {2,0,100} ,{1,3,600}} ;
        int src =0  , dst = 3 , k =1 ; 
 System.out.println(" final cost of reaching on the point is in k stop is = "+ cheapest(n, flights, src, dst, k ));
       
    }
}
