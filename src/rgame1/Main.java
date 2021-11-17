package rgame1;

public class Main {

		public static final int SCREEN_WIDTH = 1200; //게임 화면 해상도 전역 상수
		public static final int SCREEN_HEIGHT = 720;
		public static final int NOTE_SPEED = 3; //노트 하강 속도
		public static final int SLEEP_TIME = 10; //노트의 하강 주기
		public static final int REACH_TIME = 2; //노트가 생성되고 나서 판정바에 도달하는 시간
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			new FunRgame (); //게임 객체 생성
	}

}
