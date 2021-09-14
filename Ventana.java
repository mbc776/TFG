package ventana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements ActionListener {

	private JLabel texto;           // etiqueta o texto no editable
	private JTextField caja;        // caja de texto, para insertar datos
	private JButton botonWindows;          // boton con una determinada accion
	private JButton botonUbuntu;

	public Ventana() {
		super();                    // usamos el contructor de la clase padre JFrame
		configurarVentana();        // configuramos la ventana
		inicializarComponentes();   // inicializamos los atributos o componentes
	}

	private void configurarVentana() {
		this.setTitle("");                   // colocamos titulo a la ventana
		this.setSize(1000, 1000);                               // colocamos tamanio a la ventana (ancho, alto)
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
		this.setBackground(new Color(100,50,20));
		this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
	}

	private void inicializarComponentes() {
		// creamos los componentes
		texto = new JLabel();
		caja = new JTextField();
		botonWindows = new JButton();
		botonUbuntu = new JButton();
		// configuramos los componentes
		texto.setText("Inserte Nombre");    // colocamos un texto a la etiqueta
		texto.setBounds(50, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
		caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
		botonWindows.setText("Windows");   // colocamos un texto al boton
		botonWindows.setBounds(300, 300, 200, 100);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
		botonWindows.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
		botonUbuntu.setText("Ubuntu");   // colocamos un texto al boton
		botonUbuntu.setBounds(600, 300, 200, 100);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
		botonUbuntu.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
		// adicionamos los componentes a la ventana
		//this.add(texto);
		//this.add(caja);
		this.add(botonWindows);
		this.add(botonUbuntu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(botonWindows)){

			//String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
			//JOptionPane.showMessageDialog(this, "Has seleccionado Windows");    // mostramos un mensaje (frame, mensaje)
			String s;
	        Process p;
	        try {
	            //p = Runtime.getRuntime().exec("remmina -c /home/mario/.local/share/remmina/windows.remmina");
	            p = Runtime.getRuntime().exec("ssh root@192.168.0.20");
	            p = Runtime.getRuntime().exec("temporal");
	            p = Runtime.getRuntime().exec("xe vm-start uuid=0e8aaa5b-5332-2231-90bf-5d74541259eb");
	            BufferedReader br = new BufferedReader(
	                new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null)
	                System.out.println("line: " + s);
	            p.waitFor();
	            System.out.println ("exit: " + p.exitValue());
	            p.destroy();
	        } catch (Exception ex) {}
		}
		if(e.getSource().equals(botonUbuntu)){

			//String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
			//JOptionPane.showMessageDialog(this, "Has seleccionado Ubuntu");    // mostramos un mensaje (frame, mensaje)
			String s;
	        Process p;
	        try {
	            p = Runtime.getRuntime().exec("remmina -c /home/mario/.local/share/remmina/centOS.remmina");
	            BufferedReader br = new BufferedReader(
	                new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null)
	                System.out.println("line: " + s);
	            p.waitFor();
	            System.out.println ("exit: " + p.exitValue());
	            p.destroy();
	        } catch (Exception ex) {}

		}
	}

	public static void main(String[] args) {
		Ventana V = new Ventana();      // creamos una ventana
		V.setVisible(true);             // hacemos visible la ventana creada
	}
}