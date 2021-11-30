package rgame3;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteImage= new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	
	private Image noteImage2= new ImageIcon(Main.class.getResource("../images/note2.png")).getImage();
	
	private int x,y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; //현재 노트의 위치
	// + 하강 공식 적용하여 생성 1초 뒤 판정 라인에 다르도록함. 580 == 판정라인의 y좌표
	// 1초에 700픽셀이동함. 
	
	private String noteType ; //노트의 종류

	private boolean death ;
	
	private boolean proceeded = true;  //노트 생사 여부 플래그 
	
	
	
	
	public String getNoteType() { // 해당 노트가 어떤 키의 노트인지 반환 해주는 함수
		
		return noteType;
	}
	public boolean isProceeded() {
		
		
		return proceeded;
	}
	
	public void close() {   //노트 죽이기 
		
		proceeded = false ;  
	}
	
	public Note ( String noteType , boolean death) { //생성자로 필드 초기화
		
		
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
	
	public void screenDraw (Graphics2D g) { //떨어지는 노트의 그래픽 구현
		
		if (!death) {
			
			
		if (noteType.equals("Space")){ //노트가 스페이스 라면
			
			
			g.drawImage(noteImage, x, y ,null);   //현재 좌표에 두개의 노트 이미지를 그린다.
			g.drawImage(noteImage, x+100, y ,null);
			
			
		}
		
		else { 
			
			g.drawImage(noteImage,x,y,null); //현재 좌표에 노트 이미지를 그린다.
			
		}
		}
		
		
		else {
			
			
			if (noteType.equals("Space")){ //노트가 스페이스 라면
				
				
				g.drawImage(noteImage2, x, y ,null);   //현재 좌표에 두개의 노트 이미지를 그린다.
				g.drawImage(noteImage2, x+100, y ,null);
				
				
			}
			
			else { 
				
				g.drawImage(noteImage2,x,y,null); //현재 좌표에 노트 이미지를 그린다.
				
			}
			
			
			
		}
		
		


		
	}
	
	
	public void drop () {
		
		y+=Main.NOTE_SPEED; //노트 속도만큼 y 좌표 증가 
		
		if ( y>670 && !death) { //노트를 놓쳤다면, 데스 노트가 아니라면 
			
			//new Music ("pop.mp3",false).start();
			System.out.println("Miss");
			Game.score-=100;
			Game.combo = 0;
			close ();
		}
		
		else if (y>670 && death){ //데스노트가 떨어졌을 때
			
			//new Music ("failNote.mp3",false).start();
			//new Music ("pop.mp3",false).start();
			System.out.println("Luck");
			close ();
		}
		
	}
	@Override
	
	public void run() { //쓰레드 실행용
		
		try {
			
			while (true) {   //무한 하강 운동
				drop();
				
				if (proceeded) { //노트가 살아있다면 
				Thread.sleep(Main.SLEEP_TIME);  //컴퓨터와 현실세계 간 속도 동기화 
				
				}
				
				else {
					
					interrupt(); //쓰레드 종료 (노트 사망)
					break;
				}
			}
			
		} catch (Exception e) { //오류 체킹
			
			System.err.println(e.getMessage());
		}
		
	}
	
	
	
	public void judge () {  //판정 함수
		
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
		
		if (y >= 650) { // y 660 이후에 키를 눌렀다면
			
			System.out.println("Late"); // 늦은 것
			//new Music ("pop.mp3",false).start();
			Game.score-=5;
			
			close(); //소멸
		}
		                              //switch 문처럼 동작하며, 하-중-상-중-하 의 판정 단계를 지님
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
