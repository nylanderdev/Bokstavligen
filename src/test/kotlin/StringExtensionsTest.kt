import org.junit.Assert
import org.junit.Test

class StringExtensionsTest {
    @Test
    fun wordCountTest1() {
        val testString = ""
        Assert.assertEquals(0, testString.wordCount())
    }

    @Test
    fun wordCountTest2() {
        val testString = " Hello world! 1 2 3 123 "
        Assert.assertEquals(6, testString.wordCount())
    }

    @Test
    fun wordCountTest3() {
        val testString = "_"
        Assert.assertEquals(1, testString.wordCount())
    }

    @Test
    fun wordCountTest4() {
        val testString = "HelloWorld"
        Assert.assertEquals(1, testString.wordCount())
    }

}