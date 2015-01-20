import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

int limit  = 20;
int colorOne = (int)(Math.random()*255);
int colorTwo = (int)(Math.random()*255);
int colorThree = (int)(Math.random()*255);
int shrinkOne = 5;
int shrinkTwo = 5;
int shrinkThree = 5;

public void setup()
{
	background(0);
	size(1000,1000);
}
public void draw()
{
	if(colorOne >= 255 && shrinkOne == 5)
		shrinkOne *= -1;
	else if(colorOne <= 5)
		shrinkOne *= -1;
	colorOne += shrinkOne;
	if(colorTwo >= 255 && shrinkTwo == 5)
		shrinkTwo *= -1;
	else if(colorTwo <= 5)
		shrinkTwo *= -1;
	colorTwo += shrinkTwo;
	if(colorThree >= 255 && shrinkThree == 5)
		shrinkThree *= -1;
	else if(colorThree <= 5)
		shrinkThree *= -1;
	colorThree += shrinkThree;
	sierpinski(100,900,800);
}

public void keyPressed()
{
	if(key == 'a'){
		if(limit <= 10)
			limit *= 2;
		limit /= 2;
	}
	if(key == 'd'){
		if(limit >= 400)
			limit /= 2;
		limit *= 2;
	}
}
public void sierpinski(int x, int y, int len) 
{
	if(len >= limit){
		fill(colorOne,colorTwo,0);
		sierpinski(x, y, len / 2);
		fill(0,colorTwo,colorThree);
		sierpinski(x + len /2, y, len / 2);
		fill(colorOne,0,colorThree);
		sierpinski( x + len / 4, y - len / 2, len / 2);
	}
	else{
		triangle(x, y, x + len/2, y - len, x + len, y);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
