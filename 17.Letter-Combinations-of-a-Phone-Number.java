class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
          return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, map, sb, result);
        return result;
    }

    private void helper(String digits, int index, Map<Character, String> map, StringBuilder sb, List<String> result){
      if (index == digits.length()){
        result.add(sb.toString());
        return;
      }
      String letters = map.get(digits.charAt(index));
      for (int i = 0; i < letters.length(); i++) {
        sb.append(letters.charAt(i));
        helper(digits, index + 1, map, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
}
