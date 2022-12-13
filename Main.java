class Main {
  public static void main(String[] args) {
    System.out.println("Hello Union-Find");
  }
}

  class UnionFind {
  private int[] parent;
  private int[] rank;

  public UnionFind(int n) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i; // At the beginning every node is the parent of itself. This is equivalent to the MakeSet() theoretical function of the Union-Find
    }
  }

    private int find(int x) {
      // the parent of a set of disjoint nodes is the "representative" of that set
      // if the node itself is its parent then just return the node, other return the node that is the representative
      return parent[x] == x ? x: (parent[x] = find(parent[x]));
    }
 // this returns false if x and y are in the same set
    private boolean union(int x, int y) {
      int xnode = find(x);
      int ynode = find(y);
      // we merge the representative node of a smaller (lower rank) disjoint set with the set with the higher rank per agreement
        if (rank[xnode] > rank[ynode]) parent[ynode] = parent[xnode];
        else if (rank[xnode] < rank[ynode]) parent[xnode] = parent[ynode];
        else if (xnode != ynode) rank[parent[ynode] = xnode]++;
        return xnode != ynode;
    }

}

