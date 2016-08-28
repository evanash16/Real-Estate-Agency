package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Graph {

	private BufferedImage graph;
	private int x, y;
	
	public Graph(int originX, int originY, int width, int height, int[] dataSet, String title, int fontSize){
		
		graph = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = graph.getGraphics();
		
		this.x = originX;
		this.y = originY - height;
		
		g.setColor(Color.WHITE);
		g.drawLine(0, height - 1, 0, 0);
		g.drawLine(0, height - 1, width, height - 1);
		
		int[] xPoints = new int[dataSet.length];
		int[] yPoints = new int[dataSet.length];
		
		int maxValue = 0;
		
		for(int i: dataSet){
			
			if(i > maxValue){
				
				maxValue = i;
			}
		}
		
		int minValue = maxValue;
		
		for(int i: dataSet){
			
			if(i < minValue){
				
				minValue = i;
			}
		}
		
		for(int i = 0; i < dataSet.length; i++){
			
			yPoints[i] = (height - (int) (((3 * height) / 4) * ((double) dataSet[i] / (double) maxValue)));
			xPoints[i] = ((i + 1) * ((3 * width / 4) / dataSet.length));
			g.fillOval(xPoints[i] - 5, yPoints[i] - 5, 10, 10);
		}
		
		g.drawPolyline(xPoints, yPoints, xPoints.length);
		
		g.setFont(new Font(null, Font.BOLD, fontSize));
		g.drawString(title, (graph.getWidth() - g.getFontMetrics().stringWidth(title)) / 2, g.getFont().getSize());
	}
	
	public void draw(Graphics g){
		
		g.drawImage(graph, x, y, null);
	}
}
