package com.slyvronline.beans;

import org.newdawn.slick.SpriteSheet;

public class Sheet {

	public String name;
	public SpriteSheet sheet;
	
	public Sheet(String name, SpriteSheet sheet){
		this.name=name;
		this.sheet=sheet;
	}
}
