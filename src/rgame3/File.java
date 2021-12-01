package rgame3;

import java.io.Serializable;

public class File implements Serializable{
	private String name;
	private int score;
	
	public File() {
		this.name = "Unknown";
		this.score = 0;
	}
	
	public File(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}	
}
