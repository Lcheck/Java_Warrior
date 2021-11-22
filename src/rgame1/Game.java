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
	//기본 인터페이스 이미지
	
	
	private String titleName ;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	//해당 음악에 따른 게임 설정 변수
	
	ArrayList<Note> noteList= new ArrayList<Note> ();
	
	public Game (String titleName, String difficulty, String musicTitle) { //곡 이름과 난이도 설정을 위한 생성자
		
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle= musicTitle;
		//게임 설정 정보
		
		gameMusic = new Music(this.musicTitle,false);
		
		
	
		
	}
	
	public void screenDraw(Graphics2D g) { //게임 그래픽 구현
		
	
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
			g.drawImage(gameInfoImage, 0, 660, null); // 그림을 그릴 대상과 위치 설정
			g.drawImage(judgementLineImage, 0, 580, null);
			//노트 경로, 경로 라인 이미지
			
		for (int i = 0 ; i<noteList.size(); i++) { //노트의 각 객체 그리기
				
				Note note = noteList.get(i);  //노트 배열에 있는 노트 얻어오기
				
				if (!note.isProceeded()) { //해당 노트가 죽었으면
					
					noteList.remove(i);       //그리지 않는다. 
					i--;
				}
				else {
				note.screenDraw(g);} //살았으면 그린다.
			}
			
		
		
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			//텍스트 안티에일리어싱 적용
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
			g.drawString("L",993,609);   //텍스트 띄우기 
			
	
	
			
	}
	
	


public void pressS() { //해당키를 눌렀을 때
	
	judge("S"); //판정
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




public void releaseS() { //해당키를 떼었을 때
	
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
		
		dropNotes(this.titleName); //게임이 실행되는 동안 무한정 드랍시키기
		
	}
	
	public void close() {
		System.out.println("11");
		gameMusic.close(); //실행되는 음악을 종료하고
		this.interrupt(); // 실행되고 있는 게임 쓰레드도 종료한다.
	
		
	}
	
	public void dropNotes (String titleName) {
		
		Beat[] beats = null;
		
		System.out.println(isInterrupted());
		
		if ( titleName.equals("Flower Dance") & difficulty.equals("Easy")){ //현재 실행곡이 ~ 이고, 난이도가 ~ 라면
			
			int startTime = 1000 - Main.REACH_TIME * 1000; //노트의 하강 위치를 판정라인에 도달하는 시간에 맞춘다.
			int gap = 125 ; //박자 사이의 시간 (음악 마다 다름)
			
			beats = new Beat [] {  
				
					 //각 비트가 떨어질 시간대 설정, 각 비트의 위치 설정
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
		//선택 음악에 따른 음악 실행 
		
		
		
		
		while(i<beats.length && !isInterrupted()) { //쓰레드 자원 관리(떨어질 비트가 존재하고, 쓰레드가 멈추지 않았다면)
			
			boolean dropped = false; // 하강 플래그
			
		
			
			
			if (beats[i].getTime() <= gameMusic.getTime()) { //각 노트가 떨어질 시간대가, 현 음악의 진행시간과 일치한다면
				
				Note note = new Note (beats[i].getNoteName()); //노트를 떨어 뜨린다.
				note.start(); //노트 스레드 시작
				noteList.add(note); //노트 그래픽을 위한 배열 추가
				i++;
				dropped = true; //노트가 떨어졌다.
			}
			
			if (!dropped) { //노트가 떨어지지 않았다면
				
				try {
					
					Thread.sleep(5);
				} catch (InterruptedException e){
					
					System.out.println("222");
					System.out.println(isInterrupted());
				}
				
			}
			
		}
		
		
	
	}
	
	
	
	public void judge(String input)    {  //노트 판정 함수 
		
		
		for (int i =0; i<noteList.size();i++) { // 게임에 존재하는 전체 노트 순회 
			
			Note note = noteList.get(i); //해당 노트 객체 생성
			
			if (input.equals(note.getNoteType())){ //해당 노트의 타입이 매개변수와 일치한다면 
				
				note.judge(); //판정(노트 클래스의 judge이다.)
 				break; //함수는 멈춤 (선입선출의 효과를 지님, 먼저 죽은 노트를 기점으로 반복 초기화 되기 때문)			}
			
		} 
		
	}
	
	
}
	
}
