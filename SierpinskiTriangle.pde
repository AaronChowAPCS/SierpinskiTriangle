int limit  = 20;
int colorOne = 50;
int colorTwo = 150;
int colorThree = 250;
int shrinkOne = 3;
int shrinkTwo = 4;
int shrinkThree = 2;

public void setup()
{
	background(0);
	size(1000,1000);
	noStroke();
}
public void draw()
{
	if(colorOne >= 255 && shrinkOne == 3)
		shrinkOne *= -1;
	else if(colorOne <= 5)
		shrinkOne *= -1;
	colorOne += shrinkOne;
	if(colorTwo >= 255 && shrinkTwo == 4)
		shrinkTwo *= -1;
	else if(colorTwo <= 5)
		shrinkTwo *= -1;
	colorTwo += shrinkTwo;
	if(colorThree >= 255 && shrinkThree == 2)
		shrinkThree *= -1;
	else if(colorThree <= 5)
		shrinkThree *= -1;
	colorThree += shrinkThree;
	sierpinski(100,900,800,1);
	sierpinski(300,900,400,2);
	//sierpinski(400,500,200,3);
}

public void keyPressed()
{
	if(key == 'a'){
		if(limit <= 15)
			limit *= 2;
		limit /= 2;
	}
	if(key == 'd'){
		if(limit >= 300)
			limit /= 2;
		limit *= 2;
	}
}
public void sierpinski(int x, int y, int len, int num) 
{
	if(num ==1){
		if(len >= limit){
			fill(colorOne,0,colorThree);
			sierpinski(x, y, len / 2,1);
			fill(0,colorTwo,colorThree);
			sierpinski(x + len /2, y, len / 2,1);
			fill(colorOne,colorTwo,0);
			sierpinski(x + len / 4, y - len / 2, len / 2,1);
		}
		else{
			triangle(x, y, x + len/2, y - len, x + len, y);
		}
	}
	else if(num >= 2){
		if(len >= limit){
			fill(colorOne);
			sierpinski(x, y - len / 2, len / 2,2);
			fill(colorTwo);
			sierpinski(x + len /2, y - len / 2, len / 2,2);
			fill(colorThree);
			sierpinski(x + len / 4, y, len / 2,2);
		}
		else{
			triangle(x, y - len, x + len / 2, y, x + len, y- len );
		}
	}
}