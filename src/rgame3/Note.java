package rgame3;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteImage= new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	
	private Image noteImage2= new ImageIcon(Main.class.getResource("../images/note2.png")).getImage();
	
	private int x,y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; //���� ��Ʈ�� ��ġ
	// + �ϰ� ���� �����Ͽ� ���� 1�� �� ���� ���ο� �ٸ�������. 580 == ���������� y��ǥ
	// 1�ʿ� 700�ȼ��̵���. 
	
	private String noteType ; //��Ʈ�� ����

	private boolean death ;
	
	private boolean proceeded = true;  //��Ʈ ���� ���� �÷��� 
	
	
	
	
	public String getNoteType() { // �ش� ��Ʈ�� � Ű�� ��Ʈ���� ��ȯ ���ִ� �Լ�
		
		return noteType;
	}
	public boolean isProceeded() {
		
		
		return proceeded;
	}
	
	public void close() {   //��Ʈ ���̱� 
		
		proceeded = false ;  
	}
	
	public Note ( String noteType , boolean death) { //�����ڷ� �ʵ� �ʱ�ȭ
		
		
		if ( noteType.equals("S")) {
			
			x=228;
		}
		
		else if ( noteType.equals("D")) {
			
			x=332;
		}
		
		else if ( noteType.equals("F")) {
			
			x=436;
		}
		
	else if ( noteType.equals("Space")) {
			
			x=540;
		}
		
		
		else if ( noteType.equals("J")) {
			
			x=744;
		}
		
		else if ( noteType.equals("K")) {
			
			x=848;
		}
		
		else if ( noteType.equals("L")) {
			
			x=952;
		}
		this.death = death;
		this.noteType = noteType;
	}
	
	public void screenDraw (Graphics2D g) { //�������� ��Ʈ�� �׷��� ����
		
		if (!death) {
			
			
		if (noteType.equals("Space")){ //��Ʈ�� �����̽� ���
			
			
			g.drawImage(noteImage, x, y ,null);   //���� ��ǥ�� �ΰ��� ��Ʈ �̹����� �׸���.
			g.drawImage(noteImage, x+100, y ,null);
			
			
		}
		
		else { 
			
			g.drawImage(noteImage,x,y,null); //���� ��ǥ�� ��Ʈ �̹����� �׸���.
			
		}
		}
		
		
		else {
			
			
			if (noteType.equals("Space")){ //��Ʈ�� �����̽� ���
				
				
				g.drawImage(noteImage2, x, y ,null);   //���� ��ǥ�� �ΰ��� ��Ʈ �̹����� �׸���.
				g.drawImage(noteImage2, x+100, y ,null);
				
				
			}
			
			else { 
				
				g.drawImage(noteImage2,x,y,null); //���� ��ǥ�� ��Ʈ �̹����� �׸���.
				
			}
			
			
			
		}
		
		


		
	}
	
	
	public void drop () {
		
		y+=Main.NOTE_SPEED; //��Ʈ �ӵ���ŭ y ��ǥ ���� 
		
		if ( y>670 && !death) { //��Ʈ�� ���ƴٸ�, ���� ��Ʈ�� �ƴ϶�� 
			
			//new Music ("pop.mp3",false).start();
			System.out.println("Miss");
			Game.score-=100;
			Game.combo = 0;
			close ();
		}
		
		else if (y>670 && death){ //������Ʈ�� �������� ��
			
			//new Music ("failNote.mp3",false).start();
			//new Music ("pop.mp3",false).start();
			System.out.println("Luck");
			close ();
		}
		
	}
	@Override
	
	public void run() { //������ �����
		
		try {
			
			while (true) {   //���� �ϰ� �
				drop();
				
				if (proceeded) { //��Ʈ�� ����ִٸ� 
				Thread.sleep(Main.SLEEP_TIME);  //��ǻ�Ϳ� ���Ǽ��� �� �ӵ� ����ȭ 
				
				}
				
				else {
					
					interrupt(); //������ ���� (��Ʈ ���)
					break;
				}
			}
			
		} catch (Exception e) { //���� üŷ
			
			System.err.println(e.getMessage());
		}
		
	}
	
	
	
	public void judge () {  //���� �Լ�
		
		if (y<=670 && y>=490 && death) {
			
			System.out.println("Death");
			new Music ("effect.mp3",false).start();
			Game.score-=100;
		}
		
		
		if (Game.combo >= 2) {
			Game.bonus=2;
		}
		else if (Game.combo >= 200) {
			Game.bonus=3;
		}
		else if (Game.combo >= 300) {
			Game.bonus=4;
		}
		else if (Game.combo >= 400) {
			Game.bonus=5;
		}
		else if (Game.combo >= 500) {
			Game.bonus=6;
		}
		
		if (y >= 650) { // y 660 ���Ŀ� Ű�� �����ٸ�
			
			System.out.println("Late"); // ���� ��
			//new Music ("pop.mp3",false).start();
			Game.score-=5;
			
			close(); //�Ҹ�
		}
		                              //switch ��ó�� �����ϸ�, ��-��-��-��-�� �� ���� �ܰ踦 ����
		else if (y>=630) {
			
			System.out.println("Good");
		//	new Music ("pop.mp3",false).start();
			Game.score+=5*Game.bonus;
			Game.combo += 1;
			close();
		}
		
		else if (y>=610) {
			
			System.out.println("Great");
		//	new Music ("pop.mp3",false).start();
			Game.score+=10*Game.bonus;
			Game.combo += 1;
			close();
		}
		
		else if (y>=580) {
			
			System.out.println("Perfect");
		//	new Music ("pop.mp3",false).start();
			Game.score+=15*Game.bonus;
			Game.combo += 1;
			close();
		}
		
		else if (y>=560) {
			
			System.out.println("Great");
		//	new Music ("pop.mp3",false).start();
			Game.score+=10*Game.bonus;
			Game.combo += 1;
			close();
		}
		
	
		else if (y>=520) {
			
			System.out.println("Good");
		//	new Music ("pop.mp3",false).start();
			Game.score+=5*Game.bonus;
			Game.combo += 1;
			close();
		}
		
		
	}
	
	
	
}
