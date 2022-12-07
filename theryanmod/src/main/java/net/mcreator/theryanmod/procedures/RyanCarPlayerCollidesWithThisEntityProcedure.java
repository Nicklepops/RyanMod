package net.mcreator.theryanmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.theryanmod.TheryanmodMod;

import java.util.Map;

public class RyanCarPlayerCollidesWithThisEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure RyanCarPlayerCollidesWithThisEntity!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity) {
			((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("ryan").setDamageBypassesArmor(), (float) 9999);
		}
	}
}
