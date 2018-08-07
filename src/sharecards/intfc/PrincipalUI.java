package sharecards.intfc;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PrincipalUI {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("ShareCards");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);		
		JPanel panel = new JPanel ();
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		
		JLabel lblFlashnotes = new JLabel("ShareCards", SwingConstants.CENTER);
		lblFlashnotes.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblFlashnotes.setBounds(10, 11, 10, 32);
		panel.add(lblFlashnotes, BorderLayout.PAGE_START);
		frame.setContentPane(panel);

		JButton buttonUser = new JButton("Cadastre-se!");
		
		buttonUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroUsuarioUI();
			}
		});
		
		panel.add(buttonUser);
		
		JButton buttonFlash = new JButton("Entrar");
		
		buttonFlash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EntrarContaUI();
			}
		});
		panel.add(buttonFlash);
		frame.setContentPane (panel);
		
		frame.setVisible(true);
	}

}
