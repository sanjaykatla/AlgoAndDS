package dp.longest_common_subsequence

class LCSRecursionMemoization {

    var m = 0
    var n = 0

    var s1 = ""
    var s2 = ""

    fun lcs(s1: String, s2: String): Int {

        m = s1.length
        n = s2.length
        this.s1 = s1
        this.s2 = s2

        val dp = Array(m){IntArray(n){-1}}
        return lcs(m-1, n-1, dp)
    }

    private fun lcs(i: Int, j: Int, dp: Array<IntArray>): Int {

        if(i<0 || j<0) return 0

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.get(i) == s2.get(j)){
            return 1 + lcs(i-1, j-1, dp)
        }


        val result = lcs(i - 1, j, dp).coerceAtLeast(lcs(i, j - 1, dp))
        dp[i][j] = result
        return result
    }
}