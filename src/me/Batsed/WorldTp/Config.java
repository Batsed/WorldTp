
package me.Batsed.WorldTp;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Config {
	
	Command cmd;
	String[] args;
	static Player p;
	
	
	public Config(Command cmd, String[] args, Player p) {
		this.cmd = cmd;
		this.args = args;
		Config.p = p;
	}
	
    static String Saves = "Saves";
    static String rechner = Saves + ".Zahl";
    static String oldLoc = Saves + ".Oldlocation.Players.";
    static String Info = Saves + ".info";
    static String NewWarp = Saves + ".Warps";
    static String NewWarpUp = Saves + ".Warps.";
    static String WarpNumber = Saves + ".Number.";
    static String NumberCache = Saves + ".Cache";
    static String ErrorCache = Saves + ".ErrorCache";
    static String Backup = Saves + ".backup.";
    protected static FileConfiguration configuration;
    protected static File file;

    public Config(File file) {

        Config.file = file;
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {

        return configuration;
    }

    public Object get(String path) {

        if (configuration.isBoolean(path)) {
            return configuration.getBoolean(path);
        } else if (configuration.isDouble(path)) {
            return configuration.getDouble(path);
        } else if (configuration.isInt(path)) {
            return configuration.getInt(path);
        } else if (configuration.isItemStack(path)) {
            return configuration.getItemStack(path);
        } else if (configuration.isList(path)) {
            return configuration.getList(path);
        } else if (configuration.isLong(path)) {
            return configuration.getLong(path);
        } else if (configuration.isOfflinePlayer(path)) {
            return configuration.getOfflinePlayer(path);
        } else if (configuration.isString(path)) {
            return configuration.getString(path);
        } else if (configuration.isVector(path)) {
            return configuration.getVector(path);
        } else {
            return configuration.get(path);
        }
    }

    public void set(String path, Object value) {

        configuration.set(path, value);
    }

    public static void save() {

        try {
            configuration.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WarpUp(String spawnName) {
       	int zahl = configuration.getInt(Config.rechner);
    	int summe = zahl + 1;
       	configuration.set(Config.rechner, summe);
        String anzahl = String.valueOf(summe);
       	configuration.set(Config.WarpNumber + anzahl, spawnName);
       	Config.save();
       	
       	if(zahl == 0) {
       		configuration.set(Config.NewWarp, " | " + spawnName + " | ");
       		Config.save();
       	}else{
       		configuration.set(Config.NewWarp, "");
       		Config.save();
       		Config.WarpLoader(spawnName);
       	}
    }
    public static boolean WarpLoader(String spawnName) {
    	
    	int zahl = configuration.getInt(Config.rechner);
    	int anzahl = configuration.getInt(Config.NumberCache);
    	int anzahlG = anzahl + 1;
    	String warp = configuration.getString(Config.NewWarp);
    	String SpawnName = configuration.getString(Config.WarpNumber + anzahlG);
    	configuration.set(Config.NewWarp, warp + " | " + SpawnName + " |");
    	configuration.set(Config.NumberCache, anzahlG);
    	Config.save();
    	
    	if(!(anzahlG == zahl)) {
    		Config.WarpLoader(SpawnName);
    		return true;
    	}
    	if(anzahlG == zahl) {
    		configuration.set(Config.NumberCache, 0);
    		Config.save();
    		return true;
    	}
    	
		return true;
    }
    public static void TeleportToWarpLeave(Player p) {
    	String PlayerName = p.getName();
    	String s = "asdi";
    	configuration.set(Config.oldLoc + PlayerName + ".AnotherWarp", s);
    	Config.save();
    }
    public static void TeleportToWarp(Player p) {
    	String PlayerName = p.getName();
    	String s = "asdn";
    	configuration.set(Config.oldLoc + PlayerName + ".AnotherWarp", s);
    	Config.save();
    }
    public static void OldPlayerInvbackDoubleFine(Player p) {
    	String PlayerName = p.getName();
    	String s = "asde";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPointError", s);
    	Config.save();
    }
    public static void OldPlayerInvbackDouble(Player p) {
    	String PlayerName = p.getName();
    	String s = "asdf";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPointError", s);
    	Config.save();
    }
    public static void OldPlayerInvback(Player p) {
    	String PlayerName = p.getName();
    	String s = "asde";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPoint", s);
    	Config.save();
    }
    public static void OldPlayerLeave(Player p) {
    	String PlayerName = p.getName();
    	String s = "asdi";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPoint", s);
    	Config.save();
    }
    
    public static void OldPlayerLocName(Player p, String args) {
    	String spawnpoint = args;
    	String PlayerName = p.getName();
		configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPoint", spawnpoint);
		Config.save();
        Config.OldPlayerLoc(p);
    }
    
    public static void OldPlayerLoc(Player p) {
    	
    	double getZ = p.getLocation().getZ();
		double getX = p.getLocation().getX();
		double getY = p.getLocation().getY();
    	
		String PlayerName = p.getName();
		configuration.set(Config.oldLoc + PlayerName + ".spawn.Z", getZ);
		configuration.set(Config.oldLoc + PlayerName + ".spawn.X", getX);
    	configuration.set(Config.oldLoc + PlayerName + ".spawn.Y", getY);
    	Config.save();
    }
    public static void DoubleWarpOff(Player p) {
    	String PlayerName = p.getName();
    	String s = "doubleWarpOff";
    	configuration.set(Config.oldLoc + PlayerName + ".doubleWarp", s);
    	Config.save();
    }
    public static void DoubleWarp(Player p) {
    	String PlayerName = p.getName();
    	String s = "doubleWarpOn";
    	configuration.set(Config.oldLoc + PlayerName + ".doubleWarp", s);
    	Config.save();
    }

	protected static void addDefault(String path, Object value) {

        if (!configuration.contains(path)) {
            configuration.set(path, value);
        }
    }
    public void setDefaults() {
        addDefault(rechner, 0);
        addDefault(NumberCache, 0);
        addDefault("Saves.ErrorCache", 0);
        Config.save();
	}

	public Object getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
