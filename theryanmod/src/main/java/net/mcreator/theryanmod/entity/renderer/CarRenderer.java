
package net.mcreator.theryanmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.theryanmod.entity.CarEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CarRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CarEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcar(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theryanmod:textures/entities/car.png");
					}
				};
			});
		}
	}

	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelcar extends EntityModel<Entity> {
		private final ModelRenderer bb_main;

		public Modelcar() {
			textureWidth = 128;
			textureHeight = 128;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			addBoxHelper(bb_main, 0, 73, -16.0F, -5.0F, -24.0F, 32, 1, 48, 0.0F, false);
			addBoxHelper(bb_main, 102, 52, -15.0F, -4.0F, -21.0F, 5, 4, 8, 0.0F, false);
			addBoxHelper(bb_main, 102, 52, 10.0F, -4.0F, -21.0F, 5, 4, 8, 0.0F, false);
			addBoxHelper(bb_main, 102, 52, -15.0F, -4.0F, 13.0F, 5, 4, 8, 0.0F, false);
			addBoxHelper(bb_main, 102, 52, 10.0F, -4.0F, 13.0F, 5, 4, 8, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, 15.0F, -15.0F, -24.0F, 1, 10, 48, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, 16.0F, -11.0F, -23.0F, 1, 7, 12, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, -17.0F, -11.0F, -23.0F, 1, 7, 12, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, 16.0F, -11.0F, 11.0F, 1, 7, 12, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, -17.0F, -11.0F, 11.0F, 1, 7, 12, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, -16.0F, -15.0F, -24.0F, 1, 10, 48, 0.0F, false);
			addBoxHelper(bb_main, 0, 60, -10.0F, -14.0F, -25.0F, 20, 9, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 60, -0.5F, -16.0F, -24.0F, 1, 1, 3, 0.0F, false);
			addBoxHelper(bb_main, 52, 61, -10.0F, -5.0F, 22.0F, 2, 2, 3, 0.0F, false);
			addBoxHelper(bb_main, 52, 61, 8.0F, -5.0F, 22.0F, 2, 2, 3, 0.0F, false);
			addBoxHelper(bb_main, 118, 123, -15.0F, -14.0F, -25.0F, 4, 4, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 110, -15.0F, -9.0F, -25.0F, 4, 2, 1, 0.0F, false);
			addBoxHelper(bb_main, 118, 123, 11.0F, -14.0F, -25.0F, 4, 4, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 110, 11.0F, -9.0F, -25.0F, 4, 2, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, -15.0F, -15.0F, -24.0F, 30, 10, 16, 0.0F, false);
			addBoxHelper(bb_main, 0, 0, -15.0F, -15.0F, 8.0F, 30, 10, 16, 0.0F, false);
			addBoxHelper(bb_main, 81, 62, 12.0F, -14.0F, 24.0F, 3, 5, 1, 0.0F, false);
			addBoxHelper(bb_main, 81, 62, -15.0F, -14.0F, 24.0F, 3, 5, 1, 0.0F, false);
			addBoxHelper(bb_main, 22, 61, -3.0F, -7.0F, 24.0F, 6, 3, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 110, -15.0F, -8.0F, 24.0F, 3, 2, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 110, 12.0F, -8.0F, 24.0F, 3, 2, 1, 0.0F, false);
			addBoxHelper(bb_main, 0, 123, -15.0F, -20.0F, -9.0F, 30, 5, 0, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			bb_main.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

		}
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
