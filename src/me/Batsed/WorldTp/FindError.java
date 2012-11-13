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
		String sprache22 = Config.configuration.getString(Config.Backup + "language.error.TeleportToAnOtherWarp");
		String sprache23 = Config.configuration.getString(Config.Backup + "language.error.NoError");
		String sprache38 = Config.configuration.getString(Config.Backup + "language.SearchErrors");
		String sprache39 = Config.configuration.getString(Config.Backup + "language.error.loadInvByCommandLeave");
		String sprache40 = Config.configuration.getString(Config.Backup + "language.error.ClearInvByCommanderror");
		String sprache41 = Config.configuration.getString(Config.Backup + "language.error.activateCommandLeave");
		String sprache42 = Config.configuration.getString(Config.Backup + "language.error.ConfigError");
		
		int zahl = Config.configuration.getInt(Config.rechner);
		int anzahl = Config.configuration.getInt(Config.ErrorCache);
		int anzahlG = anzahl + 1;
		String SpawnName = Config.configuration.getString(Config.WarpNumber + anzahlG);
		Config.configuration.set(Config.ErrorCache, anzahlG);
		
		String saved = Config.configuration.getString(Config.Backup + SpawnName +".SaveInventory");
		String game = Config.configuration.getString(Config.Backup + SpawnName +".GamemodeCreative");
		String clearinv = Config.configuration.getString(Config.Backup + SpawnName +".ClearInventory");
		String activateinvback = Config.configuration.getString(Config.Backup + SpawnName +".activateCommandInvback");
		String AnotherWarpOn = Config.configuration.getString(Config.Backup + SpawnName +".TeleportToAnOtherWarp");
		String AktivateCommanLeave = Config.configuration.getString(Config.Backup + SpawnName +".activateCommandLeave");
		String ClearInvByCommand = Config.configuration.getString(Config.Backup + SpawnName +".ClearInvByCommand");
		String LoadInvbyCommandLeave = Config.configuration.getString(Config.Backup + SpawnName +".loadInvByCommandLeave");
		Config.save();
		
		//Fehler überprüfung
		
		p.sendMessage(ChatColor.RED + sprache38 + " " + SpawnName);
		
		if(LoadInvbyCommandLeave.length() > 5 ) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" +SpawnName + "' " + sprache39);
			System.out.println("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache39);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(LoadInvbyCommandLeave.length() < 4 ) {
			p.sendMessage("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache39);
			System.out.println("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache39);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(ClearInvByCommand.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" +SpawnName + "' " + sprache40);
			System.out.println("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache40);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(ClearInvByCommand.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" +SpawnName + "' " + sprache40);
			System.out.println("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache40);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(AktivateCommanLeave.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" +SpawnName + "' " + sprache41);
			System.out.println("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache41);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(AktivateCommanLeave.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" +SpawnName + "' " + sprache41);
			System.out.println("[WorldTp] Spawnpoint '" +SpawnName + "' " + sprache41);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(AnotherWarpOn.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache22);
			System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache22);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(AnotherWarpOn.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache22);
			System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache22);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(game.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache14);
			System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache14);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(game.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache14);
			System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache14);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(saved.length() > 5) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache15);
			System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache15);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(saved.length() < 4) {
			p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache15);
			System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache15);
			Config.configuration.set(Config.ErrorOn, "on");
		}
		if(clearinv.length() > 5) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache18);
	    	System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache18);
	    	Config.configuration.set(Config.ErrorOn, "on");
		}
	    if(clearinv.length() < 4) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName + "' " + sprache18);
	    	System.out.println("[WorldTp] Spawnpoint '" + SpawnName + "' " + sprache18);
	    	Config.configuration.set(Config.ErrorOn, "on");
	    }
	    if(activateinvback.length() > 5) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName +"' " + sprache19);
	    	System.out.println("[WorldTp] Spawnpoint '" + SpawnName +"' " + sprache19);
	    	Config.configuration.set(Config.ErrorOn, "on");
	    }
	    if(activateinvback.length() < 4) {
	    	p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + "Spawnpoint '" + SpawnName +"' " + sprache19);
	    	System.out.println("[WorldTp] Spawnpoint '" + SpawnName +"' " + sprache19);
	    	Config.configuration.set(Config.ErrorOn, "on");
	    }
	    Config.save();
	    //Schleife
	    if(!(anzahlG == zahl)) {
	    	Error();	    	
			return true;			
		}
		if(anzahlG == zahl) {
			String Error = Config.configuration.getString(Config.ErrorOn);
			Config.configuration.set(Config.ErrorCache, 0);
			
			if(Error == "on") {
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache42);
				Config.configuration.set(Config.ErrorOn, "off");
				Config.save();
				return true;
			}
			if(!(Error == "on")) {
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache23);
				return true;
			}
			return true;		
		}
		return true;
	}
}
