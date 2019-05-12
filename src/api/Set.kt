package api

import json.JsonSet
import java.net.URL

class Set(clientID: String, setID: String, password: String? = null) {
    private val jsonSet: JsonSet

    init {
        val jsonURL: String = if (password == null)
            "${quizletEndpoint}sets/$setID?client_id=$clientID"
        else
            "${quizletEndpoint}sets/$setID?client_id=$clientID/$password"
        val jsonContent = URL(jsonURL).readText()
        jsonSet = JsonSet.fromJson(jsonContent) ?: throw KotlinNullPointerException("JSON content empty at $jsonURL")
    }

    fun getID(): Int {
        return jsonSet.id
    }

    fun getURL(): String {
        return jsonSet.url
    }

    fun getTitle(): String {
        return jsonSet.title
    }

    fun getAuthor(): String {
        return jsonSet.createdBy
    }

    fun getTermCount(): Int {
        return jsonSet.termCount
    }

    // TODO: Get actual timestamps from dates
    fun getCreatedDate(): Long {
        return jsonSet.createdDate
    }

    fun getModifiedDate(): Long {
        return jsonSet.modifiedDate
    }

    fun gePublishedDate(): Long {
        return jsonSet.publishedDate
    }

    fun hasImages(): Boolean {
        return jsonSet.hasImages
    }

    // TODO: Make Kotlin types to represent visibility?
    fun getVisibility(): String {
        return jsonSet.visibility
    }

    fun getEditable(): String {
        return jsonSet.editable
    }

    fun hasAccess(): Boolean {
        return jsonSet.hasAccess
    }

    fun canEdit(): Boolean {
        return jsonSet.canEdit
    }

    fun getDescription(): String {
        return jsonSet.description
    }

    // TODO: Make return language type?
    fun getTermLanguage(): String {
        return jsonSet.langTerms
    }

    fun getDefinitionLanguage(): String {
        return jsonSet.langDefinitions
    }

    fun getTerms(): List<String> {
        val list = mutableListOf<String>()
        jsonSet.terms.forEach {
            list += it.term
        }
        return list
    }

    fun getDefinitions(): List<String> {
        val list = mutableListOf<String>()
        jsonSet.terms.forEach {
            list += it.definition
        }
        return list
    }

    fun getTermMap(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        val terms = getTerms()
        val definitions = getDefinitions()
        for (i in 0 until jsonSet.termCount) {
            map[terms[i]] = definitions[i]
        }
        return map
    }
}
