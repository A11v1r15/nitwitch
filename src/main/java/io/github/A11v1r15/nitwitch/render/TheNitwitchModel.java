package io.github.A11v1r15.nitwitch.render;

import io.github.A11v1r15.nitwitch.mobs.TheNitwitch;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.WitchModel;
import net.minecraft.client.model.geom.ModelPart;

@Environment(EnvType.CLIENT)
public class TheNitwitchModel<T extends TheNitwitch> extends WitchModel<TheNitwitch> {
	public TheNitwitchModel(ModelPart modelPart) {
		super(modelPart);
	}
}
