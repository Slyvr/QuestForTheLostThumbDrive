package com.slyvronline;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.slyvronline.beans.Anim;
import com.slyvronline.beans.Img;
import com.slyvronline.beans.Sheet;

public class Loader {

	public static void load() throws SlickException{
		loadImgs();
		LoaderLevels.load();
		LoaderMenus.load();
	}
	
	public static void loadImgs() throws SlickException{
		ArrayList<Img> imgs = new ArrayList<Img>();
		
		imgs.add(new Img("block1",new Image("res/imgs/block1.png")));
		imgs.add(new Img("drive", new Image("res/imgs/drive.png",Color.white)));
		imgs.add(new Img("portal", new Image("res/imgs/portal.png")));
		imgs.add(new Img("longgrid1",new Image("res/imgs/longgrid1.png")));
		imgs.add(new Img("grid1", new Image("res/imgs/grid1.png")));
		imgs.add(new Img("spawn",new Image("res/imgs/spawn.png")));
		imgs.add(new Img("logo", new Image("res/imgs/logo.png")));
		imgs.add(new Img("instructions", new Image("res/imgs/instructions.png")));
		imgs.add(new Img("player", new Image("res/imgs/player.png")));
		
		ArrayList<Sheet> sheets = new ArrayList<Sheet>();
		
		sheets.add(new Sheet("charsheet", new SpriteSheet("res/imgs/charsheet.png",30,30)));
		sheets.add(new Sheet("charsheet2", new SpriteSheet("res/imgs/charsheet2.png",30,30)));
		
		ArrayList<Anim> anims = new ArrayList<Anim>();
		
		int duration=200;
		anims.add(new Anim("charsheet", new Animation(sheets.get(0).sheet,duration)));
		anims.add(new Anim("charsheet2", new Animation(sheets.get(1).sheet,duration)));
		
		Main.global.sheets = sheets;
		Main.global.anims = anims;
		Main.global.imgs = imgs;
	}
}
