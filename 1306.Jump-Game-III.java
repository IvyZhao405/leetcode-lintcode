class Solution {
  //time: O(N)
  //space: O(N)
  //BFS
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
          int cur = queue.poll();
          if (arr[cur] == 0) {
            return true;
          }
          int x = cur + arr[cur];
          int y = cur - arr[cur];
          if (x < arr.length && arr[x] >= 0) {
            queue.offer(x);
          }
          if (y >= 0 && arr[y] >= 0) {
            queue.offer(y);
          }
          //mark current node as visited
          arr[cur] = -1;
        }
        return false;
    }

    //DFS
    //time: O(N) - visit each index once
    //spac: O(N) - call stack at most O(N)
    public boolean canReachII(int[] arr, int start) {
      if (start >= 0 && start < arr.length && arr[start] >= 0) {
        if (arr[start] == 0) {
          return true;
        }
        // so start + arr[start] and start - arr[start] would still give correct value
        // even though arr[start] became negative
        arr[start] = -arr[start];
        return canReachII(arr, start + arr[start]) || canReachII(arr, start - arr[start]);
      }
      return false;
    }
}
