package api

const val quizletEndpoint = "https://api.quizlet.com/2.0/"

class Kwizlet(private val clientID: String) {
    fun getSet(setID: String): Set {
        return Set(clientID, setID)
    }
}
