import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class graf extends Frame implements MouseListener,MouseMotionListener,Runnable{
	private int prx,pry,x,y;
	class pl extends Canvas{
		LinkedList<Rectangle> list=new LinkedList<>();
		public void paint(Graphics g) {
			for (int i = 0; i < list.size(); i++) {
				g.drawRect((int)list.get(i).getX(),(int)list.get(i).getY(),(int)list.get(i).getWidth(),(int)list.get(i).getHeight());
			}
			g.drawRect(prx>x?x:prx, pry>y?y:pry,Math.abs(x-prx), Math.abs(y-pry));
		}
	}
	pl can=new pl();
	private Thread nit=new Thread(this);
	public graf() {
		super();setBounds(500,100,600,600);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {dispose();}
		});
		Panel p1=new Panel();can.setSize(600,600);can.addMouseListener(this);
		can.addMouseMotionListener(this);//can.addKeyListener(this);
		p1.add(can);can.setBackground(new Color(250,250,250));
		can.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			if (e.getExtendedKeyCode()==KeyEvent.VK_UP) {
				pry-=5;y-=5;can.repaint();
			}
			else if (e.getExtendedKeyCode()==KeyEvent.VK_DOWN) {
				pry+=5;y+=5;can.repaint();
			}
			else if (e.getExtendedKeyCode()==KeyEvent.VK_RIGHT) {
				prx+=5;x+=5;can.repaint();
			}
			else if (e.getExtendedKeyCode()==KeyEvent.VK_LEFT) {
				prx-=5;x-=5;can.repaint();
			}
			}
			
		});
		add(p1);nit.start();
		setVisible(true);
	}
	public static void main(String[] args) {
		graf fGraf=new graf();
	}
	public void run() {
		while(!Thread.interrupted()) {
		can.repaint();
		//nit.sleep();
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		prx=e.getX();
		pry=e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		can.list.add(new Rectangle(prx>x?x:prx, pry>y?y:pry,Math.abs(x-prx), Math.abs(y-pry)));
		
	}
	/*public void keyPressed(KeyEvent e) {
		if (e.getExtendedKeyCode()==KeyEvent.VK_UP) {
			pry-=5;y-=5;can.repaint();
		}
		else if (e.getExtendedKeyCode()==KeyEvent.VK_DOWN) {
			pry+=5;y+=5;can.repaint();
		}
		else if (e.getExtendedKeyCode()==KeyEvent.VK_RIGHT) {
			prx+=5;x+=5;can.repaint();
		}
		else if (e.getExtendedKeyCode()==KeyEvent.VK_LEFT) {
			prx-=5;x-=5;can.repaint();
		}
	}*/
	/*public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}*/
	public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		can.repaint();
	}
	public void mouseMoved(MouseEvent e) {
		
	}
}





