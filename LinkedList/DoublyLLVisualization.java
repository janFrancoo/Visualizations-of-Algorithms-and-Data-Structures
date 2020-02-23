import java.util.Random;

import com.janfranco.datastructures.DoublyLinkedList;

import processing.core.PApplet;

public class DoublyLLVisualization extends PApplet {
	
	private final int windowWidth = 1200, windowHeight = 300;
	private final int nodeWidth = 120, nodeHeight = 50, pointerLen = 25, textSize = 20;
	private int x, y, index;
	private DoublyLinkedList<Integer> linkedList;
	private Random random = new Random();

	public static void main(String[] args) {
		PApplet.main("DoublyLLVisualization");
	}
	
	public void setup() {
		this.index = 0;
		this.x = 40;
		this.y = (windowHeight / 2) - (nodeHeight / 2);
		this.linkedList = new DoublyLinkedList<>();
	}
	
	public void settings() {
		size(windowWidth, windowHeight);
	}
	
	public void draw() {
		background(51);

		this.x = 40;
		for (int num : linkedList) {
			drawSingleNode(num);
			x += nodeWidth + pointerLen + (pointerLen / 5);
		}		
		
		index++;
		index = index % 100;
		if(index == 10 || index == 30)
			linkedList.insert(random.nextInt() % 100);
		if(index == 90 && linkedList.getHead() != null)
			linkedList.remove(linkedList.getHead().value);
	
		if (linkedList.getLength() == (windowWidth / (nodeWidth + (2 * pointerLen)) + 1))
			linkedList.clear();
	}
	
	private void drawSingleNode(int value) {
		noStroke();
		fill(255);
		rect(this.x, this.y, this.nodeWidth, this.nodeHeight);	//	body
		stroke(255, 0, 0);
		// internal separators
		strokeWeight(5);
		line(this.x + (nodeWidth / 5), this.y, this.x + (nodeWidth / 5), this.y + nodeHeight);
		line(this.x + (nodeWidth * 4 / 5), this.y, this.x + (nodeWidth * 4 / 5), this.y + nodeHeight);
		// pointers
		strokeWeight(3);
		line((this.x + this.x + (nodeWidth / 5)) / 2, this.y + (nodeHeight / 3), this.x - pointerLen, this.y + (nodeHeight / 3));
		line(this.x - pointerLen, this.y + (nodeHeight / 3), this.x - pointerLen + (pointerLen / 5), this.y + (nodeHeight / 3) + (pointerLen / 5));
		line(this.x - pointerLen, this.y + (nodeHeight / 3), this.x - pointerLen + (pointerLen / 5), this.y + (nodeHeight / 3) - (pointerLen / 5));
		line((this.x + nodeWidth + this.x + (nodeWidth * 4 / 5)) / 2, this.y + (nodeHeight * 2 / 3), 
				this.x + nodeWidth + pointerLen, this.y + (nodeHeight * 2 / 3));
		line(this.x + nodeWidth + pointerLen, this.y + (nodeHeight * 2 / 3), this.x + nodeWidth + pointerLen - (pointerLen / 5), 
				this.y + (nodeHeight * 2 / 3) + (pointerLen / 5));
		line(this.x + nodeWidth + pointerLen, this.y + (nodeHeight * 2 / 3), this.x + nodeWidth + pointerLen - (pointerLen / 5), 
				this.y + (nodeHeight * 2 / 3) - (pointerLen / 5));
		// value
		fill(0);
		textSize(textSize);
		text(value, this.x + (nodeWidth / 2) - (textSize / 2), this.y + (nodeHeight / 2) + (textSize / 2));
	}
	
}
