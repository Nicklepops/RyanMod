
package net.mcreator.theryanmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.theryanmod.TheryanmodModElements;

@TheryanmodModElements.ModElement.Tag
public class MusmonkeyItem extends TheryanmodModElements.ModElement {
	@ObjectHolder("theryanmod:musmonkey")
	public static final Item block = null;

	public MusmonkeyItem(TheryanmodModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TheryanmodModElements.sounds.get(new ResourceLocation("theryanmod:mus_monkey")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("musmonkey");
		}
	}
}
