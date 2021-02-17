package B_String;

/*
實作 Java String.indexOf

利用雙迴圈做到 , 特別注意如果for loop 遇到 length - length , 預期應該要+1
*/
public class G_ImplementIndexOf1 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        for (int i = 0 ; i < haystack.length() - needle.length()+1 ; i++) {
            for (int j = 0 ; j < needle.length() ; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                } else if (j == needle.length() -1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
