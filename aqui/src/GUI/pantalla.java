package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aeq3.Main;
import Aeq3.Main.Node;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.io.*;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;

public class pantalla extends JFrame {
	boolean respuesta;
	String cadena="";
	Main objetoMain = new Main();
	Node root = new Node();

	private JPanel contentPane;
	private JTextField EspacioforInsert;
	private JTextField espacioForSearch;
	private JTextField muestraResultado;
	private JTextField resultadoTex;

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

	 
	public pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 7, 7, 7));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonInsert = new JButton("insertar");
		BotonInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palabra =EspacioforInsert.getText() ;
				
				objetoMain.insertPalabra(root, palabra);
				cadena= cadena + EspacioforInsert.getText()+",\n";
				resultadoTex.setText(cadena);
				EspacioforInsert.setText(null);
				
			}
		});
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
		BotonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palabra= espacioForSearch.getText();
				boolean resp =objetoMain.search(root, palabra);
				muestraResultado.setText(null);
				
				if(resp==true) {
					muestraResultado.setText("true");
				}else {
					muestraResultado.setText("false");
				}
				espacioForSearch.setText(null);
				
			}
			
		});
		BotonSearch.setBounds(335, 67, 89, 23);
		contentPane.add(BotonSearch);
		
		JLabel lblNewLabel_3 = new JLabel("InsertarArchivo");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(297, 163, 98, 23);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Buscar Archivo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pantallaTxt abrir = new pantallaTxt();
				abrir.setVisible(true);
 
			}
			
		});
		btnNewButton_2.setBounds(270, 188, 154, 23);
		panel.add(btnNewButton_2);
		
		muestraResultado = new JTextField();
		muestraResultado.setHorizontalAlignment(SwingConstants.CENTER);
		muestraResultado.setForeground(new Color(0, 0, 0));
		muestraResultado.setBackground(new Color(128, 0, 0));
		muestraResultado.setEditable(false);
		muestraResultado.setEnabled(false);
		muestraResultado.setBounds(287, 67, 45, 23);
		panel.add(muestraResultado);
		muestraResultado.setColumns(10);
		
		resultadoTex = new JTextField();
		resultadoTex.setHorizontalAlignment(SwingConstants.LEFT);
		resultadoTex.setBackground(Color.BLACK);
		resultadoTex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultadoTex.setForeground(Color.BLACK);
		resultadoTex.setEditable(false);
		resultadoTex.setEnabled(false);
		resultadoTex.setBounds(10, 102, 250, 137);
		panel.add(resultadoTex);
		resultadoTex.setColumns(1);
		
		System.out.println(objetoMain.toString());
	}
}
