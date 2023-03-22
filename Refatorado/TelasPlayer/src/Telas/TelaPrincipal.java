package Telas;


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

import Func_musica.TocaSom;

import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel; 	
public class TelaPrincipal implements MouseListener {

	private JFrame frame;
	private JTextPane TextoMusica = new JTextPane();
	private String caminho;
	private TocaSom musica = new TocaSom(); 
	private String nomeArquivo;
	
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
		
		TextoMusica.setToolTipText("Digite seu texto aqui...");
		TextoMusica.setBackground(new Color(192, 192, 192));
		TextoMusica.setForeground(new Color(255, 255, 255));
		TextoMusica.setBounds(20, 63, 512, 304);
		frame.getContentPane().add(TextoMusica);
		
		JLabel lblEscolherArquivo = new JLabel("Escolher Arquivo");
		lblEscolherArquivo.setForeground(new Color(255, 255, 255));
		lblEscolherArquivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscolherArquivo.setBounds(10, 389, 137, 27);
		frame.getContentPane().add(lblEscolherArquivo);

		
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
		        	
		        	try {
		        		  caminho = selecionaArq.getSelectedFile().getAbsolutePath();
		        		  nomeArquivo = selecionaArq.getSelectedFile().getName();
		        	      File arquivo = new File(caminho);
		        	      Scanner leitor = new Scanner(arquivo);
		        	      while (leitor.hasNextLine()) {
		        	        String data = leitor.nextLine();
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
		
		JLabel lblExportaMidi = new JLabel("Exportar Arquivo");
		lblExportaMidi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExportaMidi.setForeground(Color.WHITE);
		lblExportaMidi.setBounds(10, 442, 165, 21);
		frame.getContentPane().add(lblExportaMidi);
		
		
		JButton btnExportaMidi = new JButton("Exportar Midi");
		btnExportaMidi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExportaMidi.setBounds(126, 442, 165, 21);
		frame.getContentPane().add(btnExportaMidi);
		
		btnExportaMidi.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	musica.SetText(TextoMusica.getText());
		    	
		    	try {
					musica.ExportaMIDI(nomeArquivo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		JLabel IniciaMusica = new JLabel("");
		IniciaMusica.setIcon(new ImageIcon(".\\TelasPlayer\\IconPlay.png"));
		IniciaMusica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IniciaMusica.setBounds(217, 492, 137, 123);
		frame.getContentPane().add(IniciaMusica);
		
		frame.setBounds(100, 100, 570, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		IniciaMusica.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		musica.SetText(TextoMusica.getText());
		musica.PlayMusic();
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
	
}