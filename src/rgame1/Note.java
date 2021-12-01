package rgame1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteImage= new ImageIcon(Main.class.getResource("../images/note.png")).getImage();

	
	private int x,y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; //���� ��Ʈ�� ��ġ
	// + �ϰ� ���� �����Ͽ� ���� 1�� �� ���� ���ο� �ٸ�������. 580 == ���������� y��ǥ
	// 1�ʿ� 700�ȼ��̵���. 
	
	private String noteType ; //��Ʈ�� ����

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
	
	public Note ( String noteType) { //�����ڷ� �ʵ� �ʱ�ȭ
		
		
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
		this.noteType = noteType;
	}
	
	public void screenDraw (Graphics2D g) { //�������� ��Ʈ�� �׷��� ����
		
		if (noteType.equals("Space")){ //��Ʈ�� �����̽� ���
			
			
			g.drawImage(noteImage, x, y ,null);   //���� ��ǥ�� �ΰ��� ��Ʈ �̹����� �׸���.
			g.drawImage(noteImage, x+100, y ,null);
			
			
		}
		
		else { 
			
			g.drawImage(noteImage,x,y,null); //���� ��ǥ�� ��Ʈ �̹����� �׸���.
			
		}
		
	}
	
	
	public void drop () {
		
		y+=Main.NOTE_SPEED; //��Ʈ �ӵ���ŭ y ��ǥ ���� 
		
		if ( y>620) { //��Ʈ�� ���ƴٸ�
			
			System.out.println("Miss");
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
		
		if (y >= 610) { // y 613 ���Ŀ� Ű�� �����ٸ�
			
			System.out.println("Late"); // ���� ��
			new Music ("pop.mp3",false).start();
			close(); //�Ҹ�
		}
		                              //switch ��ó�� �����ϸ�, ��-��-��-��-�� �� ���� �ܰ踦 ����
		else if (y>=590) {
			
			System.out.println("Good");
			new Music ("pop.mp3",false).start();
			close();
		}
		
		else if (y>=570) {
			
			System.out.println("Great");
			new Music ("pop.mp3",false).start();
			close();
		}
		
		else if (y>=550) {
			
			System.out.println("Perfect");
			new Music ("pop.mp3",false).start();
			close();
		}
		
		else if (y>=520) {
			
			System.out.println("Great");
			new Music ("pop.mp3",false).start();
			close();
		}
		
	
		else if (y>=490) {
			
			System.out.println("Good");
			new Music ("pop.mp3",false).start();
			close();
		}
		
		
	}
	
	
	
}