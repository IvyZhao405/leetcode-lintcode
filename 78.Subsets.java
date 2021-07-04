class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null || nums.length == 0) {
        return result;
      }
      List<Integer> cur = new ArrayList<>();
      helper(nums, 0, result, cur);
      return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> cur) {
      if (index == nums.length) {
        result.add(new ArrayList<Integer>(cur));
        return;
      }

      cur.add(nums[index]);
      helper(nums, index + 1, result, cur);
      cur.remove(cur.size() - 1);
      helper(nums, index + 1, result, cur);
    }
}
