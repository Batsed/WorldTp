package me.Batsed.WorldTp;
import org.bukkit.ChatColor;
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
		Config.save();
		
		String spawnName = Config.configuration.getString(Config.WarpNumber + anzahlG);
		
		//Warp Nummer finden
		if(spawnName.equalsIgnoreCase(warpname)) {								
			Config.configuration.set(Config.WarpNumber + anzahlG, "deleted");
			p.sendMessage(ChatColor.RED + "[WorldTp] Warp '"+ warpname +"' deleted!");
			Config.configuration.set(Config.ErrorCache, 0);						
			WarpUpDelete();
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
	    if(anzahlG == zahl) {
	    	if(!(spawnName == warpname)) {
	    		p.sendMessage(ChatColor.RED + "[WorldTp] '" + warpname + "' existiert nicht");
	    		Config.configuration.set(Config.ErrorCache, 0);	
	    		Config.save();
	    		return true;
	    	}
	    }
		return true;
	}
	   public static void WarpUpDelete() {
	       	int zahl = Config.configuration.getInt(Config.rechner);
	       	String SpawnName = Config.configuration.getString(Config.WarpNumber + 1);
	       	int warpderzahl = Config.configuration.getInt(Config.warpzahl);
	       	
	       	if(zahl == 1) {
	       		if(SpawnName.equalsIgnoreCase("deleted")) {
	       			warpderzahl = warpderzahl - 1;
	       			Config.configuration.set(Config.warpzahl, warpderzahl);
	       			Config.configuration.set(Config.NewWarp, "");
	       			Config.save();
	       			return;
	       		}       		
	    	}       	
	       	if(zahl == 1) {
	       		Config.configuration.set(Config.NewWarp, " | " + SpawnName + " | ");
	       		Config.configuration.set(Config.warpzahl, warpderzahl);
	       		Config.save();
	       		return;
	       	}else{
	       		Config.configuration.set(Config.NewWarp, "");
	       		Config.configuration.set(Config.warpzahl, 0);
	       		Config.save();
	       		WarpLoaderDelete();
	       		return;
	       	}
	    }
	    public static boolean WarpLoaderDelete() {	
	    	
	    	int zahl = Config.configuration.getInt(Config.rechner);
	    	int anzahl = Config.configuration.getInt(Config.NumberCache);
	    	int anzahlG = anzahl + 1;
	    	String warp = Config.configuration.getString(Config.NewWarp);
	    	String SpawnName = Config.configuration.getString(Config.WarpNumber + anzahlG);    
	    	int warpzahl = Config.configuration.getInt(Config.warpzahl);
	    	
	    	if(SpawnName.equalsIgnoreCase("deleted")) {	
	    		Config.configuration.set(Config.NumberCache, anzahlG);
	    		
	    		int zahlDerWarp = warpzahl;
	    		
	    		Config.configuration.set(Config.warpzahl, zahlDerWarp);
	    		Config.save();
	    		if(anzahlG == zahl) {
	    			Config.configuration.set(Config.NumberCache, 0);
	    			return false;
	    		}else{
	    			WarpLoaderDelete();
	    			return false;
	    		}
	    	}else{
	    		Config.configuration.set(Config.NewWarp, warp + " | " + SpawnName + " |");
	    		Config.configuration.set(Config.NumberCache, anzahlG);
	    	
	    		int warpderzahl = warpzahl + 1;
	    		Config.configuration.set(Config.warpzahl, warpderzahl);
	    		Config.save();
	    	}
	    	if(anzahlG > zahl) {
	    		return false;
	    	}
	    	
	    	if(!(anzahlG == zahl)) {
	    		WarpLoaderDelete();
	    		return true;
	    	}
	    	if(anzahlG == zahl) {
	    		Config.configuration.set(Config.NumberCache, 0);
	    		Config.save();
	    		return true;
	    	}
	    	
			return true;
	    }
}