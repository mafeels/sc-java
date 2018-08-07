package sharecards.intfc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlashnotes = new JLabel("ShareCards");
		lblFlashnotes.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblFlashnotes.setBounds(10, 11, 129, 32);
		contentPane.add(lblFlashnotes);
		
		JButton btnEntrarAgora = new JButton("ENTRAR AGORA!");
		btnEntrarAgora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin frame = new TelaLogin();
				frame.setVisible(true);
			}
		});
		btnEntrarAgora.setForeground(Color.RED);
		btnEntrarAgora.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnEntrarAgora.setBounds(125, 144, 179, 55);
		contentPane.add(btnEntrarAgora);
		
		JLabel lblNewLabel = new JLabel("REGISTRE-SE NO MELHOR SITE DE ESTUDO DO BRASIL!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 84, 434, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblObtenhaNotasFceis = new JLabel("OBTENHA NOTAS F\u00C1CEIS E TORNE-SE INTELIGENTE EM UM \u00DANICO CLIQUE!");
		lblObtenhaNotasFceis.setHorizontalAlignment(SwingConstants.CENTER);
		lblObtenhaNotasFceis.setBounds(0, 99, 434, 14);
		contentPane.add(lblObtenhaNotasFceis);
		
		JLabel lblGratis = new JLabel("\u00C9 GRATIS!!!!!");
		lblGratis.setHorizontalAlignment(SwingConstants.CENTER);
		lblGratis.setBounds(0, 119, 434, 14);
		contentPane.add(lblGratis);
	}
}
