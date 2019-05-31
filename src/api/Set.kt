package io.github.potatocurry.kwizlet.api

import io.github.potatocurry.kwizlet.json.JsonSet
import io.github.potatocurry.kwizlet.json.JsonTerm
import java.net.URL

class Set internal constructor(clientID: String, setID: String, password: String? = null) {
    private val jsonSet: JsonSet

    val questions: List<Question>

    init {
        val jsonURL = if (password == null)
            "$quizletEndpoint/sets/$setID?client_id=$clientID"
        else
            "$quizletEndpoint/sets/$setID?client_id=$clientID/$password"
        val jsonContent = URL(jsonURL).readText()
        jsonSet = JsonSet.fromJson(jsonContent) ?: throw KotlinNullPointerException("JSON content empty at $jsonURL")
        val tempQuestions = mutableListOf<Question>()
        jsonSet.terms.forEach { tempQuestions += Question(it) }
        questions = tempQuestions
    }

    val id = jsonSet.id

    val url = jsonSet.url

    val title = jsonSet.title

    val author = jsonSet.createdBy

    val termCount = jsonSet.termCount

    // TODO: Get actual timestamps from dates
    val createdDate = jsonSet.createdDate

    val modifiedDate = jsonSet.modifiedDate

    val publishedDate = jsonSet.publishedDate

    val hasImages = jsonSet.hasImages

    // TODO: Make Kotlin types to represent visibility?
    val visibility = jsonSet.visibility

    val editable = jsonSet.editable

    val hasAccess = jsonSet.hasAccess

    val canEdit = jsonSet.canEdit

    val description = jsonSet.description

    val termLanguage = jsonSet.langTerms

    val definitionLanguage = jsonSet.langDefinitions

    val terms = jsonSet.terms.map(JsonTerm::term)

    val definitions = jsonSet.terms.map(JsonTerm::definition)

    // Convenience methods not part of the Quizlet API

    // TODO: Come up with solution to overloaded terms so correct definitions are not counted as wrong
    val termPairs = terms.zip(definitions)

    @Deprecated(
        "Can cause errors on sets with overloaded terms",
        ReplaceWith("termPairs"),
        DeprecationLevel.WARNING
    )
    val termMap by lazy { termPairs.toMap() }

    fun String.stripParenthesis() = this.replace("\\(.*\\)", "").trim()
}

data class Question internal constructor(private val jsonTerm: JsonTerm) {
    val id = jsonTerm.id

    val term = jsonTerm.term

    val definition = jsonTerm.definition

    val image = jsonTerm.image?.url

    val rank = jsonTerm.rank
}
