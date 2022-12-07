package net.mcreator.theryanmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.theryanmod.item.ScotchItem;
import net.mcreator.theryanmod.TheryanmodMod;

import java.util.Map;

public class RyanGiveScotchProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency world for procedure RyanGiveScotch!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency x for procedure RyanGiveScotch!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency y for procedure RyanGiveScotch!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency z for procedure RyanGiveScotch!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency entity for procedure RyanGiveScotch!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheryanmodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure RyanGiveScotch!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == ScotchItem.block) {
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = ((sourceentity instanceof LivingEntity)
						? ((LivingEntity) sourceentity).getHeldItemMainhand()
						: ItemStack.EMPTY);
				((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) sourceentity).container.func_234641_j_());
			}
			if (entity.isPassenger()) {/*code*/
			} else {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theryanmod:cave_ambient")),
							SoundCategory.AMBIENT, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theryanmod:cave_ambient")),
							SoundCategory.AMBIENT, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((entity.getPosX()), (entity.getPosY()), (entity.getPosZ())),
									Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
									.withFeedbackDisabled(),
							"summon theryanmod:car ~ ~ ~ {Passengers:[{id:\"theryanmod:ryan_car\"}]}");
				}
				if (!entity.world.isRemote())
					entity.remove();
			}
		}
	}
}
