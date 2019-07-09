package io.github.potatocurry.kwizlet.json

import com.beust.klaxon.*

private val klaxon = Klaxon()

internal data class JsonSearch (
    @Json(name = "total_results")
    val totalResults: Int,

    @Json(name = "total_pages")
    val totalPages: Int,

    val page: Int,

    @Json(name = "image_set_count")
    val imageSetCount: Int,

    @Json(name = "sets")
    val searchSets: List<JsonSearchSet>
) {
    companion object {
        fun fromJson(json: String) = klaxon.parse<JsonSearch>(json)
    }
}

data class JsonSearchSet (
    val id: Int,
    val url: String,
    val title: String,

    @Json(name = "created_by")
    val createdBy: String,

    @Json(name = "term_count")
    val termCount: Int,

    @Json(name = "created_date")
    val createdDate: Long,

    @Json(name = "modified_date")
    val modifiedDate: Long,

    @Json(name = "published_date")
    val publishedDate: Long,

    @Json(name = "has_images")
    val hasImages: Boolean,

    val subjects: List<Any?>,
    val visibility: String,
    val editable: String,

    @Json(name = "has_access")
    val hasAccess: Boolean,

    @Json(name = "can_edit")
    val canEdit: Boolean,

    val description: String,

    @Json(name = "lang_terms")
    val langTerms: String,

    @Json(name = "lang_definitions")
    val langDefinitions: String,

    @Json(name = "password_use")
    val passwordUse: Long,

    @Json(name = "password_edit")
    val passwordEdit: Int,

    @Json(name = "access_type")
    val accessType: Int,

    @Json(name = "creator_id")
    val creatorID: Int
)
