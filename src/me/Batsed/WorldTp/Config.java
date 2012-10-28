
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
    static String oldLoc = Saves + ".Oldlocation.Players.";
    static String Info = Saves + ".info";
    static String NewWarp = Saves + ".Warps";
    
    protected static FileConfiguration configuration;
    protected static File file;

    public Config(File file) {

        Config.file = file;
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {

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

    public void save() {

        try {
            configuration.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void OldPlayerInvbackDoubleFine(Player p) {
    	String PlayerName = p.getName();
    	String s = "asde";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPointError", s);
    }
    public static void OldPlayerInvbackDouble(Player p) {
    	String PlayerName = p.getName();
    	String s = "asdf";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPointError", s);
    }
    public static void OldPlayerInvback(Player p) {
    	String PlayerName = p.getName();
    	String s = "asde";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPoint", s);
    }
    public static void OldPlayerLeave(Player p) {
    	String PlayerName = p.getName();
    	String s = "asdi";
    	configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPoint", s);
    }
    
    public static <Args> boolean OldPlayerLocName(Player p, String args) {
    	String spawnpoint = args;
    	String PlayerName = p.getName();
		configuration.set(Config.oldLoc + PlayerName + ".LastSpawnPoint", spawnpoint);
        return OldPlayerLoc(p);
    }
    
    public static boolean OldPlayerLoc(Player p) {
    	
    	double getZ = p.getLocation().getZ();
		double getX = p.getLocation().getX();
		double getY = p.getLocation().getY();
    	
		String PlayerName = p.getName();
		configuration.set(Config.oldLoc + PlayerName + ".spawn.Z", getZ);
		configuration.set(Config.oldLoc + PlayerName + ".spawn.X", getX);
    	configuration.set(Config.oldLoc + PlayerName + ".spawn.Y", getY);
		return true;
    }

	protected static void addDefault(String path, Object value) {

        if (!configuration.contains(path)) {
            configuration.set(path, value);
        }
    }
    public void setDefaults() {

        //addDefault(Info, "Hier das ist für euch eher uninterresant, denn diese yml Datei speichert nur alte Spielerpositionen");
        
	}

	public Object getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
