package rgame3;

public class Beat {

	
	private int time;
	
	private String noteName;
	
	private boolean death; //�ǵ帮�� �ȵǴ� ��Ʈ 
	
	public Beat(int time, String noteName,boolean death) {
		super();
		this.time = time;
		this.noteName = noteName;
		this.death = death;
	}


	public boolean isDeath() {
		return death;
	}


	public void setDeath(boolean death) {
		this.death = death;
	}


	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
}
