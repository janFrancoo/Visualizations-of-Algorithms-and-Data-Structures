import java.util.Random;

import com.janfranco.datastructures.LinkedList;

import processing.core.PApplet;

public class LinkedListVisualization extends PApplet{
	
	int index = 0;
	int x, y, bWidth, bHeight, arrowLen, space;
	LinkedList<Integer> linkedList;
	Random random;
	
	public static void main(String[] args) {
		PApplet.main("LinkedListVisualization");
	}
	
	public void setup() {
		linkedList = new LinkedList<>();
		this.x = 10;
		this.y = height / 2;
		this.bWidth = 100;
		this.bHeight = 50;
		this.arrowLen = 50;
		this.space = 140;
		
		linkedList.add(12);
		linkedList.add(21);
	
		random = new Random();
	}
	
	public void settings() {
		size(900, 400);
	}
	
	public void draw() {
		background(51);
		fill(255);
		x = 10;
		for (int num : linkedList) {
			drawSingleNode(num);
			x += space;
		}
		index++;
		index = index % 100;
		if(index == 10 || index == 30)
			linkedList.add(random.nextInt() % 100);
		if(index == 90)
			linkedList.remove(linkedList.getHead().value);
	}
	
	public void drawSingleNode(int value) {
		noStroke();
		fill(255);
		rect(x, y - (bHeight / 2), bWidth, bHeight);
		fill(0);
		textSize(14);
		text(String.valueOf(value), x + 10, y + 5);
		stroke(255, 0, 0);
		strokeWeight(8);
		line(x + (bWidth / 2), y - (bHeight / 2), x + (bWidth / 2), (y + bHeight / 2));
		strokeWeight(5);
		line(x + (bWidth * 3 / 4), y, x + (bWidth * 3 / 4) + arrowLen, y);
		line(x + (bWidth * 3 / 4) + arrowLen - 5, y - 5, x + (bWidth * 3 / 4) + arrowLen, y);
		line(x + (bWidth * 3 / 4) + arrowLen - 5, y + 5, x + (bWidth * 3 / 4) + arrowLen, y);
	}

}
