package B_String;

import java.util.HashSet;

/**
 * C_FirstUniqueCharacterInString
 */
public class C_FirstUniqueCharacterInString {

    public static void main(String[] args) {
        System.out.println(new C_FirstUniqueCharacterInString().firstUniqChar("loveleetcode"));
    }
    
    public int firstUniqChar(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0 ; i < s.length() ; i++) {
            char a = s.charAt(i);
            if (hs.contains(a)) continue;
            hs.add(a);
            boolean find = false;
            for (int j = 0 ; j < s.length(); j++) {
                if (j == i)
                    continue;
                if (a == s.charAt(j)) {
                    find = true;
                    break;
                }
            }
            if (!find)
                return i;
        }
        return -1;
    }
}