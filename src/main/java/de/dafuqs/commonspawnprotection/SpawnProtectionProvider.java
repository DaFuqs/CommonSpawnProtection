package de.dafuqs.commonspawnprotection;

import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class SpawnProtectionProvider extends PermissionBypassedProtectionProvider {
	
	@Override
	public boolean isProtected(World world, BlockPos pos) {
		int spawnRadius = world.getGameRules().getInt(GameRules.SPAWN_RADIUS);
		BlockPos spawnPos = world.getSpawnPos();
		return Math.abs(pos.getX() - spawnPos.getX()) < spawnRadius && Math.abs(pos.getZ() - spawnPos.getZ()) < spawnRadius;
	}
	
}
