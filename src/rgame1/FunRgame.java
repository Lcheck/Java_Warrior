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

public class FunRgame extends JFrame { //Jframe ���
	
	
	private Image screenImage; //������۸� (�̹����� ȭ�鿡 ��� ����) �� ���� �̹���,�׷��� Ŭ������ �ν��Ͻ�
	private Graphics screenGraphic;
	private Image background= new ImageIcon(Main.class.getResource("../images/introBack.jpg")).getImage();//�̹����� ������� �ν��Ͻ�
	
	//jpg������ ���Ե� �̹��� ��ü�� ����� �ش� ��ü�� ����� ���� �̹��� ��ü�� �ʱ�ȭ ��Ű�ڴ�.
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//�޴��ٸ� ���� png �̹��� ������ �� �޴��� ��ü�ȿ� �̹��� �ֱ�

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
	// ��ư�� ���� png �̹��� ��������
	
	
	private JButton exitButton = new JButton(Xkey);
	private JButton startButton = new JButton(start);   //�� �̹����� ���� ��ư ��ü ����
	private JButton leftButton = new JButton(left);
	private JButton rightButton = new JButton(right);
	private JButton easyButton = new JButton(easy);
	private JButton backButton = new JButton(back);
	private JButton nextButton = new JButton(next);
	
	ArrayList<Track> trackList = new ArrayList<Track>(); // Ʈ�� Ŭ������ ���� �迭
	private Music selectedMusic; // Ʈ�� Ŭ������ ������ ���� ������
	private Image selectedImage;
	private Image titleImage;
	private int nowSelected = 0 ; //���� ���õ� �� ��ȣ
	

	ArrayList<Story> storyList = new ArrayList<Story>(); // Ʈ�� Ŭ������ ���� �迭
	private Music StoryMusic; // ���丮 Ŭ������ ������ ���� ������
	private Image StoryImage;
	private String Cname;
	private int nowPage = 0 ;
	
	
	
	private int mouseX,mouseY; // ���α׷��� ���콺�� ��ǥ ����
	private boolean isMainScreen = false ;  //��Ʈ������ �������� üũ
	private boolean isGameScreen = false ;
	private boolean isStoryScreen = false ; //
	
	
	Music introMusic = new Music("cunning.mp3",true);
	
	public static Game game ; //���� ��ü ���� (������ �ϳ���, ���Ǿ� �����ϹǷ� public static)
	
	public FunRgame () {
		
		storyList.add(new Story("story1.jpg","Flower Dance.mp3","Lee"));
		storyList.add(new Story("story2.jpg","Flower Dance.mp3","Lee"));
		storyList.add(new Story("story3.jpg","Savage.mp3","Lee"));
		
		trackList.add(new Track("Flower Dance.png","select.jpg","introBack.png","Flower Dance.mp3","Flower Dance.mp3","Flower Dance"));
		trackList.add(new Track("Savage.png","SavageStart.jpg","introBack.png","Savage.mp3","Savage.mp3","Savage"));
		//�� ���� �߰� + �����ִ� ���� ? �ε��ð��� ���� �������� 
		
		
		
		
		setUndecorated(true); //����� �⺻���� �޴��ٴ� ������ �ɵ���
		setTitle("Really Funny RhythmGame"); //���� ����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ������ ������ ���� �ػ� ����
		setResizable(false); //ȭ�� �ػ󵵴� ����
		setLocationRelativeTo(null); //������, ���� ����â�� ȭ�� ���߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����� ���α׷��� ������ ������
		setVisible(true); //����â�� ���̰���
		setBackground(new Color(0,0,0,0)); // �̰��� �⺻ �� ���� ����� ������� �ϹǷν� �߰��� �޴����� ���� ���������� ���̵�����
	    setLayout(null); //��ư,�� ���� ����� ��ġ ������?
	    
	    addKeyListener(new KeyListener()); //Ű ������ �߰�
	    
		introMusic.start();
		//���� ��ü ����, ���ѹݺ� üŷ
	
		
	
		
	
		
		ButtonSet(exitButton,true,1170,0,30,30); //��ư �⺻ ����
    		
		exitButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				exitButton.setIcon(Xkey2);  //�̹��� ����
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				exitButton.setIcon(Xkey);  //�̹��� ����
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				System.exit(0);  //����
			}
			
			
		});
		
		add(exitButton);
	
		
		
		
		ButtonSet(leftButton,false,200,300,60,60); //��ư �⺻ ����
		leftButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				leftButton.setIcon(left2);  //�̹��� ����
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				leftButton.setIcon(left);  //�̹��� ����
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				 selectLeft();
			}
			
			
		});
		
		add(leftButton);
		
		
		
		ButtonSet(rightButton,false,1000,300,60,60); //��ư �⺻ ����
		rightButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				rightButton.setIcon(right2);  //�̹��� ����
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				rightButton.setIcon(right);  //�̹��� ����
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				selectRight();
			}
			
			
		});
		
		add(rightButton);
		
		
		ButtonSet(easyButton,false,480,600,300,100); //��ư �⺻ ����
		easyButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				easyButton.setIcon(easy2);  //�̹��� ����
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				easyButton.setIcon(easy);  //�̹��� ����
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				 gameStart(nowSelected,"Easy");
			}
			
			
		});
		
		add(easyButton);
		
		ButtonSet(backButton,false,50,30,60,60); //��ư �⺻ ����
		backButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				backButton.setIcon(left2);  //�̹��� ����
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				backButton.setIcon(left);  //�̹��� ����
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				 backMain(); 
			}
			
			
		});
		
		add(backButton);
		
		ButtonSet(nextButton,false,480,600,60,60); //��ư �⺻ ����
		nextButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				nextButton.setIcon(next2);  //�̹��� ����
				nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				nextButton.setIcon(next);  //�̹��� ����
				nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				if (nowPage==2) { //���丮�� ���κ��̸�
					
					enterMain();  //����Ʈ ȭ������
					StoryMusic.close(); //���丮 ���� ����
					isStoryScreen=false; // ���丮 �÷��� ������
					
					
			}
			else{
				
				 selectNext(); //�ƴϸ� ���� �������� 
			}
			
			}
		});
		
		add(nextButton);
		
		
		
		
		
		
		ButtonSet(easyButton,false,480,600,300,100); //��ư �⺻ ����
		easyButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				easyButton.setIcon(easy2);  //�̹��� ����
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				easyButton.setIcon(easy);  //�̹��� ����
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				 gameStart(nowSelected,"Easy");
			}
			
			
		});
		
		add(easyButton);
		
		
		
		ButtonSet(startButton,true,500,450,300,100); //��ư �⺻ ����
		startButton.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseEntered(MouseEvent e) {   //��ư�� ���콺�� ������
				
				startButton.setIcon(start2);  //�̹��� ����
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ�� ���� (�հ���)
				
				Music buttonEnteredMusic = new Music ("ButtonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			
			public void mouseExited(MouseEvent e) {   //��ư�� ���콺�� �־�����
				
				startButton.setIcon(start);  //�̹��� ����
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ�� ����(�⺻)
			}
			
			@Override
			
			public void mousePressed(MouseEvent e) {   //��ư Ŭ����
				
				enterStory();
			}
			
			
		});
		
		add(startButton);
		
		
		
		menuBar.setBounds(0,0,1200,30); //�޴��� ��ġ ����
		menuBar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed (MouseEvent e) { //���콺 �̺�Ʈ �߻���
				
				mouseX=e.getX();   //���콺�� ��ǥ�� �����ڴ�.
				mouseY=e.getY();
				
			}
					
		});
		
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) { // ���콺 �巡�� ��

				int x = e.getXOnScreen(); // ���� ��ũ���� ��ǥ
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // ���� �������� ��ġ ��ü�� �ٲ�
				
			}
			
		});
		add(menuBar);
		
	
		
	} 
	
	

		public void paint(Graphics g) {//Jframe���� �����ؼ� ȭ���� ����ϴ� ��ӵ� �޼ҵ�, ���α׷� ȭ�鸸ŭ �̹����� ����
			
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			//�ش� ũ�⸸ŭ�� �̹����� ����� �̹��� ��ü�� ���� ���̴�.
			screenGraphic = screenImage.getGraphics(); //��ũ�� �̹����� �̿��� �׷��� ��ü�� ����
			screenDraw((Graphics2D)screenGraphic);//ȭ�� ����� ��ȯ ����ȯ
			g.drawImage(screenImage,0,0,null); //�̹����� �׸���.
		}
		
		public void screenDraw(Graphics2D g) { //ȭ�� ����� ��ȯ ����ȯ
			
			g.drawImage(background,0,0,null); // �ܼ��� �̹��� �׸���
			
			if(isMainScreen) {  //���� ����ȭ���̶�� ����Ʈ �޴��� �����Ѵ�.
				
				g.drawImage(selectedImage, 300, 100, null); // �׸��� �׸� ���� ��ġ ����
				g.drawImage(titleImage, 340, 70, null); // �׸��� �׸� ���� ��ġ ����
			
				
				}
			
			
			if(isStoryScreen) { //���丮 ȭ�� 
				
				
				g.drawImage(StoryImage, 0, 0, null); 
				
			}
			
			if(isGameScreen) { 
				
				game.screenDraw(g);   //���� �׸��� �κ��� ��üȭ �Ͽ� �޼ҵ� �̿�
 				
				}
			
			paintComponents(g); //�߰��� ��ü���� �׷��ִ� ��
			
			try {
				
				Thread.sleep(5); // ������ �ξ� �� �ڿ�������
			} catch (Exception e) {
				
				e.printStackTrace(); // ??
			}
			this.repaint(); //���� ��ȯ��
			
			
		}
		

public void selectTrack(int nowSelected) { //���� ������ ��
	
	if (selectedMusic != null) { //�� �Լ��� ���� ������, ��� ������ ����ǰ� �ִٸ�
		selectedMusic.close(); }//�ش� ������ �����Ѵ�.
	
	
	//�뷫 Ʈ�� Ŭ���� �迭�� ������ �����´ٴ� �ǹ�
	titleImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getTitleImage())).getImage();
	selectedImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getStartImage())).getImage();
	selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
	selectedMusic.start();
}

public void selectLeft() {  //���� ��ư �̺�Ʈ �Լ�
	if(nowSelected==0)
		nowSelected = trackList.size() -1;
	else
		nowSelected--;
	selectTrack(nowSelected);
}


public void selectRight() {  //������ ��ư �̺�Ʈ �Լ�
	
	if(nowSelected==trackList.size()-1)
		nowSelected = 0;
	else
		nowSelected++;
	selectTrack(nowSelected);
}

public void selectStory (int nowPage) {
	
	if (nowPage==0) {
		introMusic.close(); 
		startButton.setVisible(false); }//��Ʈ�� ȭ���� ���۹�ư ����
	
	if (StoryMusic != null) { //�� �Լ��� ���� ������, ��� ������ ����ǰ� �ִٸ�
		StoryMusic.close(); }//�ش� ������ �����Ѵ�.
	
	
	//�뷫 ���丮 Ŭ���� �迭�� ������ �����´ٴ� �ǹ�
	StoryImage = new ImageIcon(Main.class.getResource("../images/"+ storyList.get(nowPage).getStoryImage())).getImage();
	StoryMusic = new Music(storyList.get(nowPage).getStoryMusic(),true);
	StoryMusic.start();
	
	
}

public void selectNext () {

		nowPage++;
	selectStory(nowPage);
}
	

public void gameStart (int nowSelected, String difficulty) { //������� ���� �Լ�
	
		if(selectedMusic != null)  //�������� ������ �ִٸ�
			selectedMusic.close(); //����
	
	
		isMainScreen = false;  //����Ʈȭ���� �ƴ��� �˸���.
		leftButton.setVisible(false); //����Ʈȭ���� ��ư���� ������ �ʰ� 
		rightButton.setVisible(false); 
		easyButton.setVisible(false); 
		
		//background=new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				//.getImage();
		//ȭ�� �̹��� ���� (Ʈ�� �迭�� ������ �� ��ŸƮ�̹��� �޼ҵ带 ȣ��)
		backButton.setVisible(true); // ���ư ���̰�
	
		isGameScreen =true; //���ӽ����� �˸��ڴ�.
			
			
			
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,trackList.get(nowSelected).getGameMusic());
			//���� ������ ������� ���� ��ü ����
			
		game.start(); //������ ������ ����
			
		setFocusable(true); //Ű���� ��Ŀ�� 

}

public void backMain () { //�� ��ư�� ������
	
	
	isMainScreen = true; //����Ʈ ȭ�� �̶�� �˸�
	
	
	
	
	
	
	leftButton.setVisible(true);
	rightButton.setVisible(true);
	easyButton.setVisible(true);
	leftButton.setVisible(true);
	//background=new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
	//.getImage(); 
	backButton.setVisible(false); //���ư �Ⱥ��̰�
	
	selectTrack(nowSelected); //���� �����ߴ� Ʈ������ 
	isGameScreen =false; //���� ������ �˸��ڴ�.
	game.close(); // ���� ������ ����

	 

	
	
}

public void enterMain() { //����Ʈ ȭ������ 
	

	nextButton.setVisible(false);
	background = new ImageIcon(Main.class.getResource("../images/RealGame.jpg")).getImage(); //�� ���� �̹���
	isMainScreen = true ; // ���� ȭ�� �÷��� 
	leftButton.setVisible(true);    // �޿� ��ư ���̵���
	rightButton.setVisible(true);
	easyButton.setVisible(true);
	selectTrack(0); //ù�� ° ���� �ѱ�
	
	
}

public void enterStory() { //���丮 ȭ������ 
	
	introMusic.close(); //��Ʈ�� ���� ����
	startButton.setVisible(false); //��Ʈ�� ȭ���� ���۹�ư ����
	background=new ImageIcon(Main.class.getResource("../images/" + storyList.get(nowPage).getStoryImage()))
			.getImage();
	isStoryScreen = true ; // ���丮 ȭ�� �÷���
	nextButton.setVisible(true); //���� ��ư ���̰�
	selectStory(0); //���丮 ���� �ѱ�
	
}
public void ButtonSet(JButton b,boolean visible,int x,int y,int length,int height) { //��ư �⺻ ����
	
	b.setVisible(visible);
	b.setBounds(x,y,length,height);//x��ư ��ġ ����
	b.setBorderPainted(false);
	b.setContentAreaFilled(false);
	b.setFocusPainted(false);
}
} 
