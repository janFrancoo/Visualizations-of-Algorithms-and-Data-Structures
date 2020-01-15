import java.util.Random;
import java.util.Stack;

import processing.core.PApplet;

public class StackVisualization extends PApplet{
	
	private Stack<Integer> stack;
	private int count;
	private Random random;

	public static void main(String[] args) {
		PApplet.main("StackVisualization");
	}
	
	public void setup() {
		count = 0;
		stack = new Stack<>();
		frameRate(1);
		random = new Random();
	}
	
	public void settings() {
		size(400, 700);
	}
	
	public void draw() {
		background(51);
		if(count < 11) {
			stack.add(count);
			count++;
		}
		else {
			if(!stack.isEmpty())
				stack.pop();
			else
				for(int i=0; i<abs(random.nextInt()) % 10; i++)
					stack.add(random.nextInt() % 100);
		}
		int height = stack.size() * 50;
		fill(255, 255, 255);
		rect(150, 650, 50, -height);
		for(int i=0; i<stack.size(); i++) {
			textSize(20);
			fill(255, 0, 0);
			text(Integer.toString(stack.get(i)), 170, 650 - i*50);
		}
	}
	
}
