package io.github.A11v1r15.nitwitch.render;

import io.github.A11v1r15.nitwitch.Nitwitch;
import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitchRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Witch;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class TheNitwitchRenderer<T extends TheNitwitch> extends WitchRenderer {
	private static final ResourceLocation NITWITCH_LOCATION = Nitwitch.id("textures/entity/nitwitch.png");

	public TheNitwitchRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(Witch entity) {
		return NITWITCH_LOCATION;
	}
}
