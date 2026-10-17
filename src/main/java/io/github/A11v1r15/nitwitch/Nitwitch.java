package io.github.A11v1r15.nitwitch;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nitwitch implements ModInitializer {
	public static final String ID = "nitwitch";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Nitwitch] good vibes entered the chat");
	}
}
