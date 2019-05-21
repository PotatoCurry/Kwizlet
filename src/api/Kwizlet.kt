package io.github.potatocurry.kwizlet.api

import java.net.URL

internal const val quizletEndpoint = "https://api.quizlet.com/2.0"

class Kwizlet(private val clientID: String) {
    /** Returns a [Set] by [setID] with an optional [password]. */
    fun getSet(setID: String, password: String? = null): Set {
        return Set(clientID, setID, password)
    }

    /**
     * Returns the ID of the [Set] the [url] refers to.
     * Often coupled with [getSet].
     * */
    fun parseURL(url: String): String {
        val path = URL(url).path.split("/")
        return path.first(String::isNotEmpty)
    }
}
