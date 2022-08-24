package libraries.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder

internal const val apiDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
val gsonDefault: Gson = GsonBuilder()
    .setDateFormat(apiDateFormat)
    .create()