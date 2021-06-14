class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
          return result;
        }
        List<Integer> cur = new ArrayList<>();
        dfsHelper(nums, 0, cur, result);
        return result;
    }

    private void dfsHelper(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
      if (index == nums.length) {
        result.add(new ArrayList(cur));
        return;
      }

      //add number at current index
      cur.add(nums[index]);
      dfsHelper(nums, index + 1, cur, result);
      cur.remove(cur.size() - 1);

      //don't add
      dfsHelper(nums, index + 1, cur, result);
    }
}
