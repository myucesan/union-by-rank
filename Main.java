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
    /**
     * NB: this function should also do path compression
     *
     * @param i index of a node
     * @return the root of the subtree containing i.
     */
int find(int i) {
        // the parent of a set of disjoint nodes is the "representative" of that set
      // if the node itself is its parent then just return the node, other return the node that is the representative
        int parent = this.getParent()[i];
        if (parent  == i) {
            return i;
        }

        return parent = find(parent); // path compression
    }
 // this returns false if x and y are in the same set
    boolean union(int i, int j) {
        // the the nodes are equivalent to their indices
        int leftSubTree = find(this.getParent()[i]);
        int rightSubTree = find(this.getParent()[j]);
                // we merge the representative node of a smaller (lower rank) disjoint set with the set with the higher rank per agreement
        if (find(i) != find(j)) {
            if (getRank()[leftSubTree] > getRank()[rightSubTree]) {
                this.getParent()[rightSubTree] = leftSubTree;
            } else if (getRank()[rightSubTree] > getRank()[leftSubTree]) {
                this.getParent()[leftSubTree] = rightSubTree;
            } else if (getRank()[leftSubTree] == getRank()[rightSubTree]) {
                this.getParent()[Math.max(leftSubTree, rightSubTree)] = this.getParent()[Math.min(leftSubTree, rightSubTree)];
                this.getRank()[Math.min(leftSubTree, rightSubTree)]++;
            }

            return true;
        }

        return false;
    }



}

