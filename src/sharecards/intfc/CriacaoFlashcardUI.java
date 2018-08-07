package sharecards.intfc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sharecards.dao.JDBCFlashcardDAO;
import sharecards.model.Flashcard;

public class CriacaoFlashcardUI {
	
	public CriacaoFlashcardUI() {
		final JFrame frameCrFlash = 
				new JFrame("Criação de Flashcard");
		frameCrFlash.setSize(800, 600);
		frameCrFlash.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		frameCrFlash.setContentPane(panel);
		
		JLabel labFlashNome = new JLabel();
		labFlashNome.setText("Nome do Flashcard : ");
		panel.add(labFlashNome);
		

		final JTextField textFieldFlashNome = new JTextField(30);
		panel.add(textFieldFlashNome);
		panel.add(Box.createRigidArea(new Dimension(100,10)));
		JLabel labCat = new JLabel();
		labCat.setText("Categoria : ");
		panel.add(labCat);

		final JTextField textFieldCat = new JTextField(25);
		panel.add(textFieldCat);
		
		JLabel labFrente = new JLabel();
		labFrente.setText("Frente : ");
		panel.add(labFrente);
		
		final JTextField textFieldFrente = new JTextField(20);
		panel.add(textFieldFrente);
		
		JLabel labTras = new JLabel();
		labTras.setText("Verso : ");
		panel.add(labTras);
		
		final JTextField textFieldTras = new JTextField(20);
		panel.add(textFieldTras);
		
		JLabel labAutor = new JLabel();
		labAutor.setText("Autor : ");
		panel.add(labAutor);
		
		final JTextField textFieldAutor = new JTextField(20);
		panel.add(textFieldAutor);
		
		JLabel labImg = new JLabel();
		labImg.setText("Link da imagem (opcional): ");
		panel.add(labImg);
		
		final JTextField textFieldImg = new JTextField(30);
		panel.add(textFieldImg);
		
		JButton cadButton = new JButton (" Cadastrar! ");
		cadButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JDBCFlashcardDAO fcDAO = new JDBCFlashcardDAO();
			
			Flashcard fc = new Flashcard();
			fc.setNomeFlashcard(textFieldFlashNome.getText());
			fc.setCategoriaFlashcard(textFieldCat.getText());
			fc.setFrenteFlashcard(textFieldFrente.getText());
			fc.setTrasFlashcard(textFieldTras.getText());
			fc.setAutorFlashcard(textFieldAutor.getText());
			LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
			java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
			fc.setDataCriacao(sqlDate);
			fc.setImageFlashcard(textFieldImg.getText());
			
			try {
				fcDAO.insereFlashcard(fc);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
		}
		});
		panel.add(cadButton);
	
		JButton cancelButton = new JButton (" Cancelar Criação ");
		cancelButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frameCrFlash.dispose();
		}
		});
		panel.add(cancelButton);
	
		frameCrFlash.setVisible(true);
	}
}
