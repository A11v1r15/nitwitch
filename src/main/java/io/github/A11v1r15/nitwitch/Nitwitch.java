package io.github.A11v1r15.nitwitch;

import io.github.A11v1r15.nitwitch.render.TheNitwitchRenderer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nitwitch implements ModInitializer {
	public static final String ID = "nitwitch";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
		NitwitchModEntityTypes.registerModEntityTypes();
		NitwitchModEntityTypes.registerAttributes();
		LOGGER.info("[Nitwitch] Good vibes entered the chat");

	}

	public static ResourceLocation id(String name) {
		return ResourceLocation.fromNamespaceAndPath(ID, name);
	}
}
