package com.slyvronline;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.slyvronline.beans.Ent;

public class UpdatePlayer {

	static Input prevInput;
	
	public static void update(){
		Input input = Main.global.c.getInput();
		if (prevInput==null) prevInput=input;
		
		if ((input.isKeyDown(Input.KEY_A) |
				(input.isKeyDown(Input.KEY_LEFT) ))){
			moveLeft(Main.global.currentPlayer);
		}
		if ((input.isKeyDown(Input.KEY_D) |
				(input.isKeyDown(Input.KEY_RIGHT) ))){
			moveRight(Main.global.currentPlayer);
		}
		if ((input.isKeyDown(Input.KEY_W) |
				(input.isKeyDown(Input.KEY_SPACE) |
				(input.isKeyDown(Input.KEY_UP))))){
			jump(Main.global.currentPlayer);
		}
		
		fall(Main.global.currentPlayer);
		
		prevInput=input;
	}
	
	public static void moveLeft(Ent ent){
		//ent.pos.setX(ent.pos.getX()-ent.speed);
		for(Ent e : Main.global.currentLevel.blocks){
			e.pos.setX(e.pos.getX()+ent.speed);
		}
		Ent collider = collision(ent);
		if (collider!=null){
			checkPortal(collider);
			if (collider.name.equals("portal")){
				//ent.pos.setX(ent.pos.getX()+ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()-ent.speed);
				}
			}
			checkDrive(collider);
			if (collider.name.equals("drive")){
				//ent.pos.setX(ent.pos.getX()+ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()-ent.speed);
				}
			}
			
			if (collider.name.equals("block")){
				//ent.pos.setX(ent.pos.getX()+ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()-ent.speed);
				}
			}
			
			if (collider.name.equals("spawn")){
				//ent.pos.setX(ent.pos.getX()+ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()-ent.speed);
				}
			}
		}
	}
	public static void moveRight(Ent ent){
		//ent.pos.setX(ent.pos.getX()+ent.speed);
		for(Ent e : Main.global.currentLevel.blocks){
			e.pos.setX(e.pos.getX()-ent.speed);
		}
		Ent collider = collision(ent);
		if (collider!=null){
			checkPortal(collider);
			if (collider.name.equals("portal")){
				//ent.pos.setX(ent.pos.getX()-ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()+ent.speed);
				}
			}
			checkDrive(collider);
			if (collider.name.equals("drive")){
				//ent.pos.setX(ent.pos.getX()-ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()+ent.speed);
				}
			}
			
			if (collider.name.equals("block")){
				//ent.pos.setX(ent.pos.getX()-ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()+ent.speed);
				}
			}
			
			if (collider.name.equals("spawn")){
				//ent.pos.setX(ent.pos.getX()-ent.speed);
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setX(e.pos.getX()+ent.speed);
				}
			}
		}
	}
	
	static Boolean peaked;
	static int peak = 30;
	static int start;
	
	public static void jump(Ent ent){
		
		if (!peaked){
			//ent.pos.setY(ent.pos.getY()-ent.speed*2);
			for(Ent e : Main.global.currentLevel.blocks){
				e.pos.setY(e.pos.getY()+ent.speed*2);
				if (e.name.equals("spawn")){
					if (e.pos.getY()>=start+peak){
						peaked=true;
					}
				}
			}
			
			Ent collider = collision(ent);
			if (collider!=null){
				checkPortal(collider);
				if (collider.name.equals("portal")){
					for(Ent e : Main.global.currentLevel.blocks){
						e.pos.setY(e.pos.getY()-ent.speed);
						peaked=false;
						if (e.name.equals("spawn")) start = (int) e.pos.getY();
					}
				}
				checkDrive(collider);
				if (collider.name.equals("drive")){
					for(Ent e : Main.global.currentLevel.blocks){
						e.pos.setY(e.pos.getY()-ent.speed);
						peaked=false;
						if (e.name.equals("spawn")) start = (int) e.pos.getY();
					}
				}
				
				if (collider.name.equals("block")){
					for(Ent e : Main.global.currentLevel.blocks){
						e.pos.setY(e.pos.getY()-ent.speed);
						peaked=false;
						if (e.name.equals("spawn")) start = (int) e.pos.getY();
					}
				}
				
				if (collider.name.equals("spawn")){
					for(Ent e : Main.global.currentLevel.blocks){
						e.pos.setY(e.pos.getY()-ent.speed);
						peaked=false;
						if (e.name.equals("spawn")) start = (int) e.pos.getY();
					}
				}
			}
		}
	}
	static long timer;
	
	public static void fall(Ent ent){
		//ent.pos.setY(ent.pos.getY()+ent.speed);
		for(Ent e : Main.global.currentLevel.blocks){
			e.pos.setY(e.pos.getY()-ent.speed);
		}
		Ent collider = collision(ent);
		if (collider!=null){
			checkPortal(collider);
			if (collider.name.equals("portal")){
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setY(e.pos.getY()+ent.speed);
					peaked=false;
					if (e.name.equals("spawn")) start = (int) e.pos.getY();
				}
			}
			checkDrive(collider);
			if (collider.name.equals("drive")){
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setY(e.pos.getY()+ent.speed);
					peaked=false;
					if (e.name.equals("spawn")) start = (int) e.pos.getY();
				}
			}
			
			if (collider.name.equals("block")){
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setY(e.pos.getY()+ent.speed);
					peaked=false;
					if (e.name.equals("spawn")) start = (int) e.pos.getY();
				}
			}
			
			if (collider.name.equals("spawn")){
				for(Ent e : Main.global.currentLevel.blocks){
					e.pos.setY(e.pos.getY()+ent.speed);
					peaked=false;
					if (e.name.equals("spawn")) start = (int) e.pos.getY();
				}
			}
		}
	}
	
	public static void checkPortal(Ent collider){
		
		int timeAmt=3000;
		
		if (collider.name.equals("portal") && System.currentTimeMillis()>=timer){
			for(Ent e : Main.global.currentLevel.blocks){
				if (e.name.contains("portal") && e.color.equals(collider.color) && !e.equals(collider)){
					//found other portal
					int xDiff = (int) (collider.pos.getX()-e.pos.getX());
					int yDiff = (int) (collider.pos.getY()-e.pos.getY());
					
					for(Ent en : Main.global.currentLevel.blocks){
						en.pos.setX(en.pos.getX()+xDiff);
						en.pos.setY(en.pos.getY()+yDiff);
					}
					
					timer=System.currentTimeMillis()+timeAmt;
					
					break;
				}
			}
		}
	}
	
	public static void checkDrive(Ent collider){
		if (collider.name.equals("drive")){
			Boolean exists=false;
			for(Ent e : Main.global.currentLevel.ents){
				if (e.name.contains("Found")){
					exists=true;
				}
			}
			if (!exists){
				Ent win = new Ent();
				win.name="You Found It!"+
						"\nPress [Espace] To Start A New Game";
				win.pos = new Rectangle(50,50,1,1);
				Main.global.currentLevel.ents.add(win);
			}
		}
	}
	
	public static Ent collision(Ent ent){
		for(Ent e : Main.global.currentLevel.blocks){
			if (e.pos.intersects(ent.pos)){
				if (PerPixelCollision.collision(ent.pos, e.pos, PerPixelCollision.getPixelData(ent.img.img), PerPixelCollision.getPixelData(e.img.img))){
					return e;
				}
			}
		}
		return null;
	}
}
