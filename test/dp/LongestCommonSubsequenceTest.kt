package dp

import org.junit.Test


class LongestCommonSubsequenceTest {

    @Test
    fun lcs() {
        val longestCommonSubsequence = LongestCommonSubsequence()
        val res = longestCommonSubsequence.lcs("abcde", "ace")

        assert(res == 3)
    }
}