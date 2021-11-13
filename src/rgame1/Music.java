package rgame1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream; // 파일 입출력을 위한 라이브 러리에서 각 클래스 임포트

import javazoom.jl.player.Player; //음악 실행을 위한 외부 라이브 러리에서 플레이어 클래스 임포트

public class Music extends Thread{ //쓰레드 클래스 상속 ( 쓰레드란 프로그램 안의 작은 프로그램)

	
	private Player player; // 외부 라이브러리의 플레이어 클래스 객체
	
	private boolean isLoop; // 무한 반복 여부 체킹 용
	
	
	
	private File file ;
	
	private FileInputStream fis;
	
	private BufferedInputStream bis;  // mp3 파일을 불러오기 위한 객체들
	

	
	public Music(String name, boolean isLoop) { //곡의 제목, 무한 반복 여부 설정
		
		try {
			
			this.isLoop = isLoop;
			
			file = new File (Main.class.getResource("../music/" + name).toURI()); // mp3 파일 가져오기
			
			fis = new FileInputStream(file); // 해당 파일을 입력받아서
			
			bis = new BufferedInputStream(fis); // 버퍼로 가져온다.
			
			player = new Player(bis); // 받은 파일을 담는다.
			
			
		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			
		}
	}
	
	
	
		public int getTime() { // 음악의 시간 분석
			
			if (player == null)
				return 0;
			return player.getPosition();
			
		}
		
		
		
		public void close() { // 사용자가 곡을 변환할 때, 기존의 음악을 안정적으로 종료하게 해줌
			
			isLoop = false;
			player.close();
			this.interrupt(); // 쓰레드를 중지상태로 (곡을 실행하는 미니 프로그램을 종료한다)
			
		}
		
		@Override
		
		
		
		public void run() {
			
			try {
				
				do {
					
					
					fis = new FileInputStream(file); // 해당 파일을 입력받아서 // 반복용
					
					bis = new BufferedInputStream(fis); // 버퍼로 가져온다.
					
					player = new Player(bis); // 받은 파일을 담는다.
					
					player.play(); // 곡 실행
					
				} while (isLoop); // 무한 반복 체킹
				
			}catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			
		}
		
	}


