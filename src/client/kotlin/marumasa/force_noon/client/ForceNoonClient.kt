package marumasa.force_noon.client

import marumasa.force_noon.ForceNoon.Companion.CONFIG
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents
import net.minecraft.client.MinecraftClient
import net.minecraft.client.world.ClientWorld
import net.minecraft.world.GameRules


class ForceNoonClient : ClientModInitializer {


    override fun onInitializeClient() {
        WorldRenderEvents.START.register {
            MinecraftClient.getInstance().world?.let { world ->
                setTime(world, CONFIG.time)
            }
        }
        ClientTickEvents.START_WORLD_TICK.register { world ->
            setTime(world, CONFIG.time)
        }
    }

    companion object {
        fun setTime(world: ClientWorld, time: Long) {

            world.time = time
            world.timeOfDay = time

            val key: GameRules.BooleanRule = world.gameRules.get(GameRules.DO_DAYLIGHT_CYCLE)
            key.set(false, null)
        }
    }
}
