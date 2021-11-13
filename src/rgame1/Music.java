package rgame1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream; // ���� ������� ���� ���̺� �������� �� Ŭ���� ����Ʈ

import javazoom.jl.player.Player; //���� ������ ���� �ܺ� ���̺� �������� �÷��̾� Ŭ���� ����Ʈ

public class Music extends Thread{ //������ Ŭ���� ��� ( ������� ���α׷� ���� ���� ���α׷�)

	
	private Player player; // �ܺ� ���̺귯���� �÷��̾� Ŭ���� ��ü
	
	private boolean isLoop; // ���� �ݺ� ���� üŷ ��
	
	
	
	private File file ;
	
	private FileInputStream fis;
	
	private BufferedInputStream bis;  // mp3 ������ �ҷ����� ���� ��ü��
	

	
	public Music(String name, boolean isLoop) { //���� ����, ���� �ݺ� ���� ����
		
		try {
			
			this.isLoop = isLoop;
			
			file = new File (Main.class.getResource("../music/" + name).toURI()); // mp3 ���� ��������
			
			fis = new FileInputStream(file); // �ش� ������ �Է¹޾Ƽ�
			
			bis = new BufferedInputStream(fis); // ���۷� �����´�.
			
			player = new Player(bis); // ���� ������ ��´�.
			
			
		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			
		}
	}
	
	
	
		public int getTime() { // ������ �ð� �м�
			
			if (player == null)
				return 0;
			return player.getPosition();
			
		}
		
		
		
		public void close() { // ����ڰ� ���� ��ȯ�� ��, ������ ������ ���������� �����ϰ� ����
			
			isLoop = false;
			player.close();
			this.interrupt(); // �����带 �������·� (���� �����ϴ� �̴� ���α׷��� �����Ѵ�)
			
		}
		
		@Override
		
		
		
		public void run() {
			
			try {
				
				do {
					
					
					fis = new FileInputStream(file); // �ش� ������ �Է¹޾Ƽ� // �ݺ���
					
					bis = new BufferedInputStream(fis); // ���۷� �����´�.
					
					player = new Player(bis); // ���� ������ ��´�.
					
					player.play(); // �� ����
					
				} while (isLoop); // ���� �ݺ� üŷ
				
			}catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			
		}
		
	}


