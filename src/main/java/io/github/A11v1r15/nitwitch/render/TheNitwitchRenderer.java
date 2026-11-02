package io.github.A11v1r15.nitwitch.render;

import io.github.A11v1r15.nitwitch.Nitwitch;
import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.WitchRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class TheNitwitchRenderer<T extends TheNitwitch> extends VillagerRenderer {
	private static final ResourceLocation NITWITCH_LOCATION = Nitwitch.id("textures/entity/nitwitch.png");

	public TheNitwitchRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(Villager entity) {
		return NITWITCH_LOCATION;
	}
}
