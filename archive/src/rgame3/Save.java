package rgame3;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Save {  

    public static void main(String[] args) {
    	   LocalDateTime now = LocalDateTime.now();
           
    	   String text = "당신이 얻은 최종 점수는 " + Game.score + "입니다"+ "-" + now +"\n";

           String fileNm = "C:\\Users\\User\\eclipse-성적\\rg\\src\\file.txt";


			try{


				File file = new File(fileNm);

				FileWriter fileWrite = new FileWriter(file, true);//true가 아니면 수정해서 저장 불가



				fileWrite.write(text);

				fileWrite.flush(); 

				fileWrite.close();


			} catch (Exception e){

				e.printStackTrace(); 

			}

    }

}