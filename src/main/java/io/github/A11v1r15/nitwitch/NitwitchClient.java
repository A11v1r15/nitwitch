package io.github.A11v1r15.nitwitch;

import io.github.A11v1r15.nitwitch.render.TheNitwitchRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class NitwitchClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(
			NitwitchModEntityTypes.NITWITCH,
			TheNitwitchRenderer::new
		);
	}
}
