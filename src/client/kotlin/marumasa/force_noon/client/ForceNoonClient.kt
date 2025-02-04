package marumasa.force_noon.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents

class ForceNoonClient : ClientModInitializer {

    override fun onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register { client ->
            client.world?.let { world ->
                // クライアント側のワールドの時間を変更
                world.timeOfDay = 6000L
            }
        }
    }
}
