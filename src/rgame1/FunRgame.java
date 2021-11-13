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
	
	
	private Image screenImage; //������۸� (�̹����� ȭ�鿡 ��� ����) �� ���� �̹���,�׷��� Ŭ������ �ν��Ͻ�
	private Graphics screenGraphic;
	private Image background= new ImageIcon(Main.class.getResource("../images/introBack.jpg")).getImage();//�̹����� ������� �ν��Ͻ�
	//jpg������ ���Ե� �̹��� ��ü�� ����� �ش� ��ü�� ����� ���� �̹��� ��ü�� �ʱ�ȭ ��Ű�ڴ�.
	

	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//�޴��ٸ� ���� png �̹��� �������� �ϴ� �޴��ٶ�� ��ü�ȿ� �̹����� �ҷ����� ��

	private ImageIcon Xkey = new ImageIcon(Main.class.getResource("../images/Xkey.png"));
	private ImageIcon Xkey2 = new ImageIcon(Main.class.getResource("../images/Xkey2.png"));
	private ImageIcon start = new ImageIcon(Main.class.getResource("../images/start.png"));
	private ImageIcon start2 = new ImageIcon(Main.class.getResource("../images/start2.png"));

	
	private ImageIcon left = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon right = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.png"));
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.png"));
	
	
	// ��ư�� ���� png �̹��� ��������
	
	
	private JButton exitButton = new JButton(Xkey);
	private JButton startButton = new JButton(start);   //�� �̹����� ���� ��ư ��ü ����
	private JButton leftButton = new JButton(left);
	private JButton rightButton = new JButton(right);
	
	private int mouseX,mouseY; // ���α׷��� ���콺�� ��ǥ ����
	
	private boolean isMainScreen = false ;  //��Ʈ������ �������� üũ
	
	
	ArrayList<Track> trackList = new ArrayList<Track>(); // Ʈ�� Ŭ������ ���� �迭
	
	private Music selectedMusic; // Ʈ�� Ŭ������ ������ ���� ������
	private Image selectedImage;
	private Image titleImage;
	private int nowSelected = 0 ; //���� ���õ� �� ��ȣ
	
	
	
	
	public FunRgame () {
		setUndecorated(true); //����� �⺻���� �޴��ٴ� ������ �ɵ���
		setTitle("Really Funny RhythmGame"); //���� ����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ������ ������ ���� �ػ� ����
		setResizable(false); //ȭ�� �ػ󵵴� ����
		setLocationRelativeTo(null); //������, ���� ����â�� ȭ�� ���߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����� ���α׷��� ������ ������
		setVisible(true); //����â�� ���̰���
		setBackground(new Color(0,0,0,0)); // �̰��� �⺻ �� ���� ����� ������� �ϹǷν� �߰��� �޴����� ���� ���������� ���̵�����
	    setLayout(null); //��ư,�� ���� ����� ��ġ ������?
	    
	    
	  
	    Music introMusic = new Music("cunning.mp3",true); 
		introMusic.start();
		//���� ��ü ����, ���ѹݺ� üŷ
		
		trackList.add(new Track("Flower Dance.png","select.jpg","left.png","Flower Dance.mp3","Flower Dance.mp3"));
		trackList.add(new Track("Savage.png","SavageStart.jpg","left.png","Savage.mp3","Savage.mp3"));
		//�� ���� �߰�
		
		
	exitButton.setBounds(1170,0,30,30);//x��ư ��ġ ����
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		//x��ư�� �⺻ ��� ���� �ź�
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
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(200,300,60,60);//x��ư ��ġ ����
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		//x��ư�� �⺻ ��� ���� �ź�
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
		
		rightButton.setVisible(false);
		rightButton.setBounds(1000,300,60,60);//x��ư ��ġ ����
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		//��ư�� �⺻ ��� ���� �ź�
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
		
		
		
		startButton.setBounds(50,50,300,100);//��ư ��ġ ����
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		//��ư�� �⺻ ��� ���� �ź�
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
				
				startButton.setVisible(false); //��Ʈ�� ȭ���� ���۹�ư ����
				leftButton.setVisible(true);    // �޿� ��ư ���̵���
				rightButton.setVisible(true);
				
				introMusic.close(); //��Ʈ�� ���� ����
				
				selectTrack(0); //ù�� ° ���� �ѱ�
			
				background = new ImageIcon(Main.class.getResource("../images/RealGame.jpg")).getImage(); //�� ���� �̹���
				isMainScreen = true ; // ���� ȭ�� �÷���
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
			screenDraw(screenGraphic);
			g.drawImage(screenImage,0,0,null); //�̹����� �׸���.
		}
		
		public void screenDraw(Graphics g) {
			
			g.drawImage(background,0,0,null); // �ܼ��� �̹��� �׸���
			
			if(isMainScreen) {  //���� ����ȭ���̶�� ����Ʈ �޴��� �����Ѵ�.
				
				g.drawImage(selectedImage, 300, 100, null); // �׸��� �׸� ���� ��ġ ����
				g.drawImage(titleImage, 340, 70, null); // �׸��� �׸� ���� ��ġ ����
			
				
				}
			
			paintComponents(g); //�߰��� ��ü���� �׷��ִ� ��
 			this.repaint(); //���� ��ȯ��
			
		}
		

public void selectTrack(int nowSelected) {
	
	if (selectedMusic != null) //�� �Լ��� ���� ������, ��� ������ ����ǰ� �ִٸ�
		selectedMusic.close(); //�ش� ������ �����Ѵ�.
	
	
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


} 
