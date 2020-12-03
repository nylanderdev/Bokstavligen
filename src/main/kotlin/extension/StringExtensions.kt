package extension

/**
 * Count the number of whitespace-separated substrings in a string
 *
 * @return The number of whitespace-separated substrings (words) in a string
 */
fun String.wordCount(): Int {
    // todo (unknown priority): optimize (regex is overkill)
    val wordRegex = Regex("\\S+")
    var matchCount = 0
    wordRegex.findAll(this).iterator().forEach { _ -> matchCount++ }
    return matchCount
}