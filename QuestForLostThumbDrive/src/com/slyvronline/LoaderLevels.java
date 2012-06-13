package com.slyvronline;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.slyvronline.beans.Ent;
import com.slyvronline.beans.Level;

public class LoaderLevels {

	public static ArrayList<Color> colors;
	public static ArrayList<String> colorStrings;
	
	public static void load(){
		loadColors();
		
		ArrayList<Level> levels = new ArrayList<Level>();
		
		levels.add(loadMainLevel());
		levels.add(loadLevel1());
		
		Main.global.levels = levels;
		Main.global.currentLevel = levels.get(0);
	}
	
	public static Level loadMainLevel(){
		Level level = new Level();
		level.name="";
		level.blocks = getLevelBlocks(Main.global.getImageByName("grid1").img);
		level.ents = new ArrayList<Ent>();
		
		addPlayer(level);
		
		return level;
	}
	
	public static Level loadLevel1(){
		Level level = new Level();
		level.name="1";
		level.blocks = getLevelBlocks(Main.global.getImageByName("longgrid1").img);
		level.ents = getLevelEnts(Main.global.getImageByName("longgrid1").img, level);
		
		//center blocks
		for(Ent e : level.blocks){
			e.pos.setX(e.pos.getX()+130);
			e.pos.setY(e.pos.getY()-50);
		}
		
		addPlayer(level);
		
		return level;
	}
	
	public static ArrayList<Ent> getLevelEnts(Image img, Level level){
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		Ent levelId = new Ent();
		levelId.name = "Level "+level.name;
		levelId.pos = new Rectangle(0,0,1,1);
		ents.add(levelId);
		
		return ents;
	}
	
	public static ArrayList<Ent> getLevelBlocks(Image img){
		ArrayList<Ent> blocks = new ArrayList<Ent>();
		
		for (int y=0; y<img.getHeight(); y+=10){
			for (int x=0; x<img.getWidth(); x+=10){
				Color pixel = img.getColor(x+2, y+2);
				String color = comparedColor(pixel);
				if (color!=null && !color.equals("")){
					if (color.equals("red")){
						//new block
						Ent ent = new Ent();
						ent.name = "block";
						ent.img = Main.global.getImageByName("block1");
						ent.color = pixel;
						ent.pos = new Rectangle(x,y, ent.img.img.getWidth(),ent.img.img.getHeight());
						blocks.add(ent);
					}
					else if (color.equals("gray")){
						//spawn
						Ent ent = new Ent();
						ent.name = "spawn";
						ent.img = Main.global.getImageByName("spawn");
						ent.color = pixel;
						ent.pos = new Rectangle(x,y, ent.img.img.getWidth(),ent.img.img.getHeight());
						blocks.add(ent);
					}
					else if (color.equals("pink")){
						//drive
						Ent ent = new Ent();
						ent.name = "drive";
						ent.img = Main.global.getImageByName("drive");
						ent.color = Color.white;
						ent.pos = new Rectangle(x,y, ent.img.img.getWidth(),ent.img.img.getHeight());
						blocks.add(ent);
					}
					else {
						//portal with color setting
						Ent ent = new Ent();
						ent.name = "portal";
						ent.img = Main.global.getImageByName("portal");
						ent.color = pixel;
						ent.pos = new Rectangle(x,y, ent.img.img.getWidth(),ent.img.img.getHeight());
						blocks.add(ent);
					}
				}
			}
		}
		
		return blocks;
	}
	
	public static void loadColors(){
		colors = new ArrayList<Color>();
		colorStrings = new ArrayList<String>();
		Color red = new Color(237,28,36);
		Color gray = new Color(127,127,127);
		Color purple = new Color(163,73,164);
		Color lightgreen = new Color(181,230,29);
		Color brown = new Color(185,122,87);
		Color yellow = new Color(255,242,0);
		Color pink = new Color(255,174,201);
		Color orange = new Color(255,127,39);
		colors.add(red);
		colors.add(gray);
		colors.add(purple);
		colors.add(lightgreen);
		colors.add(brown);
		colors.add(yellow);
		colors.add(pink);
		colors.add(orange);
		colorStrings.add("red");
		colorStrings.add("gray");
		colorStrings.add("purple");
		colorStrings.add("lightgreen");
		colorStrings.add("brown");
		colorStrings.add("yellow");
		colorStrings.add("pink");
		colorStrings.add("orange");
	}
	
	public static String comparedColor(Color pixel){
		for(int i=0; i<colors.size(); i++){
			Color color = colors.get(i);
			if (color.getRed()==pixel.getRed())
				if (color.getGreen()==pixel.getGreen())
					if (color.getBlue()==pixel.getBlue())
						return colorStrings.get(i);
		}
		return null;
	}
	
	public static void addPlayer(Level level){
		//Add player
		Ent player = new Ent();
		player.name="player";
		player.color = Color.white;
		player.img = Main.global.getImageByName("player");
		player.speed=2;
		for(Ent block : level.blocks){
			if (block.name.contains("spawn")){
				player.pos = new Rectangle(block.pos.getX(),block.pos.getY(),player.img.img.getWidth(),player.img.img.getHeight());
				player.pos.setY(player.pos.getY()-40);
				break;
			}
		}
		Main.global.currentPlayer = player;
	}
}
