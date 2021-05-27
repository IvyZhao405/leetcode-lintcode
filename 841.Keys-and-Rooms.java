class Solution {
   //BFS
   //time: O(N + E) - N is number of rooms, E is the total number of keys
   //space: O(N) - hashset visited and queue both O(N)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      if (rooms == null || rooms.size() == 0) {
        return true;
      }

      Set<Integer> visited = new HashSet<>();
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(0);
      visited.add(0);
      while (!queue.isEmpty()) {
        Integer cur = queue.poll();
        for (int neighbor: rooms.get(cur)) {
          if (!visited.contains(neighbor)) {
            queue.offer(neighbor);
            visited.add(neighbor);
          }
        }
      }
      return visited.size() == rooms.size();
    }

    //DFS
    //Same complexity
    public boolean canVisitAllRoomsII(List<List<Integer>> rooms) {
      Set<Integer> visited = new HashSet<>();
      dfs(0, rooms, visited);
      return rooms.size() == visited.size();
    }

    private void dfs(Integer room, List<List<Integer>> rooms, Set<Integer> visited) {
      if (visited.contains(room)) {
        return;
      }
      visited.add(room);
      for (Integer neighbor: rooms.get(room)) {
        dfs(neighbor, rooms, visited);
      }
    }
}
