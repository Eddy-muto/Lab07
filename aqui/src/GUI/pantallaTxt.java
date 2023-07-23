package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aeq3.Main;
import Aeq3.document;
import Aeq3.Main.Node;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaTxt extends JFrame {

	private JPanel contentPane;
	private JTextField PalabraBuscar;
	private JTextField PalabraReemplazo;
	private JTextField textoTalCual;
	private JButton Reemplaza;
	private JTextField textoReemplazado;
	private JButton botonLLamaPanel2;

	/**
	 * Launch the application.
	 */
	document docu= new document();
	static Main objetoMain = new Main();
	String texto= docu.retornTexto();
	Node root = new Node();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaTxt frame = new pantallaTxt();
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
	public pantallaTxt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 552, 452);
		contentPane.add(panel);
		panel.setLayout(null);
		
		PalabraBuscar = new JTextField();
		PalabraBuscar.setBounds(134, 201, 150, 20);
		panel.add(PalabraBuscar);
		PalabraBuscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("palabra a BUSCAR");
		lblNewLabel.setBounds(18, 201, 125, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("palabra Reemplazo");
		lblNewLabel_1.setBounds(18, 232, 101, 20);
		panel.add(lblNewLabel_1);
		
		PalabraReemplazo = new JTextField();
		PalabraReemplazo.setBounds(134, 232, 150, 20);
		panel.add(PalabraReemplazo);
		PalabraReemplazo.setColumns(10);
		
		textoTalCual = new JTextField();
		textoTalCual.setBounds(18, 33, 524, 159);
		panel.add(textoTalCual);
		textoTalCual.setColumns(10);
		
		Reemplaza = new JButton("reemplazar");
		Reemplaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busca= PalabraBuscar.getText();
				String reemplaza = PalabraReemplazo.getText();
				String [] dictionary = new String[] {reemplaza};
				
				String resultadoString=objetoMain.replaceWords(dictionary, texto);
				System.out.println(texto);
				System.out.println("aqui"+ resultadoString);
				
				textoReemplazado.setText(resultadoString);
			}
		});
		Reemplaza.setBounds(353, 215, 89, 23);
		panel.add(Reemplaza);
		
		textoReemplazado = new JTextField();
		textoReemplazado.setBounds(18, 263, 524, 145);
		panel.add(textoReemplazado);
		textoReemplazado.setColumns(10);
		
		botonLLamaPanel2 = new JButton("mis Archivos");
		botonLLamaPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto= docu.retornTexto();
				textoTalCual.setText(texto);
				String [] arreglo = docu.arrayTexto(texto);
				
				int largo=arreglo.length;
				String palabraString="";
				for(int i=0;i<largo;i++) 
					palabraString=arreglo[i];
					objetoMain.insertPalabra(root, palabraString);
			}
		});
		botonLLamaPanel2.setBounds(417, 6, 125, 23);
		panel.add(botonLLamaPanel2);
	}

}
