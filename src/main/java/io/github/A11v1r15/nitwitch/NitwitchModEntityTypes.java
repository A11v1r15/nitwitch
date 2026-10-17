package io.github.A11v1r15.nitwitch;

import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class NitwitchModEntityTypes {
	public static final EntityType<TheNitwitch> NITWITCH = register(
		NitwitchModEntityTypeIds.NITWITCH,
		EntityType.Builder.<TheNitwitch>of(TheNitwitch::new, MobCategory.MISC)
			.sized(0.75f, 1.75f)
	);

	private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(String.valueOf(key)));
	}

	public static void registerModEntityTypes() {
		Nitwitch.LOGGER.info("Registering EntityTypes for " + Nitwitch.ID);
	}

	public static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(NITWITCH, TheNitwitch.createAttributes());
	}
}
