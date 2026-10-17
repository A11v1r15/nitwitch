package io.github.A11v1r15.nitwitch.mixin;

import io.github.A11v1r15.nitwitch.NitwitchModEntityTypeIds;
import io.github.A11v1r15.nitwitch.NitwitchModEntityTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(Villager.class)
public abstract class VillagerEntityMixin {

	@Shadow
	public abstract VillagerData getVillagerData();

	@ModifyVariable(method = "thunderHit(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LightningBolt;)V", at = @At("STORE"), ordinal = 0)
		private Witch nitwitch$changeThunderHit(Witch x, ServerLevel serverLevel, LightningBolt lightningBolt) {
			VillagerProfession profession = this.getVillagerData().getProfession();
		if (profession.equals(VillagerProfession.NITWIT))
			x = NitwitchModEntityTypes.NITWITCH.create(serverLevel);
			//x.setCustomName(Component.literal("This used to be a " + profession.name()));
			return x;
		}
}

