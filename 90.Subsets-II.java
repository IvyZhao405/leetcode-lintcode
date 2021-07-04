class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
          return result;
        }
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        helper(nums, 0, cur, result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
      if (index == nums.length) {
        result.add(new ArrayList<Integer>(cur));
        return;
      }

      cur.add(index);
      helper(nums, index + 1, cur, result);
      cur.remove(cur.size() - 1);

      while (index + 1 < input.length && nums[index + 1] == nums[index]){
        index++;
      }
      helper(nums, index + 1, cur, result);
    }

}
