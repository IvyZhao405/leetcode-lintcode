class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
          return result;
        }

        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / 2; i++) {
          if (n % i == 0) {
            factors.add(i);
          }
        }
        List<Integer> cur = new ArrayList<>();
        helper(n, 0, cur, factors, result);
        return result;
    }

    private void helper(int n, int index, List<Integer> cur, List<Integer> factors, List<List<Integer>> result) {
      if (index == factors.size()) {
        if (n == 1) {
          result.add(new ArrayList<Integer>(cur));
          return;
        }
      }
      helper(n, index + 1, cur, factors, result);
      int factor = factors.get(index);
      int size = cur.size();
      while (n % factor == 0) {
        cur.add(factor);
        n /= factor; 
        helper(n, index + 1, cur, factors, result);
      }
      cur.subList(size, cur.size()).clear();
    }
}
