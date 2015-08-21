import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bogglegraph.BoggleGraphElegant;
import dictionary.Boggle;

/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 24, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */


/**
 * @author Max
 *
 */
@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener, MouseMotionListener{
	private Image board;
	private ArrayList<Highlighter> highlighted;
	private int row[] = {4,104,203,300,400};
	private int col[] = {-1, 95, 195, 290, 390};
	private ArrayList<CircularButton> boggle;
	private Boggle boggin;
	private BoggleGraphElegant graph;
	public Board(){
		addMouseListener(this);
		addMouseMotionListener(this);
		setBoggin(new Boggle());
		Highlighter.setImage(new ImageIcon(this.getClass().getResource("/resource/highlighter.png")));
		highlighted = new ArrayList<Highlighter>();
		board =  new ImageIcon(this.getClass().getResource("/resource/boggle2.png")).getImage();
		setUp();
	}
	/**
	 * 
	 */
	private void setUp() {
		boggle = new ArrayList<CircularButton>();
		for(int i=0;i<boggin.getBoard().length;i++){
			for(int j=0;j<boggin.getBoard()[0].length;j++){
				boggle.add(new CircularButton(row[i]+50,col[j]+50,50, i, j, ""+boggin.getBoard()[i][j]));
				//System.out.println(boggle.get(i).getRadius());
			}
		}
	}
	/**
	 * @return the boggin
	 */
	public Boggle getBoggin() {
		return boggin;
	}
	/**
	 * @param boggin the boggin to set
	 */
	public void setBoggin(Boggle boggin) {
		this.boggin = boggin;
			
	}
	public void paint(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.BLACK);	
		Font f = new Font("Comic Sans",Font.PLAIN,70);
        g.setFont(f);
		g.drawImage(board,0,0,null);
		for(CircularButton x:boggle){
			g.drawString(x.getText(),x.getStartX()-30,x.getStartY()+17);
		}
		for(Highlighter x:highlighted){
			g.drawImage(Highlighter.giveImage(), x.getStartX()-50, x.getStartY()-50, null);
		}
		f = new Font("Calibri Light",Font.PLAIN, 30);
		g.setFont(f);
		g.drawString(""+boggin.getTotalScore(),610,468);
		int i = 0;
		int j = 0;
		if(boggin.getFoundWords().size()>12)
			i = boggin.getFoundWords().size() - 12;
		Enumeration<String> values = boggin.getFoundWords().keys();
		String nextValue;
		while(values.hasMoreElements()){
			nextValue = values.nextElement();
			g.drawString(nextValue+" - "+boggin.getScore(nextValue),513, j*30+70);
			i++;
			j++;
		}
		g.drawString("",610, 435);
		repaint();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(highlighted.size() >= 12){
			return;
		}
		Highlighter lastMove = highlighted.get(highlighted.size()-1);
		for(CircularButton x:boggle){
			if((Math.abs(x.getRow() - lastMove.getRow()) == 1) || (Math.abs(x.getCol() - lastMove.getCol())==1)){
				if(x.isInside(e)){
					if(Math.abs(x.getRow() - lastMove.getRow()) > 1 || Math.abs(x.getCol() - lastMove.getCol())> 1){
						return;
					}
					for(Highlighter z:highlighted){
						if(z.compareTo(x)==1){
							//System.out.println("NOPE");
							return;
						}
					}
					highlighted.add(new Highlighter(x));
					repaint();
					return;
				}
			}
		}
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		/*
		// TODO Auto-generated method stub
		for(int i =0;i<highlighted.size();i++){
			if(highlighted.get(i).isInside(e)){
				highlighted.remove(i);
				repaint();
				return;
			}
		}
		for(Button x:boggle){
			if(x.isInside(e)){
				highlighted.add(new Highlighter(x));
				System.out.println(x.getText()+"\n"+x.getStartX()+" "+x.getStartY());
				repaint();
				return;
			}
		}
		
		repaint();*/
		highlighted.clear();
		for(CircularButton x:boggle){
			if(x.isInside(e)){
				highlighted.add(new Highlighter(x));
				//System.out.println(x.getText()+"\n"+x.getStartX()+" "+x.getStartY());
				repaint();
				return;
			}
		}
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(highlighted.size()>=3){
			String str = "";
			for(Highlighter x:highlighted){
				str+=x.getText();
			}
			boggin.checkWord(str);
		}
		repaint();
	}

}
