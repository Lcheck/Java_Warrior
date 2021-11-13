package rgame1;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FunRgame extends JFrame {
	
	
	private Image screenImage; //더블버퍼링 (이미지를 화면에 계속 갱신) 을 위한 이미지,그래픽 클래스의 인스턴스
	private Graphics screenGraphic;
	private Image background= new ImageIcon(Main.class.getResource("../images/introBack.jpg")).getImage();//이미지를 담기위한 인스턴스
	//jpg파일이 포함된 이미지 객체를 만들고 해당 객체를 만들어 놓은 이미지 객체에 초기화 시키겠다.
	

	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//메뉴바를 위한 png 이미지 가져오기 일단 메뉴바라는 객체안에 이미지를 불러오는 용

	private ImageIcon Xkey = new ImageIcon(Main.class.getResource("../images/Xkey.png"));
	private ImageIcon Xkey2 = new ImageIcon(Main.class.getResource("../images/Xkey2.png"));
	private ImageIcon start = new ImageIcon(Main.class.getResource("../images/start.png"));
	private ImageIcon start2 = new ImageIcon(Main.class.getResource("../images/start2.png"));

	
	private ImageIcon left = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon right = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.png"));
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.png"));
	
	
	// 버튼을 위한 png 이미지 가져오기
	
	
	private JButton exitButton = new JButton(Xkey);
	private JButton startButton = new JButton(start);   //각 이미지를 가진 버튼 객체 선언
	private JButton leftButton = new JButton(left);
	private JButton rightButton = new JButton(right);
	
	private int mouseX,mouseY; // 프로그램내 마우스의 좌표 변수
	
	private boolean isMainScreen = false ;  //인트로인지 메인인지 체크
	
	
	ArrayList<Track> trackList = new ArrayList<Track>(); // 트랙 클래스를 담을 배열
	
	private Music selectedMusic; // 트랙 클래스의 정보를 담을 변수들
	private Image selectedImage;
	private Image titleImage;
	private int nowSelected = 0 ; //현재 선택된 곡 번호
	
	
	
	
	public FunRgame () {
		setUndecorated(true); //실행시 기본적인 메뉴바는 보이지 앉도록
		setTitle("Really Funny RhythmGame"); //게임 제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 선언한 상수대로 게임 해상도 설정
		setResizable(false); //화면 해상도는 고정
		setLocationRelativeTo(null); //실행후, 게임 실행창을 화면 정중앙에 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로그램을 완전히 제거함
		setVisible(true); //게임창을 보이게함
		setBackground(new Color(0,0,0,0)); // 이것은 기본 맨 뒤의 배경을 흰색으로 하므로써 추가한 메뉴바의 색을 정상적으로 보이도록함
	    setLayout(null); //버튼,라벨 같은 요소의 위치 고정용?
	    
	    
	  
	    Music introMusic = new Music("cunning.mp3",true); 
		introMusic.start();
		//음악 객체 생성, 무한반복 체킹
		
		trackList.add(new Track("Flower Dance.png","select.jpg","left.png","Flower Dance.mp3","Flower Dance.mp3"));
		trackList.add(new Track("Savage.png","SavageStart.jpg","left.png","Savage.mp3","Savage.mp3"));
		//곡 정보 추가
		
		
	exitButton.setBounds(1170,0,30,30);//x버튼 위치 설정
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		//x버튼의 기본 모양 설정 거부
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
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(200,300,60,60);//x버튼 위치 설정
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		//x버튼의 기본 모양 설정 거부
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
		
		rightButton.setVisible(false);
		rightButton.setBounds(1000,300,60,60);//x버튼 위치 설정
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		//버튼의 기본 모양 설정 거부
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
		
		
		
		startButton.setBounds(50,50,300,100);//버튼 위치 설정
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		//버튼의 기본 모양 설정 거부
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
				
				startButton.setVisible(false); //인트로 화면의 시작버튼 제거
				leftButton.setVisible(true);    // 왼오 버튼 보이도록
				rightButton.setVisible(true);
				
				introMusic.close(); //인트로 음악 끄기
				
				selectTrack(0); //첫번 째 음악 켜기
			
				background = new ImageIcon(Main.class.getResource("../images/RealGame.jpg")).getImage(); //본 게임 이미지
				isMainScreen = true ; // 메인 화면 플래그
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
			screenDraw(screenGraphic);
			g.drawImage(screenImage,0,0,null); //이미지를 그린다.
		}
		
		public void screenDraw(Graphics g) {
			
			g.drawImage(background,0,0,null); // 단순히 이미지 그리기
			
			if(isMainScreen) {  //만약 메인화면이라면 셀렉트 메뉴를 제공한다.
				
				g.drawImage(selectedImage, 300, 100, null); // 그림을 그릴 대상과 위치 설정
				g.drawImage(titleImage, 340, 70, null); // 그림을 그릴 대상과 위치 설정
			
				
				}
			
			paintComponents(g); //추가된 객체들을 그려주는 것
 			this.repaint(); //무한 순환용
			
		}
		

public void selectTrack(int nowSelected) {
	
	if (selectedMusic != null) //이 함수가 실행 됐을때, 어떠한 음악이 실행되고 있다면
		selectedMusic.close(); //해당 음악을 종료한다.
	
	
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


} 
