import com.janfranco.datastructures.CircularQueue;
import processing.core.PApplet;

public class CQueueVisualization extends PApplet {

	int n;
	float res, r, angle; 
	CircularQueue<Integer> cQueue;
	
	public static void main(String[] args) {
		PApplet.main("CQueueVisualization");
	}
	
	public void settings() {
		size(500, 500);	
	}
	
	public void setup() {
		n = 8;
		r = 200;
		angle = 0;
		res = TWO_PI / n;
		cQueue = new CircularQueue<>(n);
		frameRate(3);
	}

	public void draw() {
		clear();
		background(0);
		fill(255);
		circle(250, 250, r * 2);

		int n = (int) random(2);
		fill(0, 255, 255);
		textSize(25);
		if(cQueue.getActiveSize() != 0 && n == 0) {
			cQueue.dequeue();
            text("dequeue()", 10, 30);
		}
		else if(cQueue.getActiveSize() != cQueue.getSize() - 1){
			int num = (int) random(10);
			cQueue.enqueue(num);
            text("enqueue(" + num + ")", 10, 30);
		}
		
		fill(255, 0, 0);
		textSize(45);
		// Write data
	    if(cQueue.getFrontIndex() > cQueue.getRearIndex() || (cQueue.getRearIndex() == cQueue.getFrontIndex() && cQueue.getRTour())) {
	    	angle = cQueue.getFrontIndex() * res % TWO_PI;
	        for(int i=cQueue.getFrontIndex(); i<cQueue.getSize(); i++) {
	            text(Integer.toString(cQueue.get(i)), r * cos(angle) + 250, r * sin(angle) + 250);
	            angle += res % TWO_PI;
	        }
	        for(int i=0; i<cQueue.getRearIndex(); i++) {
	        	text(Integer.toString(cQueue.get(i)), r * cos(angle) + 250, r * sin(angle) + 250);
	        	angle += res % TWO_PI;
	        }
	    }
	    else {
	    	angle = cQueue.getFrontIndex() * res % TWO_PI;
	        for(int i=cQueue.getFrontIndex(); i<cQueue.getRearIndex(); i++) {
	        	text(Integer.toString(cQueue.get(i)), r * cos(angle) + 250, r * sin(angle) + 250);
	        	angle += res % TWO_PI;
	        }
	    }
	}

}
