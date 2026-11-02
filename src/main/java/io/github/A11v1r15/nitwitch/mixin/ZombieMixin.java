package io.github.A11v1r15.nitwitch.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Zombie.class)
public class ZombieMixin {

	@WrapOperation(
		method = "killedEntity",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/entity/npc/Villager;convertTo(Lnet/minecraft/world/entity/EntityType;Z)Lnet/minecraft/world/entity/Mob;"
		)
	)
	private net.minecraft.world.entity.Mob stopNitwitchConversion(
		Villager villager, EntityType entityType, boolean b, Operation<Mob> original
	) {
		if (villager instanceof TheNitwitch) {
			return null;
		}
		return original.call(villager, entityType, b);
	}
}
