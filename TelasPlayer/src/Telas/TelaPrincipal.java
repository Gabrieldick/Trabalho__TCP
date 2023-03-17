package Telas;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
public class TelaPrincipal implements MouseListener {

	private JFrame frame;
	
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
		        	System.out.println(selecionaArq.getSelectedFile().getAbsolutePath());
		        }
		    }
		    
		});
		
		
		
		JTextPane TextoMusica = new JTextPane();
		TextoMusica.setToolTipText("Digite seu texto aqui...");
		TextoMusica.setBackground(new Color(192, 192, 192));
		TextoMusica.setForeground(new Color(255, 255, 255));
		TextoMusica.setBounds(20, 63, 512, 304);
		frame.getContentPane().add(TextoMusica);
		
		JSpinner SelectInstrumento = new JSpinner();
		SelectInstrumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SelectInstrumento.setBackground(new Color(192, 192, 192));
		SelectInstrumento.setForeground(new Color(255, 255, 255));
		SelectInstrumento.setModel(new SpinnerListModel(new String[] {"Guitarra", "Violao", "Violino", "Piano", "Flauta"}));
		SelectInstrumento.setBounds(126, 466, 165, 21);
		frame.getContentPane().add(SelectInstrumento);
		
		JSpinner SelectBPM = new JSpinner();
		SelectBPM.setToolTipText("Digite um valor maior que 0 e menor que 1000");
		SelectBPM.setModel(new SpinnerNumberModel(0, 0, 1000, 5));
		SelectBPM.setForeground(Color.WHITE);
		SelectBPM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SelectBPM.setBackground(Color.LIGHT_GRAY);
		SelectBPM.setBounds(126, 429, 165, 21);
		frame.getContentPane().add(SelectBPM);
		
		JLabel IniciaMusica = new JLabel("");
		IniciaMusica.setIcon(new ImageIcon(".\\.\\IconPlay.png"));
		IniciaMusica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IniciaMusica.setBounds(265, 497, 137, 123);
		frame.getContentPane().add(IniciaMusica);
		frame.setBounds(100, 100, 698, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		IniciaMusica.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TelaMusica tela = new TelaMusica();
		this.frame.dispose();
		tela.getFrame().setVisible(true);
		
		
		
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
