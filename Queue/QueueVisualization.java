import com.janfranco.datastructures.Queue;
import processing.core.PApplet;

public class QueueVisualization extends PApplet {

	Queue<Integer> queue;
	
	public static void main(String[] args) {
		PApplet.main("QueueVisualization");
	}
	
	public void settings() {
		size(350, 800);	
	}
	
	public void setup() {
		queue = new Queue<>(10);
		frameRate(1);
	}

	public void draw() {
		background(51);
		int n = (int) random(2);
		fill(255, 0, 0);
		textSize(15);
		if(n == 1) {
			int num = (int) random(10);
			queue.enqueue(num);
			text("enqueue(" + num + ")", 10, 30);
		} 
		else {
			queue.dequeue();	
			text("dequeue()", 10, 30);
		}
		
		fill(255, 255, 255);
		rect(150, 780, 50, -750);
		for(int i=queue.getFrontIndex(); i<queue.getRearIndex(); i++) {
			textSize(20);
			fill(255, 0, 0);
			text(Integer.toString(queue.get(i)), 170, 780 - i * 50); // Write data
			
			// Write rear and front
			if(i == queue.getFrontIndex())		text("Front (" + queue.getFrontIndex() + ") -> ", 20, 780 - i * 50);
			if(i == queue.getRearIndex() - 1) {
				if(queue.getFrontIndex() == queue.getRearIndex() - 1)
					if(i == queue.getRearIndex() - 1)	text(" <- Rear  (" + queue.getRearIndex()  + ")", 210, 780 - i * 50);
				else
					if(i == queue.getRearIndex() - 1)	text("Rear (" + queue.getRearIndex()  + ") -> ", 20, 780 - i * 50);
			}
		}
	}

}
