package io.github.potatocurry.kwizlet.api

import io.github.potatocurry.kwizlet.json.JsonSet
import io.github.potatocurry.kwizlet.json.JsonTerm
import java.net.URL

class Set(clientID: String, setID: String, password: String? = null) {
    private val jsonSet: JsonSet

    init {
        val jsonURL: String = if (password == null)
            "$quizletEndpoint/sets/$setID?client_id=$clientID"
        else
            "$quizletEndpoint/sets/$setID?client_id=$clientID/$password"
        val jsonContent = URL(jsonURL).readText()
        jsonSet = JsonSet.fromJson(jsonContent) ?: throw KotlinNullPointerException("JSON content empty at $jsonURL")
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

    val termPairs = terms.zip(definitions)

    val termMap = termPairs.toMap()
}
