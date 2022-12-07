package net.mcreator.theryanmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.theryanmod.TheryanmodMod;

import java.util.Map;

public class RyanItIsStruckByLightningProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency entity for procedure RyanItIsStruckByLightning!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1);
	}
}
