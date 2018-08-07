package sharecards.intfc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblEsqueceuASenha;
	private JLabel lblUsername;
	private JLabel lblSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 116, 92, 20);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(194, 53, 32, 26);
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(164, 142, 92, 23);
		
		lblEsqueceuASenha = new JLabel("Esqueceu a senha?");
		lblEsqueceuASenha.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEsqueceuASenha.setBounds(164, 171, 92, 14);
		contentPane.setLayout(null);
		
		lblSenha = new JLabel("senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(164, 119, 92, 14);
		contentPane.add(lblSenha);
		
		lblUsername = new JLabel("username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(164, 93, 92, 14);
		contentPane.add(lblUsername);
		contentPane.add(textField_1);
		
		textField = new JTextField();
		textField.setBounds(164, 90, 92, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		contentPane.add(btnNewButton);
		contentPane.add(lblEsqueceuASenha);
		contentPane.add(lblNewLabel);
	}

}
