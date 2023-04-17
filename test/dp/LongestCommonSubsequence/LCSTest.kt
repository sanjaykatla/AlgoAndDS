package dp.LongestCommonSubsequence

import org.junit.Test


class LCSTest {

    @Test
    fun lcs() {
        val longestCommonSubsequence = LCSRecursion()

        val start = System.currentTimeMillis()
        val res = longestCommonSubsequence.lcs("abcde", "ace")
        val stop = System.currentTimeMillis()
        println("Time taken: "+ (stop-start)/1000)
        assert(res == 3)
    }
}