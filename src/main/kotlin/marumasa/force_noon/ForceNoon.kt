package marumasa.force_noon

import com.mojang.logging.LogUtils
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger

class ForceNoon : ModInitializer {

    override fun onInitialize() {
        LOGGER.info("Start: $MOD_ID")
    }

    companion object {
        val LOGGER: Logger = LogUtils.getLogger()
        const val MOD_ID: String = "force_noon"
        val CONFIG: Config = Config()
    }
}
