import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.ArrayIndexOutOfBoundsException;
class DirectedGraph{
  int V;
  LinkedList<Integer> adjacencyList[];
  Queue<Integer> IsAlreadyVisited = new LinkedList<Integer>();
  public DirectedGraph(int V){
      this.V = V;
      adjacencyList = new LinkedList[V];
      for(int i=0;i<V;i++){
        adjacencyList[i] = new LinkedList<Integer>();
      }
  }
  public boolean addEdgeFromNodeAtoNodeB(int source, int destination){
    try{
      this.adjacencyList[source].add(destination);
      return true;
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }
  public void displayGraph(){
    for(int i=0;i<adjacencyList.length;i++){
      System.out.println("Adjacency List for "+ i);
      Iterator it = adjacencyList[i].iterator();
      while(it.hasNext()){
        System.out.println("->"+it.next());
      }
    }
  }
  public boolean AreNodesConnected(int src,int dest){
      if(adjacencyList[src].contains(dest)){
        return true;
      }
        return false;
  }
  public boolean IsRouteAvailable(int src,int dest){
    try{
      LinkedList<Integer> list = adjacencyList[src];
    Iterator it              = list.iterator();
    while(it.hasNext()){
      int node = (int)it.next();
      if(!IsAlreadyVisited.contains(node)){
      IsAlreadyVisited.add(node);
      if(adjacencyList[node].contains(dest)){
        return true;
      }else{
        return IsRouteAvailable(node,dest);
      }
    }else{
      return false;
    }
    }
      return false;
  }catch(ArrayIndexOutOfBoundsException e){
  return false;
}}

  public static void main(String[] args){
    DirectedGraph graph = new DirectedGraph(10);
    for(int i=0,j=10;i<10&&j>=0;i++,j--){
      graph.addEdgeFromNodeAtoNodeB(i,j);
      graph.addEdgeFromNodeAtoNodeB(i,j+1);
    }
    graph.displayGraph();
    if(graph.AreNodesConnected(4,9)){
      System.out.println("Connected");
    }else{
      System.out.println("Not Connected");
    }
    if(graph.IsRouteAvailable(4,5)){
      System.out.println("Available");
    }else{
      System.out.println("Not Available");
    }

  }
}
