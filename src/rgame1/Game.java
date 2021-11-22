package rgame1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;



public class Game extends Thread {
	
	private Image gameInfoImage= new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage= new ImageIcon(Main.class.getResource("../images/JudgementLine.png")).getImage();
	private Image noteRouteLineImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private Image noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSPACE1Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSPACE2Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	//�⺻ �������̽� �̹���
	
	
	private String titleName ;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	//�ش� ���ǿ� ���� ���� ���� ����
	
	ArrayList<Note> noteList= new ArrayList<Note> ();
	
	public Game (String titleName, String difficulty, String musicTitle) { //�� �̸��� ���̵� ������ ���� ������
		
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle= musicTitle;
		//���� ���� ����
		
		gameMusic = new Music(this.musicTitle,false);
		
		
	
		
	}
	
	public void screenDraw(Graphics2D g) { //���� �׷��� ����
		
	
			g.drawImage(noteRouteSImage, 228, 30, null);
			g.drawImage(noteRouteDImage, 332, 30, null);
			g.drawImage(noteRouteFImage, 436, 30, null);
			g.drawImage(noteRouteSPACE1Image, 540, 30, null);
			g.drawImage(noteRouteSPACE2Image, 644, 30, null);
			g.drawImage(noteRouteJImage, 748, 30, null);
			g.drawImage(noteRouteKImage, 852, 30, null);
			g.drawImage(noteRouteLImage, 956, 30, null);
			
			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 640, 30, null);
			g.drawImage(noteRouteLineImage, 744, 30, null);
			g.drawImage(noteRouteLineImage, 848, 30, null);
			g.drawImage(noteRouteLineImage, 952, 30, null);
			g.drawImage(gameInfoImage, 0, 660, null); // �׸��� �׸� ���� ��ġ ����
			g.drawImage(judgementLineImage, 0, 580, null);
			//��Ʈ ���, ��� ���� �̹���
			
		for (int i = 0 ; i<noteList.size(); i++) { //��Ʈ�� �� ��ü �׸���
				
				Note note = noteList.get(i);  //��Ʈ �迭�� �ִ� ��Ʈ ������
				
				if (!note.isProceeded()) { //�ش� ��Ʈ�� �׾�����
					
					noteList.remove(i);       //�׸��� �ʴ´�. 
					i--;
				}
				else {
				note.screenDraw(g);} //������� �׸���.
			}
			
		
		
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			//�ؽ�Ʈ ��Ƽ���ϸ���� ����
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString(titleName,20,702);
			
			g.drawString(difficulty, 1000,702);
			g.drawString("000000", 565,702);
			
			g.drawString("S",270,609);
			g.drawString("D",374,609);
			g.drawString("F",470,609);
			g.drawString("SPACE",580,609);
			g.drawString("J",784,609);
			g.drawString("K",889,609);
			g.drawString("L",993,609);   //�ؽ�Ʈ ���� 
			
	
	
			
	}
	
	


public void pressS() { //�ش�Ű�� ������ ��
	
	judge("S"); //����
	noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
}

public void pressD() {
	judge("D"); 
	noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
}

public void pressF() {
	judge("F"); 

	noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	
}

public void pressSPACE() {
	
	judge("Space");

	noteRouteSPACE1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	noteRouteSPACE2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	
}

public void pressJ() {
	
	judge("J");

	noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	
}

public void pressK() {
	judge("K");
	noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	
}

public void pressL() {
	
	judge("L");
	noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	
}




public void releaseS() { //�ش�Ű�� ������ ��
	
	noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
}

public void releaseD() {
	
	noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
}

public void releaseF() {
	noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
}

public void releaseSPACE() {
	noteRouteSPACE1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	noteRouteSPACE2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
}

public void releaseJ() {
	noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
}

public void releaseK() {
	noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
}

public void releaseL() {
	noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
}




	@Override
	
	public void run() {
		
		dropNotes(this.titleName); //������ ����Ǵ� ���� ������ �����Ű��
		
	}
	
	public void close() {
		System.out.println("11");
		gameMusic.close(); //����Ǵ� ������ �����ϰ�
		this.interrupt(); // ����ǰ� �ִ� ���� �����嵵 �����Ѵ�.
	
		
	}
	
	public void dropNotes (String titleName) {
		
		Beat[] beats = null;
		
		System.out.println(isInterrupted());
		
		if ( titleName.equals("Flower Dance") & difficulty.equals("Easy")){ //���� ������� ~ �̰�, ���̵��� ~ ���
			
			int startTime = 1000 - Main.REACH_TIME * 1000; //��Ʈ�� �ϰ� ��ġ�� �������ο� �����ϴ� �ð��� �����.
			int gap = 125 ; //���� ������ �ð� (���� ���� �ٸ�)
			
			beats = new Beat [] {  
				
					 //�� ��Ʈ�� ������ �ð��� ����, �� ��Ʈ�� ��ġ ����
				new Beat (startTime + gap *17, "S"),
				new Beat (startTime + gap *20, "D"),
				new Beat (startTime + gap*23, "F"),
				new Beat (startTime + gap*27, "Space"),
				new Beat (startTime + gap*30, "J"),
				new Beat (startTime + gap*33, "K"),
				new Beat (startTime + gap*38, "L"),
				
				
				

				
		};
		

			
			
			
		}
		int i = 0;
		
		gameMusic.start();
		//���� ���ǿ� ���� ���� ���� 
		
		
		
		
		while(i<beats.length && !isInterrupted()) { //������ �ڿ� ����(������ ��Ʈ�� �����ϰ�, �����尡 ������ �ʾҴٸ�)
			
			boolean dropped = false; // �ϰ� �÷���
			
		
			
			
			if (beats[i].getTime() <= gameMusic.getTime()) { //�� ��Ʈ�� ������ �ð��밡, �� ������ ����ð��� ��ġ�Ѵٸ�
				
				Note note = new Note (beats[i].getNoteName()); //��Ʈ�� ���� �߸���.
				note.start(); //��Ʈ ������ ����
				noteList.add(note); //��Ʈ �׷����� ���� �迭 �߰�
				i++;
				dropped = true; //��Ʈ�� ��������.
			}
			
			if (!dropped) { //��Ʈ�� �������� �ʾҴٸ�
				
				try {
					
					Thread.sleep(5);
				} catch (InterruptedException e){
					
					System.out.println("222");
					System.out.println(isInterrupted());
				}
				
			}
			
		}
		
		
	
	}
	
	
	
	public void judge(String input)    {  //��Ʈ ���� �Լ� 
		
		
		for (int i =0; i<noteList.size();i++) { // ���ӿ� �����ϴ� ��ü ��Ʈ ��ȸ 
			
			Note note = noteList.get(i); //�ش� ��Ʈ ��ü ����
			
			if (input.equals(note.getNoteType())){ //�ش� ��Ʈ�� Ÿ���� �Ű������� ��ġ�Ѵٸ� 
				
				note.judge(); //����(��Ʈ Ŭ������ judge�̴�.)
 				break; //�Լ��� ���� (���Լ����� ȿ���� ����, ���� ���� ��Ʈ�� �������� �ݺ� �ʱ�ȭ �Ǳ� ����)			}
			
		} 
		
	}
	
	
}
	
}
