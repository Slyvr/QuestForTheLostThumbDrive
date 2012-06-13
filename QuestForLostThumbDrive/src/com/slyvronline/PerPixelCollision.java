package com.slyvronline;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class PerPixelCollision {

	public static Color[] getPixelData(Image img){
		Color[] data = new Color[img.getWidth() * img.getHeight()];
		
		int counter=0;
		for(int y=0; y<img.getHeight(); y++){
			for (int x=0; x<img.getWidth(); x++){
				data[counter]=img.getColor(x, y);
				counter++;
			}
		}
		
		return data;
	}
	
	public static Boolean collision(Rectangle rect1, Rectangle rect2, Color[] dataA, Color[] dataB){
		
		int top = (int) Math.max(rect1.getMinY(), rect2.getMinY());
		int bottom = (int) Math.min(rect1.getMaxY(), rect2.getMaxY());
		int left = (int) Math.max(rect1.getMinX(), rect2.getMinX());
		int right = (int) Math.min(rect1.getMaxX(), rect2.getMaxX());
		
		for (int y=top; y<bottom; y++){
			for (int x=left; x<right; x++){
				Color colorA = dataA[(int) ((x-rect1.getMinX()) + (y-rect1.getMinY()) * rect1.getWidth())];
				Color colorB = dataB[(int) ((x-rect2.getMinX()) + (y-rect2.getMinY()) * rect2.getWidth())];
				
				if (colorA.getAlpha() != 0 && colorB.getAlpha() != 0){
					return true;
				}
			}
		}
		
		return false;
	}
	
//	public static Boolean IntersectPixels(Rectangle rectangleA, Color[] dataA,Rectangle rectangleB, Color[] dataB)
//	{
//		// Find the bounds of the rectangle intersection
//		int top = Math.Max(rectangleA.Top, rectangleB.Top);
//		int bottom = Math.Min(rectangleA.Bottom, rectangleB.Bottom);
//		int left = Math.Max(rectangleA.Left, rectangleB.Left);
//		int right = Math.Min(rectangleA.Right, rectangleB.Right);
//	
//		// Check every point within the intersection bounds
//		for (int y = top; y < bottom; y++)
//		{
//			for (int x = left; x < right; x++)
//			{
//				// Get the color of both pixels at this point
//				Color colorA = dataA[(x - rectangleA.Left) +
//				                 (y - rectangleA.Top) * rectangleA.Width];
//				Color colorB = dataB[(x - rectangleB.Left) +
//				                 (y - rectangleB.Top) * rectangleB.Width];
//				
//				// If both pixels are not completely transparent,
//				if (colorA.A != 0 && colorB.A != 0)
//				{
//					// then an intersection has been found
//					return true;
//				}
//			}
//		}
//		
//		// No intersection found
//		return false;
//	}
	
}
