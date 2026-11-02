package io.github.A11v1r15.nitwitch.mixin;

import io.github.A11v1r15.nitwitch.NitwitchModEntityTypes;
import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.gossip.GossipContainer;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static io.github.A11v1r15.nitwitch.Nitwitch.LOGGER;


@Mixin(Villager.class)
public abstract class VillagerEntityMixin extends AbstractVillager {

	public VillagerEntityMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
		super(entityType, level);
	}

	@Shadow
	public abstract VillagerData getVillagerData();
	@Shadow
	private void releaseAllPois() {};
	@Shadow
	private GossipContainer getGossips() {return null;};

	@Override
	public void thunderHit(ServerLevel serverLevel, LightningBolt lightningBolt) {
		PathfinderMob witch = null;
		VillagerProfession profession = this.getVillagerData().getProfession();
		if (profession.equals(VillagerProfession.NITWIT)) {
			witch = NitwitchModEntityTypes.NITWITCH.create(serverLevel);
		} else if (serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
			witch = EntityType.WITCH.create(serverLevel);
		}
		if (witch != null) {
			LOGGER.info("Villager {} was struck by lightning {}.", this, lightningBolt);
			witch.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
			witch.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(witch.blockPosition()), MobSpawnType.CONVERSION, (SpawnGroupData)null);
			witch.setNoAi(this.isNoAi());
			if (this.hasCustomName()) {
				witch.setCustomName(this.getCustomName());
				witch.setCustomNameVisible(this.isCustomNameVisible());
			}
			witch.setPersistenceRequired();
			serverLevel.addFreshEntityWithPassengers(witch);

			if (witch instanceof TheNitwitch nitwitch){
				nitwitch.setVillagerData(this.getVillagerData());
				nitwitch.setGossips((Tag)this.getGossips().store(NbtOps.INSTANCE));
			}

			this.releaseAllPois();
			this.discard();
		} else {
			super.thunderHit(serverLevel, lightningBolt);
		}
	}
}

