package me.Batsed.WorldTp;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class language {
	
	Command cmd;
	String[] args;
	static Player p;
	
	
	public language(Command cmd, String[] args, Player p) {
		this.cmd = cmd;
		this.args = args;
		Config.p = p;
	} 	
	static String normal = "language.normal.";
	static String help = "language.Help.";
	static String error = "language.error.";
    protected static FileConfiguration Lconfiguration;
    protected static File file;

    public language(File file) {

        language.file = file;
        Lconfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {

        return Lconfiguration;
    }

    public Object get(String path) {

        if (Lconfiguration.isBoolean(path)) {
            return Lconfiguration.getBoolean(path);
        } else if (Lconfiguration.isDouble(path)) {
            return Lconfiguration.getDouble(path);
        } else if (Lconfiguration.isInt(path)) {
            return Lconfiguration.getInt(path);
        } else if (Lconfiguration.isItemStack(path)) {
            return Lconfiguration.getItemStack(path);
        } else if (Lconfiguration.isList(path)) {
            return Lconfiguration.getList(path);
        } else if (Lconfiguration.isLong(path)) {
            return Lconfiguration.getLong(path);
        } else if (Lconfiguration.isOfflinePlayer(path)) {
            return Lconfiguration.getOfflinePlayer(path);
        } else if (Lconfiguration.isString(path)) {
            return Lconfiguration.getString(path);
        } else if (Lconfiguration.isVector(path)) {
            return Lconfiguration.getVector(path);
        } else {
            return Lconfiguration.get(path);
        }
    }

    public void set(String path, Object value) {

    	Lconfiguration.set(path, value);
    }

    public static void save() {

        try {
            Lconfiguration.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

	protected static void addDefault(String path, Object value) {

        if (!Lconfiguration.contains(path)) {
            Lconfiguration.set(path, value);
        }
    }
    public void setDefaults() {
    	
		//language
		String path1 = "language.normal.Wt";
		addDefault(path1, "You have teleported");
		String path2 = "language.normal.Leave";
		addDefault(path2, "You have teleported back to your old position");
		String path3 = "language.normal.Setspawnpoint";
		addDefault(path3, "You have set the spawn point");
		String path17 = "language.normal.BlockLeave";
		addDefault(path17, "Leave is not activated for this warp");
		String path4 = "language.normal.Setspawnpoint2";
		addDefault(path4, "Saved");
		String path16 = "language.normal.info";
		addDefault(path16, "in gamemode");
		String path23 = "language.normal.NoError";
		addDefault(path23, "No errors found");
		String path32 = "language.normal.ConfigReload";
		addDefault(path32, "Config updated");
		String path38 = "language.normal.SearchErrors";
		addDefault(path38, "searching for errors in warp:");
		String path44 = "language.normal.SpawnInfo";
		addDefault(path44, "searching for information in warp:");
		String path45 = "language.normal.WarpDeleted";
		addDefault(path45, "This warp has been deleted");
		String path46 = "language.normal.deleted";
		addDefault(path46, "deleted");

		//errors
		String path9 = "language.error.NoArgument";
		addDefault(path9, "Not enough arguments");
		String path10 = "language.error.TooManyArgument";
		addDefault(path10, "Too many arguments");
		String path11 = "language.error.NoWarpPoint";
		addDefault(path11, "Warp point doesn't exist");
		String path12 = "language.error.error";
		addDefault(path12, "Your input is not correct");
		String path13 = "language.error.ConfigError";
		addDefault(path13, "WorldTp config contains an error");
		String path14 = "language.error.GamemodeCreativeError";
		addDefault(path14, "has an error at GamemodeCreative");
		String path15 = "language.error.SaveInventoryError";
		addDefault(path15, "has a config error at SaveInventory");
		String path18 = "language.error.ClearInventoryError";
		addDefault(path18, "has a config error at ClearInventory");
		String path19 = "language.error.activateCommandInvbackError";
		addDefault(path19, "has a config error at activateCommandInvback");
		String path22 = "language.error.TeleportToAnOtherWarp";
		addDefault(path22, "has a config error at TeleportToAnOtherWarp");
		String path20 = "language.error.noPremmissions";
		addDefault(path20, "You don't have the rights to do that");
		String path24 = "language.error.BlockInvback";
		addDefault(path24, "The command '/leave' has been deactivated for this spawn after the use of '/invback'");
		String path25 = "language.error.DoubleWarp";
		addDefault(path25, "You can only warp back once");
		String path26 = "language.error.InvbackFalse";
		addDefault(path26, "The command 'invback' is disabled for this spawn point");
		String path27 = "language.error.DoubleInv";
		addDefault(path27, "Command '/invback' has already been used");
		String path28 = "language.error.BlockCommand";
		addDefault(path28, "This command is not allowed for this spawn");
		String path29 = "language.error.WarpName";
		addDefault(path29, "This name is not allowed as warp name");
		String path30 = "language.error.DoubleWarpTp";
		addDefault(path30, "Warping multiple times is not allowed");
		String path31 = "language.error.NoWarp";
		addDefault(path31, "No warps available");
		String path33 = "language.error.ClearInvByCommanderror";
		addDefault(path33, "has a config error at ClearInvByCommand");
		String path37 = "language.error.WarpError";
		addDefault(path37, "contains an error. Please contact an administrator");
		String path39 = "language.error.loadInvByCommandLeaveerror";
		addDefault(path39, "has a config error at loadInvByCommandLeave.");
		String path40 = "language.error.ClearInvByCommanderror";
		addDefault(path40, "has a config error at ClearInvByCommand.");
		String path41 = "language.error.activateCommandLeave";
		addDefault(path41, "has a config error at activateCommandLeave");	
		String path47 = "language.error.BlockMisspelling";
		addDefault(path47, "is not a valid input");
		String path51 = "language.error.FoundNoInventory";
		addDefault(path51, "No inventory found");
		String path52 = "language.error.NoLeavePoint";
		addDefault(path52, "No Leavepoint available");
		String path53 = "language.error.NoPoint";
		addDefault(path53, "does not exist");
		
		//help
		String path5 = "language.Help.Setspawnpoint";
		addDefault(path5, "Sets the spawn point that you reach with the '/wt' command");
		String path6 = "language.Help.Wt";
		addDefault(path6, "With this you port yourself to a spawn point");
		String path7 = "language.Help.Leave";
		addDefault(path7, "With this you return to your former location");
		String path8 = "language.Help.WorldTp";
		addDefault(path8, "WorldTp help");
		String path21 = "language.Help.Invback";
		addDefault(path21, "Returns your inventory");
		String path34 = "language.Help.WtInfo";
		addDefault(path34, "Shows information about your spawn");
		String path35 = "language.Help.WtList";
		addDefault(path35, "Shows available warps");
		String path36 = "language.Help.WtFinderror";
		addDefault(path36, "Looks for config errors");
		String path48 = "language.Help.ClearInv";
		addDefault(path48, "Empties the players inventory");
		String path49 = "language.Help.WtReload";
		addDefault(path49, "Reloads the Config");
		String path50 = "language.Help.WtDelete";
		addDefault(path50, "Deletes the desired spawn");
		language.save();
        //addDefault(rechner, 0);
       // Config.save();
	}

	public Object LgetConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
