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

//color myColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
int limit  = 20;
public void setup()
{
	background(0);
	size(1000,1000);
	//fill(myColor);
	
}
public void draw()
{
	//myColor = color((int)(Math.random()*255));
	//fill(myColor);
	//tint(255,100);
	sierpinski(100,900,800);

	//triangle(100,400,400,400,250,100);
}
public void mousePressed()//optional
{
	limit -= 5;
}
public void sierpinski(int x, int y, int len) 
{
	if(len >= limit){
		sierpinski(x, y, len / 2);
		sierpinski(x + len /2, y, len / 2);
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
