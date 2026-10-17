package io.github.A11v1r15.nitwitch;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class NitwitchModEntityTypeIds {
	public static ResourceKey<EntityType<?>> NITWITCH = create("nitwitch");

	private static ResourceKey<EntityType<?>> create(String name) {
		return ResourceKey.create(Registries.ENTITY_TYPE, Nitwitch.id(name));
	}
}
