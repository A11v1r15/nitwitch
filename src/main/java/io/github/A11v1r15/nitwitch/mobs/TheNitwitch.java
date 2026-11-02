package io.github.A11v1r15.nitwitch.mobs;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TheNitwitch extends Villager {
	private boolean assignProfessionWhenSpawned = true;
	public TheNitwitch(EntityType<? extends Villager> entityType, Level level) {
		super(entityType, level);
		this.setVillagerData(this.getVillagerData().setType(VillagerType.PLAINS).setProfession(VillagerProfession.NITWIT));
	}

	@Override
	protected @NotNull Component getTypeName() {
		return Component.translatable(this.getType().getDescriptionId());
	}
}
