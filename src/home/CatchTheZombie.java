package home;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;

public class CatchTheZombie extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	
	//private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	//private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	//private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	//private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));

	//private JButton startButton = new JButton(startButtonBasicImage);
	//private JButton quitButton = new JButton(quitButtonBasicImage);
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();

	//private int mouseX, mouseY;

	public CatchTheZombie() { 
		setTitle("온수행");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 화면 정중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 닫았을 떄 완전히 종료 되도록 함
		setVisible(true);	
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		//setBackground(new Color(0, 0, 0, 0)); // paintCompnent 했을 때 배경을 하얀색으로 해줌
		//setLayout(null); // button이나 JRabel을 넣었을 때 그 위치 그대로 넣게 함

		
		/*
		startButton.setBounds(40, 200, 100, 30); // x, y, w, h
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// 게임 시작 이벤트 
			}
		});
		add(startButton);
		
		quitButton.setBounds(40, 330, 100, 30);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		*/
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		//paintComponents(g); // 고정된 정적인 이미지를 component 해줌
		this.repaint(); // 전체 화면 이미지를 프로그램 종료될 때까지 매 순간마다 계속 반복하면서 그려줌
	}

}
