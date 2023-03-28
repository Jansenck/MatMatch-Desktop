package Services

import io.github.cdimascio.dotenv.dotenv
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class PostUser {
    companion object {
        const val HTTP_POST = "POST"
        const val CONTENT_TYPE = "Content-Type"
        const val JSON_CONTENT_TYPE = "application/json"
        const val UTF8 = "UTF-8"
    }

    fun execute(username: String, password: String): String {
        val dotenv = dotenv()
        val apiUrl = "${dotenv["API_BASE_URL"]}/users"
        val connection = URL(apiUrl).openConnection() as HttpURLConnection

        return try {
            connection.requestMethod = HTTP_POST
            connection.setRequestProperty(CONTENT_TYPE, JSON_CONTENT_TYPE)
            connection.doOutput = true

            val jsonBody = """{"username": "$username", "password": "$password"}"""
            connection.outputStream.write(jsonBody.toByteArray(Charsets.UTF_8))

            when (connection.responseCode) {
                HttpURLConnection.HTTP_CREATED -> {
                    BufferedReader(InputStreamReader(connection.inputStream, UTF8)).use {
                        it.readText()
                    }
                }
                else -> throw IOException("Request error. HTTP: ${connection.responseCode}")
            }
        } finally {
            connection.disconnect()
        }
    }
}
