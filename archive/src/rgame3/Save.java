package rgame3;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Save {  

    public static void main(String[] args) {
    	   LocalDateTime now = LocalDateTime.now();
           
    	   String text = "����� ���� ���� ������ " + Game.score + "�Դϴ�"+ "-" + now +"\n";

           String fileNm = "C:\\Users\\User\\eclipse-����\\rg\\src\\file.txt";


			try{


				File file = new File(fileNm);

				FileWriter fileWrite = new FileWriter(file, true);//true�� �ƴϸ� �����ؼ� ���� �Ұ�



				fileWrite.write(text);

				fileWrite.flush(); 

				fileWrite.close();


			} catch (Exception e){

				e.printStackTrace(); 

			}

    }

}