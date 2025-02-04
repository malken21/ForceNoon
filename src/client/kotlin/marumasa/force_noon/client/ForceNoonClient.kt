package marumasa.force_noon.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents

class ForceNoonClient : ClientModInitializer {

    private val time = 6000L

    override fun onInitializeClient() {
        WorldRenderEvents.START.register { client ->
            client.world()?.let { world ->
                // クライアント側のワールドの時間を変更
                world.time = time
                world.timeOfDay = time
            }
        }
    }
}
