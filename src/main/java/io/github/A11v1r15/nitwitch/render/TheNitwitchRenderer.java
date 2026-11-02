package io.github.A11v1r15.nitwitch.render;

import io.github.A11v1r15.nitwitch.Nitwitch;
import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

@Environment(EnvType.CLIENT)
public class TheNitwitchRenderer<T extends TheNitwitch> extends MobRenderer {
	private static final ResourceLocation NITWITCH_LOCATION = Nitwitch.id("textures/entity/nitwitch.png");

	public TheNitwitchRenderer(EntityRendererProvider.Context context) {
		super(context, new TheNitwitchModel(context.bakeLayer(ModelLayers.WITCH)), 0.5F);
		this.addLayer(new CustomHeadLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new CrossedArmsItemLayer(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Entity entity)  {
		return NITWITCH_LOCATION;
	}
}
