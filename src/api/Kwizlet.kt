package io.github.potatocurry.kwizlet.api

import java.net.URL

internal const val quizletEndpoint = "https://api.quizlet.com/2.0"

class Kwizlet(private val clientID: String) {
    /** Returns a [Set] by [setID] with an optional [password]. */
    fun getSet(setID: String, password: String? = null): Set { // TODO: Make variable arguments or array? TODO: Make term only version?
        return Set(clientID, setID, password)
    }

    /** Returns a [Set] by [setURL] with an optional [password]. */
    fun getSet(setURL: URL, password: String? = null): Set { // TODO: Make variable arguments or array? TODO: Make term only version?
        return getSet(parseURL(setURL), password)
    }

    /** Returns the ID of the [Set] the [url] refers to. */
    fun parseURL(url: URL): String {
        val path = url.path.split("/")
        return path.first(String::isNotEmpty)
    }

    fun search(query: String): Search { // TODO: Make solution using multiple pages to allow for unrestricted max results parameter
        return Search(clientID, query.replace(" ", "+"))
    }
}

///** Returns a [List] of [Set]s resulting from searching with the given [query]. */
