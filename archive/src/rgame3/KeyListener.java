package rgame3;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{ //키어댑터를 상속받은 키 감지 클래스
	
	
	@Override
	
	public void keyPressed(KeyEvent e) {  //키누름 감지 함수 오버라이딩
		
		
		if (FunRgame.game ==null) { //게임이 진행중이지 않다면 
			
			
			return;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {  //해당키를 눌렀을 때
			
			FunRgame.game.pressS(); //이벤트 함수 실행
			new Music ("pressSound.mp3",false).start(); //효과음 실행
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_D ) {
			FunRgame.game.pressD();
			new Music ("pressSound.mp3",false).start();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F ) {
			
			FunRgame.game.pressF();
			new Music ("pressSound.mp3",false).start();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
			
			FunRgame.game.pressSPACE();
			new Music ("pressSound.mp3",false).start();
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_J ) {
			
			FunRgame.game.pressJ();
			new Music ("pressSound.mp3",false).start();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K ) {
			
			FunRgame.game.pressK();
			new Music ("pressSound.mp3",false).start();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L ) {
			
			FunRgame.game.pressL();	
			new Music ("pressSound.mp3",false).start();
		}
	}
	
	@Override
	
	public void keyReleased(KeyEvent e) {
		
if(e.getKeyCode() == KeyEvent.VK_S) {  //해당키를 떼었을 때
			
	FunRgame.game.releaseS(); //이벤트 함수 실행	
		}
		else if(e.getKeyCode() == KeyEvent.VK_D ) {
			FunRgame.game.releaseD();
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_F ) {
			FunRgame.game.releaseF();
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
			FunRgame.game.releaseSPACE();
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_J ) {
			
			FunRgame.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K ) {
			
			FunRgame.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L ) {
			
			FunRgame.game.releaseL();
		}
	}
	

}
