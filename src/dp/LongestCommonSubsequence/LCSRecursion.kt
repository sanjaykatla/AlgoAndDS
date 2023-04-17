package dp.LongestCommonSubsequence

class LCSRecursion {

    var m = 0
    var n = 0

    var s1 = ""
    var s2 = ""

    fun lcs(s1: String, s2: String): Int {

        m = s1.length
        n = s2.length
        this.s1 = s1
        this.s2 = s2
        return lcs(m-1, n-1)
    }

    private fun lcs(i: Int, j: Int): Int {

        if(i<0 || j<0) return 0

        if(s1.get(i) == s2.get(j)){
            return 1 + lcs(i-1, j-1)
        }

        return lcs(i - 1, j)
            .coerceAtLeast(lcs(i, j - 1))
    }
}