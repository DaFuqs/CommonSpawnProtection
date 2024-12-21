package de.dafuqs.commonspawnprotection;

import net.minecraft.server.world.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class SpawnProtectionProvider extends PermissionBypassedProtectionProvider {
	
	@Override
	public boolean isProtected(World world, BlockPos pos) {
		if(world instanceof ServerWorld serverWorld) {
			int spawnRadius = serverWorld.getGameRules().getInt(GameRules.SPAWN_RADIUS);
			BlockPos spawnPos = world.getSpawnPos();
			return Math.abs(pos.getX() - spawnPos.getX()) < spawnRadius && Math.abs(pos.getZ() - spawnPos.getZ()) < spawnRadius;
		}
		return false;
	}
	
}
