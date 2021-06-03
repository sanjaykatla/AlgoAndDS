package strings;

public class InterleavedString {

    private char[] c1;
    private char[] c2;
    private char[] c3;

    public static void main(String[] args){
        final InterleavedString interleavedString = new InterleavedString();
        System.out.println(interleavedString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(interleavedString.isInterleave("", "", ""));
        System.out.println(interleavedString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//        interleavedString.isInterleave();
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        c1 = s1.trim().toCharArray();
        c2 = s2.trim().toCharArray();
        c3 = s3.trim().toCharArray();

        return isInterleave(0, 0, 0);
    }

    private boolean isInterleave(int i, int j, int k) {

        

        if(c1[i] != c3[k] || c2[j] != c3[k]){
            return false;
        }

        return isInterleave(i+1,j,k+1) || isInterleave(i,j+1,k+1);
    }
}
