package io.github.potatocurry.json

import com.beust.klaxon.*

private val klaxon = Klaxon()

internal data class JsonSet (
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
    val creatorID: Int,

    val creator: JsonCreator,

    @Json(name = "class_ids")
    val classIDS: List<Long>,

    val terms: List<JsonTerm>
) {
    companion object {
        fun fromJson(json: String) = klaxon.parse<JsonSet>(json)
    }
}

internal data class JsonCreator (
    val username: String,

    @Json(name = "account_type")
    val accountType: String,

    @Json(name = "profile_image")
    val profileImage: String,

    val id: Long
)

internal data class JsonTerm (
    val id: Long,
    val term: String,
    val definition: String,
    val image: Any? = null,
    val rank: Int
)
