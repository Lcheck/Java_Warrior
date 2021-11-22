package rgame1;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FunRgame extends JFrame { //Jframe 상속
	
	
	private Image screenImage; //더블버퍼링 (이미지를 화면에 계속 갱신) 을 위한 이미지,그래픽 클래스의 인스턴스
	private Graphics screenGraphic;
	private Image background= new ImageIcon(Main.class.getResource("../images/introBack.jpg")).getImage();//이미지를 담기위한 인스턴스
	
	//jpg파일이 포함된 이미지 객체를 만들고 해당 객체를 만들어 놓은 이미지 객체에 초기화 시키겠다.
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//메뉴바를 위한 png 이미지 가져온 후 메뉴바 객체안에 이미지 넣기

	private ImageIcon Xkey = new ImageIcon(Main.class.getResource("../images/Xkey.png"));
	private ImageIcon Xkey2 = new ImageIcon(Main.class.getResource("../images/Xkey2.png"));
	private ImageIcon start = new ImageIcon(Main.class.getResource("../images/start.png"));
	private ImageIcon start2 = new ImageIcon(Main.class.getResource("../images/start2.png"));
	private ImageIcon left = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon right = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.png"));
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.png"));
	private ImageIcon easy = new ImageIcon(Main.class.getResource("../images/easy.png"));
	private ImageIcon easy2 = new ImageIcon(Main.class.getResource("../images/easy2.png"));
	private ImageIcon back = new ImageIcon(Main.class.getResource("../images/back.png"));
	private ImageIcon next = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon next2 = new ImageIcon(Main.class.getResource("../images/right2.png"));
	// 버튼을 위한 png 이미지 가져오기
	
	
	private JButton exitButton = new JButton(Xkey);
	private JButton startButton = new JButton(start);   //각 이미지를 가진 버튼 객체 선언
	private JButton leftButton = new JButton(left);
	private JButton rightButton = new JButton(right);
	private JButton easyButton = new JButton(easy);
	private JButton backButton = new JButton(back);
	private JButton nextButton = new JButton(next);
	
	ArrayList<Track> trackList = new ArrayList<Track>(); // 트랙 클래스를 담을 배열
	private Music selectedMusic; // 트랙 클래스의 정보를 담을 변수들
	private Image selectedImage;
	private Image titleImage;
	private int nowSelected = 0 ; //현재 선택된 곡 번호
	

	ArrayList<Story> storyList = new ArrayList<Story>(); // 트랙 클래스를 담을 배열
	private Music StoryMusic; // 스토리 클래스의 정보를 담을 변수들
	private Image StoryImage;
	private String Cname;
	private int nowPage = 0 ;
	
	
	
	private int mouseX,mouseY; // 프로그램내 마우스의 좌표 변수
	private boolean isMainScreen = false ;  //인트로인지 메인인지 체크
	private boolean isGameScreen = false ;
	private boolean isStoryScreen = false ; //
	
	
	Music introMusic = new Music("cunning.mp3",true);
	
	public static Game game ; //게임 객체 선언 (게임은 하나만, 통용되어 실행하므로 public static)
	
	public FunRgame () {
		
		storyList.add(new Story("story1.jpg","Flower Dance.mp3","Lee"));
		storyList.add(new Story("story2.jpg","Flower Dance.mp3","Lee"));
		storyList.add(new Story("story3.jpg","Savage.mp3","Lee"));
		
		trackList.add(new Track("Flower Dance.png","select.jpg","introBack.png","Flower Dance.mp3","Flower Dance.mp3","Flower Dance"));
		trackList.add(new Track("Savage.png","SavageStart.jpg","introBack.png","Savage.mp3","Savage.mp3","Savage"));
		//곡 정보 추가 + 위에있는 이유 ? 로딩시간에 따른 오류방지 
		
		
		
		
		setUndecorated(true); //실행시 기본적인 메뉴바는 보이지 앉도록
		setTitle("Really Funny RhythmGame"); //게임 제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 선언한 상수대로 게임 해상도 설정
		setResizable(false); //화면 해상도는 고정
		setLocationRelativeTo(null); //실행후, 게임 실행창을 화면 정중앙에 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로그램을 완전히 제거함
		setVisible(true); //게임창을 보이게함
		setBackground(new Color(0,0,0,0)); // 이것은 기본 맨 뒤의 배경을 흰색으로 하므로써 추가한 메뉴바의 색을 정상적으로 보이도록함
	    setLayout(null); //버튼,라벨 같은 요소의 위치 고정용?
	    
	    addKeyListener(new KeyListener()); //키 리스너 추가
	    
		introMusic.start();
		//음악 객체 생성, 무한반복 체킹
	
		
	
		
	
		
		ButtonSet(exitButton,true,1170,0,30,30); //버튼 기본 세팅
    		
		exitButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				exitButton.setIcon(Xkey2);  //이미지 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				exitButton.setIcon(Xkey);  //이미지 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				System.exit(0);  //종료
			}
			
			
		});
		
		add(exitButton);
	
		
		
		
		ButtonSet(leftButton,false,200,300,60,60); //버튼 기본 세팅
		leftButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				leftButton.setIcon(left2);  //이미지 변경
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				leftButton.setIcon(left);  //이미지 변경
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				 selectLeft();
			}
			
			
		});
		
		add(leftButton);
		
		
		
		ButtonSet(rightButton,false,1000,300,60,60); //버튼 기본 세팅
		rightButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				rightButton.setIcon(right2);  //이미지 변경
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				rightButton.setIcon(right);  //이미지 변경
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				selectRight();
			}
			
			
		});
		
		add(rightButton);
		
		
		ButtonSet(easyButton,false,480,600,300,100); //버튼 기본 세팅
		easyButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				easyButton.setIcon(easy2);  //이미지 변경
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				easyButton.setIcon(easy);  //이미지 변경
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				 gameStart(nowSelected,"Easy");
			}
			
			
		});
		
		add(easyButton);
		
		ButtonSet(backButton,false,50,30,60,60); //버튼 기본 세팅
		backButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				backButton.setIcon(left2);  //이미지 변경
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				backButton.setIcon(left);  //이미지 변경
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				 backMain(); 
			}
			
			
		});
		
		add(backButton);
		
		ButtonSet(nextButton,false,480,600,60,60); //버튼 기본 세팅
		nextButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				nextButton.setIcon(next2);  //이미지 변경
				nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				nextButton.setIcon(next);  //이미지 변경
				nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				if (nowPage==2) { //스토리의 끝부분이면
					
					enterMain();  //셀렉트 화면으로
					StoryMusic.close(); //스토리 음악 끄기
					isStoryScreen=false; // 스토리 플래그 내리기
					
					
			}
			else{
				
				 selectNext(); //아니면 다음 페이지로 
			}
			
			}
		});
		
		add(nextButton);
		
		
		
		
		
		
		ButtonSet(easyButton,false,480,600,300,100); //버튼 기본 세팅
		easyButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				easyButton.setIcon(easy2);  //이미지 변경
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				easyButton.setIcon(easy);  //이미지 변경
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				 gameStart(nowSelected,"Easy");
			}
			
			
		});
		
		add(easyButton);
		
		
		
		ButtonSet(startButton,true,500,450,300,100); //버튼 기본 세팅
		startButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				startButton.setIcon(start2);  //이미지 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				startButton.setIcon(start);  //이미지 변경
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				enterStory();
			}
			
			
		});
		
		add(startButton);
		
		
		
		menuBar.setBounds(0,0,1200,30); //메뉴바 위치 설정
		menuBar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed (MouseEvent e) { //마우스 이벤트 발생시
				
				mouseX=e.getX();   //마우스의 좌표를 얻어오겠다.
				mouseY=e.getY();
				
			}
					
		});
		
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) { // 마우스 드래그 시

				int x = e.getXOnScreen(); // 현재 스크린의 좌표
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // 현재 프레임의 위치 자체를 바꿈
				
			}
			
		});
		add(menuBar);
		
	
		
	} 
	
	

		public void paint(Graphics g) {//Jframe내에 존재해서 화면을 담당하는 약속된 메소드, 프로그램 화면만큼 이미지를 생성
			
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			//해당 크기만큼의 이미지를 만들고 이미지 객체에 넣을 것이다.
			screenGraphic = screenImage.getGraphics(); //스크린 이미지를 이용해 그래픽 객체를 만듬
			screenDraw((Graphics2D)screenGraphic);//화질 향상을 위환 형변환
			g.drawImage(screenImage,0,0,null); //이미지를 그린다.
		}
		
		public void screenDraw(Graphics2D g) { //화질 향상을 위환 형변환
			
			g.drawImage(background,0,0,null); // 단순히 이미지 그리기
			
			if(isMainScreen) {  //만약 메인화면이라면 셀렉트 메뉴를 제공한다.
				
				g.drawImage(selectedImage, 300, 100, null); // 그림을 그릴 대상과 위치 설정
				g.drawImage(titleImage, 340, 70, null); // 그림을 그릴 대상과 위치 설정
			
				
				}
			
			
			if(isStoryScreen) { //스토리 화면 
				
				
				g.drawImage(StoryImage, 0, 0, null); 
				
			}
			
			if(isGameScreen) { 
				
				game.screenDraw(g);   //게임 그리는 부분을 겍체화 하여 메소드 이용
 				
				}
			
			paintComponents(g); //추가된 객체들을 그려주는 것
			
			try {
				
				Thread.sleep(5); // 간격을 두어 좀 자연스럽게
			} catch (Exception e) {
				
				e.printStackTrace(); // ??
			}
			this.repaint(); //무한 순환용
			
			
		}
		

public void selectTrack(int nowSelected) { //곡을 택했을 때
	
	if (selectedMusic != null) { //이 함수가 실행 됐을때, 어떠한 음악이 실행되고 있다면
		selectedMusic.close(); }//해당 음악을 종료한다.
	
	
	//대략 트랙 클래스 배열의 정보를 가져온다는 의미
	titleImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getTitleImage())).getImage();
	selectedImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getStartImage())).getImage();
	selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
	selectedMusic.start();
}

public void selectLeft() {  //왼쪽 버튼 이벤트 함수
	if(nowSelected==0)
		nowSelected = trackList.size() -1;
	else
		nowSelected--;
	selectTrack(nowSelected);
}


public void selectRight() {  //오른쪽 버튼 이벤트 함수
	
	if(nowSelected==trackList.size()-1)
		nowSelected = 0;
	else
		nowSelected++;
	selectTrack(nowSelected);
}

public void selectStory (int nowPage) {
	
	if (nowPage==0) {
		introMusic.close(); 
		startButton.setVisible(false); }//인트로 화면의 시작버튼 제거
	
	if (StoryMusic != null) { //이 함수가 실행 됐을때, 어떠한 음악이 실행되고 있다면
		StoryMusic.close(); }//해당 음악을 종료한다.
	
	
	//대략 스토리 클래스 배열의 정보를 가져온다는 의미
	StoryImage = new ImageIcon(Main.class.getResource("../images/"+ storyList.get(nowPage).getStoryImage())).getImage();
	StoryMusic = new Music(storyList.get(nowPage).getStoryMusic(),true);
	StoryMusic.start();
	
	
}

public void selectNext () {

		nowPage++;
	selectStory(nowPage);
}
	

public void gameStart (int nowSelected, String difficulty) { //리듬게임 시작 함수
	
		if(selectedMusic != null)  //실행중인 음악이 있다면
			selectedMusic.close(); //종료
	
	
		isMainScreen = false;  //셀렉트화면이 아님을 알린다.
		leftButton.setVisible(false); //셀렉트화면의 버튼들을 보이지 않게 
		rightButton.setVisible(false); 
		easyButton.setVisible(false); 
		
		//background=new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				//.getImage();
		//화면 이미지 변경 (트랙 배열의 원소의 겟 스타트이미지 메소드를 호출)
		backButton.setVisible(true); // 백버튼 보이게
	
		isGameScreen =true; //게임시작을 알리겠다.
			
			
			
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,trackList.get(nowSelected).getGameMusic());
			//게임 정보를 기반으로 게임 객체 생성
			
		game.start(); //게임의 스레드 실행
			
		setFocusable(true); //키보드 포커스 

}

public void backMain () { //백 버튼을 누르면
	
	
	isMainScreen = true; //셀렉트 화면 이라고 알림
	
	
	
	
	
	
	leftButton.setVisible(true);
	rightButton.setVisible(true);
	easyButton.setVisible(true);
	leftButton.setVisible(true);
	//background=new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
	//.getImage(); 
	backButton.setVisible(false); //백버튼 안보이게
	
	selectTrack(nowSelected); //원래 선택했던 트랙으로 
	isGameScreen =false; //게임 끝남을 알리겠다.
	game.close(); // 게임 쓰레드 종료

	 

	
	
}

public void enterMain() { //셀렉트 화면으로 
	

	nextButton.setVisible(false);
	background = new ImageIcon(Main.class.getResource("../images/RealGame.jpg")).getImage(); //본 게임 이미지
	isMainScreen = true ; // 메인 화면 플래그 
	leftButton.setVisible(true);    // 왼오 버튼 보이도록
	rightButton.setVisible(true);
	easyButton.setVisible(true);
	selectTrack(0); //첫번 째 음악 켜기
	
	
}

public void enterStory() { //스토리 화면으로 
	
	introMusic.close(); //인트로 음악 끄기
	startButton.setVisible(false); //인트로 화면의 시작버튼 제거
	background=new ImageIcon(Main.class.getResource("../images/" + storyList.get(nowPage).getStoryImage()))
			.getImage();
	isStoryScreen = true ; // 스토리 화면 플래그
	nextButton.setVisible(true); //다음 버튼 보이게
	selectStory(0); //스토리 음악 켜기
	
}
public void ButtonSet(JButton b,boolean visible,int x,int y,int length,int height) { //버튼 기본 설정
	
	b.setVisible(visible);
	b.setBounds(x,y,length,height);//x버튼 위치 설정
	b.setBorderPainted(false);
	b.setContentAreaFilled(false);
	b.setFocusPainted(false);
}
} 
