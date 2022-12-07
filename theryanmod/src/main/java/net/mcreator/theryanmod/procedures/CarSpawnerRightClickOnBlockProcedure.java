package net.mcreator.theryanmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.theryanmod.entity.CarEntity;
import net.mcreator.theryanmod.TheryanmodMod;

import java.util.Map;

public class CarSpawnerRightClickOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency world for procedure CarSpawnerRightClickOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency x for procedure CarSpawnerRightClickOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency y for procedure CarSpawnerRightClickOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency z for procedure CarSpawnerRightClickOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == Blocks.AIR
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new CarEntity.CustomEntity(CarEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y + 1, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.work_toolsmith")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, (y + 1), z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.work_toolsmith")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
