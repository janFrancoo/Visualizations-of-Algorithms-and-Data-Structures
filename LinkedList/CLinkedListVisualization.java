import java.util.Random;

import com.janfranco.datastructures.CircularLinkedList;

import processing.core.PApplet;

public class CLinkedListVisualization extends PApplet{
	
	int index = 0;
	int x, y, bWidth, bHeight, arrowLen, space;
	CircularLinkedList<Integer> linkedList;
	Random random;
	
	public static void main(String[] args) {
		PApplet.main("CLinkedListVisualization");
	}
	
	public void setup() {
		linkedList = new CircularLinkedList<>();
		this.x = 10;
		this.y = height / 2;
		this.bWidth = 100;
		this.bHeight = 70;
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

		int i = 0;
		int length = linkedList.getLength();
		for (int num : linkedList) {
			i++;
			if (i == length - 1)
				drawSingleNode(num, true);
			else
				drawSingleNode(num, false);
			x += space;
		}
		index++;
		index = index % 100;
		if(index == 10 || index == 30)
			linkedList.add(random.nextInt() % 100);
		if(index == 90)
			linkedList.remove(linkedList.getHead().value);
	}
	
	public void drawSingleNode(int value, boolean isLastNode) {
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
		if (!isLastNode) {
			line(x + (bWidth * 3 / 4) + arrowLen - 5, y - 5, x + (bWidth * 3 / 4) + arrowLen, y);
			line(x + (bWidth * 3 / 4) + arrowLen - 5, y + 5, x + (bWidth * 3 / 4) + arrowLen, y);
		} 
		else {
			line(x + (bWidth * 3 / 4) + arrowLen, y, x + (bWidth * 3 / 4) + arrowLen, y + bHeight);
			line(50, y + bHeight, x + (bWidth * 3 / 4) + arrowLen, y + bHeight);
			line(50, y + bHeight, 50, y + bHeight - (bHeight / 5));
			line(45, y + bHeight - (bHeight / 10), 50, y + bHeight - (bHeight / 5));
			line(55, y + bHeight - (bHeight / 10), 50, y + bHeight - (bHeight / 5));
		}
	}

}
