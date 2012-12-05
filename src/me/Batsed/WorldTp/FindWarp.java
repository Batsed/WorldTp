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
		
		//Warp Nummer finden
		if(spawnName == warpname) {
			Config.configuration.set(Config.WarpNumber + anzahlG, "deleted");
			Config.save();
			return true;
		}
				
	    //Schleife
	    if(!(anzahlG == zahl)) {
	    	 if(!(spawnName == warpname)) {
	 	    	warpNumber(warpname);	    	
	 			return true;			
	 		}		
		}
		return true;
	} 
}