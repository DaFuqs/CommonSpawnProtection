package de.dafuqs.commonspawnprotection;

import eu.pb4.common.protection.api.*;
import net.fabricmc.api.*;
import net.minecraft.util.*;

public class CommonSpawnProtection implements ModInitializer {
	
	public static final String MOD_ID = "common_spawn_protection";
	public static Identifier locate(String name) {
		return new Identifier(MOD_ID, name);
	}
	
	@Override
	public void onInitialize() {
		CommonProtection.register(locate("spawn"), new SpawnProtectionProvider());
		CommonProtection.register(locate("end_portal"), new EndPortalProtectionProvider());
	}
	
}
