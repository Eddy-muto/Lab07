package Aeq3;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;

import Aeq3.Main.Node;

public class document {
	
	public static void main(String[]args) {
		
		
	}
	public static String retornTexto() {
		
		String palabraString="";
		 Scanner entrada = null;
	        JFileChooser fileChooser = new JFileChooser();
	        int valor = fileChooser.showOpenDialog(fileChooser);
	        if (valor == JFileChooser.APPROVE_OPTION) {
	            String ruta = fileChooser.getSelectedFile().getAbsolutePath();                                        
	            try {
	                File f = new File(ruta);
	                entrada = new Scanner(f);
	                while (entrada.hasNext()) {
	                	System.out.println("saludo");
	                    palabraString=entrada.nextLine();
	                }
	            } catch (FileNotFoundException e1) {
	                System.out.println(e1.getMessage());
	            } finally {
	                if (entrada != null) {
	                    entrada.close();
	                }
	            }
	        } else {
	            System.out.println("No se ha seleccionado ningún fichero");
	        }
	        
	        return palabraString;
	}
	public static String [] arrayTexto(String texto) {
		 String[] strArr = texto.split("\\s+");
		 return strArr;
	}
	
}
