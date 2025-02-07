package marumasa.force_noon

import com.google.gson.Gson
import marumasa.force_noon.ForceNoon.Companion.MOD_ID
import net.fabricmc.loader.api.FabricLoader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class Config {
    var time = 6000L
        set(value) {
            field = value
            serialize()
        }

    private data class JsonModel(
        val time: Long,
    )

    private fun deserialize() {
        val model = loadJSON()
        time = model.time
    }

    private fun serialize() {
        saveJSON(
            JsonModel(
                time
            )
        )
    }

    init {
        val configFile = path.toFile()
        if (!configFile.exists()) {
            serialize()
        } else {
            deserialize()
        }
    }

    companion object {
        private val path: Path = FabricLoader.getInstance().configDir.normalize().resolve(
            "$MOD_ID.json"
        )

        private val gson = Gson()

        private fun loadJSON(): JsonModel {
            try {
                Files.newBufferedReader(path).use { reader ->
                    return gson.fromJson(
                        reader,
                        JsonModel::class.java
                    )
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }

        private fun saveJSON(model: JsonModel) {
            try {
                Files.newBufferedWriter(path).use { writer ->
                    gson.toJson(model, model.javaClass, writer)
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }
}