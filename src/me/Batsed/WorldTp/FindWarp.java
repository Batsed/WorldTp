package me.Batsed.WorldTp;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class FindWarp {
	
	Command cmd;
	String[] args;
	Player p;
	
	public FindWarp(Command cmd, String[] args, Player p) {
		this.cmd = cmd;
		this.args = args;
		this.p = p;
	}
	
	public boolean warpNumber(String warpname) { 
		
		int zahl = Config.configuration.getInt(Config.rechner);
		int anzahl = Config.configuration.getInt(Config.ErrorCache);
		int anzahlG = anzahl + 1;
		Config.configuration.set(Config.ErrorCache, anzahlG);
		
		String spawnName = Config.configuration.getString(Config.WarpNumber + anzahlG);
		String warpName = warpname;
		
		//Warp Nummer finden
		if(spawnName.equalsIgnoreCase(warpName)) {								
			Config.configuration.set(Config.WarpNumber + anzahlG, "deleted");
			Config.configuration.set(Config.ErrorCache, 0);			
			Config.WarpUp("asdi");
			Config.save();			
			return false;
		}	
				
	    //Schleife
	    if(!(anzahlG == zahl)) {
	    	 if(!(spawnName == warpname)) {
	 	    	warpNumber(warpname);
	 	    	return true;
	 		}		
		}
	    
	    Config.configuration.set(Config.ErrorCache, 0);
	    Config.save();
	    Config.WarpUp("deleted");
		return true;
	}
}