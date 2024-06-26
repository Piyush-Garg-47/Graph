import java.util.*;

public class StronglyConnected {
     static class Edge{
        int dest ;
        int src ; 
      
        public Edge(int s , int d){
            this.dest = d ;
            this.src = s ;
           
        }
 
    }
 
     static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
      
        
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));
         
        graph[3].add(new Edge(3, 4));
       
    }

    public static void topsort(  ArrayList<Edge> graph[] , int curr , boolean vis [] , Stack<Integer> s ) {
        vis[curr] = true ; 

        for(int i =0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get( i) ; 
            if(!vis[e.dest]){
                topsort(graph, e.dest, vis, s);
            }
        } 
         s.push(curr)  ; 
    }

    public static void dfs(  ArrayList<Edge> graph[] , int curr , boolean vis [] ) {
        vis[curr] = true ; 
        System.out.print(curr +" ");

        for(int i =0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get( i) ; 
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis );
            }
        } 
        
    }
    public static void kosaraju(    ArrayList<Edge> graph[] , int v ){
      
        //step 1 

        Stack<Integer> s =new Stack<>();
        boolean vis [] =new boolean[v] ;

        for(int i =0 ; i<v ; i++){

            if(!vis[i]){
                topsort(graph, i, vis, s);
            }
        }

       // step 2 
       
       ArrayList<Edge> transpose[] = new ArrayList[v];
       for (int i = 0; i < graph.length; i++) {
        vis[i] =false ; 
        transpose[i] = new ArrayList<>();
       }

       for(int i = 0 ; i<v ; i++){
        for(int j=0 ; j<graph[i].size() ; i++){
             Edge e =graph[i].get(j) ; 

             transpose[e.dest].add(new Edge(e.dest , e.src)) ; 
        }
       }

       // step 3 

       while(!s.isEmpty()){
        int curr = s.pop() ; 
        if(!vis[curr]){
            System.out.print(" SCC ->");
            dfs(transpose , curr , vis ) ; 
            System.out.println();
        }
       }
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
    kosaraju(graph, v);
    }

}
