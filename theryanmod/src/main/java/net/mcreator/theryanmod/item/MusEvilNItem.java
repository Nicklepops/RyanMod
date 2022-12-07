
package net.mcreator.theryanmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.theryanmod.TheryanmodModElements;

@TheryanmodModElements.ModElement.Tag
public class MusEvilNItem extends TheryanmodModElements.ModElement {
	@ObjectHolder("theryanmod:mus_evil_n")
	public static final Item block = null;

	public MusEvilNItem(TheryanmodModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TheryanmodModElements.sounds.get(new ResourceLocation("theryanmod:mus_eviln")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("mus_evil_n");
		}
	}
}
