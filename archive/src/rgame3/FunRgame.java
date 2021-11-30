package rgame3;
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
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.*;

public class FunRgame extends JFrame { //Jframe 상속
	
	
	private Image screenImage; //더블버퍼링 (이미지를 화면에 계속 갱신) 을 위한 이미지,그래픽 클래스의 인스턴스
	private Graphics screenGraphic;
	private Image background= new ImageIcon(Main.class.getResource("../images/Main.png")).getImage();//이미지를 담기위한 인스턴스
	private Image textBG=new ImageIcon(Main.class.getResource("../images/textBg.png")).getImage();
	private Image Eyes = new ImageIcon(Main.class.getResource("../images/shadow.png")).getImage();
	//jpg파일이 포함된 이미지 객체를 만들고 해당 객체를 만들어 놓은 이미지 객체에 초기화 시키겠다.
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//메뉴바를 위한 png 이미지 가져온 후 메뉴바 객체안에 이미지 넣기

	private ImageIcon Xkey = new ImageIcon(Main.class.getResource("../images/Xkey.png"));
	private ImageIcon Xkey2 = new ImageIcon(Main.class.getResource("../images/Xkey2.png"));
	private ImageIcon start = new ImageIcon(Main.class.getResource("../images/notLook.png"));
	private ImageIcon start2 = new ImageIcon(Main.class.getResource("../images/notLook.png"));
	private ImageIcon left = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon right = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.png"));
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.png"));
	private ImageIcon easy = new ImageIcon(Main.class.getResource("../images/easy.png"));
	private ImageIcon easy2 = new ImageIcon(Main.class.getResource("../images/easy2.png"));
	private ImageIcon back = new ImageIcon(Main.class.getResource("../images/back.png"));
	private ImageIcon next = new ImageIcon(Main.class.getResource("../images/nextButton.png"));
	private ImageIcon next2 = new ImageIcon(Main.class.getResource("../images/nextButton2.png"));
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
	private boolean isStoryScreen = false ; 
	

	
	Music introMusic = new Music("MBG.mp3",true);
	
	public static Game game =null; //게임 객체 선언 (게임은 하나만, 통용되어 실행하므로 public static)
	ArrayList<Abuse> abuseList = new ArrayList<Abuse>() ;
	
	
	String n ="Lee";
	
	
	public FunRgame () {
		
		
		
		new Music("nameInput.mp3",false).start();
		n = showInputDialog("이름을 입력하세요.");
		
		if (n==null) {
			new Music("notice3.mp3",false).start();
			showMessageDialog(null,"운이 좋으시네요");
			return;
		}
		

		trackList.add(new Track("Flower Dance.png","select2.gif","InGameBG.png","Doll Dancing  - Puddle of Infinity.mp3","Doll Dancing  - Puddle of Infinity.mp3","Flower Dance"));
		trackList.add(new Track("Savage.png","select2.gif","story2.jpg","Something.wav","Savage.mp3","Savage"));
		
		
		
		
		storyList.add(new Story("InGameBG.png","DoorClose.mp3",n,"역시, 괜히 온건가"));
		storyList.add(new Story("InGameBG.png","not_open.mp3",n,"뭐야.. 문이 닫혔잖아"));
		storyList.add(new Story("InGameBG.png","Something.mp3",n,"?"));
		storyList.add(new Story("InGameBG.png","MainStep.mp3",n,"거기 누구 있어요?"));
		storyList.add(new Story("InGameBG.png","MainStep.mp3",n,"'...'"));
		storyList.add(new Story("InGameBG.png","effect.mp3",n,"!!"));
	
		storyList.add(new Story("ending6.gif","Scarry.mp3",n,"으아아아"));
		storyList.add(new Story("ending6.gif","Scarry.mp3",n,"으아아아"));
		
		//곡 정보 추가 + 위에있는 이유 ? 로딩시간에 따른 오류방지 
		
//		abuseList.add(new Abuse(10,"보는 부패뿐이 인생에다.","notice3.mp3"));
//		
//		abuseList.add(new Abuse(15, "생명을 커다란 얼마나 가는 뿐이다.","notice3.mp3"));
//		
//		
//		abuseList.add(new Abuse(20,"영원히 시들어 보는 뜨고 ","notice3.mp3"));
//		
//		
//		abuseList.add(new Abuse(25,"많이 같은 아름다우냐?","notice3.mp3"));
//		
//		
//		abuseList.add(new Abuse(35,"용기가 보배를 되려니와","notice3.mp3"));
		
		abuseList.add(new Abuse(35,n+"\r\n보는 부패뿐이 인생에다.","notice5.mp3"));
		
		abuseList.add(new Abuse(50,n+n+n+n+n+n+n+n+n+n+n+n+n+"\r\n용기가 보배를 되려니와","notice2.mp3"));
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
				
				Music buttonEnteredMusic = new Music ("bell.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
				
				exitButton.setIcon(Xkey);  //이미지 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //버튼 클릭시
				
				if(nowPage>0) {
				new Music("notice.mp3",false).start();
				showMessageDialog(null,"어디가");
				}
				else {
				 System.exit(0);  //종료
				}
				
			}
			
			
		});
		
		add(exitButton);
	
		
		
		
		ButtonSet(leftButton,false,200,300,60,60); //버튼 기본 세팅
		leftButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				leftButton.setIcon(left2);  //이미지 변경
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("bell.mp3",false);
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
				
				Music buttonEnteredMusic = new Music ("bell.mp3",false);
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
		
		
		ButtonSet(easyButton,false,450,400,300,100); //버튼 기본 세팅
		easyButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				easyButton.setIcon(easy2);  //이미지 변경
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("bell.mp3",false);
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
		
		
		
//		ButtonSet(backButton,false,50,30,60,60); //버튼 기본 세팅
//		backButton.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			
//			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
//				
//				backButton.setIcon(left2);  //이미지 변경
//				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
//				
//				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
//				buttonEnteredMusic.start();
//			}
//			
//			@Override
//			
//			public void mouseExited(MouseEvent e) {   //버튼과 마우스가 멀어지면
//				
//				backButton.setIcon(left);  //이미지 변경
//				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서 설정(기본)
//			}
//			
//			@Override
//			
//			public void mousePressed(MouseEvent e) {   //버튼 클릭시
//				
//				 backMain(); 
//			}
//			
//			
//		});
		
		add(backButton);
		
		ButtonSet(nextButton,false,1050,500,100,60); //버튼 기본 세팅
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
				
				setFocusable(true); //키보드 포커스 ! 오류 해결 완료 
				
				if (nowPage==storyList.size()-3) { //스토리의 끝부분이면 (엔딩 전 부분)
					enterMain();  //셀렉트 화면으로
					
					
					nowPage++; //엔딩을 위해 1 증가
					// 안내자 멘트 new Music ("test5.mp3",false).start();
					
					
			}
				else if (nowPage==storyList.size()-4) {
					
					introMusic.close(); //인트로 끄기
					selectNext();
				}
			else{
				
				
				 selectNext(); //아니면 다음 페이지로 
			}
			
			}
		});
		
		add(nextButton);
		
		
	
		
		ButtonSet(startButton,true,350,450,100,100); //버튼 기본 세팅
		
		startButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //버튼와 마우스가 만나면
				
				startButton.setIcon(start2);  //이미지 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서 설정 (손가락)
				
				Music buttonEnteredMusic = new Music ("openDoor.mp3",false);
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
				
				
				startButton.setVisible(false);
				
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
		

		new Music("FindStart.mp3",false).start();
		
		
		
	} 
	
	

		public void paint(Graphics g) {//Jframe내에 존재해서 화면을 담당하는 약속된 메소드, 프로그램 화면만큼 이미지를 생성
			
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			//해당 크기만큼의 이미지를 만들고 이미지 객체에 넣을 것이다.
			screenGraphic = screenImage.getGraphics(); //스크린 이미지를 이용해 그래픽 객체를 만듬
			screenDraw((Graphics2D)screenGraphic);//화질 향상을 위환 형변환
			g.drawImage(screenImage,0,0,null); //이미지를 그린다.
		}
		
		public void screenDraw(Graphics2D g) { //화질 향상을 위환 형변환
			
			
			
		if(isStoryScreen) { //스토리 화면 
				
				
				g.drawImage(StoryImage, 0, 0, null); 
				g.drawImage(textBG, 0, 500, null);
				
				g.setColor(Color.white);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				//텍스트 안티에일리어싱 적용
				g.setFont(new Font("고딕체",Font.PLAIN,25));
				g.drawString(storyList.get(nowPage).getCname(),20,500);
				
				g.drawString(storyList.get(nowPage).getText(), 20,550);
			
				if (nowPage==storyList.size()-3) { //깜짝 등장 (눈알)
					
					g.drawImage(Eyes,0,0, null);
				}
				
				
				
			}
			else {
				g.drawImage(background,0,0,null); // 단순히 이미지 그리기
			}
		
			if(isMainScreen) {  //만약 메인화면이라면 셀렉트 메뉴를 제공한다.
				
				g.drawImage(selectedImage, 400, 100, null); // 그림을 그릴 대상과 위치 설정
//				g.drawImage(titleImage, 340, 70, null); // 그림을 그릴 대상과 위치 설정
			
				
				}
		
	
			
			if(isGameScreen) { 
				
				game.screenDraw(g);   //게임 그리는 부분을 겍체화 하여 메소드 이용
 				
				if (game.score>250) { //게임 종료 플래그가 올라가면 
					System.out.println("%%");
					FunAbuse("주며, 찬미를 기관과 하였으며, 이상은 아니다. 투명하되 힘차게 인생의 뭇 많이 피에 얼마나 칼이다. 있을 품었기 하는 부패뿐이다. 든 예수는 소금이라 얼음과 길지 할지라도 생생하며, 방황하여도, 얼마나 뿐이다. 인도하겠다는 꽃이 것은 구할 옷을 청춘 커다란 보는 것이다. 이것이야말로 예수는 트고, 온갖 동력은 수 어디 곳으로 피가 위하여서. 스며들어 그들의 따뜻한 가는 우리 노래하며 인간의 커다란 봄바람이다. 밝은 이상은 봄바람을 그것은 있음으로써 피가 동력은 위하여서. 속에 열매를 충분히 투명하되 가치를 청춘의 가는 부패뿐이다. 이상은 할지라도 있을 시들어 구할 황금시대의 이것은 인생의 듣는다.\r\n"
							+ "\r\n"
							+ "피가 창공에 있는 그들에게 가는 이것이다. 이것은 하는 보이는 어디 밝은 약동하다. 힘차게 영원히 석가는 얼마나 목숨을 것이다. 때에, 속에서 얼음 황금시대의 인간의 것이다. 가슴에 그들의 미인을 하는 더운지라 석가는 끝에 열락의 교향악이다. 피고 그들의 가슴에 있는 사람은 이상 따뜻한 있다. 얼마나 이상 천자만홍이 새가 석가는 속에 뿐이다. 굳세게 넣는 고행을 별과 아름답고 이는 같은 교향악이다. 그와 이상을 고동을 꽃이 되려니와, 원대하고, 우리 그리하였는가?\r\n"
							+ "\r\n"
							+ "있는 우리 청춘에서만 굳세게 곳으로 사라지지 약동하다. 노년에게서 피가 튼튼하며, 넣는 착목한는 사막이다. 못하다 인간이 그들에게 들어 되는 것이다. 긴지라 그들의 인생을 미묘한 말이다. 소금이라 이상의 그들의 보이는 아니더면, 실로 과실이 돋고, 아니다. 거선의 천하를 되려니와, 얼음이 사랑의 하는 보배를 있는가? 불어 타오르고 듣기만 말이다. 미인을 얼음에 이상이 투명하되 위하여, 꾸며 그들은 실현에 실로 있으랴? 보이는 사랑의 소리다.이것은 역사를 얼마나 것이다. 못할 보이는 보내는 거친 아름다우냐? 보는 이것이야말로 곳으로 것은 사막이다.");
					FunAbuse("당신은 " + game.score + "점을 획득했습니다." );		
					Save();
					enterEnding();
				}
				else if (game.score<0) {
					
					nowPage++;
					FunAbuse("주며, 찬미를 기관과 하였으며, 이상은 아니다. 투명하되 힘차게 인생의 뭇 많이 피에 얼마나 칼이다. 있을 품었기 하는 부패뿐이다. 든 예수는 소금이라 얼음과 길지 할지라도 생생하며, 방황하여도, 얼마나 뿐이다. 인도하겠다는 꽃이 것은 구할 옷을 청춘 커다란 보는 것이다. 이것이야말로 예수는 트고, 온갖 동력은 수 어디 곳으로 피가 위하여서. 스며들어 그들의 따뜻한 가는 우리 노래하며 인간의 커다란 봄바람이다. 밝은 이상은 봄바람을 그것은 있음으로써 피가 동력은 위하여서. 속에 열매를 충분히 투명하되 가치를 청춘의 가는 부패뿐이다. 이상은 할지라도 있을 시들어 구할 황금시대의 이것은 인생의 듣는다.\r\n"
							+ "\r\n"
							+ "피가 창공에 있는 그들에게 가는 이것이다. 이것은 하는 보이는 어디 밝은 약동하다. 힘차게 영원히 석가는 얼마나 목숨을 것이다. 때에, 속에서 얼음 황금시대의 인간의 것이다. 가슴에 그들의 미인을 하는 더운지라 석가는 끝에 열락의 교향악이다. 피고 그들의 가슴에 있는 사람은 이상 따뜻한 있다. 얼마나 이상 천자만홍이 새가 석가는 속에 뿐이다. 굳세게 넣는 고행을 별과 아름답고 이는 같은 교향악이다. 그와 이상을 고동을 꽃이 되려니와, 원대하고, 우리 그리하였는가?\r\n"
							+ "\r\n"
							+ "있는 우리 청춘에서만 굳세게 곳으로 사라지지 약동하다. 노년에게서 피가 튼튼하며, 넣는 착목한는 사막이다. 못하다 인간이 그들에게 들어 되는 것이다. 긴지라 그들의 인생을 미묘한 말이다. 소금이라 이상의 그들의 보이는 아니더면, 실로 과실이 돋고, 아니다. 거선의 천하를 되려니와, 얼음이 사랑의 하는 보배를 있는가? 불어 타오르고 듣기만 말이다. 미인을 얼음에 이상이 투명하되 위하여, 꾸며 그들은 실현에 실로 있으랴? 보이는 사랑의 소리다.이것은 역사를 얼마나 것이다. 못할 보이는 보내는 거친 아름다우냐? 보는 이것이야말로 곳으로 것은 사막이다.");
					FunAbuse("당신은 " + game.score + "점을 획득했습니다." );
					Save();
					enterEnding();
				}
				
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
	
	
	if(StoryMusic != null) {  //실행중인 음악이 있다면
		StoryMusic.close(); }//종료
	
	
	StoryImage = new ImageIcon(Main.class.getResource("../images/"+ storyList.get(nowPage).getStoryImage())).getImage();
	StoryMusic = new Music(storyList.get(nowPage).getStoryMusic(),false);
	StoryMusic.start();
	
	
}

public void selectNext () {

		nowPage++;
	selectStory(nowPage);
}
	

public void gameStart (int nowSelected, String difficulty) { //리듬게임 시작 함수
	
		if(selectedMusic != null) {  //실행중인 음악이 있다면
			selectedMusic.close(); }//종료
	
	
		isMainScreen = false;  //셀렉트화면이 아님을 알린다.
		leftButton.setVisible(false); //셀렉트화면의 버튼들을 보이지 않게 
		rightButton.setVisible(false); 
		easyButton.setVisible(false); 
		
		background=new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		//화면 이미지 변경 (트랙 배열의 원소의 겟 스타트이미지 메소드를 호출)
		backButton.setVisible(true); // 백버튼 보이게
	
		isGameScreen =true; //게임시작을 알리겠다.
			
				
		
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,trackList.get(nowSelected).getGameMusic());
			//게임 정보를 기반으로 게임 객체 생성
			
		game.start(); //게임의 스레드 실행
		
		for(Abuse temp:abuseList) {
			
			temp.start();  //괴롭히기 시작
		}
		
		setFocusable(true); //키보드 포커스

}

//public void backMain () { //백 버튼을 누르면
//	
//	
//	isMainScreen = true; //셀렉트 화면 이라고 알림
//	
//	leftButton.setVisible(true);
//	rightButton.setVisible(true);
//	easyButton.setVisible(true);
//	leftButton.setVisible(true);
//	background=new ImageIcon(Main.class.getResource("../images/InGameBG.png"))
//	.getImage(); 
//	backButton.setVisible(false); //백버튼 안보이게
//	
//	selectTrack(nowSelected); //원래 선택했던 트랙으로 
//	isGameScreen =false; //게임 끝남을 알리겠다.
//	game.close(); // 게임 쓰레드 종료
//	for(Abuse temp:abuseList) {
//		
//		temp.close();  //괴롭히기 끝
//	}
//	setFocusable(false);//키보드 포커스 해제 
//	 
//
//	
//	
//}

public void enterMain() { //셀렉트 화면으로 
	
	StoryMusic.close(); //스토리 음악 끄기
	isStoryScreen=false; // 스토리 플래그 내리기
	nextButton.setVisible(false);
	
	background = new ImageIcon(Main.class.getResource("../images/InGameBG.png")).getImage(); //본 게임 이미지
	isMainScreen = true ; // 메인 화면 플래그 
//	leftButton.setVisible(true);    // 왼오 버튼 보이도록
//	rightButton.setVisible(true);
	easyButton.setVisible(true);
	selectTrack(nowSelected); //첫번 째 음악 켜기
	
	
}

public void enterEnding() {
	
	isStoryScreen=true;
	isGameScreen =false;
	backButton.setVisible(false);
	selectStory(nowPage);
	setFocusable(false);//키보드 포커스 해제
	game.close(); // 게임 쓰레드 종료
	
	for(Abuse temp:abuseList) {
		
		temp.close();  //괴롭히기 끝
	} 
	
	
	


	
	

	


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

public void FunAbuse(String t) {
	
	String text = t;
	
	ArrayList<Abuse> al = new ArrayList<Abuse>() ;
	
	for (int j=1 ; j<2; j++) {
		
		al.add(new Abuse(j,text,"notice3.mp3"));
	}
	
for(Abuse temp:al) {
	
		temp.start();  //괴롭히기 시작
		
	}
	
}
public void Save() {
	LocalDateTime now = LocalDateTime.now();
    
	   String text = "당신이 얻은 최종 점수는 " + Game.score + "입니다"+ " - " + now +"\n"; // 날짜와 점수 같이 저장

    String fileNm = "C:\\Users\\User\\eclipse-성적\\rg\\src\\file.txt";// 경로를 자기 위치로 바꿔야 정상적으로 작동함


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
