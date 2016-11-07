package com.gsgdx.desktop;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.gsgdx.Gameserver;

public class ServerLauncher {
	public static void main (String[] arg) {
		HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
		new HeadlessApplication(new Gameserver(), config);
	}
}
