package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class TelaMusica {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMusica window = new TelaMusica();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMusica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(95, 95, 95));
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seu Texto:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 26, 76, 27);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setForeground(Color.WHITE);
		lblBpm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBpm.setBounds(10, 392, 137, 27);
		getFrame().getContentPane().add(lblBpm);
		
		JLabel lblInstrumento = new JLabel("Instrumento");
		lblInstrumento.setForeground(Color.WHITE);
		lblInstrumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstrumento.setBounds(10, 429, 137, 27);
		getFrame().getContentPane().add(lblInstrumento);
		
		JTextPane TextoMusica = new JTextPane();
		TextoMusica.setToolTipText("Digite seu texto aqui...");
		TextoMusica.setBackground(new Color(192, 192, 192));
		TextoMusica.setForeground(new Color(255, 255, 255));
		TextoMusica.setBounds(20, 63, 654, 304);
		getFrame().getContentPane().add(TextoMusica);
		
		TextoMusica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == 27)
        		{
        			System.out.println("aqui");
        			TelaPrincipal tela = new TelaPrincipal();
        			frame.dispose();
        			tela.getFrame().setVisible(true);
        		}
       
             }
         });
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBackground(new Color(192, 192, 192));
		spinner.setForeground(new Color(255, 255, 255));
		spinner.setModel(new SpinnerListModel(new String[] {"Guitarra", "Violao", "Violino", "Piano", "Flauta"}));
		spinner.setBounds(126, 429, 165, 21);
		getFrame().getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setToolTipText("Digite um valor maior que 0 e menor que 1000");
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 1000, 5));
		spinner_1.setForeground(Color.WHITE);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_1.setBackground(Color.LIGHT_GRAY);
		spinner_1.setBounds(126, 395, 165, 21);
		getFrame().getContentPane().add(spinner_1);
		
		JLabel playPause = new JLabel("");
		playPause.setIcon(new ImageIcon(".\\.\\IconPlay.png", "play"));
		playPause.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playPause.setBounds(436, 420, 137, 123);
		getFrame().getContentPane().add(playPause);
		
		playPause.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (playPause.getIcon().toString().equals("play"))
				{
					//inserir codigo de dar play na musica
					playPause.setIcon(new ImageIcon(".\\.\\IconPause.png", "pause"));
				}
				else
				{
					//inserir codigo de dar pause na musica
					playPause.setIcon(new ImageIcon(".\\.\\IconPlay.png", "play"));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblNotaAtual = new JLabel("Nota Atual");
		lblNotaAtual.setForeground(Color.WHITE);
		lblNotaAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotaAtual.setBounds(10, 466, 137, 27);
		getFrame().getContentPane().add(lblNotaAtual);
		
		JLabel lblPressioneEscPara = new JLabel("Esc para retornar ao inicio");
		lblPressioneEscPara.setForeground(Color.WHITE);
		lblPressioneEscPara.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPressioneEscPara.setBounds(486, 593, 198, 27);
		getFrame().getContentPane().add(lblPressioneEscPara);
		
		JLabel DisplayNota = new JLabel("Nota");
		DisplayNota.setForeground(Color.WHITE);
		DisplayNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DisplayNota.setBounds(126, 466, 137, 27);
		getFrame().getContentPane().add(DisplayNota);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setForeground(Color.WHITE);
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVolume.setBounds(10, 516, 57, 27);
		getFrame().getContentPane().add(lblVolume);
		
		JLabel barraVol1 = new JLabel("|");
		barraVol1.setHorizontalAlignment(SwingConstants.CENTER);
		barraVol1.setForeground(Color.WHITE);
		barraVol1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol1.setBounds(125, 516, 19, 27);
		getFrame().getContentPane().add(barraVol1);
		
		JLabel barraVol2 = new JLabel("|");
		barraVol2.setForeground(Color.WHITE);
		barraVol2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol2.setBounds(137, 516, 19, 27);
		getFrame().getContentPane().add(barraVol2);
		
		JLabel barraVol3 = new JLabel("|");
		barraVol3.setForeground(Color.WHITE);
		barraVol3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol3.setBounds(149, 516, 19, 27);
		getFrame().getContentPane().add(barraVol3);
		
		JLabel barraVol4 = new JLabel("|");
		barraVol4.setForeground(Color.WHITE);
		barraVol4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol4.setBounds(161, 516, 19, 27);
		getFrame().getContentPane().add(barraVol4);
		
		JLabel barraVol5 = new JLabel("|");
		barraVol5.setForeground(Color.WHITE);
		barraVol5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol5.setBounds(173, 516, 19, 27);
		getFrame().getContentPane().add(barraVol5);
		
		JLabel barraVol6 = new JLabel("|");
		barraVol6.setForeground(Color.WHITE);
		barraVol6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol6.setBounds(185, 516, 19, 27);
		frame.getContentPane().add(barraVol6);
		
		JLabel barraVol7 = new JLabel("|");
		barraVol7.setForeground(Color.WHITE);
		barraVol7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol7.setBounds(197, 516, 19, 27);
		frame.getContentPane().add(barraVol7);
		
		JButton buttonVolMenos = new JButton("-");
		buttonVolMenos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonVolMenos.setBounds(70, 508, 51, 50);
		frame.getContentPane().add(buttonVolMenos);
		
		JButton buttonVolMais = new JButton("+");
		buttonVolMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVolMais.setFont(new Font("Tahoma", Font.PLAIN, 22));
		buttonVolMais.setBounds(224, 508, 50, 50);
		frame.getContentPane().add(buttonVolMais);
		getFrame().setBounds(100, 100, 698, 667);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
		
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
}
