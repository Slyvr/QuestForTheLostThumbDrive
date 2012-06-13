package com.slyvronline;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import com.slyvronline.beans.Anim;
import com.slyvronline.beans.Ent;
import com.slyvronline.beans.Img;
import com.slyvronline.beans.Level;
import com.slyvronline.beans.Menu;
import com.slyvronline.beans.Sheet;

public class Global {

	public GameContainer c;
	
	public ArrayList<Img> imgs;
	public ArrayList<Sheet> sheets;
	public ArrayList<Anim> anims;
	public ArrayList<Ent> ents;
	public ArrayList<Level> levels;
	public ArrayList<Menu> menus;
	
	public Level currentLevel;
	public Menu currentMenu;
	public Ent currentPlayer;
	
	public Global(){
		imgs = new ArrayList<Img>();
		ents = new ArrayList<Ent>();
	}
	
	public Menu getMenuByName(String name){
		for(Menu menu : menus)
			if (menu.name.equals(name)) return menu;
		return null;
	}
	
	public Img getImageByName(String name){
		for(Img img : imgs)
			if (img.name.equals(name)) return img;
		return null;
	}
	public Sheet getSheetByName(String name){
		for(Sheet sheet : sheets)
			if (sheet.name.equals(name)) return sheet;
		return null;
	}
	public Anim getAnimByName(String name){
		for(Anim anim : anims)
			if (anim.name.equals(name)) return anim;
		return null;
	}
	public Ent getEntByName(String name){
		for(Ent ent : ents)
			if (ent.name.equals(name)) return ent;
		return null;
	}
}
