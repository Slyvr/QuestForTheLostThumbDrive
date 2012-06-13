package com.slyvronline;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

import com.slyvronline.beans.Ent;
import com.slyvronline.beans.Menu;

public class LoaderMenus {

	public static void load(){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(loadMainMenu());
		menus.add(loadGameMenu());
		
		
		Main.global.currentMenu = menus.get(0);
		Main.global.menus = menus;
	}
	
	public static Menu loadMainMenu(){
		Menu menu = new Menu();
		menu.name="main";
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		Ent logo = new Ent();
		logo.name = "logo";
		logo.img = Main.global.getImageByName("logo");
		logo.pos = new Rectangle(100,10,logo.img.img.getWidth(),logo.img.img.getHeight());
		logo.color = Color.white;
		ents.add(logo);
		
		Ent ent = new Ent();
		ent.name = "instructions";
		ent.img = Main.global.getImageByName("instructions");
		ent.pos = new Rectangle(100,150,ent.img.img.getWidth(),ent.img.img.getHeight());
		ent.color = Color.white;
		ents.add(ent);
		
		menu.ents = ents;
		
		return menu;
	}
	
	public static Menu loadGameMenu(){
		Menu menu = new Menu();
		menu.name="game";
		menu.ents = new ArrayList<Ent>();
		
		return menu;
	}
}
