package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;

public class pantalla extends JFrame {

	private JPanel contentPane;
	private JTextField EspacioforInsert;
	private JTextField espacioForSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla frame = new pantalla();
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
	public pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 7, 7, 7));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonInsert = new JButton("insertar");
		BotonInsert.setBounds(335, 22, 89, 23);
		contentPane.add(BotonInsert);
		
		JLabel lblNewLabel = new JLabel("Insertar palabra");
		lblNewLabel.setBounds(10, 24, 98, 18);
		contentPane.add(lblNewLabel);
		
		EspacioforInsert = new JTextField();
		EspacioforInsert.setBounds(118, 23, 163, 20);
		contentPane.add(EspacioforInsert);
		EspacioforInsert.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar Palabra");
		lblNewLabel_1.setBounds(10, 71, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		espacioForSearch = new JTextField();
		espacioForSearch.setBounds(118, 68, 163, 20);
		contentPane.add(espacioForSearch);
		espacioForSearch.setColumns(10);
		
		JButton BotonSearch = new JButton("Buscar");
		BotonSearch.setBounds(335, 67, 89, 23);
		contentPane.add(BotonSearch);
		
		JLabel resultadosImprime = new JLabel("");
		resultadosImprime.setBackground(UIManager.getColor("Button.highlight"));
		resultadosImprime.setBounds(10, 140, 231, 110);
		contentPane.add(resultadosImprime);
		
		JButton btnNewButton_3 = new JButton("Mostrar Datos");
		btnNewButton_3.setBounds(10, 111, 163, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("InsertarArchivo");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(297, 163, 98, 23);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Buscar Archivo");
		btnNewButton_2.setBounds(270, 188, 154, 23);
		panel.add(btnNewButton_2);
	}
}
