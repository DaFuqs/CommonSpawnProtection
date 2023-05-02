package de.dafuqs.commonspawnprotection;

import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EndPortalProtectionProvider extends PermissionBypassedProtectionProvider {
	
	@Override
	public boolean isProtected(World world, BlockPos pos) {
		return world.getRegistryKey().equals(World.END)
				&& Math.abs(pos.getX()) < 16 && Math.abs(pos.getZ()) < 16
				&& world.getBlockState(pos).isOf(Blocks.BEDROCK);
	}
	
}
