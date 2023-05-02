package de.dafuqs.commonspawnprotection;

import com.mojang.authlib.*;
import eu.pb4.common.protection.api.*;
import net.minecraft.entity.*;
import net.minecraft.entity.decoration.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import org.jetbrains.annotations.*;

public abstract class PermissionBypassedProtectionProvider implements ProtectionProvider {
	
	@Override
	public boolean isAreaProtected(World world, Box area) {
		return false;
	}
	
	@Override
	public boolean canBreakBlock(World world, BlockPos pos, GameProfile profile, @Nullable PlayerEntity player) {
		return !isProtected(world, pos) || isPlayerWithPermissionsGreaterZero(player);
	}
	
	@Override
	public boolean canDamageEntity(World world, Entity entity, GameProfile profile, @Nullable PlayerEntity player) {
		if(entity instanceof AbstractDecorationEntity || entity instanceof ArmorStandEntity) {
			// protect modification of item frames and other decoration entities
			return !isProtected(world, entity.getBlockPos()) || isPlayerWithPermissionsGreaterZero(player);
		} else {
			return true;
		}
	}
	
	private static boolean isPlayerWithPermissionsGreaterZero(@Nullable PlayerEntity player) {
		return player != null && player.hasPermissionLevel(1);
	}
	
}
