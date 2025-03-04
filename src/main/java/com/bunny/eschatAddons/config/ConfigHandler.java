package com.bunny.eschatAddons.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigHandler {

    private static Configuration config;

    // No Downtime Config
    public static boolean NoDTEnabled;
    public static int NoDTDelay;
    public static boolean NoDTHUD;
    public static int NoDTHUD_X;
    public static int NoDTHUD_Y;

    // --------------------------------------------------------------

    // Party Commands

    public static boolean PartyCommandsEnabled;
    public static boolean PartyInvEnabled;

    public static void loadConfig(File file) {
        config = new Configuration(file);

        try {
            config.load();
        } catch (Exception e) {
            System.err.println("Failed to load configuration file: " + file.getName());
            e.printStackTrace();
        }

        // No DT

        NoDTEnabled = config.get("NoDT", "Enabled", false, "Is No Downtime Enabled?").getBoolean();
        NoDTDelay = config.get("NoDT", "Delay", 0, "How long is the delay before entering a new run?").getInt();
        NoDTHUD = config.get("NoDT", "HUD", false, "No Downtime Enabled/Disabled HUD").getBoolean();
        NoDTHUD_X = config.get("NoDT", "X_Position", 50, "The X position of the NoDT HUD").getInt();
        NoDTHUD_Y = config.get("NoDT", "Y_Position", 50, "The Y position of the NoDT HUD").getInt();

        // -----------------------------------------------------------------

        // Party Commands

        PartyCommandsEnabled = config.get("PartyCommands", "Enabled", false, "Are the party commands Enabled?").getBoolean();
        PartyInvEnabled = config.get("PartyCommands", "InvEnabled", false, "Is !inv enabled?").getBoolean();
    }

    public static void saveConfig() {
        if (config == null) {
            System.err.println("Config not initialized. Call loadConfig() first.");
            return;
        }

        // ---------------------------------------------------------------------

        // NoDT

        config.get("NoDT", "Enabled", NoDTEnabled, "Is No Downtime Enabled?").set(NoDTEnabled);
        config.get("NoDT", "Delay", NoDTDelay, "How long is the delay before entering a new run?").set(NoDTDelay);
        config.get("NoDT", "HUD", NoDTHUD, "No Downtime Enabled/Disabled HUD").set(NoDTHUD);
        config.get("NoDT", "X_Position", NoDTHUD_X, "The X position of the NoDT HUD").set(NoDTHUD_X);
        config.get("NoDT", "Y_Position", NoDTHUD_Y, "The Y position of the NoDT HUD").set(NoDTHUD_Y);

        // ---------------------------------------------------------------------

        // Party Commands

        config.get("PartyCommands", "Enabled", false, "Are the party commands Enabled?").set(PartyCommandsEnabled);
        config.get("PartyCommands", "InvEnabled", false, "Is !inv enabled?").set(PartyInvEnabled);

        // Force writing the changes
        config.save();
        System.out.println("Configuration saved successfully.");
    }
}
