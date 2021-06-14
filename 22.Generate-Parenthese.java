class Solution {
  //time: n^2 *n
  //space: n
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n<= 0) {
          return result;
        }
        StringBuilder sb = new StringBuilder();
        dfsHelper(n, n, sb, result);
        return result;
    }

    private void dfsHelper(int left, int right, StringBuilder sb, List<String> result) {
      if (left == 0 && right == 0) {
        result.add(sb.toString());
        return;
      }
      if (left > 0 ){
        sb.append("(");
        dfsHelper(left - 1, right, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
      if (right > left){
        sb.append(")");
        dfsHelper(left, right - 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
}
