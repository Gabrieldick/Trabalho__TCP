package Telas;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Func_musica.identificaCaractere;

import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel; 	
public class TelaPrincipal implements MouseListener {

	private JFrame frame;
	private JTextPane TextoMusica = new JTextPane();
	
	final JFileChooser fc = new JFileChooser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 95, 95));
		frame.getContentPane().setLayout(null);
		
		JLabel lblTexto = new JLabel("Seu Texto:");
		lblTexto.setForeground(new Color(255, 255, 255));
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTexto.setBounds(10, 26, 76, 27);
		frame.getContentPane().add(lblTexto);
		
		JLabel lblEscolherArquivo = new JLabel("Escolher Arquivo");
		lblEscolherArquivo.setForeground(new Color(255, 255, 255));
		lblEscolherArquivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscolherArquivo.setBounds(10, 389, 137, 27);
		frame.getContentPane().add(lblEscolherArquivo);
		
		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setForeground(Color.WHITE);
		lblBpm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBpm.setBounds(10, 426, 137, 27);
		frame.getContentPane().add(lblBpm);
		
		JLabel lblInstrumento = new JLabel("Instrumento");
		lblInstrumento.setForeground(Color.WHITE);
		lblInstrumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstrumento.setBounds(10, 463, 137, 27);
		frame.getContentPane().add(lblInstrumento);
		
		JButton SelectArquivo = new JButton("Procurar Arquivo");
		SelectArquivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SelectArquivo.setBounds(126, 392, 165, 21);
		frame.getContentPane().add(SelectArquivo);
		
		SelectArquivo.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser selecionaArq = new JFileChooser();
		        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecione um arquivo de texto", "txt");
		        selecionaArq.setFileFilter(filtro);
		        int abriu = selecionaArq.showOpenDialog(null);
		        
		        if(abriu == JFileChooser.APPROVE_OPTION)
		        {
		        	String caminho = selecionaArq.getSelectedFile().getAbsolutePath();
		        	try {
		        	      File arquivo = new File(caminho);
		        	      Scanner leitor = new Scanner(arquivo);
		        	      while (leitor.hasNextLine()) {
		        	        String data = leitor.nextLine();
		        	        System.out.println(data);
		        	      }
		        	      leitor.close();
		        	    } catch (FileNotFoundException excecao) {
		        	      System.out.println("Erro ao abrir o arquivo");
		        	      excecao.printStackTrace();
		        	    }
		        }
		    }
		    
		});
		
		
		
		
		TextoMusica.setToolTipText("Digite seu texto aqui...");
		TextoMusica.setBackground(new Color(192, 192, 192));
		TextoMusica.setForeground(new Color(255, 255, 255));
		TextoMusica.setBounds(20, 63, 512, 304);
		frame.getContentPane().add(TextoMusica);
		
		
		SelectArquivo.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser selecionaArq = new JFileChooser();
		        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecione um arquivo de texto", "txt");
		        selecionaArq.setFileFilter(filtro);
		        int abriu = selecionaArq.showOpenDialog(null);
		        
		        if(abriu == JFileChooser.APPROVE_OPTION)
		        {
		        	String caminho = selecionaArq.getSelectedFile().getAbsolutePath();
		        	try {
		        	      File arquivo = new File(caminho);
		        	      Scanner leitor = new Scanner(arquivo);
		        	      while (leitor.hasNextLine()) {
		        	        String data = leitor.nextLine();
		        	        System.out.println(data);
		        	        TextoMusica.setText(data);
		        	      }
		        	      leitor.close();
		        	    } catch (FileNotFoundException excecao) {
		        	      System.out.println("Erro ao abrir o arquivo");
		        	      excecao.printStackTrace();
		        	    }
		        }
		    }
		    
		});
		
		
		JSpinner SelectBPM = new JSpinner();
		SelectBPM.setToolTipText("Digite um valor maior que 0 e menor que 1000");
		SelectBPM.setModel(new SpinnerNumberModel(0, 0, 1000, 5));
		SelectBPM.setForeground(Color.WHITE);
		SelectBPM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SelectBPM.setBackground(Color.LIGHT_GRAY);
		SelectBPM.setBounds(126, 429, 165, 21);
		frame.getContentPane().add(SelectBPM);
		
		JLabel IniciaMusica = new JLabel("");
		IniciaMusica.setIcon(new ImageIcon(".\\TelasPlayer\\IconPlay.png"));
		IniciaMusica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IniciaMusica.setBounds(265, 497, 137, 123);
		frame.getContentPane().add(IniciaMusica);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Guitarra", "Violao", "Piano"}));
		comboBox.setBounds(126, 468, 165, 21);
		frame.getContentPane().add(comboBox);
		frame.setBounds(100, 100, 698, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		IniciaMusica.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		identificaCaractere id = new identificaCaractere(TextoMusica.getText());
		id.setMusica(id.geraStringMusica());
		Pattern music = new Pattern(id.getMusica());
		Player player = new Player();
		player.play(music);
		this.frame.dispose();
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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private static void ExportaMIDI(Pattern music, String nome){
        File arquivoMIDI = new File(nome+"_output.mid");
        try {
            MidiFileManager.savePatternToMidi(music, arquivoMIDI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}