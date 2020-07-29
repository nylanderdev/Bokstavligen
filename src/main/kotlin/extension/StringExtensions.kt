package extension

fun String.wordCount(): Int {
    // todo (unknown priority): optimize (regex is overkill)
    val wordRegex = Regex("\\S+")
    var matchCount = 0
    wordRegex.findAll(this).iterator().forEach { _ -> matchCount++ }
    return matchCount
}