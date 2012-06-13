package com.slyvronline;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.slyvronline.beans.Ent;

public class Main extends BasicGame{

	public static String title = "Quest For The Lost Thumb Drive";
	public static int screenWidth=400;
	public static int screenHeight=300;
	public static Global global;
	
	public Main() {
		super(title);
	}

	@Override
	public void init(GameContainer c) throws SlickException {
		global = new Global();
		global.c = c;
		Loader.load();
		c.setTargetFrameRate(60);
		c.setShowFPS(false);
	}
	
	@Override
	public void render(GameContainer c, Graphics g) throws SlickException {

		for(Ent ent : global.currentLevel.blocks){
			ent.img.img.draw(ent.pos.getX(), ent.pos.getY(), ent.color);
		}
		
		for(Ent ent : global.currentLevel.ents){
			if (ent.img!=null)
				ent.img.img.draw(ent.pos.getX(), ent.pos.getY(), ent.color);
			else
				g.drawString(ent.name, ent.pos.getX(), ent.pos.getY());
		}
		
		for(Ent ent : global.currentMenu.ents){
			ent.img.img.draw(ent.pos.getX(), ent.pos.getY(), ent.color);
		}
		
		if (global.currentMenu.name.equals("game")&& global.currentPlayer!=null)
			global.currentPlayer.img.img.draw(global.currentPlayer.pos.getX(), global.currentPlayer.pos.getY());
	}

	@Override
	public void update(GameContainer c, int d) throws SlickException {
		Input input = c.getInput();
		
		if (global.currentMenu.name.equals("main")){
			if (input.isKeyDown(Input.KEY_ENTER)){
				global.currentMenu = global.getMenuByName("game");
				global.currentLevel = LoaderLevels.loadLevel1();
			}
		}
		else{
			if (input.isKeyDown(Input.KEY_ESCAPE)){
				global.currentMenu = global.getMenuByName("main");
				global.currentLevel = LoaderLevels.loadMainLevel();
			}
		}
		if (global.currentMenu.name.equals("game"))
			UpdatePlayer.update();
	}
	
	public static void main(String[] args) {
		try{
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(screenWidth, screenHeight, false);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}
