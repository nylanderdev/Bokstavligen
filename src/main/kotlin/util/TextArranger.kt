package util

import javafx.scene.text.Text

class TextArranger {

    private lateinit var firstCharacter: Text
    private lateinit var characterIterator: Iterator<Text>
    private lateinit var textCharacters: List<Text>
    private lateinit var rows: MutableList<MutableList<Text>>
    private var remainingRowLength = 0.0
    private lateinit var row: MutableList<Text>
    private var wrapped = false
    private lateinit var character: Text


    private fun createTextRows(rowLength: Double, text: List<Text>): List<List<Text>> {
        // todo: breaks in words shouldnt happen
        textCharacters = splitTextByCharacters(text)
        characterIterator = textCharacters.iterator()
        rows = MutableList(0) {
            MutableList(0) { Text() }
        }
        loadVeryFirstCharacter();
        while (characterIterator.hasNext()) {
            remainingRowLength = rowLength
            row = MutableList(0) { Text() }
            row.add(firstCharacter)
            //println(firstCharacter.text)
            remainingRowLength = rowLength - firstCharacter.layoutBounds.width
            wrapped = false
            while (!wrapped) {
                if (characterIterator.hasNext()) {
                    character = characterIterator.next()
                    //println(character.text)
                    tryFit()
                } else break
            }
            rows.add(row)
        }
        return rows
    }

    private fun tryFit() {
        // Does it fit?
        if (remainingRowLength - character.layoutBounds.width >= 0.0) {
            fit();
        } else if (Character.isWhitespace(character.text[0])) {
            noFitWhitespace();
        } else {
            noFit();
        }
    }

    private fun noFit() {
        // Does not fit!
        firstCharacter = character
        wrapped = true
    }

    private fun noFitWhitespace() {
        // Does not fit and is whitespace!
        remainingRowLength = 0.0
        row.add(character)
        // if its whitespace,
        // set remaining length to 0
        // and add it anyways
        // it will probably work lmao
    }

    private fun fit() {
        // Fits!
        row.add(character)
        remainingRowLength -= character.layoutBounds.width
    }

    private fun loadVeryFirstCharacter() {
        if (characterIterator.hasNext()) {
            firstCharacter = characterIterator.next()
        }
    }

    companion object {

        fun arrangeTextInRows(rowLength: Double, text: List<Text>): List<List<Text>> =
                TextArranger().createTextRows(rowLength, text)

        private fun splitTextByCharacters(text: List<Text>): List<Text> {
            val textCharacters = MutableList(0) { Text() }
            for (textNode in text) {
                textCharacters.addAll(splitTextByCharacters(textNode))
            }
            return textCharacters
        }

        private fun splitTextByCharacters(textNode: Text): List<Text> {
            val textCharacters = MutableList(0) { Text() }
            val textString = textNode.text!!
            for (character in textString) {
                val textCharacter = copyTextNode(textNode)
                textCharacter.text = character.toString()
                textCharacters.add(textCharacter)
            }
            return textCharacters
        }

        private fun copyTextNode(textNode: Text): Text {
            val copy = Text(textNode.text)
            copy.font = textNode.font
            copy.strikethroughProperty().set(textNode.isStrikethrough)
            copy.underlineProperty().set(textNode.isUnderline)
            return copy
        }
    }
}