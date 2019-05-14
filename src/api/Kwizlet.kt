package io.github.potatocurry.kwizlet.api

internal const val quizletEndpoint = "https://api.quizlet.com/2.0"

class Kwizlet(private val clientID: String) {
    fun getSet(setID: String, password: String? = null): Set {
        return Set(clientID, setID, password)
    }
}
