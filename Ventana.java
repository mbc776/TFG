package ventana;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;





/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 */
public class Ventana extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton botonWindows;
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
		getContentPane().setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
	}

	private void inicializarComponentes() {
		/*background=new ImageIcon("UC.jpg").getImage();
		
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
		this.add(botonWindows);
		this.add(botonUbuntu);*/
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 457);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		botonUbuntu = new JButton("Ubuntu");
		botonUbuntu.setBounds(800, 510, 163, 92);
		botonUbuntu.addActionListener(this);
		botonUbuntu.createImage(163, 92);
		panel.add(botonUbuntu);
		
		botonWindows = new JButton("Windows");
		botonWindows.setBounds(1100, 508, 163, 92);
		botonWindows.addActionListener(this);
		panel.add(botonWindows);
		JLabel label = new JLabel(new ImageIcon("images/UC.jpg"));
		label.setBounds(1500, 100, 1528, 1173);
		panel.add(label);
		
		JButton botonExit = new JButton("X");
		botonExit.setBackground(Color.RED);
		botonExit.setBounds(1800, 0, 130, 40);
		panel.add(botonExit);
		botonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(botonWindows)){
			String user = "root";
			String password = "temporal";
			String host = "192.168.0.20";
			int port = 22;
			Session session = null;
		    ChannelExec channel = null;
		    
		    try {
		        session = new JSch().getSession(user, host, port);
		        session.setPassword(password);
		        session.setConfig("StrictHostKeyChecking", "no");
		        System.out.println("Establishing Connection...");
		        session.connect();
		        System.out.println("Connection established.");
		        
		        channel = (ChannelExec) session.openChannel("exec");
		        channel.setCommand("xe vm-start uuid=0e8aaa5b-5332-2231-90bf-5d74541259eb");
		        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
		        channel.setOutputStream(responseStream);
		        System.out.println("Crating SFTP Channel.");
		        channel.connect();
		        System.out.println("SFTP Channel created.");
		        
		        while (channel.isConnected()) {
		            Thread.sleep(100);
		        }
		        
		        String responseString = new String(responseStream.toByteArray());
		        System.out.println(responseString);
		        //channel.disconnect();
		        //session.disconnect();
		    } catch(Exception ex){
		    	
		    }
			String s;
			Process p;
				try {
					Thread.sleep(10000);
					p = Runtime.getRuntime().exec("remmina -c /home/mario/.local/share/remmina/windows.remmina");
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
			String user = "root";
			String password = "temporal";
			String host = "192.168.0.20";
			int port = 22;
			Session session = null;
		    ChannelExec channel = null;
		    
		    try {
		        session = new JSch().getSession(user, host, port);
		        session.setPassword(password);
		        session.setConfig("StrictHostKeyChecking", "no");
		        System.out.println("Establishing Connection...");
		        session.connect();
		        System.out.println("Connection established.");
		        
		        channel = (ChannelExec) session.openChannel("exec");
		        channel.setCommand("xe vm-start uuid=66852cce-4284-0697-cbe2-0aed6fe84ffd");
		        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
		        channel.setOutputStream(responseStream);
		        System.out.println("Crating SFTP Channel.");
		        channel.connect();
		        System.out.println("SFTP Channel created.");
		        
		        while (channel.isConnected()) {
		            Thread.sleep(100);
		        }
		        
		        String responseString = new String(responseStream.toByteArray());
		        System.out.println(responseString);
		        channel.disconnect();
		        session.disconnect();
		    } catch(Exception ex){
		    	
		    }
			String s;
			Process p;
			try {
				Thread.sleep(30000);
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
