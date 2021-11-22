package rgame3;

import static javax.swing.JOptionPane.showMessageDialog;

public class Abuse extends Thread{
	
	
	int bomb;
	String text;
	String sound;
	public Abuse (int bomb,String text,String sound) {
		
		this.sound=sound;
		this.bomb=bomb*1000;
		this.text=text;
	}
	@Override
	public void run() {
		
		try {
			Thread.sleep(bomb);
			new Music(sound,false).start();
			showMessageDialog(null,text);
			interrupt();
			Thread.sleep(5);
			

			
			
		}catch (InterruptedException e){
			
			
			
		}
		
	}
	
	
	public void close() {
		interrupt();
		
	}

}
