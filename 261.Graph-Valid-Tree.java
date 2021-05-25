class UnionFind{
  private int[] parent;
  private int[] size; // keep track of size of each set

  public UnionFind(int n) {
    parent = new int[n];
    size = new int[n];
    for (int node = 0; node < n; node++) {
      parent[node] = node;
      size[node] = 1;
    }
  }

  //Find method with path compression.
  public int find(int A) {
    //the root of a set should be parent[A] == A
    // we assign all nodes in this set to point to the same root.
    if (parent[A] != A) {
      parent[A] = find(parent[A]);
    }
    return parent[A];
  }

  public boolean union(int A, int B) {
    //Find the roots for A and B.
    int rootA = find(A);
    int rootB = find(B);
    //check if A and b are already in the same set
    if (rootA == rootB) {
      return false;
    }
    //larger set shouuld remain as root
    if (size[rootA] < size[rootB]) {
      parent[rootA] = rootB;
      size[rootB] += size[rootA];
    } else {
      parent[rootB] = rootA;
      size[rootA] += size[rootB];
    }
    return true;
  }
}


//time: O(N) - unionFind amortized time complexity is O(1)
//space: O(N)
class Solution {
    public boolean validTree(int n, int[][] edges) {
      //Condition1: The graph must contain n - 1 egdes
      if (edges.length != n - 1) {
        return false;
      }

      //condition2: the graph must contain a single component
      //And when we encounter an edge we cannot union, we have a cycle, just return false
      UnionFind unionFind = new UnionFind(n);
      for (int[] edge: edges) {
        int A = edge[0];
        int B = edge[1];
        if (!unionFind.union(A,B)){
          return false;
        }
      }
      return true;
    }
}
