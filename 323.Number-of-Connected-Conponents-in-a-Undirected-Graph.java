class UnionFind{
  private int[] parent;
  private int[] size;

  public UnionFind(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      //initialize every node's parent be itself and set size 1.
      parent[i] = i;
      size[i] = 1;
    }
  }

  //find method with path compression
  //Assign all nodes on the path to the same root.
  public int find(int A) {
    if (parent[A] != A) {
      parent[A] = find(parent[A]);
    }
    return parent[A];
  }

  //union: merge set with lower rank to set with larger rank.
  public int union(int A, int B) {
    int rootA = find(A);
    int rootB = find(B);
    if (rootA == rootB) {
      return 0;
    }
    if (size[rootA] < size[rootB]) {
      parent[rootA] = rootB;
      size[rootB] += size[rootA];
    } else {
      parent[rootB] = rootA;
      size[rootA] += size[rootB];
    }
    return 1;
  }
}

class Solution {
  //Time: O(E * a(n)) -- O(E) - union and find amortized time is O(1)
  // Space: O(N) 
    public int countComponents(int n, int[][] edges) {
      UnionFind unionFind = new UnionFind(n);
      int components = n;
      //component - 1 if we can connect one more node
      //component - 0 if the nodes are already connected
      for (int[] edge: edges) {
        components -= unionFind.union(edge[0], edge[1]);
      }
      return components;
    }
}
