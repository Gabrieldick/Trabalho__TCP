package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\.\\IconPlay.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(270, 503, 273, 123);
		getFrame().getContentPane().add(lblNewLabel_1);
		
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
		
		JLabel DiminuiVol = new JLabel("-");
		DiminuiVol.setForeground(Color.WHITE);
		DiminuiVol.setFont(new Font("Tahoma", Font.PLAIN, 50));
		DiminuiVol.setBounds(99, 516, 19, 27);
		getFrame().getContentPane().add(DiminuiVol);
		
		JLabel AumentaVol = new JLabel("+");
		AumentaVol.setForeground(Color.WHITE);
		AumentaVol.setFont(new Font("Tahoma", Font.PLAIN, 35));
		AumentaVol.setBounds(242, 503, 44, 39);
		getFrame().getContentPane().add(AumentaVol);
		
		JLabel barraVol1 = new JLabel("I");
		barraVol1.setForeground(Color.WHITE);
		barraVol1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol1.setBounds(126, 516, 19, 27);
		getFrame().getContentPane().add(barraVol1);
		
		JLabel barraVol1_1 = new JLabel("I");
		barraVol1_1.setForeground(Color.WHITE);
		barraVol1_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol1_1.setBounds(147, 516, 19, 27);
		getFrame().getContentPane().add(barraVol1_1);
		
		JLabel barraVol1_2 = new JLabel("I");
		barraVol1_2.setForeground(Color.WHITE);
		barraVol1_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol1_2.setBounds(168, 516, 19, 27);
		getFrame().getContentPane().add(barraVol1_2);
		
		JLabel barraVol1_3 = new JLabel("I");
		barraVol1_3.setForeground(Color.WHITE);
		barraVol1_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol1_3.setBounds(191, 516, 19, 27);
		getFrame().getContentPane().add(barraVol1_3);
		
		JLabel barraVol1_4 = new JLabel("I");
		barraVol1_4.setForeground(Color.WHITE);
		barraVol1_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		barraVol1_4.setBounds(213, 516, 19, 27);
		getFrame().getContentPane().add(barraVol1_4);
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
