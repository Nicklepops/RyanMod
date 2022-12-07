
package net.mcreator.theryanmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import net.mcreator.theryanmod.TheryanmodModElements;

@TheryanmodModElements.ModElement.Tag
public class ItalianSausageItem extends TheryanmodModElements.ModElement {
	@ObjectHolder("theryanmod:italian_sausage")
	public static final Item block = null;

	public ItalianSausageItem(TheryanmodModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).isImmuneToFire().rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(8).saturation(0.3f).setAlwaysEdible().meat().build()));
			setRegistryName("italian_sausage");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
