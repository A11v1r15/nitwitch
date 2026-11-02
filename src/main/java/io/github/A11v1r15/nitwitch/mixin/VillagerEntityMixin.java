package io.github.A11v1r15.nitwitch.mixin;

import io.github.A11v1r15.nitwitch.NitwitchModEntityTypes;
import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.gossip.GossipContainer;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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

	@Inject(method = "thunderHit(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LightningBolt;)V", at = @At("HEAD"), cancellable = true)
	private void nitwitch$changeThunderHit(ServerLevel serverLevel, LightningBolt lightningBolt, CallbackInfo ci) {
		VillagerProfession profession = this.getVillagerData().getProfession();
		TheNitwitch nitwitch = null;
		if (profession.equals(VillagerProfession.NITWIT)) {
			nitwitch = NitwitchModEntityTypes.NITWITCH.create(serverLevel);
		}
		if (nitwitch != null) {
			LOGGER.info("Villager {} was struck by lightning {}.", this, lightningBolt);
			nitwitch.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
			nitwitch.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(nitwitch.blockPosition()), MobSpawnType.CONVERSION, (SpawnGroupData)null);
			nitwitch.setNoAi(this.isNoAi());
			if (this.hasCustomName()) {
				nitwitch.setCustomName(this.getCustomName());
				nitwitch.setCustomNameVisible(this.isCustomNameVisible());
			}
			nitwitch.setPersistenceRequired();
			serverLevel.addFreshEntityWithPassengers(nitwitch);
			nitwitch.setVillagerData(this.getVillagerData());
			nitwitch.setGossips((Tag)this.getGossips().store(NbtOps.INSTANCE));

			this.releaseAllPois();
			this.discard();
			ci.cancel();
		}
	}
}

