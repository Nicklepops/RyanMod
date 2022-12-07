// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelcar extends ModelBase {
	private final ModelRenderer bb_main;

	public Modelcar() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 73, -16.0F, -5.0F, -24.0F, 32, 1, 48, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 102, 52, -15.0F, -4.0F, -21.0F, 5, 4, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 102, 52, 10.0F, -4.0F, -21.0F, 5, 4, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 102, 52, -15.0F, -4.0F, 13.0F, 5, 4, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 102, 52, 10.0F, -4.0F, 13.0F, 5, 4, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 15.0F, -15.0F, -24.0F, 1, 10, 48, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 16.0F, -11.0F, -23.0F, 1, 7, 12, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -17.0F, -11.0F, -23.0F, 1, 7, 12, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 16.0F, -11.0F, 11.0F, 1, 7, 12, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -17.0F, -11.0F, 11.0F, 1, 7, 12, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -16.0F, -15.0F, -24.0F, 1, 10, 48, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 60, -10.0F, -14.0F, -25.0F, 20, 9, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 60, -0.5F, -16.0F, -24.0F, 1, 1, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 52, 61, -10.0F, -5.0F, 22.0F, 2, 2, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 52, 61, 8.0F, -5.0F, 22.0F, 2, 2, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 118, 123, -15.0F, -14.0F, -25.0F, 4, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 110, -15.0F, -9.0F, -25.0F, 4, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 118, 123, 11.0F, -14.0F, -25.0F, 4, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 110, 11.0F, -9.0F, -25.0F, 4, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -15.0F, -15.0F, -24.0F, 30, 10, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -15.0F, -15.0F, 8.0F, 30, 10, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 81, 62, 12.0F, -14.0F, 24.0F, 3, 5, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 81, 62, -15.0F, -14.0F, 24.0F, 3, 5, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 61, -3.0F, -7.0F, 24.0F, 6, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 110, -15.0F, -8.0F, 24.0F, 3, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 110, 12.0F, -8.0F, 24.0F, 3, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 123, -15.0F, -20.0F, -9.0F, 30, 5, 0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}