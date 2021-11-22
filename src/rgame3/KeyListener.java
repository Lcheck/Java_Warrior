package rgame3;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{ //Ű����͸� ��ӹ��� Ű ���� Ŭ����
	
	
	@Override
	
	public void keyPressed(KeyEvent e) {  //Ű���� ���� �Լ� �������̵�
		
		
		if (FunRgame.game ==null) { //������ ���������� �ʴٸ� 
			
			
			return;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {  //�ش�Ű�� ������ ��
			
			FunRgame.game.pressS(); //�̺�Ʈ �Լ� ����
			new Music ("pressSound.mp3",false).start(); //ȿ���� ����
			
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
		
if(e.getKeyCode() == KeyEvent.VK_S) {  //�ش�Ű�� ������ ��
			
	FunRgame.game.releaseS(); //�̺�Ʈ �Լ� ����	
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
