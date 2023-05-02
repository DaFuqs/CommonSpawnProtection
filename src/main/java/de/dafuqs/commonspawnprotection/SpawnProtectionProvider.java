package de.dafuqs.commonspawnprotection;

import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class SpawnProtectionProvider extends PermissionBypassedProtectionProvider {
	
	@Override
	public boolean isProtected(World world, BlockPos pos) {
		return pos.isWithinDistance(world.getSpawnPos(), world.getGameRules().getInt(GameRules.SPAWN_RADIUS));
	}
	
}
