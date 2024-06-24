import java.util.*;
public class Kuskals {
    static class Edge implements Comparable<Edge>{
        int dest ;
        int src ; 
        int wt ; 
        public Edge(int s , int d, int w){
            this.dest = d ;
            this.src = s ;
            this .wt =w ;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt -e2.wt ;
        }
    }

    static void create(ArrayList<Edge> edges){

    edges.add(new Edge(0, 1, 10)) ;
    edges.add(new Edge(0, 2, 15)) ;
    edges.add(new Edge(0, 3, 30)) ;
    edges.add(new Edge(1, 3, 40)) ;
    edges.add(new Edge(2, 3, 50)) ;
    }
    static int n =4 ;
    static int par [] =new int[n] ;
     static int rank[] =new int[n] ;

      public static void init(){
         for(int i =0 ; i< n ;i++){
            par[i] =i ;
         }
      }

      public static int find(int x ){
        if(x == par[x]){
            return x ;
        }

        return par[x] =  find(par[x]) ;
      }
      public static void union(int a , int b ){
        int parA= find(a) ;
        int parB =find(b) ;

        if(rank[parA] == rank[parB]){
            par[parB] =parA ; 
            rank[parA]++;

        }else if(rank[parA] < rank[parB]){
            par[parA] =parB; 
        }else {
            par[parB] =parA ; 
        }
      }

      public static void kruskalsMST(  ArrayList<Edge> edges , int  v){
       init();  
        Collections.sort(edges); 
        int mstcost = 0 ;
        int count = 0 ;
         for(int i=0 ;  i < edges.size() && count < v - 1 ; i++){
            Edge e = edges.get(i) ;

           int  parA =find(e.src); //scr = a 
           int parB = find(e.dest ) ; 
            if(parA != parB){
                union(e.src , e.dest);
                mstcost += e.wt ; 
            }
         }

          System.out.println(mstcost );
      }

      public static void main(String[] args) {
        int v =4 ;

        ArrayList<Edge> edges= new ArrayList<>() ; 
        create(edges);
        kruskalsMST(edges, v);
      }

}
