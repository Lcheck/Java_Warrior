package rgame3;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Score {

	public Score(String name, int gameScore) {
		File score;
		File myScore = new File(name, gameScore);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Score.dat"));
			oos.writeObject(myScore);
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Score.dat"));
			score = (File)ois.readObject();
			
			Thread.sleep(300);
			String myInfo = score.getName()+ " : "+ Integer.toString(score.getScore());
			showMessageDialog(null, myInfo);
			
			//(score.getName()+ " " + score.getScore());
//			g.setFont(new Font("Arial", Font.BOLD, 100));
//			g.setColor(Color.white);
//			g.drawString(Integer.toString(score.getScore()), 500, 290);
//			
			
			oos.close();
			ois.close();
		}catch(

		FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(
		IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(
		ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
