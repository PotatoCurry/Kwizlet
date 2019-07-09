package io.github.potatocurry.kwizlet.api

import io.github.potatocurry.kwizlet.json.JsonSearch
import io.github.potatocurry.kwizlet.json.JsonSearchSet
import java.net.URL

class Search internal constructor(clientID: String, query: String) {
    private val jsonSearch: JsonSearch

    val searchSets: List<SearchSet>

    init {
        val jsonURL = "$quizletEndpoint/search/sets?q=$query&client_id=$clientID"
        val jsonContent = URL(jsonURL).readText()
        jsonSearch = JsonSearch.fromJson(jsonContent) ?: throw KotlinNullPointerException("JSON content empty at $jsonURL")
        val tempSearchSets = mutableListOf<SearchSet>()
        jsonSearch.searchSets.forEach { tempSearchSets += SearchSet(it) }
        searchSets = tempSearchSets
    }

    val totalResults = jsonSearch.totalResults

    val totalPages = jsonSearch.totalPages

    val page = jsonSearch.page

    val imageSetCount = jsonSearch.imageSetCount
}

data class SearchSet internal constructor(private val jsonSearchSet: JsonSearchSet) {
    val id = jsonSearchSet.id

    val url = jsonSearchSet.url

    val title = jsonSearchSet.title

    val author = jsonSearchSet.createdBy

    val termCount = jsonSearchSet.termCount

    // TODO: Get actual timestamps from dates
    val createdDate = jsonSearchSet.createdDate

    val modifiedDate = jsonSearchSet.modifiedDate

    val publishedDate = jsonSearchSet.publishedDate

    val hasImages = jsonSearchSet.hasImages

    // TODO: Make Kotlin types to represent visibility?
    val visibility = jsonSearchSet.visibility

    val editable = jsonSearchSet.editable

    val hasAccess = jsonSearchSet.hasAccess

    val canEdit = jsonSearchSet.canEdit

    val description = jsonSearchSet.description

    val termLanguage = jsonSearchSet.langTerms

    val definitionLanguage = jsonSearchSet.langDefinitions
}
