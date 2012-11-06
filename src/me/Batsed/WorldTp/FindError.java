package me.Batsed.WorldTp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class FindError {
	
	Command cmd;
	String[] args;
	Player p;
	
	public FindError(Command cmd, String[] args, Player p) {
		this.cmd = cmd;
		this.args = args;
		this.p = p;
	}
	
	public boolean Error() { 
		
		String sprache14 = Config.configuration.getString(Config.Backup + "language.error.GamemodeCreativeError");
		String sprache15 = Config.configuration.getString(Config.Backup + "language.error.SaveInventoryError");
		String sprache18 = Config.configuration.getString(Config.Backup + "language.error.ClearInventoryError");
		String sprache19 = Config.configuration.getString(Config.Backup + "language.error.activateCommandInvbackError");
		
		int zahl = Config.configuration.getInt(Config.rechner);
		int anzahl = Config.configuration.getInt(Config.ErrorCache);
		int anzahlG = anzahl + 1;
		String SpawnName = Config.configuration.getString(Config.WarpNumber + anzahlG);
		Config.configuration.set(Config.ErrorCache, anzahlG);
		
		String saved = Config.configuration.getString(Config.Backup + SpawnName +".SaveInventory");
		String game = Config.configuration.getString(Config.Backup + SpawnName +".GamemodeCreative");
		String clearinv = Config.configuration.getString(Config.Backup + SpawnName +".ClearInventory");
		String invback = Config.configuration.getString(Config.Backup + SpawnName +".activateCommandInvback");
		String AnotherWarpOn = Config.configuration.getString(Config.Backup + SpawnName +".TeleportToAnOtherWarp");
		Config.save();
		
		//Fehler überprüfung
		
		p.sendMessage(ChatColor.RED + "search for errors in warp: " + SpawnName);
		
		if(AnotherWarpOn.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' hat in der Config bei TeleportToAnOtherWarp einen Fehler");
			System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' hat in der Config bei TeleportToAnOtherWarp einen Fehler");
		}
		if(AnotherWarpOn.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' hat in der Config bei TeleportToAnOtherWarp einen Fehler");
			System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' hat in der Config bei TeleportToAnOtherWarp einen Fehler");
		}
		if(game.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache14);
			System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache14);
		}
		if(game.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache14);
			System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache14);
		}
		if(saved.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache15);
			System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache15);
		}
		if(saved.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache15);
			System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache15);
		}
		if(clearinv.length() > 5) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache18);
	    	System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache18);
		}
	    if(clearinv.length() < 4) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache18);
	    	System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache18);
	    }
	    if(invback.length() > 5) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName +"' " + sprache19);
	    	System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName +"' " + sprache19);
	    }
	    if(invback.length() < 4) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName +"' " + sprache19);
	    	System.out.println(ChatColor.RED + "[WorldTp] Spawnpoint '" + SpawnName +"' " + sprache19);
	    }	    
	    //Schleife
	    if(!(anzahlG == zahl)) {
	    	Error();	    	
			return true;			
		}
		if(anzahlG == zahl) {
			Config.configuration.set(Config.ErrorCache, 0);
			Config.save();
			p.sendMessage(ChatColor.RED + "[WorldTp] Keine Errors gefunden");
			return true;		
		}
		return true;
	}
}
