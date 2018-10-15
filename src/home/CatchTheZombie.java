package home;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatchTheZombie extends JFrame {

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();

	private ImageIcon startButtonPressedImage = new ImageIcon(Main.class.getResource("../images/startButtonPressed.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));

	private ImageIcon loadButtonPressedImage = new ImageIcon(Main.class.getResource("../images/loadButtonPressed.png"));
	private ImageIcon loadButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/loadButtonEntered.png"));
	private ImageIcon loadButtonBasicImage = new ImageIcon(Main.class.getResource("../images/loadButtonBasic.png"));

	private ImageIcon quitButtonPressedImage = new ImageIcon(Main.class.getResource("../images/quitButtonPressed.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));


	public CatchTheZombie() { 
		this.setTitle("온수행"); // 윈도우 제목 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼 생성

		MyPanel panel = new MyPanel();
		panel.setLayout(new FlowLayout()); // 레이아웃 설정

		// 버튼 설정
		JButton startButton = new JButton("");
		startButton.setIcon(startButtonBasicImage);
		startButton.setBounds(350, 350, 100, 30); // x, y, w, h
		startButton.setBorderPainted(false); // 버튼의 외곽선을 없애줌
		startButton.setContentAreaFilled(false);  // 버튼의 내용영역 채우기 안함
		startButton.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용 안함
		// 시작버튼 이벤트 처리
		startButton.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				startButton.setIcon(startButtonEnteredImage);
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { startButton.setIcon(startButtonBasicImage); }
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setPressedIcon(startButtonPressedImage);
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				
				// 나중에 추가
			}
		});
		add(startButton);

		JButton loadButton = new JButton("");
		loadButton.setIcon(loadButtonBasicImage);
		loadButton.setBounds(350, 380, 100, 30); // x, y, w, h
		loadButton.setBorderPainted(false); // 버튼의 외곽선을 없애줌
		loadButton.setContentAreaFilled(false);  // 버튼의 내용영역 채우기 안함
		loadButton.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용 안함
		// 이어하기버튼 이벤트 처리
		loadButton.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				loadButton.setIcon(loadButtonEnteredImage);
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { loadButton.setIcon(loadButtonBasicImage); }
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				loadButton.setPressedIcon(loadButtonPressedImage);
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				
				// 나중에 추가
			}
		});
		add(loadButton);

		JButton quitButton = new JButton("");
		quitButton.setIcon(quitButtonBasicImage);
		quitButton.setBounds(350, 410, 100, 30);
		quitButton.setBorderPainted(false); // 버튼의 외곽선을 없애줌
		quitButton.setContentAreaFilled(false);  // 버튼의 내용영역 채우기 안함
		quitButton.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용 안함
		// 종료버튼 이벤트 처리
		quitButton.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { quitButton.setIcon(quitButtonBasicImage); }
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				quitButton.setPressedIcon(quitButtonPressedImage);
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);

		// 인트로 음악 설정
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();

		this.add(panel); 
		this.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 윈도우 창 크기 설정
		//setResizable(false);
		//setLocationRelativeTo(null);
		this.setVisible(true); // 이 메소드를 이용해야 윈도우 창이 나타남
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(introBackground, 0, 0, getWidth(), getHeight(), this);
		}
	}
}