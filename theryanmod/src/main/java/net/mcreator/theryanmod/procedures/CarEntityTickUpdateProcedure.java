package net.mcreator.theryanmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.theryanmod.TheryanmodMod;

import java.util.Map;

public class CarEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency world for procedure CarEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency x for procedure CarEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency y for procedure CarEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency z for procedure CarEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency entity for procedure CarEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 0.05));
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 5) {
			if (entity.getPersistentData().getDouble("timer") >= 1) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), (z - 1), (int) 1, 0, 0.1, 0, 0.01);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, x, (y + 1), (z - 1), (int) 1, 0, 0.1, 0, 0.01);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, (y + 1), (z - 1), (int) 1, 0, 0.1, 0, 0.01);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y + 1, z - 1),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, (y + 1), (z - 1),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y + 1, z - 1),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, (y + 1), (z - 1),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				entity.getPersistentData().putDouble("timer", 0);
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 10) {
			if (entity.getPersistentData().getDouble("timer") >= 1.5) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), (z - 1), (int) 1, 0, 0.1, 0, 0.01);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, x, (y + 1), (z - 1), (int) 1, 0, 0.1, 0, 0.01);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y + 1, z - 1),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, (y + 1), (z - 1),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				entity.getPersistentData().putDouble("timer", 0);
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 15) {
			if (entity.getPersistentData().getDouble("timer") >= 2) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), (z - 1), (int) 1, 0, 0.1, 0, 0.01);
				}
				entity.getPersistentData().putDouble("timer", 0);
			}
		}
	}
}
