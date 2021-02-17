package B_String;

/*
實作 Java String.indexOf
*/
public class G_ImplementIndexOf {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return -1;
        
        char[] target = needle.toCharArray();
        char[] cHaystack = haystack.toCharArray();
        int ans = -1;
        int compareS = 0,compareE = 0;
        
        for (int i = 0 ; i < cHaystack.length ; i++) {
            if (cHaystack[i] == target[0]) {
                compareS = i;
                compareE = 0;
                while (cHaystack[compareS] == target[compareE]) {
                    if (compareE == target.length-1) {
                        return i;
                    }
                    compareE++;
                    compareS++;
                    if (compareS >= cHaystack.length || compareE >= target.length) {
                        break;
                    }
                }
            }
            
        }
        return ans;
    }
}
