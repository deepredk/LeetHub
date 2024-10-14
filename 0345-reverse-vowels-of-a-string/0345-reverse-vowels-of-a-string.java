class Solution {
    public String reverseVowels(String s) {
        List<Integer> vowelIdxs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelIdxs.add(i);
            }
        }

        char[] chs = s.toCharArray();
        for (int i = 0; i < vowelIdxs.size() / 2; i++) {
            int a = vowelIdxs.get(i);
            int b = vowelIdxs.get(vowelIdxs.size()-1-i);

            char tmp = chs[a];
            chs[a] = chs[b];
            chs[b] = tmp;
        }

        return new String(chs);
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}